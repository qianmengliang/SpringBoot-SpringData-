package com.alibaba.customer.service;


import com.alibaba.customer.entity.Customer;
import com.alibaba.customer.entity.LinkMan;
import org.springframework.data.domain.Page;

/**
 * @author user
 * @date 2019/1/9
 * @time 17:35
 */
public interface CrmService {

    void addCustomer(Customer customer);



    Page<Customer> findCustomer(Integer pageSize, Integer page, String cust_name);

    void addLinkMan(LinkMan linkMan, Customer customer);

    Page<LinkMan> findLinkMan(Integer pageSize, Integer page, String lkm_name);

    Customer findOneCustomer(int cust_id);

    void updateCustomer(Customer customer);
}
