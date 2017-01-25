package com.cardpay.mgt.riskblack.model.vo;

import java.util.Date;

/**
 * 审批VO
 *
 * @author rankai
 *         createTime 2017-01-2017/1/24 14:41
 */
public class RiskBlackCustomerApproveVo {
    /**
     * 风险客户审核信息id
     */
    private Integer riskBlackApproveId;

    /**
     * 风险客户申请操作类型(0 转入黑名单 1 转出黑名单 2 转出风险名单)
     */
    private Integer riskBlackOperationType;

    /**
     * 风险客户审批状态(0 待审核 1 已审核)
     */
    private Integer riskBlackApproveStatus;

    /**
     * 转入转出风险或者黑名单原因
     */
    private String riskBlackTransforReason;

    /**
     * 审核时间
     */
    private Date approveTime;

    /**
     * 审核人
     */
    private Integer approveBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人
     */
    private Integer createBy;

    /**
     * 客户id
     */
    private Integer riskBlackCustomerId;

    /**
     * 客户类型(0 个人客户 1 企业客户)
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

    public Integer getRiskBlackApproveId() {
        return riskBlackApproveId;
    }

    public void setRiskBlackApproveId(Integer riskBlackApproveId) {
        this.riskBlackApproveId = riskBlackApproveId;
    }

    public Integer getRiskBlackOperationType() {
        return riskBlackOperationType;
    }

    public void setRiskBlackOperationType(Integer riskBlackOperationType) {
        this.riskBlackOperationType = riskBlackOperationType;
    }

    public Integer getRiskBlackApproveStatus() {
        return riskBlackApproveStatus;
    }

    public void setRiskBlackApproveStatus(Integer riskBlackApproveStatus) {
        this.riskBlackApproveStatus = riskBlackApproveStatus;
    }

    public String getRiskBlackTransforReason() {
        return riskBlackTransforReason;
    }

    public void setRiskBlackTransforReason(String riskBlackTransforReason) {
        this.riskBlackTransforReason = riskBlackTransforReason;
    }

    public Date getApproveTime() {
        return approveTime;
    }

    public void setApproveTime(Date approveTime) {
        this.approveTime = approveTime;
    }

    public Integer getApproveBy() {
        return approveBy;
    }

    public void setApproveBy(Integer approveBy) {
        this.approveBy = approveBy;
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

    public Integer getRiskBlackCustomerId() {
        return riskBlackCustomerId;
    }

    public void setRiskBlackCustomerId(Integer riskBlackCustomerId) {
        this.riskBlackCustomerId = riskBlackCustomerId;
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

    /**
     *
     */
}
