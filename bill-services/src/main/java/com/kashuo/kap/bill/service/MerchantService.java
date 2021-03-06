package com.kashuo.kap.bill.service;

import com.kashuo.kap.bill.dao.MerchantMapper;
import com.kashuo.kap.bill.dao.StoreMapper;
import com.kashuo.kap.bill.domain.Merchant;
import com.kashuo.kap.bill.domain.Store;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by sunjiawei on 2017/6/8.
 */
@Service
public class MerchantService {
    @Resource
    private MerchantMapper merchantMapper;

    public Merchant selectByPrimaryKey(int merchantId){
        return merchantMapper.selectByPrimaryKey(merchantId);
    }

}
