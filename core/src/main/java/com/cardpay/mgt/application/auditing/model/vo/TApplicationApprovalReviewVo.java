package com.cardpay.mgt.application.auditing.model.vo;

import com.cardpay.mgt.application.auditing.model.TApplicationApprovalReview;
import com.cardpay.mgt.application.auditing.model.TApplicationApprovalUsers;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 审贷会成员VO
 *
 * @author chenkai
 *         createTime 2017-02-2017/2/13 14:51
 */
public class TApplicationApprovalReviewVo {

    /**
     * 审贷会id
     */
    private Integer reviewId;

    /**
     * 进件id
     */
    private Integer applicationId;

    /**
     * 审贷会
     */
    private Date reviewStartTime;

    private Date reviewEndTime;

    /**
     * 进件审批决定(0 通过 1 有条件通过 2 退回修改 3 拒绝 )
     */
    private Integer reviewConclution;

    /**
     * 进件审批条件
     */
    private String reviewConditions;

    /**
     * 进件审批额度
     */
    private BigDecimal reviewAmount;

    /**
     * 进件审批利率
     */
    private BigDecimal reviewRate;

    /**
     * 进件审批意见
     */
    private String reviewOpinion;

    /**
     * 进件审批人姓名
     */
    private String reviewPersonCname;

    /**
     * 进件审批人id
     */
    private String reviewPersonId;

    /**
     * 进件审核审贷会节点id
     */
    private Integer approvalId;

    /**
     * 审核状态(0 未审核  1 完成审核)
     */
    private Integer reviewStatus;

    private List<TApplicationApprovalUsers> tApplicationApprovalUsers;

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Date getReviewStartTime() {
        return reviewStartTime;
    }

    public void setReviewStartTime(Date reviewStartTime) {
        this.reviewStartTime = reviewStartTime;
    }

    public Date getReviewEndTime() {
        return reviewEndTime;
    }

    public void setReviewEndTime(Date reviewEndTime) {
        this.reviewEndTime = reviewEndTime;
    }

    public Integer getReviewConclution() {
        return reviewConclution;
    }

    public void setReviewConclution(Integer reviewConclution) {
        this.reviewConclution = reviewConclution;
    }

    public String getReviewConditions() {
        return reviewConditions;
    }

    public void setReviewConditions(String reviewConditions) {
        this.reviewConditions = reviewConditions;
    }

    public BigDecimal getReviewAmount() {
        return reviewAmount;
    }

    public void setReviewAmount(BigDecimal reviewAmount) {
        this.reviewAmount = reviewAmount;
    }

    public BigDecimal getReviewRate() {
        return reviewRate;
    }

    public void setReviewRate(BigDecimal reviewRate) {
        this.reviewRate = reviewRate;
    }

    public String getReviewOpinion() {
        return reviewOpinion;
    }

    public void setReviewOpinion(String reviewOpinion) {
        this.reviewOpinion = reviewOpinion;
    }

    public String getReviewPersonCname() {
        return reviewPersonCname;
    }

    public void setReviewPersonCname(String reviewPersonCname) {
        this.reviewPersonCname = reviewPersonCname;
    }

    public String getReviewPersonId() {
        return reviewPersonId;
    }

    public void setReviewPersonId(String reviewPersonId) {
        this.reviewPersonId = reviewPersonId;
    }

    public Integer getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(Integer approvalId) {
        this.approvalId = approvalId;
    }

    public Integer getReviewStatus() {
        return reviewStatus;
    }

    public void setReviewStatus(Integer reviewStatus) {
        this.reviewStatus = reviewStatus;
    }

    public List<TApplicationApprovalUsers> gettApplicationApprovalUsers() {
        return tApplicationApprovalUsers;
    }

    public void settApplicationApprovalUsers(List<TApplicationApprovalUsers> tApplicationApprovalUsers) {
        this.tApplicationApprovalUsers = tApplicationApprovalUsers;
    }
}
