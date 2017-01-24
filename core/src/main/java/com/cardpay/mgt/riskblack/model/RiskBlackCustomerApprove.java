package com.cardpay.mgt.riskblack.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.persistence.*;

@Table(name = "T_RISKBLACK_CUSTOMER_APPROVE")
@ApiModel(value="风险客户或者黑名单操作审批表")
public class RiskBlackCustomerApprove {
    /**
     * 风险客户审核信息id
     */
    @Id
    @Column(name = "RISK_BLACK_APPROVE_ID")
    @ApiModelProperty(value="风险客户审核信息id",required = true)
    private Integer riskBlackApproveId;

    /**
     * 风险客户申请操作类型(0 转入黑名单 1 转出黑名单 2 转出风险名单)
     */
    @Column(name = "RISK_BLACK_OPERATION_TYPE")
    @ApiModelProperty(value="风险客户申请操作类型(0 转入黑名单 1 转出黑名单 2 转出风险名单)",required = true)
    private Integer riskBlackOperationType;

    /**
     * 风险客户审批状态(0 待审核 1 已审核)
     */
    @Column(name = "RISK_BLACK_APPROVE_STATUS")
    @ApiModelProperty(value="风险客户审批状态(0 待审核 1 已审核)",required = true)
    private Integer riskBlackApproveStatus;

    /**
     * 转入转出风险或者黑名单原因
     */
    @Column(name = "RISK_BLACK_TRANSFOR_REASON")
    @ApiModelProperty(value="转入转出风险或者黑名单原因",required = true)
    private String riskBlackTransforReason;

    /**
     * 审核时间
     */
    @Column(name = "APPROVE_TIME")
    @ApiModelProperty(value="审核时间",required = true)
    private Date approveTime;

    /**
     * 审核人
     */
    @Column(name = "APPROVE_BY")
    @ApiModelProperty(value="审核人",required = true)
    private Integer approveBy;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    @ApiModelProperty(value="创建时间",required = true)
    private Date createTime;

    /**
     * 创建人
     */
    @Column(name = "CREATE_BY")
    @ApiModelProperty(value="创建人",required = true)
    private Integer createBy;

    /**
     * 客户id
     */
    @Column(name = "RISK_BLACK_CUSTOMER_ID")
    @ApiModelProperty(value="客户id",required = true)
    private Integer riskBlackCustomerId;

    /**
     * 客户类型(0 个人客户 1 企业客户)
     */
    @Column(name = "CUSTOMER_TYPE")
    @ApiModelProperty(value="客户类型(0 个人客户 1 企业客户)",required = true)
    private Integer customerType;

    /**
     * 获取风险客户审核信息id
     *
     * @return RISK_BLACK_APPROVE_ID - 风险客户审核信息id
     */
    public Integer getRiskBlackApproveId() {
        return riskBlackApproveId;
    }

    /**
     * 设置风险客户审核信息id
     *
     * @param riskBlackApproveId 风险客户审核信息id
     */
    public void setRiskBlackApproveId(Integer riskBlackApproveId) {
        this.riskBlackApproveId = riskBlackApproveId;
    }

    /**
     * 获取风险客户申请操作类型(0 转入黑名单 1 转出黑名单 2 转出风险名单)
     *
     * @return RISK_BLACK_OPERATION_TYPE - 风险客户申请操作类型(0 转入黑名单 1 转出黑名单 2 转出风险名单)
     */
    public Integer getRiskBlackOperationType() {
        return riskBlackOperationType;
    }

    /**
     * 设置风险客户申请操作类型(0 转入黑名单 1 转出黑名单 2 转出风险名单)
     *
     * @param riskBlackOperationType 风险客户申请操作类型(0 转入黑名单 1 转出黑名单 2 转出风险名单)
     */
    public void setRiskBlackOperationType(Integer riskBlackOperationType) {
        this.riskBlackOperationType = riskBlackOperationType;
    }

    /**
     * 获取风险客户审批状态(0 待审核 1 已审核)
     *
     * @return RISK_BLACK_APPROVE_STATUS - 风险客户审批状态(0 待审核 1 已审核)
     */
    public Integer getRiskBlackApproveStatus() {
        return riskBlackApproveStatus;
    }

    /**
     * 设置风险客户审批状态(0 待审核 1 已审核)
     *
     * @param riskBlackApproveStatus 风险客户审批状态(0 待审核 1 已审核)
     */
    public void setRiskBlackApproveStatus(Integer riskBlackApproveStatus) {
        this.riskBlackApproveStatus = riskBlackApproveStatus;
    }

    /**
     * 获取转入转出风险或者黑名单原因
     *
     * @return RISK_BLACK_TRANSFOR_REASON - 转入转出风险或者黑名单原因
     */
    public String getRiskBlackTransforReason() {
        return riskBlackTransforReason;
    }

    /**
     * 设置转入转出风险或者黑名单原因
     *
     * @param riskBlackTransforReason 转入转出风险或者黑名单原因
     */
    public void setRiskBlackTransforReason(String riskBlackTransforReason) {
        this.riskBlackTransforReason = riskBlackTransforReason;
    }

    /**
     * 获取审核时间
     *
     * @return APPROVE_TIME - 审核时间
     */
    public Date getApproveTime() {
        return approveTime;
    }

    /**
     * 设置审核时间
     *
     * @param approveTime 审核时间
     */
    public void setApproveTime(Date approveTime) {
        this.approveTime = approveTime;
    }

    /**
     * 获取审核人
     *
     * @return APPROVE_BY - 审核人
     */
    public Integer getApproveBy() {
        return approveBy;
    }

    /**
     * 设置审核人
     *
     * @param approveBy 审核人
     */
    public void setApproveBy(Integer approveBy) {
        this.approveBy = approveBy;
    }

    /**
     * 获取创建时间
     *
     * @return CREATE_TIME - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取创建人
     *
     * @return CREATE_BY - 创建人
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人
     *
     * @param createBy 创建人
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取客户id
     *
     * @return RISK_BLACK_CUSTOMER_ID - 客户id
     */
    public Integer getRiskBlackCustomerId() {
        return riskBlackCustomerId;
    }

    /**
     * 设置客户id
     *
     * @param riskBlackCustomerId 客户id
     */
    public void setRiskBlackCustomerId(Integer riskBlackCustomerId) {
        this.riskBlackCustomerId = riskBlackCustomerId;
    }

    /**
     * 获取客户类型(0 个人客户 1 企业客户)
     *
     * @return CUSTOMER_TYPE - 客户类型(0 个人客户 1 企业客户)
     */
    public Integer getCustomerType() {
        return customerType;
    }

    /**
     * 设置客户类型(0 个人客户 1 企业客户)
     *
     * @param customerType 客户类型(0 个人客户 1 企业客户)
     */
    public void setCustomerType(Integer customerType) {
        this.customerType = customerType;
    }
}