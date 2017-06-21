package com.kashuo.kap.bill.service;

import com.kashuo.kap.bill.domain.Transaction;
import com.kashuo.kap.bill.model.dto.TransactionCondition;
import com.kashuo.kap.bill.model.form.TransactionForm;
import com.kashuo.kap.bill.utils.ConstantUtil;
import com.kashuo.kap.bill.utils.CustomCodeUtil;
import com.kashuo.kap.bill.utils.DateUtil;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 普通漏单处理
 * Created by sunjiawei on 2017/6/21.
 */
@Service
public class NormalService extends BaseService{

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

    public boolean normalInsert(TransactionForm form){
        Transaction record = this.form2Entity(form);//form to entity

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




}
