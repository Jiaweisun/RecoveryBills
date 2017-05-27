package com.kashuo.kap.bill.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Merchant {
    private Integer id;

    private String name;

    private String logo;

    private String slogans;

    private String code;

    private Integer type;

    private String channelCode;

    private String spelling;

    private String shortSelling;

    private String company;

    private Integer provinceId;

    private Integer cityId;

    private Integer districtId;

    private String address;

    private String contactPerson;

    private String phoneNumber;

    private String email;

    private Integer companyAccountId;

    private Boolean hasAliPay;

    private Boolean hasWechatPay;

    private Boolean hasCashPay;

    private Boolean hasPrePayCard;

    private Integer status;

    private Integer categoryId;

    private Integer commissionType;

    private BigDecimal commissionFee;

    private BigDecimal cashBonus;

    private BigDecimal taxFee;

    private Integer settlementType;

    private String registryName;

    private String registryCode;

    private String companyType;

    private String legalUser;

    private Integer cardType;

    private String cardCode;

    private String business;

    private Integer merchantAccountType;

    private Date createdAt;

    private String createdBy;

    private Date updatedAt;

    private String updatedBy;

    private Boolean deleteMark;

    private Integer dataType;

    private Integer systemId;

    private BigDecimal guideDiscount;

    private String paxCid;

    private Byte hasPapers;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public String getSlogans() {
        return slogans;
    }

    public void setSlogans(String slogans) {
        this.slogans = slogans == null ? null : slogans.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode == null ? null : channelCode.trim();
    }

    public String getSpelling() {
        return spelling;
    }

    public void setSpelling(String spelling) {
        this.spelling = spelling == null ? null : spelling.trim();
    }

    public String getShortSelling() {
        return shortSelling;
    }

    public void setShortSelling(String shortSelling) {
        this.shortSelling = shortSelling == null ? null : shortSelling.trim();
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company == null ? null : company.trim();
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getDistrictId() {
        return districtId;
    }

    public void setDistrictId(Integer districtId) {
        this.districtId = districtId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson == null ? null : contactPerson.trim();
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber == null ? null : phoneNumber.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getCompanyAccountId() {
        return companyAccountId;
    }

    public void setCompanyAccountId(Integer companyAccountId) {
        this.companyAccountId = companyAccountId;
    }

    public Boolean getHasAliPay() {
        return hasAliPay;
    }

    public void setHasAliPay(Boolean hasAliPay) {
        this.hasAliPay = hasAliPay;
    }

    public Boolean getHasWechatPay() {
        return hasWechatPay;
    }

    public void setHasWechatPay(Boolean hasWechatPay) {
        this.hasWechatPay = hasWechatPay;
    }

    public Boolean getHasCashPay() {
        return hasCashPay;
    }

    public void setHasCashPay(Boolean hasCashPay) {
        this.hasCashPay = hasCashPay;
    }

    public Boolean getHasPrePayCard() {
        return hasPrePayCard;
    }

    public void setHasPrePayCard(Boolean hasPrePayCard) {
        this.hasPrePayCard = hasPrePayCard;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getCommissionType() {
        return commissionType;
    }

    public void setCommissionType(Integer commissionType) {
        this.commissionType = commissionType;
    }

    public BigDecimal getCommissionFee() {
        return commissionFee;
    }

    public void setCommissionFee(BigDecimal commissionFee) {
        this.commissionFee = commissionFee;
    }

    public BigDecimal getCashBonus() {
        return cashBonus;
    }

    public void setCashBonus(BigDecimal cashBonus) {
        this.cashBonus = cashBonus;
    }

    public BigDecimal getTaxFee() {
        return taxFee;
    }

    public void setTaxFee(BigDecimal taxFee) {
        this.taxFee = taxFee;
    }

    public Integer getSettlementType() {
        return settlementType;
    }

    public void setSettlementType(Integer settlementType) {
        this.settlementType = settlementType;
    }

    public String getRegistryName() {
        return registryName;
    }

    public void setRegistryName(String registryName) {
        this.registryName = registryName == null ? null : registryName.trim();
    }

    public String getRegistryCode() {
        return registryCode;
    }

    public void setRegistryCode(String registryCode) {
        this.registryCode = registryCode == null ? null : registryCode.trim();
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType == null ? null : companyType.trim();
    }

    public String getLegalUser() {
        return legalUser;
    }

    public void setLegalUser(String legalUser) {
        this.legalUser = legalUser == null ? null : legalUser.trim();
    }

    public Integer getCardType() {
        return cardType;
    }

    public void setCardType(Integer cardType) {
        this.cardType = cardType;
    }

    public String getCardCode() {
        return cardCode;
    }

    public void setCardCode(String cardCode) {
        this.cardCode = cardCode == null ? null : cardCode.trim();
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business == null ? null : business.trim();
    }

    public Integer getMerchantAccountType() {
        return merchantAccountType;
    }

    public void setMerchantAccountType(Integer merchantAccountType) {
        this.merchantAccountType = merchantAccountType;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    public Boolean getDeleteMark() {
        return deleteMark;
    }

    public void setDeleteMark(Boolean deleteMark) {
        this.deleteMark = deleteMark;
    }

    public Integer getDataType() {
        return dataType;
    }

    public void setDataType(Integer dataType) {
        this.dataType = dataType;
    }

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    public BigDecimal getGuideDiscount() {
        return guideDiscount;
    }

    public void setGuideDiscount(BigDecimal guideDiscount) {
        this.guideDiscount = guideDiscount;
    }

    public String getPaxCid() {
        return paxCid;
    }

    public void setPaxCid(String paxCid) {
        this.paxCid = paxCid == null ? null : paxCid.trim();
    }

    public Byte getHasPapers() {
        return hasPapers;
    }

    public void setHasPapers(Byte hasPapers) {
        this.hasPapers = hasPapers;
    }
}