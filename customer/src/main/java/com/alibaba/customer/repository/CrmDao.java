package com.alibaba.customer.repository;


import com.alibaba.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

/**
 * @author user
 * @date 2019/1/10
 * @time 15:18
 */
public interface CrmDao extends JpaRepository<Customer ,Long>,JpaSpecificationExecutor<Customer> {

 /*   @Query("update cst_customer set cust_name=?1 ,cust_level=?2,cust_source=?3,cust_linkman=?4,cust_phone=?5,cust_mobile=?6 where cust_id=?6 ")
    @Modifying
    void update(String cust_name, String cust_level, String cust_source, String cust_linkman, String cust_phone, String cust_mobile, Long cust_id);
*/
}
