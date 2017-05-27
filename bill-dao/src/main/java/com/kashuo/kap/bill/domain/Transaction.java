package com.kashuo.kap.bill.domain;

import org.springframework.web.bind.annotation.ModelAttribute;

import java.math.BigDecimal;
import java.util.Date;

public class Transaction {
    private Integer id;

    private String transNo;

    private String transChannel;

    private String activityId;

    private String activityName;

    private String preferType;

    private String acquirerTransNo;

    private String orderNo;

    private Integer transType;

    private Integer emiType;

    private Integer emiMonths;

    private BigDecimal emiThreshold;

    private BigDecimal busiGrossProfit;

    private Integer merchantId;

    private Integer storeId;

    private String storeChannel;

    private Integer acquirerId;

    private Integer agencyId;

    private BigDecimal transRate;

    private String deviceSn;

    private String storeNumber;

    private String terminalNumber;

    private String paymentType;

    private Integer status;

    private Integer profitStatus;

    private String profitStatusMsg;

    private Date transDate;

    private Date transTime;

    private BigDecimal totalAmount;

    private BigDecimal disAmount;

    private BigDecimal canDisAmount;

    private BigDecimal payAmount;

    private BigDecimal subsidyAmount;

    private BigDecimal busiGetAmount;

    private BigDecimal bankMoney;

    private BigDecimal prepayMoney;

    private BigDecimal prerealMoney;

    private BigDecimal totalProfit;

    private BigDecimal ksProfit;

    private BigDecimal acquirerProfit;

    private String acquirerTerminalNumber;

    private String acquirerMerchantNumber;

    private String refNumber;

    private String batchNumber;

    private String voucherNumber;

    private Date billDate;

    private String acqChannel;

    private BigDecimal acquirerCommissionAmount;

    private BigDecimal commissionAmount;

    private BigDecimal serviceChargeAmount;

    private String cardNumber;

    private String cardEnc;

    private String bankName;

    private String accountNumber;

    private String userMobile;

    private String coupons;

    private String transComment;

    private Date createdAt;

    private Date updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTransNo() {
        return transNo;
    }

    public void setTransNo(String transNo) {
        this.transNo = transNo == null ? null : transNo.trim();
    }

    public String getTransChannel() {
        return transChannel;
    }

    public void setTransChannel(String transChannel) {
        this.transChannel = transChannel == null ? null : transChannel.trim();
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId == null ? null : activityId.trim();
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName == null ? null : activityName.trim();
    }

    public String getPreferType() {
        return preferType;
    }

    public void setPreferType(String preferType) {
        this.preferType = preferType == null ? null : preferType.trim();
    }

    public String getAcquirerTransNo() {
        return acquirerTransNo;
    }

    public void setAcquirerTransNo(String acquirerTransNo) {
        this.acquirerTransNo = acquirerTransNo == null ? null : acquirerTransNo.trim();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    public Integer getTransType() {
        return transType;
    }

    public void setTransType(Integer transType) {
        this.transType = transType;
    }

    public Integer getEmiType() {
        return emiType;
    }

    public void setEmiType(Integer emiType) {
        this.emiType = emiType;
    }

    public Integer getEmiMonths() {
        return emiMonths;
    }

    public void setEmiMonths(Integer emiMonths) {
        this.emiMonths = emiMonths;
    }

    public BigDecimal getEmiThreshold() {
        return emiThreshold;
    }

    public void setEmiThreshold(BigDecimal emiThreshold) {
        this.emiThreshold = emiThreshold;
    }

    public BigDecimal getBusiGrossProfit() {
        return busiGrossProfit;
    }

    public void setBusiGrossProfit(BigDecimal busiGrossProfit) {
        this.busiGrossProfit = busiGrossProfit;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStoreChannel() {
        return storeChannel;
    }

    public void setStoreChannel(String storeChannel) {
        this.storeChannel = storeChannel == null ? null : storeChannel.trim();
    }

    public Integer getAcquirerId() {
        return acquirerId;
    }

    public void setAcquirerId(Integer acquirerId) {
        this.acquirerId = acquirerId;
    }

    public Integer getAgencyId() {
        return agencyId;
    }

    public void setAgencyId(Integer agencyId) {
        this.agencyId = agencyId;
    }

    public BigDecimal getTransRate() {
        return transRate;
    }

    public void setTransRate(BigDecimal transRate) {
        this.transRate = transRate;
    }

    public String getDeviceSn() {
        return deviceSn;
    }

    public void setDeviceSn(String deviceSn) {
        this.deviceSn = deviceSn == null ? null : deviceSn.trim();
    }

    public String getStoreNumber() {
        return storeNumber;
    }

    public void setStoreNumber(String storeNumber) {
        this.storeNumber = storeNumber == null ? null : storeNumber.trim();
    }

    public String getTerminalNumber() {
        return terminalNumber;
    }

    public void setTerminalNumber(String terminalNumber) {
        this.terminalNumber = terminalNumber == null ? null : terminalNumber.trim();
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType == null ? null : paymentType.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getProfitStatus() {
        return profitStatus;
    }

    public void setProfitStatus(Integer profitStatus) {
        this.profitStatus = profitStatus;
    }

    public String getProfitStatusMsg() {
        return profitStatusMsg;
    }

    public void setProfitStatusMsg(String profitStatusMsg) {
        this.profitStatusMsg = profitStatusMsg == null ? null : profitStatusMsg.trim();
    }

    public Date getTransDate() {
        return transDate;
    }

    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    public Date getTransTime() {
        return transTime;
    }

    public void setTransTime(Date transTime) {
        this.transTime = transTime;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getDisAmount() {
        return disAmount;
    }

    public void setDisAmount(BigDecimal disAmount) {
        this.disAmount = disAmount;
    }

    public BigDecimal getCanDisAmount() {
        return canDisAmount;
    }

    public void setCanDisAmount(BigDecimal canDisAmount) {
        this.canDisAmount = canDisAmount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public BigDecimal getSubsidyAmount() {
        return subsidyAmount;
    }

    public void setSubsidyAmount(BigDecimal subsidyAmount) {
        this.subsidyAmount = subsidyAmount;
    }

    public BigDecimal getBusiGetAmount() {
        return busiGetAmount;
    }

    public void setBusiGetAmount(BigDecimal busiGetAmount) {
        this.busiGetAmount = busiGetAmount;
    }

    public BigDecimal getBankMoney() {
        return bankMoney;
    }

    public void setBankMoney(BigDecimal bankMoney) {
        this.bankMoney = bankMoney;
    }

    public BigDecimal getPrepayMoney() {
        return prepayMoney;
    }

    public void setPrepayMoney(BigDecimal prepayMoney) {
        this.prepayMoney = prepayMoney;
    }

    public BigDecimal getPrerealMoney() {
        return prerealMoney;
    }

    public void setPrerealMoney(BigDecimal prerealMoney) {
        this.prerealMoney = prerealMoney;
    }

    public BigDecimal getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(BigDecimal totalProfit) {
        this.totalProfit = totalProfit;
    }

    public BigDecimal getKsProfit() {
        return ksProfit;
    }

    public void setKsProfit(BigDecimal ksProfit) {
        this.ksProfit = ksProfit;
    }

    public BigDecimal getAcquirerProfit() {
        return acquirerProfit;
    }

    public void setAcquirerProfit(BigDecimal acquirerProfit) {
        this.acquirerProfit = acquirerProfit;
    }

    public String getAcquirerTerminalNumber() {
        return acquirerTerminalNumber;
    }

    public void setAcquirerTerminalNumber(String acquirerTerminalNumber) {
        this.acquirerTerminalNumber = acquirerTerminalNumber == null ? null : acquirerTerminalNumber.trim();
    }

    public String getAcquirerMerchantNumber() {
        return acquirerMerchantNumber;
    }

    public void setAcquirerMerchantNumber(String acquirerMerchantNumber) {
        this.acquirerMerchantNumber = acquirerMerchantNumber == null ? null : acquirerMerchantNumber.trim();
    }

    public String getRefNumber() {
        return refNumber;
    }

    public void setRefNumber(String refNumber) {
        this.refNumber = refNumber == null ? null : refNumber.trim();
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber == null ? null : batchNumber.trim();
    }

    public String getVoucherNumber() {
        return voucherNumber;
    }

    public void setVoucherNumber(String voucherNumber) {
        this.voucherNumber = voucherNumber == null ? null : voucherNumber.trim();
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public String getAcqChannel() {
        return acqChannel;
    }

    public void setAcqChannel(String acqChannel) {
        this.acqChannel = acqChannel == null ? null : acqChannel.trim();
    }

    public BigDecimal getAcquirerCommissionAmount() {
        return acquirerCommissionAmount;
    }

    public void setAcquirerCommissionAmount(BigDecimal acquirerCommissionAmount) {
        this.acquirerCommissionAmount = acquirerCommissionAmount;
    }

    public BigDecimal getCommissionAmount() {
        return commissionAmount;
    }

    public void setCommissionAmount(BigDecimal commissionAmount) {
        this.commissionAmount = commissionAmount;
    }

    public BigDecimal getServiceChargeAmount() {
        return serviceChargeAmount;
    }

    public void setServiceChargeAmount(BigDecimal serviceChargeAmount) {
        this.serviceChargeAmount = serviceChargeAmount;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber == null ? null : cardNumber.trim();
    }

    public String getCardEnc() {
        return cardEnc;
    }

    public void setCardEnc(String cardEnc) {
        this.cardEnc = cardEnc == null ? null : cardEnc.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber == null ? null : accountNumber.trim();
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile == null ? null : userMobile.trim();
    }

    public String getCoupons() {
        return coupons;
    }

    public void setCoupons(String coupons) {
        this.coupons = coupons == null ? null : coupons.trim();
    }

    public String getTransComment() {
        return transComment;
    }

    public void setTransComment(String transComment) {
        this.transComment = transComment == null ? null : transComment.trim();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}