package com.cardpay.mgt.riskblack.model.vo;

import java.util.Date;

/**
 * 黑名单VO
 *
 * @author rankai
 *         createTime 2017-02-2017/2/7 11:02
 */
public class BlackCustomerVo {

    /**
     * 黑名单客户列表id
     */
    private Integer blackId;

    /**
     * 黑名单客户id
     */
    private Integer tBlackCustomerId;

    /**
     * 黑名单进入原因
     */
    private String blackReason;

    /**
     * 黑名单客户状态(0 正常 1 转出审核中)
     */
    private Integer tBlackCustomerStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 操作人
     */
    private Integer createBy;

    /**
     * 黑名单客户所属客户经理id
     */
    private Integer customerManagerId;

    /**
     * 客户类型
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

    /**
     * 用户状态(0正常,1高风险用户 2黑名单用户 3高风险转黑名单审核 4黑名单转出 5禁用客户 6客户移交中)
     */
    private Integer customerStatus;

    public Integer getBlackId() {
        return blackId;
    }

    public void setBlackId(Integer blackId) {
        this.blackId = blackId;
    }

    public Integer gettBlackCustomerId() {
        return tBlackCustomerId;
    }

    public void settBlackCustomerId(Integer tBlackCustomerId) {
        this.tBlackCustomerId = tBlackCustomerId;
    }

    public String getBlackReason() {
        return blackReason;
    }

    public void setBlackReason(String blackReason) {
        this.blackReason = blackReason;
    }

    public Integer gettBlackCustomerStatus() {
        return tBlackCustomerStatus;
    }

    public void settBlackCustomerStatus(Integer tBlackCustomerStatus) {
        this.tBlackCustomerStatus = tBlackCustomerStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Integer getCustomerManagerId() {
        return customerManagerId;
    }

    public void setCustomerManagerId(Integer customerManagerId) {
        this.customerManagerId = customerManagerId;
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

    public Integer getCustomerStatus() {
        return customerStatus;
    }

    public void setCustomerStatus(Integer customerStatus) {
        this.customerStatus = customerStatus;
    }
}
