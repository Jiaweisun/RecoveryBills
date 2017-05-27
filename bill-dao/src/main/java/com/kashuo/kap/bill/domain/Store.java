package com.kashuo.kap.bill.domain;

import java.math.BigDecimal;
import java.util.Date;

public class Store {
    private Integer id;

    private String name;

    private String code;

    private String logo;

    private String channelCode;

    private Integer merchantId;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private Integer regionId;

    private String company;

    private Integer provinceId;

    private Integer cityId;

    private Integer districtId;

    private String address;

    private String faxNumber;

    private String presalePhoneNumber;

    private String businessHours;

    private String businessStartHours;

    private String businessEndHours;

    private String description;

    private String contactPerson;

    private String phoneNumber;

    private String email;

    private String salesContact;

    private String salesPhone;

    private Integer companyAccountId;

    private Boolean hasAliPay;

    private Boolean hasWechatPay;

    private Boolean hasCashPay;

    private Boolean hasPrePayCard;

    private Integer status;

    private String auditOpinion;

    private Integer storeType;

    private Integer roleType;

    private String mobilePayType;

    private String mobileMerchantNo;

    private String mobileTerminalNo;

    private BigDecimal mobileWechatRate;

    private BigDecimal mobileAlipayRate;

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

    private Integer storeAccountType;

    private Date createdAt;

    private String createdBy;

    private Date updatedAt;

    private String updatedBy;

    private Boolean deleteMark;

    private Integer smStoreId;

    private Date auditAt;

    private Integer systemId;

    private BigDecimal normalDiscount;

    private String fitCard;

    private BigDecimal storeArea;

    private Long storeCategoryId;

    private String floor;

    private Integer merchantRegionId;

    private String merchantRegionName;

    private BigDecimal guideDiscount;

    private String auditBy;

    private String paxShopId;

    private String paxMid;

    private String paxRequestId;

    private String positionNum;

    private String storeContactor;

    private String storePhone;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public String getChannelCode() {
        return channelCode;
    }

    public void setChannelCode(String channelCode) {
        this.channelCode = channelCode == null ? null : channelCode.trim();
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public Integer getRegionId() {
        return regionId;
    }

    public void setRegionId(Integer regionId) {
        this.regionId = regionId;
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

    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber == null ? null : faxNumber.trim();
    }

    public String getPresalePhoneNumber() {
        return presalePhoneNumber;
    }

    public void setPresalePhoneNumber(String presalePhoneNumber) {
        this.presalePhoneNumber = presalePhoneNumber == null ? null : presalePhoneNumber.trim();
    }

    public String getBusinessHours() {
        return businessHours;
    }

    public void setBusinessHours(String businessHours) {
        this.businessHours = businessHours == null ? null : businessHours.trim();
    }

    public String getBusinessStartHours() {
        return businessStartHours;
    }

    public void setBusinessStartHours(String businessStartHours) {
        this.businessStartHours = businessStartHours == null ? null : businessStartHours.trim();
    }

    public String getBusinessEndHours() {
        return businessEndHours;
    }

    public void setBusinessEndHours(String businessEndHours) {
        this.businessEndHours = businessEndHours == null ? null : businessEndHours.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
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

    public String getSalesContact() {
        return salesContact;
    }

    public void setSalesContact(String salesContact) {
        this.salesContact = salesContact == null ? null : salesContact.trim();
    }

    public String getSalesPhone() {
        return salesPhone;
    }

    public void setSalesPhone(String salesPhone) {
        this.salesPhone = salesPhone == null ? null : salesPhone.trim();
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

    public String getAuditOpinion() {
        return auditOpinion;
    }

    public void setAuditOpinion(String auditOpinion) {
        this.auditOpinion = auditOpinion == null ? null : auditOpinion.trim();
    }

    public Integer getStoreType() {
        return storeType;
    }

    public void setStoreType(Integer storeType) {
        this.storeType = storeType;
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    public String getMobilePayType() {
        return mobilePayType;
    }

    public void setMobilePayType(String mobilePayType) {
        this.mobilePayType = mobilePayType == null ? null : mobilePayType.trim();
    }

    public String getMobileMerchantNo() {
        return mobileMerchantNo;
    }

    public void setMobileMerchantNo(String mobileMerchantNo) {
        this.mobileMerchantNo = mobileMerchantNo == null ? null : mobileMerchantNo.trim();
    }

    public String getMobileTerminalNo() {
        return mobileTerminalNo;
    }

    public void setMobileTerminalNo(String mobileTerminalNo) {
        this.mobileTerminalNo = mobileTerminalNo == null ? null : mobileTerminalNo.trim();
    }

    public BigDecimal getMobileWechatRate() {
        return mobileWechatRate;
    }

    public void setMobileWechatRate(BigDecimal mobileWechatRate) {
        this.mobileWechatRate = mobileWechatRate;
    }

    public BigDecimal getMobileAlipayRate() {
        return mobileAlipayRate;
    }

    public void setMobileAlipayRate(BigDecimal mobileAlipayRate) {
        this.mobileAlipayRate = mobileAlipayRate;
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

    public Integer getStoreAccountType() {
        return storeAccountType;
    }

    public void setStoreAccountType(Integer storeAccountType) {
        this.storeAccountType = storeAccountType;
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

    public Integer getSmStoreId() {
        return smStoreId;
    }

    public void setSmStoreId(Integer smStoreId) {
        this.smStoreId = smStoreId;
    }

    public Date getAuditAt() {
        return auditAt;
    }

    public void setAuditAt(Date auditAt) {
        this.auditAt = auditAt;
    }

    public Integer getSystemId() {
        return systemId;
    }

    public void setSystemId(Integer systemId) {
        this.systemId = systemId;
    }

    public BigDecimal getNormalDiscount() {
        return normalDiscount;
    }

    public void setNormalDiscount(BigDecimal normalDiscount) {
        this.normalDiscount = normalDiscount;
    }

    public String getFitCard() {
        return fitCard;
    }

    public void setFitCard(String fitCard) {
        this.fitCard = fitCard == null ? null : fitCard.trim();
    }

    public BigDecimal getStoreArea() {
        return storeArea;
    }

    public void setStoreArea(BigDecimal storeArea) {
        this.storeArea = storeArea;
    }

    public Long getStoreCategoryId() {
        return storeCategoryId;
    }

    public void setStoreCategoryId(Long storeCategoryId) {
        this.storeCategoryId = storeCategoryId;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor == null ? null : floor.trim();
    }

    public Integer getMerchantRegionId() {
        return merchantRegionId;
    }

    public void setMerchantRegionId(Integer merchantRegionId) {
        this.merchantRegionId = merchantRegionId;
    }

    public String getMerchantRegionName() {
        return merchantRegionName;
    }

    public void setMerchantRegionName(String merchantRegionName) {
        this.merchantRegionName = merchantRegionName == null ? null : merchantRegionName.trim();
    }

    public BigDecimal getGuideDiscount() {
        return guideDiscount;
    }

    public void setGuideDiscount(BigDecimal guideDiscount) {
        this.guideDiscount = guideDiscount;
    }

    public String getAuditBy() {
        return auditBy;
    }

    public void setAuditBy(String auditBy) {
        this.auditBy = auditBy == null ? null : auditBy.trim();
    }

    public String getPaxShopId() {
        return paxShopId;
    }

    public void setPaxShopId(String paxShopId) {
        this.paxShopId = paxShopId == null ? null : paxShopId.trim();
    }

    public String getPaxMid() {
        return paxMid;
    }

    public void setPaxMid(String paxMid) {
        this.paxMid = paxMid == null ? null : paxMid.trim();
    }

    public String getPaxRequestId() {
        return paxRequestId;
    }

    public void setPaxRequestId(String paxRequestId) {
        this.paxRequestId = paxRequestId == null ? null : paxRequestId.trim();
    }

    public String getPositionNum() {
        return positionNum;
    }

    public void setPositionNum(String positionNum) {
        this.positionNum = positionNum == null ? null : positionNum.trim();
    }

    public String getStoreContactor() {
        return storeContactor;
    }

    public void setStoreContactor(String storeContactor) {
        this.storeContactor = storeContactor == null ? null : storeContactor.trim();
    }

    public String getStorePhone() {
        return storePhone;
    }

    public void setStorePhone(String storePhone) {
        this.storePhone = storePhone == null ? null : storePhone.trim();
    }
}