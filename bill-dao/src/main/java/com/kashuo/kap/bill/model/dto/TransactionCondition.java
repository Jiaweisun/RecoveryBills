package com.kashuo.kap.bill.model.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by sunjiawei on 2017/5/24.
 */
public class TransactionCondition {

    private String deviceSn;
    private String transDate;
    private String transTime;
    private BigDecimal totalAmount;
    private BigDecimal payAmount;
    private String cardNumber;
    private String preCardNumber;
    private String cardNumberEnd;
    private Integer status;
    private Integer agencyId;
    private String paymentType;//支付类型

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

    public Integer getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Integer agencyId) {
        this.agencyId = agencyId;
    }

    public String getTransTime() {
        return transTime;
    }

    public void setTransTime(String transTime) {
        this.transTime = transTime;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPreCardNumber() {
        return preCardNumber;
    }

    public void setPreCardNumber(String preCardNumber) {
        this.preCardNumber = preCardNumber;
    }

    public String getCardNumberEnd() {
        return cardNumberEnd;
    }

    public void setCardNumberEnd(String cardNumberEnd) {
        this.cardNumberEnd = cardNumberEnd;
    }
}
