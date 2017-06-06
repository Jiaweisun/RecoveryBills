package com.kashuo.kap.bill.model.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by sunjiawei on 2017/5/24.
 */
public class TransactionCondition {

    private String deviceSn;
    private String transDate;
    private BigDecimal totalAmount;
    private BigDecimal payAmount;
    private String cardNumber;
    private Integer status;

    public String getDeviceSn() {
        return deviceSn==null?"":deviceSn.trim();
    }

    public void setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn;
    }

    public String getTransDate() {
        return transDate;
    }

    public void setTransDate(String transDate) {
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

    public String getCardNumber() {
        return cardNumber==null?"":cardNumber.trim();
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
