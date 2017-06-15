package com.kashuo.kap.bill.controller;

import com.kashuo.kap.bill.domain.Merchant;
import com.kashuo.kap.bill.domain.Store;
import com.kashuo.kap.bill.model.form.TransactionForm;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

/**
 * 普通单边账
 * Created by sunjiawei on 2017/5/24.
 */
@Controller
@RequestMapping(value = "/normal")
public class NormalBillController extends BaseController{



    @RequestMapping(value="", method = RequestMethod.GET)
    public String normal(Model m){
        log.info("普通单边账 ");
        m.addAttribute("transactionForm",new TransactionForm());
        return "pages/normal/add";
    }

    /**
     *  TransactionForm form,@RequestParam("fileName") MultipartFile file
     * there is two ways to insert data into db. the one is  load excel file, another is using form.
     * @Validated(ValidInsertGroup.class)
     *@param form
     * @return
     */
    @RequestMapping(value="", method = RequestMethod.POST)
    public String normalAdd(@Valid TransactionForm form, BindingResult result, Model model){
//        ModelAndView mav = new ModelAndView();
        model.addAttribute("transactionForm",form);

        if(result.hasErrors()){
            List<ObjectError>  list = result.getAllErrors();
            for(ObjectError  error:list){
                System.out.println(error.getCode()+"---"+error.getArguments()+"---"+error.getDefaultMessage());
            }

            return "pages/normal/add";
        }
        //1.确认门店编号是否存在
        String msg ="";
        Merchant merchant = merchantService.selectByPrimaryKey(form.getMerchantId());
        if (merchant == null) {
            msg = "商户号不存在，请重新输入！";
            result.rejectValue("merchantId", "misFormat", msg);
//            mav.setViewName("pages/result");
//            return mav;
            return "pages/normal/add";
        }

        int storeId = form.getStoreId();
        Store store = storeService.selectByPrimaryKey(storeId);


        if (store == null) {
            msg = "门店号不存在，请重新输入！";
            result.rejectValue("storeId", "misFormat", msg);
//            mav.setViewName("pages/result");
//            return mav;
            return "pages/normal/add";
        }

        store = storeService.selectByPK(form.getMerchantId(),form.getStoreId());

        if (store == null) {
            msg = "门店不属于 【" + merchant.getName() + "】 商户，请核实后重新输入！";
//            mav.addObject("msg",msg);
//            mav.setViewName("pages/result");
//            return mav;
        }


        String storeChannelCode = store.getChannelCode();
//        Transaction searchResult =  transactionService.SelectOne(form);
//        if(searchResult != null){//已经存在
//            Integer status = searchResult.getStatus();
//            log.info("状态，{}",status);
//        }
        form.setStoreChannel(storeChannelCode);
//        boolean tt = transactionService.normalInsert(form);
//        if (!tt){
//            log.info("结果 ,{}",tt);
////            mav.setViewName("pages/normal/add");
//        }else{
////            mav.addObject("msg","补单成功！！");
////            mav.setViewName("pages/result");
//        }
//        return mav;
        return "pages/result";
    }

}
