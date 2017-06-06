package com.kashuo.kap.bill.controller;

import com.kashuo.kap.bill.domain.Transaction;
import com.kashuo.kap.bill.model.dto.TransactionCondition;
import com.kashuo.kap.bill.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

/**
 * 银行单边账
 * Created by sunjiawei on 2017/5/24.
 */
@Controller
@RequestMapping(value = "/bank")
public class BankController extends BaseController{

    @Autowired
    private TransactionService transactionService;

//    @RequestMapping(value="", method = {RequestMethod.GET,RequestMethod.POST})
//    public String bank(@ModelAttribute TransactionCondition condition){
//
//        //  1. to page
//        return "pages/bank/info";
//    }

    /**
     * 当条件为空的时候，默认查询所有，但由于数据量巨大，因此只显示100条。（不推荐无条件查询）
     * @param condition
     * @return
     */
    @RequestMapping(value = "", method = {RequestMethod.GET,RequestMethod.POST})
    public ModelAndView search(@ModelAttribute TransactionCondition condition) {

        log.info(".... search begin....");
        ModelAndView mav = new ModelAndView();
        // 2. search by condition and redirect to parent page
        List<Transaction> transactions = transactionService.bankSelect(condition);
        mav.addObject("condition",condition);
        mav.addObject("transactions",transactions);
        mav.setViewName("pages/bank/info");
        log.info(".... search end....");
        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView update(@RequestParam("transNo") String transNo) {

        ModelAndView mav = new ModelAndView();
        Transaction record = transactionService.selectOne(transNo);
        Integer status = record.getStatus();
        if (status ==1 || status ==2 || status == 3||status == 4){
            ////
            //返回消息（status: 1 , trans_no: xxxxxx）
            mav.addObject("transNo",record.getTransNo());
            mav.setViewName("redirect:/bank/status");
            return mav;
        }
        // 2. update by a column and redirect to parent page
        transactionService.updateByTransNo(transNo);
        mav.setViewName("redirect:/bank");
//        "redirect:/emp/list"
        return mav;
    }

    @RequestMapping(value="/status", method = {RequestMethod.GET})
    public ModelAndView status(@RequestParam("transNo") String transNo){
        ModelAndView mav = new ModelAndView();
        mav.addObject("transNo",transNo);
        mav.setViewName("pages/bank/status");
        return mav;
    }


}
