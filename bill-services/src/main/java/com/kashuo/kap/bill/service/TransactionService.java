package com.kashuo.kap.bill.service;

import com.kashuo.kap.bill.dao.TransactionMapper;
import com.kashuo.kap.bill.domain.Transaction;
import com.kashuo.kap.bill.model.dto.TransactionCondition;
import com.kashuo.kap.bill.model.form.TransactionForm;
import com.kashuo.kap.bill.utils.ConstantUtil;
import com.kashuo.kap.bill.utils.CustomCodeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
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

    @SuppressWarnings("")
    //单边账
    public boolean normal(TransactionForm form){
        Transaction record = toEntity(form);//form to entity
        TransactionCondition condition = this.toCondition(record); // entity to condition
        //检查，若存在，检查状态，若不存在，直接入库
        Transaction result =  SelectOne(condition);
        if(result != null){
            Integer status = result.getStatus();
            log.info("状态，{}",status);
            if (status != null && (status ==1 || status == 4)){
                //// TODO: 2017/5/24  
                //返回消息（status: 1 , trans_no: xxxxxx）
                //return。。。
            }
        }
       int resCount =  insertSelective(record);
        if (resCount<1)

            return false;
        return true;
    }




    /********************************************************************************/
    //银行
    public boolean bank(TransactionCondition condition){
        Transaction result =  SelectOne(condition);
        if(result != null){
            Integer status = result.getStatus();
            if (status != null && (status ==1 || status == 4)){
                //// TODO: 2017/5/24
                //返回消息（status: 1 , trans_no: xxxxxx）
                //return。。。
            }
        }
        return false;
    }





    /************************************  内部    ********************************************/
    //根据金额，sn, 交易日期， 查询交易
    private Transaction SelectOne(TransactionCondition record){
        return transactionMapper.SelectOne(record);
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
    private TransactionCondition toCondition(Transaction record){
        TransactionCondition condition = new TransactionCondition();
        condition.setDeviceSn(record.getDeviceSn());
        condition.setPayAmount(record.getPayAmount());
        condition.setTotalAmount(record.getTotalAmount());
        condition.setTransDate(record.getTransDate());
        return condition;
    }

    /**
     * form convert into entity
     * @param record
     * @return
     */
    private Transaction toEntity(TransactionForm record){
        Transaction result = new Transaction();
        result.setDeviceSn(record.getDeviceSn());
        result.setPayAmount(record.getPayAmount());
        result.setTotalAmount(record.getTotalAmount());
        result.setPaymentType(record.getPaymentType());
        result.setMerchantId(Integer.parseInt(record.getMerchantId()));
        result.setStoreId(Integer.parseInt(record.getStoreId()));
        return null;
    }

    /**
     *  insert selective
     * @param record
     * @return
     */
    private int insertSelective(Transaction record){

        record.setTransNo(CustomCodeUtil.generatedTransNo("2017-05-25","16:43:52"));
        record.setStatus(ConstantUtil.ONE);
        record.setAcqChannel(ConstantUtil.acqChannel);
        record.setTransComment(ConstantUtil.transComment);
        record.setCreatedAt(new Date());
        record.setUpdatedAt(new Date());
        return transactionMapper.insert(record);
    }
}
