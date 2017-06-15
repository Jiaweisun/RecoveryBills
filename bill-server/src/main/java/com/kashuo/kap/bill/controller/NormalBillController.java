package com.kashuo.kap.bill.controller;

import com.kashuo.kap.bill.domain.Merchant;
import com.kashuo.kap.bill.domain.Store;
import com.kashuo.kap.bill.domain.Transaction;
import com.kashuo.kap.bill.model.MerchantWithStore;
import com.kashuo.kap.bill.model.form.TransactionForm;
import com.kashuo.kap.bill.service.TransactionService;
import com.kashuo.kap.bill.utils.CustomStringUtils;
import com.kashuo.kap.bill.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

/**
 * 普通单边账
 * Created by sunjiawei on 2017/5/24.
 */
@Controller
@RequestMapping(value = "/normal")
public class NormalBillController extends BaseController{

    private  String rootPath = "d:\\upload\\";

    @RequestMapping(value="", method = RequestMethod.GET)
    public String normal(Model m){
        log.info("普通单边账 ");
        m.addAttribute("transaction",new Transaction());
        return "pages/normal/add";
    }

    /**
     *  TransactionForm form,@RequestParam("fileName") MultipartFile file
     * there is two ways to insert data into db. the one is  load excel file, another is using form.
     *@param form
     * @return
     */
    @RequestMapping(value="", method = RequestMethod.POST)
    public String normalAdd(@Valid Transaction form, BindingResult result, Model model){
        ModelAndView mav = new ModelAndView();
        model.addAttribute("transaction",form);

        if(result.hasErrors()){
            List<ObjectError>  list = result.getAllErrors();
            for(ObjectError  error:list){
                System.out.println(error.getCode()+"---"+error.getArguments()+"---"+error.getDefaultMessage());
            }

            return "pages/normal/add";
        }
//        log.info("普通单边账 ,{},{}",form,file);
//        // 方式1： 文件导入
//        String fileName = FileUtils.saveFile(file, rootPath);
//        log.info("文件名称 ,{}",fileName);
//        if (!CustomStringUtils.isBlank(fileName)) {
//         //// TODO: 2017/5/27 convert into sql
//        }
        //方式2：
        //1.确认门店编号是否存在
        String msg ="";
        Merchant merchant = merchantService.selectByPrimaryKey(form.getMerchantId());
        if (merchant == null) {
            msg = "商户号不存在，请重新输入！";
            mav.setViewName("pages/result");
//            return mav;
        }

        int storeId = form.getStoreId();
        Store store = storeService.selectByPrimaryKey(storeId);

        if (store == null) {
            msg = "门店号不存在，请重新输入！";
            mav.setViewName("pages/result");
//            return mav;
        }

        store = storeService.selectByPK(form.getMerchantId(),form.getStoreId());

        if (store == null) {
            msg = "门店不属于 【" + merchant.getName() + "】 商户，请核实后重新输入！";
            mav.addObject("msg",msg);
            mav.setViewName("pages/result");
//            return mav;
        }


        String storeChannelCode = store.getChannelCode();
        Transaction searchResult =  transactionService.SelectOne(form);
        if(searchResult != null){
            Integer status = searchResult.getStatus();
            log.info("状态，{}",status);
        }
        form.setStoreChannel(storeChannelCode);
        boolean tt = transactionService.normalInsert(form);
        if (!tt){
            log.info("结果 ,{}",result);
            mav.setViewName("pages/normal/add");
        }else{
            mav.addObject("msg","补单成功！！");
            mav.setViewName("pages/result");
        }
//        return mav;
        return "pages/result";
    }

}
