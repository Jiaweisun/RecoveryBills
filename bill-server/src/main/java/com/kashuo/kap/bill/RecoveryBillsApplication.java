package com.kashuo.kap.bill;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

/**
 * Created by sunjiawei on 2017/5/23.
 */
@Controller
@SpringBootApplication
public class RecoveryBillsApplication {
    public static void main(String[] args){
        SpringApplication.run(RecoveryBillsApplication.class, args);
    }
}
