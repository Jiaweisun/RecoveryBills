package com.kashuo.kap.bill.service;

import com.kashuo.kap.bill.dao.MerchantMapper;
import com.kashuo.kap.bill.dao.StoreMapper;
import com.kashuo.kap.bill.domain.Merchant;
import com.kashuo.kap.bill.domain.Store;
import com.kashuo.kap.bill.model.MerchantWithStore;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by sunjiawei on 2017/5/27.
 */
@Service
public class ConditionService {

    @Resource
    private MerchantMapper merchantMapper;

    @Resource
    private StoreMapper storeMapper;


    //1. 获取所有商户和从属的门店
    private List<MerchantWithStore> selectAll(){
       Merchant merchant = selectOne("");
        MerchantWithStore.toMerchantWithStore(merchant,selectAllByMCode(merchant.getCode()));
        //// TODO: 2017/5/27
        return null;
    }

    //2. 根据商户名称，模糊匹配商户

    private MerchantWithStore selectOne(){
        //// TODO: 2017/5/27
        return null;
    }
    //3. 根据门店名称选择所属门店

    //
    private Merchant selectOne(String name){
        return merchantMapper.selectOne(name);
    }

    /**
     *
     * @param mcode merchant code
     * @return
     */
    private List<Store> selectAllByMCode(String mcode){
        return null;
    }
}
