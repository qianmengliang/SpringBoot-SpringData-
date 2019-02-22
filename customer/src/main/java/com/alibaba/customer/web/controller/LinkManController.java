package com.alibaba.customer.web.controller;


import com.alibaba.customer.entity.Customer;
import com.alibaba.customer.entity.LinkMan;
import com.alibaba.customer.service.CrmService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author user
 * @date 2019/1/14
 * @time 20:50
 */
@RestController
@RequestMapping("/linkMan")
public class LinkManController {
    @Autowired
    private CrmService crmService;
    @RequestMapping("/addLinkMan.do")
    public String addLinkMan(LinkMan linkMan, Customer customer){
        crmService.addLinkMan(linkMan,customer);
        return "forward:jsp/linkman/list.jsp";
    }
    @RequestMapping("/findLinkManList.do")
    public @ResponseBody Page<LinkMan> findLinkManList(@RequestParam(name ="pageSize",required = false,defaultValue = "10")Integer pageSize, @RequestParam(name = "page",required = false,defaultValue = "1")Integer page, @RequestParam(name = "lkm_name",required = false)String lkm_name){
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

        Page<LinkMan> list = crmService.findLinkMan(pageSize,page,lkm_name);
        return list;
    }
}
