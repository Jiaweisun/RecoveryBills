package com.kashuo.kap.bill.dao;

import com.kashuo.kap.bill.domain.Merchant;
import org.apache.ibatis.annotations.Param;

public interface MerchantMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Merchant record);

    int insertSelective(Merchant record);

    Merchant selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Merchant record);

    int updateByPrimaryKey(Merchant record);

    Merchant selectOne(@Param("name") String name);
}