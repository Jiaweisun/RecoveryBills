package com.kashuo.kap.bill.controller;

import com.kashuo.kap.bill.domain.Transaction;
import com.kashuo.kap.bill.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * 普通单边账
 * Created by sunjiawei on 2017/5/24.
 */
@Controller
@RequestMapping(value = "/normal")
public class NormalBillController extends BaseController{
    @Autowired
    private TransactionService transactionService;

    @RequestMapping(value="", method = RequestMethod.GET)
    public String normal(){
        log.info("普通单边账 ");
        return "pages/normal/add";
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public String normalAdd(@ModelAttribute Transaction record){
        log.info("普通单边账 ,{0}",record);

        boolean result = transactionService.normal(record);
        log.info("结果 ,{0}",result);
        return "pages/normal/add";
    }

}
