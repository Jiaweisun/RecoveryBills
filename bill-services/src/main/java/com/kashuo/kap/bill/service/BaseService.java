package com.kashuo.kap.bill.service;

import com.kashuo.kap.bill.dao.StoreMapper;
import com.kashuo.kap.bill.dao.TransactionMapper;
import com.kashuo.kap.bill.domain.Transaction;
import com.kashuo.kap.bill.model.dto.TransactionCondition;
import com.kashuo.kap.bill.model.form.TransactionForm;
import com.kashuo.kap.bill.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by sunjiawei on 2017/6/21.
 */
@Service
public class BaseService {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    protected TransactionMapper transactionMapper;

    @Resource
    protected StoreMapper storeMapper;


    public Transaction selectOne(String transNo){
        return transactionMapper.selectOne(transNo);
    }

    /**
     * entity convert into condition
     * @param record
     * @return
     */
    protected TransactionCondition entity2Condition(Transaction record){
        TransactionCondition condition = new TransactionCondition();
        condition.setDeviceSn(record.getDeviceSn());
        condition.setPayAmount(record.getPayAmount());
        condition.setTotalAmount(record.getTotalAmount());
        condition.setTransDate(record.getTransDate().toString());
        return condition;
    }

    protected TransactionCondition form2Condition(TransactionForm record){
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
    protected Transaction form2Entity(TransactionForm record){
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


}
