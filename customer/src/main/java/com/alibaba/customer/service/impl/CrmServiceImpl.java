package com.alibaba.customer.service.impl;


import com.alibaba.customer.entity.Customer;
import com.alibaba.customer.entity.LinkMan;
import com.alibaba.customer.repository.CrmDao;
import com.alibaba.customer.repository.LinkManDao;
import com.alibaba.customer.service.CrmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * @author user
 * @date 2019/1/9
 * @time 17:35
 */
@Service
@Transactional
public class CrmServiceImpl implements CrmService {
@Autowired
private CrmDao customerDao;
@Autowired
private LinkManDao linkManDao;

    @Override
    public void addCustomer(Customer customer) {
        customerDao.save(customer);
    }

    @Override
    public Page<Customer> findCustomer(Integer pageSize, Integer page, String cust_name) {
        Specification<Customer> customerSpecification;
        if(cust_name!=null&&cust_name.length()>0&&!"".equals(cust_name)){
           final String custName="%"+cust_name+"%";
             customerSpecification = new Specification<Customer>() {
                @Override
                public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                    return criteriaBuilder.like(root.get("cust_name").as(String.class),custName);
                }
            };
        }else {
            customerSpecification=null;
        }
        Pageable pageRequest = new PageRequest(page, pageSize);

        return customerDao.findAll(customerSpecification, pageRequest);
    }

    @Override
    public void addLinkMan(LinkMan linkMan, Customer customer) {
        customer.getLinkMans().add(linkMan);
        linkMan.setCustomer(customer);
       //customerDao.save(customer);
        linkManDao.save(linkMan);

    }

    @Override
    public Page<LinkMan> findLinkMan(Integer pageSize, Integer page, String lkm_name) {
        Specification<LinkMan> linkManSpecification;
        if(lkm_name!=null&&!"".equals(lkm_name)&&lkm_name.length()>0){
           final String lkm_name1="%"+lkm_name+"%";
            linkManSpecification=new Specification<LinkMan>() {
                @Override
                public Predicate toPredicate(Root<LinkMan> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                    return criteriaBuilder.like(root.get("lkm_name").as(String.class),lkm_name1);
                }
            };

        }else {
            linkManSpecification=null;
        }
        Pageable pageRequest = new PageRequest(page, pageSize);
        return linkManDao.findAll(linkManSpecification,pageRequest);

    }

    @Override
    public Customer findOneCustomer(int cust_id) {

     return  customerDao.getOne(new Long((long) cust_id));

    }

    @Override
    public void updateCustomer(Customer customer) {
        //customerDao.update(customer.getCust_name(),customer.getCust_level(),customer.getCust_source(),customer.getCust_linkman(),customer.getCust_phone(),customer.getCust_mobile(),customer.getCust_id());
    }


}
