package com.kashuo.kap.bill.dao;

import com.kashuo.kap.bill.domain.Store;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoreMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Store record);

    int insertSelective(Store record);

    Store selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Store record);

    int updateByPrimaryKey(Store record);

    /**
     *
     * @param mid 商户号
     * @param sid 门店号（选填）
     * @return
     */
    List<Store> selectByPK(@Param("mid") Integer mid,@Param("sid") Integer sid);

}