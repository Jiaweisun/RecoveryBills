package com.kashuo.kap.bill.model.form;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.io.File;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by sunjiawei on 2017/5/27.
 */
public class TransactionForm {


    @NotNull(message = "{normal.merchantId}")
    private Integer merchantId;

    @NotNull(message = "{normal.storeId}")
    private Integer storeId;

    @NotNull(message = "{normal.deviceSn}")
    @Length(min = 6, max = 10, message = "{normal.deviceSn.length}")
    private String deviceSn;

    @NotNull(message = "{normal.transDate}")
    private String transDate;
    @NotNull(message = "{normal.transTime}")
    private String transTime;

    @NotNull(message = "{normal.totalAmount}")
    @DecimalMin(value="0.00",message="decim最小值是0")
//    @Pattern(regexp = "/^[+-]?(0|([1-9]\\d{0,11}))(\\.\\d{2})?$/", message = "{normal.totalAmount.format}")
    private BigDecimal totalAmount;

    @NotNull(message = "{normal.payAmount}")
    @DecimalMin(value="0.00",message="decim最小值是0")
//    @Pattern(regexp = "/^[+-]?(0|([1-9]\\d{0,11}))(\\.\\d{2})?$/", message = "{normal.payAmount.format}")
    private BigDecimal payAmount;

    @NotNull(message = "{normal.payAmount}")
    @DecimalMin(value="0.00",message="decim最小值是0")
    private BigDecimal transRate;

    @NotNull(message = "{normal.payAmount}")
    @DecimalMin(value="0.00",message="decim最小值是0")
    private BigDecimal totalProfit;

    private String bankName;
    private String cardNumber;

    private String paymentType;
    private String storeChannel;

    private Integer acquirerId;//收单机构编号
    private String acqChannel;//收单机构编码

    private Integer agencyId;


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

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType == null ? null : paymentType.trim();
    }

    public String getTransDate() {
        return transDate;
    }

    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }

    public String getTransTime() {
        return transTime;
    }

    public void setTransTime(String transTime) {
        this.transTime = transTime;
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


    public BigDecimal getTotalProfit() {
        return totalProfit;
    }

    public void setTotalProfit(BigDecimal totalProfit) {
        this.totalProfit = totalProfit;
    }



    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber == null ? null : cardNumber.trim();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getAcqChannel() {
        return acqChannel;
    }

    public void setAcqChannel(String acqChannel) {
        this.acqChannel = acqChannel;
    }
}
