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
        Transaction record = this.form2Entity(form);//form to entity
        TransactionCondition condition = this.form2Condition(form); // entity to condition
        //检查，若存在，检查状态，若不存在，直接入库
        Transaction result =  SelectOne(condition);//todo:有可能不止一条
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




    /*******************************   银行   *************************************************/

    //bank search
    public List<Transaction> bankSelect(TransactionCondition record){
        return transactionMapper.bankSelect(record);
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
    //根据金额，sn, 交易日期， 查询交易
    private Transaction SelectOne(TransactionCondition record){
        Transaction result =transactionMapper.SelectOneForNormal(record);
        return result;
    }


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
        result.setMerchantId(Integer.parseInt(record.getMerchantId().trim()));
        result.setStoreId(Integer.parseInt(record.getStoreId().trim()));
        return result;
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


    //update status
    private int updateSelective(Transaction record){
        record.setStatus(ConstantUtil.ONE);
        record.setUpdatedAt(new Date());
        return transactionMapper.updateByPrimaryKeySelective(record);
    }


}
