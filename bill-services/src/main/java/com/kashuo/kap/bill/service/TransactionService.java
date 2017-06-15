package com.kashuo.kap.bill.service;

import com.kashuo.kap.bill.dao.StoreMapper;
import com.kashuo.kap.bill.dao.TransactionMapper;
import com.kashuo.kap.bill.domain.Transaction;
import com.kashuo.kap.bill.model.dto.TransactionCondition;
import com.kashuo.kap.bill.model.form.TransactionForm;
import com.kashuo.kap.bill.utils.ConstantUtil;
import com.kashuo.kap.bill.utils.CustomCodeUtil;
import com.kashuo.kap.bill.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by sunjiawei on 2017/5/24.
 */
@Service
public class TransactionService {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private TransactionMapper transactionMapper;

    @Resource
    private StoreMapper storeMapper;

    @SuppressWarnings("")
    //单边账
    public Transaction SelectOne(TransactionForm form){
        TransactionCondition record = this.form2Condition(form);
        Transaction result =transactionMapper.SelectOneForNormal(record);
        return result;
    }

    public Transaction SelectOne(Transaction record){
        TransactionCondition condition = this.entity2Condition(record);
        Transaction result =transactionMapper.SelectOneForNormal(condition);
        return result;
    }

    public boolean normalInsert(Transaction record){
//        Transaction record = this.form2Entity(form);//form to entity

        int result =0;
        try {
            String transDate = DateUtil.convertDateToString(record.getTransDate());
            String transTime = DateUtil.ConverToStrHour(record.getTransTime());
            result = insertSelective(record,transDate,transTime);//,form.getTransDate(),form.getTransTime()
        }
        catch (Exception e){
            e.toString();
        }
        if (result <= 0)
            return false;
        return true;
    }

    /**
     *  insert selective
     *
     * @param record
     * @return
     */
    private int insertSelective(Transaction record,String transDate, String transTime){

        record.setTransNo(CustomCodeUtil.generatedTransNo(transDate,transTime));
        record.setStoreChannel(record.getStoreChannel());
        record.setStatus(ConstantUtil.ONE);
        record.setAcqChannel(ConstantUtil.acqChannel);
        record.setTransComment(ConstantUtil.transComment);
//        record.setTransDate(record.getTransDate());
//        record.setTransTime(record.getTransTime());
        record.setCreatedAt(new Date());
        record.setUpdatedAt(new Date());
        return transactionMapper.insert(record);
    }




    /*******************************   银行   *************************************************/

    //bank search
    public List<Transaction> bankSelect(TransactionCondition record,String paymentType){
        List<Transaction> results = new ArrayList<>();
        resetCondition(record);
        if (paymentType == ConstantUtil.LONG)
            results = transactionMapper.bankSelectLong(record);
        else
            results = transactionMapper.bankSelect(record);
        return results;
    }

    private TransactionCondition resetCondition(TransactionCondition record){
        String cardNumber = record.getCardNumber();
        String [] str = new String[]{};
        if (cardNumber!=null){
            if(cardNumber.contains("*")){
                str = cardNumber.split("\\*");
            }
            record.setPreCardNumber(str[0]);
            record.setCardNumberEnd(str[str.length-1]);
        }
        return record;
    }

    //bank update
    public boolean updateByTransNo(String transNo,Date transDate,Date transTime,String cardNumber){

        Transaction record = this.selectOne(transNo);
        if (record.getPaymentType()==ConstantUtil.LONG)//龙支付
            record.setCardNumber(cardNumber);

        record.setTransDate(transDate);
        record.setTransTime(transTime);
        updateSelective(record);
        return true;
    }

    /************************************  内部    ********************************************/

    public Transaction selectOne(String transNo){
        return transactionMapper.selectOne(transNo);
    }

    /**
     * entity convert into condition
     * @param record
     * @return
     */
    private TransactionCondition entity2Condition(Transaction record){
        TransactionCondition condition = new TransactionCondition();
        condition.setDeviceSn(record.getDeviceSn());
        condition.setPayAmount(record.getPayAmount());
        condition.setTotalAmount(record.getTotalAmount());
        condition.setTransDate(record.getTransDate().toString());
        return condition;
    }

    private TransactionCondition form2Condition(TransactionForm record){
        TransactionCondition result = new TransactionCondition();
        result.setDeviceSn(record.getDeviceSn());
        result.setPayAmount(record.getPayAmount());
        result.setTotalAmount(record.getTotalAmount());
//        result.setPaymentType(record.getPaymentType());
//        result.setMerchantId(Integer.parseInt(record.getMerchantId().trim()));
//        result.setStoreId(Integer.parseInt(record.getStoreId().trim()));
        return result;
    }

    /**
     * form convert into entity
     * @param record
     * @return
     */
    private Transaction form2Entity(TransactionForm record){
        Transaction result = new Transaction();
        result.setDeviceSn(record.getDeviceSn());
        result.setPayAmount(record.getPayAmount());
        result.setTotalAmount(record.getTotalAmount());
        result.setPaymentType(record.getPaymentType());
        result.setMerchantId(record.getMerchantId());
        result.setStoreId(record.getStoreId());
        result.setStoreChannel(record.getStoreChannel());
        try {
            result.setTransDate(DateUtil.ConverToDate(record.getTransDate()));
            result.setTransTime(DateUtil.ConverToDateHour(record.getTransTime()));
        }catch (Exception e){

        }

        return result;
    }




    //update status
    private int updateSelective(Transaction record){
        record.setStatus(ConstantUtil.ONE);
        record.setTransComment(ConstantUtil.transComment);
        record.setUpdatedAt(new Date());
        return transactionMapper.updateByPrimaryKeySelective(record);
    }

}
