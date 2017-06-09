package com.kashuo.kap.bill.domain;

import java.util.Date;

public class ProfitAgency {
    private Integer id;

    private String name;

    private Date createTime;

    private Byte hasLimit;

    private String createBy;

    private Byte industryNonstandard;

    private Integer code;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Byte getHasLimit() {
        return hasLimit;
    }

    public void setHasLimit(Byte hasLimit) {
        this.hasLimit = hasLimit;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Byte getIndustryNonstandard() {
        return industryNonstandard;
    }

    public void setIndustryNonstandard(Byte industryNonstandard) {
        this.industryNonstandard = industryNonstandard;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}