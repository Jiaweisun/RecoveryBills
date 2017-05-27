package com.kashuo.kap.bill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 银行单边账
 * Created by sunjiawei on 2017/5/24.
 */
@Controller
@RequestMapping(value = "/bank")
public class BankController {

    @RequestMapping(value="", method = RequestMethod.GET)
    public String bank(){
//        log.info("nihao niahao niaho ");
        return "pages/bank/info";
    }
}
