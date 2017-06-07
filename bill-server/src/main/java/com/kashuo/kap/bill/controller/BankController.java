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

    /**
     * get, post请求分开是为了避免
     * @param condition
     * @return
     */
    @RequestMapping(value="", method = RequestMethod.GET)
    public ModelAndView bank(@ModelAttribute TransactionCondition condition){
        ModelAndView mav = new ModelAndView();
        mav.addObject("condition",condition);

        mav.setViewName("pages/bank/info");
        log.info(".... search end....");
        return mav;
    }

    /**
     * 当条件为空的时候，默认查询所有，但由于数据量巨大，因此只显示100条。（不推荐无条件查询）
     * @param condition
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ModelAndView search(@ModelAttribute TransactionCondition condition) {

        log.info(".... search begin....");
        ModelAndView mav = new ModelAndView();
        mav.addObject("condition",condition);

//          if (condition.getAgencyId() == 4)//龙支付
//        {
                //// TODO: 2017/6/6 龙支付
//        }
        // 2. search by condition and redirect to parent page
        List<Transaction> transactions = transactionService.bankSelect(condition);

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
