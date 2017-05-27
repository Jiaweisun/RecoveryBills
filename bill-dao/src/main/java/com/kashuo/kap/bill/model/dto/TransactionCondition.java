package com.kashuo.kap.bill.model.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by sunjiawei on 2017/5/24.
 */
public class TransactionCondition {

    private String deviceSn;
    private Date transDate;
    private BigDecimal totalAmount;
    private BigDecimal payAmount;

    public String getDeviceSn() {
        return deviceSn;
    }

    public void setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn;
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }
}
