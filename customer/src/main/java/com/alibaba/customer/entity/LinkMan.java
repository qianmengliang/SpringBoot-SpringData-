package com.alibaba.customer.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author user
 * @date 2019/1/14
 * @time 16:39
 */
@Entity
@Table(name = "cst_linkman")
public class LinkMan implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long lkm_id;
    @Column
    private String lkm_name;
    @Column
    private String lkm_gender;
    @Column
    private String lkm_phone;
    @Column
    private String lkm_mobile;
    @Column
    private String lkm_email;
    @Column
    private String lkm_qq;
    @Column
    private String lkm_position;
    @Column
    private String lkm_memo;
    @JsonIgnore
    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "lkm_cust_id",referencedColumnName = "cust_id")
    private Customer customer;

    public LinkMan(String lkm_name, String lkm_gender, String lkm_phone, String lkm_mobile, String lkm_email, String lkm_qq, String lkm_position, String lkm_memo, Customer customer) {
        this.lkm_name = lkm_name;
        this.lkm_gender = lkm_gender;
        this.lkm_phone = lkm_phone;
        this.lkm_mobile = lkm_mobile;
        this.lkm_email = lkm_email;
        this.lkm_qq = lkm_qq;
        this.lkm_position = lkm_position;
        this.lkm_memo = lkm_memo;
        this.customer = customer;
    }

    public LinkMan() {
    }

    public Long getLkm_id() {
        return lkm_id;
    }

    public void setLkm_id(Long lkm_id) {
        this.lkm_id = lkm_id;
    }

    public String getLkm_name() {
        return lkm_name;
    }

    public void setLkm_name(String lkm_name) {
        this.lkm_name = lkm_name;
    }

    public String getLkm_gender() {
        return lkm_gender;
    }

    public void setLkm_gender(String lkm_gender) {
        this.lkm_gender = lkm_gender;
    }

    public String getLkm_phone() {
        return lkm_phone;
    }

    public void setLkm_phone(String lkm_phone) {
        this.lkm_phone = lkm_phone;
    }

    public String getLkm_mobile() {
        return lkm_mobile;
    }

    public void setLkm_mobile(String lkm_mobile) {
        this.lkm_mobile = lkm_mobile;
    }

    public String getLkm_email() {
        return lkm_email;
    }

    public void setLkm_email(String lkm_email) {
        this.lkm_email = lkm_email;
    }

    public String getLkm_qq() {
        return lkm_qq;
    }

    public void setLkm_qq(String lkm_qq) {
        this.lkm_qq = lkm_qq;
    }

    public String getLkm_position() {
        return lkm_position;
    }

    public void setLkm_position(String lkm_position) {
        this.lkm_position = lkm_position;
    }

    public String getLkm_memo() {
        return lkm_memo;
    }

    public void setLkm_memo(String lkm_memo) {
        this.lkm_memo = lkm_memo;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
