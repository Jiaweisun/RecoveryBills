package com.kashuo.kap.bill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by sunjiawei on 2017/5/23.
 */
@Controller
@RequestMapping(value = "/")
public class OthersController extends  BaseController{

    @RequestMapping(value="", method = RequestMethod.GET)
    public String hi(){
        log.info("index page ");
        return "pages/index";
    }

    @RequestMapping(value="about", method = RequestMethod.GET)
    public String about(){
        log.info("about page");
        return "pages/about";
    }

    @RequestMapping(value="contact", method = RequestMethod.GET)
    public String contact(){
        log.info("contact page");
        return "pages/contact";
    }
}
