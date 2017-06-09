package com.kashuo.kap.bill.controller;

import com.kashuo.kap.bill.domain.Store;
import com.kashuo.kap.bill.domain.Transaction;
import com.kashuo.kap.bill.model.form.TransactionForm;
import com.kashuo.kap.bill.service.TransactionService;
import com.kashuo.kap.bill.utils.CustomStringUtils;
import com.kashuo.kap.bill.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * 普通单边账
 * Created by sunjiawei on 2017/5/24.
 */
@Controller
@RequestMapping(value = "/normal")
public class NormalBillController extends BaseController{

    private  String rootPath = "d:\\upload\\";

    @RequestMapping(value="", method = RequestMethod.GET)
    public String normal(){
        log.info("普通单边账 ");
        return "pages/normal/add";
    }

    /**
     * there is two ways to insert data into db. the one is  load excel file, another is using form.
     * @param form
     * @param file
     * @return
     */
    @RequestMapping(value="/add", method = RequestMethod.POST)
    public ModelAndView normalAdd(@ModelAttribute TransactionForm form, @RequestParam("fileName") MultipartFile file){
        ModelAndView mav = new ModelAndView();
        log.info("普通单边账 ,{},{}",form,file);
        // 方式1： 文件导入
        String fileName = FileUtils.saveFile(file, rootPath);
        log.info("文件名称 ,{}",fileName);
        if (!CustomStringUtils.isBlank(fileName)) {
         //// TODO: 2017/5/27 convert into sql
        }
        //方式2：
        //1.确认门店编号是否存在
        String msg ="";
        int storeId = form.getStoreId();
        Store store = storeService.selectByPrimaryKey(storeId);
        if (store == null)
           msg = "门店号不存在，请重新输入！";
        String storeChannelCode = store.getChannelCode();
        Transaction searchResult =  transactionService.SelectOne(form);//todo:有可能不止一条
        if(searchResult != null){
            Integer status = searchResult.getStatus();
            log.info("状态，{}",status);
        }
        boolean result = transactionService.normalInsert(form);
        if (!result){
            log.info("结果 ,{}",result);
            mav.setViewName("pages/normal/add");
        }else{
            mav.addObject("msg","成功还是失败！！");
            mav.setViewName("pages/result");
        }
        return mav;


    }

}
