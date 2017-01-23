package com.cardpay.mgt.loan.model.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 不良客户VO
 *
 * @author rankai
 *         createTime 2017-01-2017/1/23 15:28
 */
public class BadDebtCustomerVo {
    /**
     * 不良客户列表id
     */
    private Integer collectionId;

    /**
     * 不良客户id
     */
    private Integer badCustomerId;

    /**
     * 不良客户证件号码
     */
    private String badCustomerCardNum;


    /**
     * 逾期或者不良金额
     */
    private BigDecimal badDebtAmount;


    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 进件id
     */
    private Integer applicationId;

    /**
     * 客户类型(0 个人用户 1 企业用户)
     */
    private Integer customerType;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 客户名称
     */
    private String customerName;

    public Integer getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    public Integer getBadCustomerId() {
        return badCustomerId;
    }

    public void setBadCustomerId(Integer badCustomerId) {
        this.badCustomerId = badCustomerId;
    }

    public String getBadCustomerCardNum() {
        return badCustomerCardNum;
    }

    public void setBadCustomerCardNum(String badCustomerCardNum) {
        this.badCustomerCardNum = badCustomerCardNum;
    }

    public BigDecimal getBadDebtAmount() {
        return badDebtAmount;
    }

    public void setBadDebtAmount(BigDecimal badDebtAmount) {
        this.badDebtAmount = badDebtAmount;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Integer customerType) {
        this.customerType = customerType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
}
