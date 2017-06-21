package com.kashuo.kap.bill.service;

import com.kashuo.kap.bill.domain.Transaction;
import com.kashuo.kap.bill.model.dto.TransactionCondition;
import com.kashuo.kap.bill.utils.ConstantUtil;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 银行漏单处理
 * Created by sunjiawei on 2017/5/24.
 */
@Service
public class TransactionService extends BaseService{

    //bank search
    public List<Transaction> bankSelect(TransactionCondition record,String paymentType){
        List<Transaction> results = new ArrayList<>();
        if (record.getCardNumber() !=""){
            resetCondition(record);
        }

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
        int result = updateSelective(record);
        if (result<=0)
            return false;
        return true;
    }

    //update status
    private int updateSelective(Transaction record){
        record.setStatus(ConstantUtil.ONE);
        record.setTransComment(ConstantUtil.transComment);
        record.setUpdatedAt(new Date());
        return transactionMapper.updateByPrimaryKeySelective(record);
    }

}
