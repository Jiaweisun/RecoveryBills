package com.kashuo.kap.bill.model;

import com.kashuo.kap.bill.domain.Merchant;
import com.kashuo.kap.bill.domain.Store;

import java.util.List;

/**
 * Created by sunjiawei on 2017/5/27.
 */
public class MerchantWithStore {

    private long id;
    private String merchantName;
    private String merchantCode;
    private List<Store> stores;

    public static MerchantWithStore toMerchantWithStore(Merchant merchant, List<Store> stores){
        MerchantWithStore result = new MerchantWithStore();
        result.setId(merchant.getId());
        result.setMerchantCode(merchant!=null?merchant.getCode():null);
        result.setMerchantName(merchant!=null?merchant.getName():null);
        result.setStores(stores);
        return result;
    }


    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
