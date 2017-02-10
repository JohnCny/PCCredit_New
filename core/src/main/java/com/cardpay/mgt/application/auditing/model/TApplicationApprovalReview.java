package com.cardpay.mgt.application.auditing.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "T_APPLICATION_APPROVAL_REVIEW")
@ApiModel(value="审贷会排审表管理")
public class TApplicationApprovalReview extends GenericEntity<Integer>{
    /**
     * 审贷会id
     */
    @Id
    @Column(name = "REVIEW_ID")
    @ApiModelProperty(value="审贷会id",required = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select APP_APPROVAL_REVIEW_SEQ.nextval from dual")
    private Integer reviewId;

    /**
     * 进件id
     */
    @Column(name = "APPLICATION_ID")
    @ApiModelProperty(value="进件id",required = true)
    private Integer applicationId;

    /**
     * 审贷会
     */
    @Column(name = "REVIEW_START_TIME")
    @ApiModelProperty(value="审贷会",required = true)
    private Date reviewStartTime;

    @Column(name = "REVIEW_END_TIME")
    @ApiModelProperty(value="null",required = true)
    private Date reviewEndTime;

    /**
     * 进件审批决定(0 通过 1 有条件通过 2 退回修改 3 拒绝 )
     */
    @Column(name = "REVIEW_CONCLUTION")
    @ApiModelProperty(value="进件审批决定(0 通过 1 有条件通过 2 退回修改 3 拒绝 )",required = true)
    private Integer reviewConclution;

    /**
     * 进件审批条件 
     */
    @Column(name = "REVIEW_CONDITIONS")
    @ApiModelProperty(value="进件审批条件 ",required = true)
    private String reviewConditions;

    /**
     * 进件审批额度
     */
    @Column(name = "REVIEW_AMOUNT")
    @ApiModelProperty(value="进件审批额度",required = true)
    private BigDecimal reviewAmount;

    /**
     * 进件审批利率
     */
    @Column(name = "REVIEW_RATE")
    @ApiModelProperty(value="进件审批利率",required = true)
    private BigDecimal reviewRate;

    /**
     * 进件审批意见
     */
    @Column(name = "REVIEW_OPINION")
    @ApiModelProperty(value="进件审批意见",required = true)
    private String reviewOpinion;

    /**
     * 进件审批人姓名
     */
    @Column(name = "REVIEW_PERSON_CNAME")
    @ApiModelProperty(value="进件审批人姓名",required = true)
    private String reviewPersonCname;

    /**
     * 进件审批人id
     */
    @Column(name = "REVIEW_PERSON_ID")
    @ApiModelProperty(value="进件审批人id",required = true)
    private String reviewPersonId;

    /**
     * 进件审核审贷会节点id
     */
    @Column(name = "APPROVAL_ID")
    @ApiModelProperty(value="进件审核审贷会节点id",required = true)
    private Integer approvalId;

    /**
     * 审核状态(0 未审核  1 完成审核)
     */
    @Column(name = "REVIEW_STATUS")
    @ApiModelProperty(value="审核状态(0 未审核  1 完成审核)",required = true)
    private Integer reviewStatus;

    /**
     * 获取审贷会id
     *
     * @return REVIEW_ID - 审贷会id
     */
    public Integer getReviewId() {
        return reviewId;
    }

    /**
     * 设置审贷会id
     *
     * @param reviewId 审贷会id
     */
    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
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
     * 获取审贷会
     *
     * @return REVIEW_START_TIME - 审贷会
     */
    public Date getReviewStartTime() {
        return reviewStartTime;
    }

    /**
     * 设置审贷会
     *
     * @param reviewStartTime 审贷会
     */
    public void setReviewStartTime(Date reviewStartTime) {
        this.reviewStartTime = reviewStartTime;
    }

    /**
     * @return REVIEW_END_TIME
     */
    public Date getReviewEndTime() {
        return reviewEndTime;
    }

    /**
     * @param reviewEndTime
     */
    public void setReviewEndTime(Date reviewEndTime) {
        this.reviewEndTime = reviewEndTime;
    }

    /**
     * 获取进件审批决定(0 通过 1 有条件通过 2 退回修改 3 拒绝 )
     *
     * @return REVIEW_CONCLUTION - 进件审批决定(0 通过 1 有条件通过 2 退回修改 3 拒绝 )
     */
    public Integer getReviewConclution() {
        return reviewConclution;
    }

    /**
     * 设置进件审批决定(0 通过 1 有条件通过 2 退回修改 3 拒绝 )
     *
     * @param reviewConclution 进件审批决定(0 通过 1 有条件通过 2 退回修改 3 拒绝 )
     */
    public void setReviewConclution(Integer reviewConclution) {
        this.reviewConclution = reviewConclution;
    }

    /**
     * 获取进件审批条件 
     *
     * @return REVIEW_CONDITIONS - 进件审批条件 
     */
    public String getReviewConditions() {
        return reviewConditions;
    }

    /**
     * 设置进件审批条件 
     *
     * @param reviewConditions 进件审批条件 
     */
    public void setReviewConditions(String reviewConditions) {
        this.reviewConditions = reviewConditions;
    }

    /**
     * 获取进件审批额度
     *
     * @return REVIEW_AMOUNT - 进件审批额度
     */
    public BigDecimal getReviewAmount() {
        return reviewAmount;
    }

    /**
     * 设置进件审批额度
     *
     * @param reviewAmount 进件审批额度
     */
    public void setReviewAmount(BigDecimal reviewAmount) {
        this.reviewAmount = reviewAmount;
    }

    /**
     * 获取进件审批利率
     *
     * @return REVIEW_RATE - 进件审批利率
     */
    public BigDecimal getReviewRate() {
        return reviewRate;
    }

    /**
     * 设置进件审批利率
     *
     * @param reviewRate 进件审批利率
     */
    public void setReviewRate(BigDecimal reviewRate) {
        this.reviewRate = reviewRate;
    }

    /**
     * 获取进件审批意见
     *
     * @return REVIEW_OPINION - 进件审批意见
     */
    public String getReviewOpinion() {
        return reviewOpinion;
    }

    /**
     * 设置进件审批意见
     *
     * @param reviewOpinion 进件审批意见
     */
    public void setReviewOpinion(String reviewOpinion) {
        this.reviewOpinion = reviewOpinion;
    }

    /**
     * 获取进件审批人姓名
     *
     * @return REVIEW_PERSON_CNAME - 进件审批人姓名
     */
    public String getReviewPersonCname() {
        return reviewPersonCname;
    }

    /**
     * 设置进件审批人姓名
     *
     * @param reviewPersonCname 进件审批人姓名
     */
    public void setReviewPersonCname(String reviewPersonCname) {
        this.reviewPersonCname = reviewPersonCname;
    }

    /**
     * 获取进件审批人id
     *
     * @return REVIEW_PERSON_ID - 进件审批人id
     */
    public String getReviewPersonId() {
        return reviewPersonId;
    }

    /**
     * 设置进件审批人id
     *
     * @param reviewPersonId 进件审批人id
     */
    public void setReviewPersonId(String reviewPersonId) {
        this.reviewPersonId = reviewPersonId;
    }

    /**
     * 获取进件审核审贷会节点id
     *
     * @return APPROVAL_ID - 进件审核审贷会节点id
     */
    public Integer getApprovalId() {
        return approvalId;
    }

    /**
     * 设置进件审核审贷会节点id
     *
     * @param approvalId 进件审核审贷会节点id
     */
    public void setApprovalId(Integer approvalId) {
        this.approvalId = approvalId;
    }

    /**
     * 获取审核状态(0 未审核  1 完成审核)
     *
     * @return REVIEW_STATUS - 审核状态(0 未审核  1 完成审核)
     */
    public Integer getReviewStatus() {
        return reviewStatus;
    }

    /**
     * 设置审核状态(0 未审核  1 完成审核)
     *
     * @param reviewStatus 审核状态(0 未审核  1 完成审核)
     */
    public void setReviewStatus(Integer reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    @Override
    public Integer getPK() {
        return reviewId;
    }
}