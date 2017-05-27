package com.kashuo.kap.bill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sunjiawei on 2017/5/23.
 */
@Controller
@RequestMapping(value = "/")
public class TestController extends  BaseController{

    @RequestMapping(value="", method = RequestMethod.GET)
    public String hi(){
        log.info("nihao niahao niaho ");
        return "pages/index";
    }

    @RequestMapping(value="about", method = RequestMethod.GET)
    public String ahout(){
        log.info("nihao niahao niaho ");
        return "pages/about";
    }
}
