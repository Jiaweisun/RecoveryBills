package com.kashuo.kap.bill.service;

import com.kashuo.kap.bill.dao.StoreMapper;
import com.kashuo.kap.bill.dao.TransactionMapper;
import com.kashuo.kap.bill.domain.Store;
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
import java.math.BigDecimal;
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

    public boolean normalInsert(TransactionForm form){
        Transaction record = this.form2Entity(form);//form to entity

        int result = insertSelective(record,form.getTransDate(),form.getTransTime());
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
        record.setTransDate(record.getTransDate());
        record.setTransTime(record.getTransTime());
        record.setCreatedAt(new Date());
        record.setUpdatedAt(new Date());
        return transactionMapper.insert(record);
    }




    /*******************************   银行   *************************************************/

    //bank search
    public List<Transaction> bankSelect(TransactionCondition record,String paymentType){
        List<Transaction> results = new ArrayList<>();
        switch (paymentType){
            case ConstantUtil.LONG:
                results = transactionMapper.bankSelectLong(record);
                break;
            case ConstantUtil.OTHER:
                results = transactionMapper.bankSelect(record);
                break;
        }
        return results;
    }

    //bank update
    public boolean updateByTransNo(String transNo){

        Transaction record = this.selectOne(transNo);
        Integer status = record.getStatus();
        if (status ==1 || status == 4){
            ////
            //返回消息（status: 1 , trans_no: xxxxxx）
            return false;
        }
        // update...
        updateSelective(record);
        return true;
    }

    /************************************  内部    ********************************************/


//    //根据金额，sn, 交易日期， 查询交易
//    public Transaction SelectOne(TransactionCondition record){
//        Transaction record = this.form2Entity(form);
////        TransactionCondition condition = this.form2Condition(form);
//        Transaction result =transactionMapper.SelectOneForNormal(record);
//        return result;
//    }


    public Transaction selectOne(String transNo){
        return transactionMapper.selectOne(transNo);
    }

    @Deprecated
    private Transaction SelectOne(String deviceSn, Date transDate,BigDecimal totalAmount, BigDecimal payAmount){
        return null;
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
