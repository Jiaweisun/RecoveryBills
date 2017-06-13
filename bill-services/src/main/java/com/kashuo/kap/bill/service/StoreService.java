package com.kashuo.kap.bill.service;

import com.kashuo.kap.bill.dao.StoreMapper;
import com.kashuo.kap.bill.domain.Store;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by sunjiawei on 2017/6/8.
 */
@Service
public class StoreService {
    @Resource
    private StoreMapper storeMapper;

    public Store selectByPrimaryKey(int storeId){
        return storeMapper.selectByPrimaryKey(storeId);
    }

    /**
     *
     * @param mid 商户号
     * @param sid 门店号（选填）
     * @return
     */
    public Store selectByPK(int mid, int sid){
        List<Store> stores = storeMapper.selectByPK(mid, sid);
        return stores==null?stores.get(0):null;
    }

}
