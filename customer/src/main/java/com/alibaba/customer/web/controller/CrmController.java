package com.alibaba.customer.web.controller;

import com.alibaba.customer.entity.Customer;

import com.alibaba.customer.service.CrmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author user
 * @date 2019/1/9
 * @time 17:34
 */

@Controller
@RequestMapping("/customer")
public class CrmController {
    @Autowired
    private CrmService crmService;

    @RequestMapping("/findCustomerList.do")
    public @ResponseBody Page<Customer> findCustomerList(@RequestParam(name ="pageSize",required = false,defaultValue = "10")Integer pageSize, @RequestParam(name = "page",required = false,defaultValue = "1")Integer page, @RequestParam(name = "cust_name",required = false)String cust_name){
        if(pageSize!=null){
            pageSize=pageSize;
        }else {
            pageSize=10;
        }
        if(page!=null){
            page=page-1;
        }else {
            page=0;
        }
        Page<Customer> list = crmService.findCustomer(pageSize,page,cust_name);
        return  list;
    }

    @RequestMapping("/addCustomer.do")
    public String addCustomer( Customer customer){
        crmService.addCustomer(customer);
        return "forward:/jsp/customer/list.jsp";
    }

    @RequestMapping("/findOne.do")
    public @ResponseBody Customer  findOne(@RequestParam(name = "cust_id",required = true)String cust_id){
        Customer customer=null;
       int custId=Integer.parseInt(cust_id);
        if(cust_id!=null&&custId>0){
             customer=crmService.findOneCustomer(custId);
        }
        return customer;
    }
    @RequestMapping("update.do")
    public String update(Customer customer){
        crmService.updateCustomer(customer);
        return "forward:/jsp/customer/list.jsp";
    }
}
