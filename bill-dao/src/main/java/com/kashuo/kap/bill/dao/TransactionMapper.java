package com.kashuo.kap.bill.dao;


import com.kashuo.kap.bill.domain.Transaction;
import com.kashuo.kap.bill.model.dto.TransactionCondition;

import java.util.List;

public interface TransactionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Transaction record);

    int insertSelective(Transaction record);

    Transaction selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Transaction record);

    int updateByPrimaryKey(Transaction record);

    Transaction SelectOne(TransactionCondition record);
}