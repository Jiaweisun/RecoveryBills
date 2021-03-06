package com.kashuo.kap.bill.service;

import com.kashuo.kap.bill.dao.MerchantMapper;
import com.kashuo.kap.bill.dao.ProfitAgencyMapper;
import com.kashuo.kap.bill.dao.StoreMapper;
import com.kashuo.kap.bill.domain.Merchant;
import com.kashuo.kap.bill.domain.ProfitAgency;
import com.kashuo.kap.bill.domain.Store;
import com.kashuo.kap.bill.model.MerchantWithStore;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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

    @Resource
    private ProfitAgencyMapper profitAgencyMapper;

    ///****************************** 支付方式 ***********************************
    public List<ProfitAgency> agencyAll(){
        return profitAgencyMapper.selectAll();
    }

    //1. 获取所有商户和从属的门店
    public List<MerchantWithStore> selectAll(){
        List<Merchant> merchants = this.merchantSelectAll();
        List<MerchantWithStore> results = new ArrayList<>();

        MerchantWithStore mws = null;
        for (Merchant merchant: merchants) {

            mws = MerchantWithStore.toMerchantWithStore(merchant,selectAllByPK(merchant.getId()));
        }
        results.add(mws);
        return results;
    }

    //2. 根据商户名称，模糊匹配商户

    private List<Merchant> merchantSelectAll(){
        return merchantMapper.merchantAll();
    }

    private List<Merchant> merchantSelectByName(String name){
        return null;
    }

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
     * @param mid merchant id
     * @return
     */
    private List<Store> selectAllByPK(Integer mid){
        return storeMapper.selectByPK(mid,null);
    }
}
