package com.kashuo.kap.bill.dao;


import com.kashuo.kap.bill.domain.Transaction;
import com.kashuo.kap.bill.model.dto.TransactionCondition;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransactionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Transaction record);

    int insertSelective(Transaction record);

    Transaction selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Transaction record);

    int updateByPrimaryKey(Transaction record);

    Transaction SelectOneForNormal(TransactionCondition record);

    List<Transaction> bankSelect(TransactionCondition record);

    List<Transaction> bankSelectLong(TransactionCondition record);

    Transaction selectOne(@Param("transNo") String transNo);
}