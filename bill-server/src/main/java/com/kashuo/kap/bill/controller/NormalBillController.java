package com.kashuo.kap.bill.controller;

import com.kashuo.kap.bill.domain.Merchant;
import com.kashuo.kap.bill.domain.ProfitAgency;
import com.kashuo.kap.bill.domain.Store;
import com.kashuo.kap.bill.domain.Transaction;
import com.kashuo.kap.bill.model.form.TransactionForm;
import com.kashuo.kap.bill.utils.ConstantUtil;
import com.kashuo.kap.bill.utils.CustomCodeUtil;
import org.apache.ibatis.jdbc.Null;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;

import static java.sql.JDBCType.NULL;

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
        List<ProfitAgency> agencies = conditionService.agencyAll();
        m.addAttribute("agencies",agencies);
        m.addAttribute("transactionForm",new TransactionForm());
        m.addAttribute("abc","normal");
        return "pages/normal/add";
    }

    /**
     *  TransactionForm form,@RequestParam("fileName") MultipartFile file
     * there are two ways to insert data into db. the one is  load excel file, another is using form.
     * @Validated(ValidInsertGroup.class)
     *@param form
     * @return
     */
    @RequestMapping(value="", method = RequestMethod.POST)
    public String normalAdd(@Valid TransactionForm form, BindingResult result, Model model){
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
            return "pages/normal/add";
        }

        int storeId = form.getStoreId();
        Store store = storeService.selectByPrimaryKey(storeId);

        if (store == null) {
            msg = "门店号不存在，请重新输入！";
            result.rejectValue("storeId", "misFormat", msg);
            return "pages/normal/add";
        }

        store = storeService.selectByPK(form.getMerchantId(),form.getStoreId());

        if (store == null) {
            msg = "门店不属于 【" + merchant.getName() + "】 商户，请核实后重新输入！";
             result.rejectValue("storeId", "misFormat", msg);
            return "pages/normal/add";
        }

        Transaction searchResult =  normalService.SelectOne(form);
        if(searchResult != null){//已经存在
            Integer status = searchResult.getStatus();
            msg = "deviceSn: "+form.getDeviceSn()+", status: " + status+", trans_no: "+searchResult.getTransNo()+"，请核实后重新输入！";
            result.rejectValue("deviceSn", "misFormat", msg);
            return "pages/normal/add";
        }

        String storeChannelCode = store.getChannelCode();

        if (storeChannelCode == ""||storeChannelCode == null){
            msg = " failed！";
            result.rejectValue("storeId", "misFormat", msg);
            return "pages/normal/add";
        }else{

            String transNo = CustomCodeUtil.generatedTransNo(form.getTransDate(),form.getTransTime());
            String orderNo = transNo;
//            Integer acquireer_id = 32;
//            String acq_channel = "CCB";
            if(form.getAgencyId()==1||form.getAgencyId()==2)
                form.setPaymentType("BANK");
            else if(form.getAgencyId()==3)
                form.setPaymentType("WECHAT");
            else if(form.getAgencyId()==4)
                form.setPaymentType("ALIPAY");
            else if(form.getAgencyId()==6)
                form.setPaymentType("LONGPAY");

            String cardNumber = form.getCardNumber()==""?null:form.getCardNumber();
            String bankName = form.getBankName() == ""?null:form.getBankName();


            msg = ConstantUtil.NORMAL_SQL_P+"'"+transNo+"', '"+transNo+"', '"+form.getMerchantId()+"', '"+form.getStoreId()+"', '"+storeChannelCode+"','"+
                    form.getTransDate()+"', '"+form.getTransTime()+"', "+form.getTotalAmount()+","+form.getAgencyId() +", '"+form.getDeviceSn()+"', "+NULL+","+1+","+
                    0+","+form.getPayAmount()+","+form.getTransRate()+","+form.getTotalProfit()+","+form.getAcquirerId()+",'"+form.getAcqChannel()+"', '"+form.getPaymentType()+
                    "', "+cardNumber+", "+bankName+", '"+ConstantUtil.transComment+"', now(), now() );";
            model.addAttribute("msg",msg);
            return "pages/result";
        }

//        form.setStoreChannel(storeChannelCode);
//        boolean tt = normalService.normalInsert(form);
//        if (!tt){
//            msg = " failed！";
//            result.rejectValue("storeId", "misFormat", msg);
//            return "pages/normal/add";
//        }else{
//            msg = " 补单成功！！";
//            model.addAttribute("msg",msg);
//            return "pages/result";
//        }
    }

}
