package com.kashuo.kap.bill.controller;

import com.kashuo.kap.bill.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by sunjiawei on 2017/5/23.
 */
@Controller
public class BaseController {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    protected ConditionService conditionService;

    @Autowired
    protected TransactionService transactionService;

    @Autowired
    protected NormalService normalService;

    @Autowired
    protected MerchantService merchantService;

    @Autowired
    protected StoreService storeService;

}
