package com.kashuo.kap.bill.dao;

import com.kashuo.kap.bill.domain.ProfitAgency;

import java.util.List;

public interface ProfitAgencyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProfitAgency record);

    int insertSelective(ProfitAgency record);

    ProfitAgency selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProfitAgency record);

    int updateByPrimaryKey(ProfitAgency record);

    List<ProfitAgency> selectAll();
}