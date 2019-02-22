package com.alibaba.customer.entity;




import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @author user
 * @date 2019/1/9
 * @time 12:43
 */
@Entity
@Table(name = "cst_customer")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Customer implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long cust_id;
    @Column
    private Long cust_user_id;
    @Column
    private Long cust_create_id;
    @Column
    private String cust_name;
    @Column
    private String cust_source;
    @Column
    private String cust_industry;
    @Column
    private String cust_level;
    @Column
    private String cust_linkman;
    @Column
    private String cust_phone;
    @Column
    private String cust_mobile;
   /* @OneToMany(targetEntity = LinkMan.class)
    @JoinColumn(name = "lkm_cust_id",referencedColumnName="cust_id")*/
   @JsonIgnore
   @OneToMany(mappedBy = "customer",cascade=CascadeType.ALL)
    private Set<LinkMan> linkMans =new HashSet<>();

    @Override
    public String toString() {
        return "Customer{" +
                "cust_id=" + cust_id +
                ", cust_user_id=" + cust_user_id +
                ", cust_create_id=" + cust_create_id +
                ", cust_name='" + cust_name + '\'' +
                ", cust_source='" + cust_source + '\'' +
                ", cust_industry='" + cust_industry + '\'' +
                ", cust_level='" + cust_level + '\'' +
                ", cust_linkman='" + cust_linkman + '\'' +
                ", cust_phone='" + cust_phone + '\'' +
                ", cust_mobile='" + cust_mobile + '\'' +
                ", linkMans=" + linkMans +
                '}';
    }

    public Set<LinkMan> getLinkMans() {
        return linkMans;
    }

    public void setLinkMans(Set<LinkMan> linkMans) {
        this.linkMans = linkMans;
    }

    public Long getCust_id() {
        return cust_id;
    }

    public void setCust_id(Long cust_id) {
        this.cust_id = cust_id;
    }

    public Long getCust_user_id() {
        return cust_user_id;
    }

    public void setCust_user_id(Long cust_user_id) {
        this.cust_user_id = cust_user_id;
    }

    public Long getCust_create_id() {
        return cust_create_id;
    }

    public void setCust_create_id(Long cust_create_id) {
        this.cust_create_id = cust_create_id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getCust_source() {
        return cust_source;
    }

    public void setCust_source(String cust_source) {
        this.cust_source = cust_source;
    }

    public String getCust_industry() {
        return cust_industry;
    }

    public void setCust_industry(String cust_industry) {
        this.cust_industry = cust_industry;
    }

    public String getCust_level() {
        return cust_level;
    }

    public void setCust_level(String cust_level) {
        this.cust_level = cust_level;
    }

    public String getCust_linkman() {
        return cust_linkman;
    }

    public void setCust_linkman(String cust_linkman) {
        this.cust_linkman = cust_linkman;
    }

    public String getCust_phone() {
        return cust_phone;
    }

    public void setCust_phone(String cust_phone) {
        this.cust_phone = cust_phone;
    }

    public String getCust_mobile() {
        return cust_mobile;
    }

    public void setCust_mobile(String cust_mobile) {
        this.cust_mobile = cust_mobile;
    }

    public Customer() {
    }

    public Customer(Long cust_id, Long cust_user_id, Long cust_create_id, String cust_name, String cust_source, String cust_industry, String cust_level, String cust_linkman, String cust_phone, String cust_mobile) {
        this.cust_id = cust_id;
        this.cust_user_id = cust_user_id;
        this.cust_create_id = cust_create_id;
        this.cust_name = cust_name;
        this.cust_source = cust_source;
        this.cust_industry = cust_industry;
        this.cust_level = cust_level;
        this.cust_linkman = cust_linkman;
        this.cust_phone = cust_phone;
        this.cust_mobile = cust_mobile;
    }
}
