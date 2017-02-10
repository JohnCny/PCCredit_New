package com.cardpay.mgt.application.auditing.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "T_APPLICATION_APPROVAL")
@ApiModel(value="进件审批")
public class TApplicationApproval extends GenericEntity<Integer>{
    /**
     * 进件审批id
     */
    @Id
    @Column(name = "APPROVAL_ID")
    @ApiModelProperty(value="进件审批id",required = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select APP_APPROVAL_SEQ.nextval from dual")
    private Integer approvalId;

    /**
     * 进件id
     */
    @Column(name = "APPLICATION_ID")
    @ApiModelProperty(value="进件id",required = true)
    private Integer applicationId;

    /**
     * 进件审批决定(0 通过 1 有条件通过 2 退回修改 3 拒绝 )
     */
    @Column(name = "APPROVAL_CONCLUTION")
    @ApiModelProperty(value="进件审批决定(0 通过 1 有条件通过 2 退回修改 3 拒绝 )",required = true)
    private Short approvalConclution;

    /**
     * 进件审批条件 
     */
    @Column(name = "APPROVAL_CONDITIONS")
    @ApiModelProperty(value="进件审批条件 ",required = true)
    private String approvalConditions;

    /**
     * 进件审批额度
     */
    @Column(name = "APPROVAL_AMOUNT")
    @ApiModelProperty(value="进件审批额度",required = true)
    private BigDecimal approvalAmount;

    /**
     * 进件审批利率
     */
    @Column(name = "APPROVAL_RATE")
    @ApiModelProperty(value="进件审批利率",required = true)
    private BigDecimal approvalRate;

    /**
     * 进件审批意见
     */
    @Column(name = "APPROVAL_OPINION")
    @ApiModelProperty(value="进件审批意见",required = true)
    private String approvalOpinion;

    /**
     * 进件审批人姓名
     */
    @Column(name = "APPROVAL_PERSON_CNAME")
    @ApiModelProperty(value="进件审批人姓名",required = true)
    private String approvalPersonCname;

    /**
     * 进件审批人id
     */
    @Column(name = "APPROVAL_PERSON_ID")
    @ApiModelProperty(value="进件审批人id",required = true)
    private String approvalPersonId;

    /**
     * 当前所属产品审批节点id
     */
    @Column(name = "PRODUCT_APPROVAL_ID")
    @ApiModelProperty(value="当前所属产品审批节点id",required = true)
    private Integer productApprovalId;

    /**
     * 进件审批人节点名称
     */
    @Column(name = "APPROVAL_NODE_NAME")
    @ApiModelProperty(value="进件审批人节点名称",required = true)
    private String approvalNodeName;

    /**
     * 当前审核人进件审批状态(0 未完成 1 完成 2  退回重写  3 待复核)
     */
    @Column(name = "APPROVAL_STATUS")
    @ApiModelProperty(value="当前审核人进件审批状态(0 未完成 1 完成 2  退回重写  3 待复核)",required = true)
    private Short approvalStatus;

    /**
     * 获取进件审批id
     *
     * @return APPROVAL_ID - 进件审批id
     */
    public Integer getApprovalId() {
        return approvalId;
    }

    /**
     * 设置进件审批id
     *
     * @param approvalId 进件审批id
     */
    public void setApprovalId(Integer approvalId) {
        this.approvalId = approvalId;
    }

    /**
     * 获取进件id
     *
     * @return APPLICATION_ID - 进件id
     */
    public Integer getApplicationId() {
        return applicationId;
    }

    /**
     * 设置进件id
     *
     * @param applicationId 进件id
     */
    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * 获取进件审批决定(0 通过 1 有条件通过 2 退回修改 3 拒绝 )
     *
     * @return APPROVAL_CONCLUTION - 进件审批决定(0 通过 1 有条件通过 2 退回修改 3 拒绝 )
     */
    public Short getApprovalConclution() {
        return approvalConclution;
    }

    /**
     * 设置进件审批决定(0 通过 1 有条件通过 2 退回修改 3 拒绝 )
     *
     * @param approvalConclution 进件审批决定(0 通过 1 有条件通过 2 退回修改 3 拒绝 )
     */
    public void setApprovalConclution(Short approvalConclution) {
        this.approvalConclution = approvalConclution;
    }

    /**
     * 获取进件审批条件 
     *
     * @return APPROVAL_CONDITIONS - 进件审批条件 
     */
    public String getApprovalConditions() {
        return approvalConditions;
    }

    /**
     * 设置进件审批条件 
     *
     * @param approvalConditions 进件审批条件 
     */
    public void setApprovalConditions(String approvalConditions) {
        this.approvalConditions = approvalConditions;
    }

    /**
     * 获取进件审批额度
     *
     * @return APPROVAL_AMOUNT - 进件审批额度
     */
    public BigDecimal getApprovalAmount() {
        return approvalAmount;
    }

    /**
     * 设置进件审批额度
     *
     * @param approvalAmount 进件审批额度
     */
    public void setApprovalAmount(BigDecimal approvalAmount) {
        this.approvalAmount = approvalAmount;
    }

    /**
     * 获取进件审批利率
     *
     * @return APPROVAL_RATE - 进件审批利率
     */
    public BigDecimal getApprovalRate() {
        return approvalRate;
    }

    /**
     * 设置进件审批利率
     *
     * @param approvalRate 进件审批利率
     */
    public void setApprovalRate(BigDecimal approvalRate) {
        this.approvalRate = approvalRate;
    }

    /**
     * 获取进件审批意见
     *
     * @return APPROVAL_OPINION - 进件审批意见
     */
    public String getApprovalOpinion() {
        return approvalOpinion;
    }

    /**
     * 设置进件审批意见
     *
     * @param approvalOpinion 进件审批意见
     */
    public void setApprovalOpinion(String approvalOpinion) {
        this.approvalOpinion = approvalOpinion;
    }

    /**
     * 获取进件审批人姓名
     *
     * @return APPROVAL_PERSON_CNAME - 进件审批人姓名
     */
    public String getApprovalPersonCname() {
        return approvalPersonCname;
    }

    /**
     * 设置进件审批人姓名
     *
     * @param approvalPersonCname 进件审批人姓名
     */
    public void setApprovalPersonCname(String approvalPersonCname) {
        this.approvalPersonCname = approvalPersonCname;
    }

    /**
     * 获取进件审批人id
     *
     * @return APPROVAL_PERSON_ID - 进件审批人id
     */
    public String getApprovalPersonId() {
        return approvalPersonId;
    }

    /**
     * 设置进件审批人id
     *
     * @param approvalPersonId 进件审批人id
     */
    public void setApprovalPersonId(String approvalPersonId) {
        this.approvalPersonId = approvalPersonId;
    }

    /**
     * 获取当前所属产品审批节点id
     *
     * @return PRIDUCT_APPROVAL_ID - 当前所属产品审批节点id
     */
    public Integer getProductApprovalId() {
        return productApprovalId;
    }

    /**
     * 设置当前所属产品审批节点id
     *
     * @param productApprovalId 当前所属产品审批节点id
     */
    public void setProductApprovalId(Integer productApprovalId) {
        this.productApprovalId = productApprovalId;
    }

    /**
     * 获取进件审批人节点名称
     *
     * @return APPROVAL_NODE_NAME - 进件审批人节点名称
     */
    public String getApprovalNodeName() {
        return approvalNodeName;
    }

    /**
     * 设置进件审批人节点名称
     *
     * @param approvalNodeName 进件审批人节点名称
     */
    public void setApprovalNodeName(String approvalNodeName) {
        this.approvalNodeName = approvalNodeName;
    }

    /**
     * 获取当前审核人进件审批状态(0 未完成 1 完成 2  退回重写  3 待复核)
     *
     * @return APPROVAL_STATUS - 当前审核人进件审批状态(0 未完成 1 完成 2  退回重写  3 待复核)
     */
    public Short getApprovalStatus() {
        return approvalStatus;
    }

    /**
     * 设置当前审核人进件审批状态(0 未完成 1 完成 2  退回重写  3 待复核)
     *
     * @param approvalStatus 当前审核人进件审批状态(0 未完成 1 完成 2  退回重写  3 待复核)
     */
    public void setApprovalStatus(Short approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    @Override
    public Integer getPK() {
        return approvalId;
    }
}