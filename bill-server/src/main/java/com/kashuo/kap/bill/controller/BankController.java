package com.kashuo.kap.bill.controller;

import com.kashuo.kap.bill.domain.ProfitAgency;
import com.kashuo.kap.bill.domain.Transaction;
import com.kashuo.kap.bill.model.dto.TransactionCondition;
import com.kashuo.kap.bill.service.TransactionService;
import com.kashuo.kap.bill.utils.ConstantUtil;
import com.kashuo.kap.bill.utils.DateUtil;
import com.kashuo.kap.bill.utils.NullUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 银行单边账
 * Created by sunjiawei on 2017/5/24.
 */
@Controller
@RequestMapping(value = "/bank")
public class BankController extends BaseController{



    /**
     * get, post请求分开是为了避免
     * @param condition
     * @return
     */
    @RequestMapping(value="", method = RequestMethod.GET)
    public ModelAndView bank(@ModelAttribute TransactionCondition condition){
        ModelAndView mav = new ModelAndView();
        mav.addObject("condition",condition);
        getAgency(mav);
        mav.setViewName("pages/bank/info");
        log.info(".... search end....");
        return mav;
    }

    /**
     * 当条件为空的时候，默认不查询（不推荐无条件查询）
     * @param condition
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ModelAndView search(@ModelAttribute TransactionCondition condition) {

        log.info(".... search begin....");
        ModelAndView mav = new ModelAndView();
        mav.addObject("condition",condition);
        if (NullUtil.isNull(condition.getCardNumber())){
            mav.setViewName("pages/bank/info");
            return mav;
        }
        getAgency(mav);
        List<Transaction> transactions = transactionService.bankSelect(condition,condition.getPaymentType());
        mav.addObject("transactions",transactions);
        mav.setViewName("pages/bank/info");
        log.info(".... search end....");
        return mav;
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public ModelAndView update(@RequestParam("transNo") String transNo,@RequestParam("transDate") String transDate, @RequestParam("transTime") String transTime, @RequestParam("cardNumber") String cardNumber) {

        ModelAndView mav = new ModelAndView();
        Date date = null,time = null;
        try {
            date = DateUtil.ConverToDate(transDate);
            time = DateUtil.ConverToDate(transTime);
        }catch (Exception e){
            e.printStackTrace();
        }
        // 2. update by a column and redirect to parent page
        transactionService.updateByTransNo(transNo, date, time, cardNumber);
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

    private void getAgency(ModelAndView mav){
        List<ProfitAgency> agencies = conditionService.agencyAll();
        mav.addObject("agencies",agencies);

    }
}
