package com.cardpay.mgt.riskblack.model.vo;

import java.util.Date;

/**
 * 风险客户VO
 *
 * @author rankai
 *         createTime 2017-01-2017/1/24 10:03
 */
public class RiskCustomerVo {

    /**
     * 不良客户列表id
     */
    private Integer collectionId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 进入不良客户原因
     */
    private String badReason;

    /**
     * 不良客户所属客户经理id
     */
    private Integer customerManagerId;

    /**
     * 客户id
     */
    private Integer customerId;

    /**
     * 客户类型(0 个人用户 1 企业用户)
     */
    private Integer customerType;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 客户身份证号码
     */
    private String idCard;

    public Integer getCollectionId() {
        return collectionId;
    }

    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getBadReason() {
        return badReason;
    }

    public void setBadReason(String badReason) {
        this.badReason = badReason;
    }

    public Integer getCustomerManagerId() {
        return customerManagerId;
    }

    public void setCustomerManagerId(Integer customerManagerId) {
        this.customerManagerId = customerManagerId;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Integer customerType) {
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }
}
