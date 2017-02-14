package com.cardpay.mgt.process.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.persistence.*;

@Table(name = "T_APP_APPROVE")
@ApiModel(value = "null")
public class AppApprove extends GenericEntity<Integer> {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select T_APP_APPROVE_SEQ.nextval from dual")
    @ApiModelProperty(value = "null", required = true)
    private Integer id;

    @Column(name = "APP_ID")
    @ApiModelProperty(value = "null", required = true)
    private Integer appId;

    @Column(name = "PRODUCT_APPROVE_ID")
    @ApiModelProperty(value = "null", required = true)
    private Integer productApproveId;

    @Column(name = "SORT")
    @ApiModelProperty(value = "null", required = true)
    private Integer sort;

    /**
     * 审批状态 0 待进行 1正在进行 2正在符合 3已完成
     */
    @Column(name = "STATUS")
    @ApiModelProperty(value = "审批状态(0 待进行 1正在进行 2正在符合 3已完成)", required = true)
    private Integer status;

    @Column(name = "CREATE_TIME")
    @ApiModelProperty(value = "null", required = true)
    private Date createTime;

    /**
     * 操作完成时间
     */
    @Column(name = "COMPLETE_TIME")
    @ApiModelProperty(value = "操作完成时间", required = true)
    private Date completeTime;

    /**
     * 是否为复核节点 0否1是
     */
    @Column(name = "IS_REVIEW")
    @ApiModelProperty(value = "是否为复核节点 0否1是", required = true)
    private Integer isReview;

    /**
     * 可审批角色
     */
    @Column(name = "APPROVE_ROLES")
    @ApiModelProperty(value = "可审批角色", required = true)
    private String approveRoles;

    /**
     * 是否随机分件(0 不随机分件 1 随机分件)
     */
    @Column(name = "IS_RANDOM_DIVISION")
    @ApiModelProperty(value = "是否随机分件(0 不随机分件 1 随机分件)", required = true)
    private Integer isRandomDivision;

    /**
     * 是否进行额度判断(0 判断  1 是不判断 )
     */
    @Column(name = "IS_LOAN_LIMIT")
    @ApiModelProperty(value = "是否进行额度判断(0 判断  1 是不判断 )", required = true)
    private Integer isLoanLimit;

    /**
     * 审批额度值
     */
    @Column(name = "LOAN_LIMIT")
    @ApiModelProperty(value = "审批额度值", required = true)
    private Long loanLimit;

    /**
     * 审贷会通过方式(0 集体通过 1 多数通过)
     */
    @Column(name = "LOAN_MEETING_TYPE")
    @ApiModelProperty(value = "审贷会通过方式(0 集体通过 1 多数通过)", required = true)
    private Integer loanMeetingType;

    /**
     * 是否为末节点
     */
    @Column(name = "IS_END")
    @ApiModelProperty(value = "是否为末节点(0 否 1 是)", required = true)
    private Integer isEnd;


    /**
     * @return ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return APP_ID
     */
    public Integer getAppId() {
        return appId;
    }

    /**
     * @param appId
     */
    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    /**
     * @return PRODUCT_APPROVE_ID
     */
    public Integer getProductApproveId() {
        return productApproveId;
    }

    /**
     * @param productApproveId
     */
    public void setProductApproveId(Integer productApproveId) {
        this.productApproveId = productApproveId;
    }

    /**
     * @return SORT
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * @param sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取审批状态 0 待进行 1正在进行 2已完成
     *
     * @return STATUS - 审批状态 0 待进行 1正在进行 2已完成
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置审批状态 0 待进行 1正在进行 2已完成
     *
     * @param status 审批状态 0 待进行 1正在进行 2已完成
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return CREATE_TIME
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取操作完成时间
     *
     * @return COMPLETE_TIME - 操作完成时间
     */
    public Date getCompleteTime() {
        return completeTime;
    }

    /**
     * 设置操作完成时间
     *
     * @param completeTime 操作完成时间
     */
    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    /**
     * 获取是否为复核节点 0否1是
     *
     * @return IS_REVIEW - 是否为复核节点 0否1是
     */
    public Integer getIsReview() {
        return isReview;
    }

    /**
     * 设置是否为复核节点 0否1是
     *
     * @param isReview 是否为复核节点 0否1是
     */
    public void setIsReview(Integer isReview) {
        this.isReview = isReview;
    }

    /**
     * 获取可审批角色
     *
     * @return APPROVE_ROLES - 可审批角色
     */
    public String getApproveRoles() {
        return approveRoles;
    }

    /**
     * 设置可审批角色
     *
     * @param approveRoles 可审批角色
     */
    public void setApproveRoles(String approveRoles) {
        this.approveRoles = approveRoles;
    }

    /**
     * 获取是否随机分件(0 不随机分件 1 随机分件)
     *
     * @return IS_RANDOM_DIVISION - 是否随机分件(0 不随机分件 1 随机分件)
     */
    public Integer getIsRandomDivision() {
        return isRandomDivision;
    }

    /**
     * 设置是否随机分件(0 不随机分件 1 随机分件)
     *
     * @param isRandomDivision 是否随机分件(0 不随机分件 1 随机分件)
     */
    public void setIsRandomDivision(Integer isRandomDivision) {
        this.isRandomDivision = isRandomDivision;
    }

    /**
     * 获取是否进行额度判断(0 判断  1 是不判断 )
     *
     * @return IS_LOAN_LIMIT - 是否进行额度判断(0 判断  1 是不判断 )
     */
    public Integer getIsLoanLimit() {
        return isLoanLimit;
    }

    /**
     * 设置是否进行额度判断(0 判断  1 是不判断 )
     *
     * @param isLoanLimit 是否进行额度判断(0 判断  1 是不判断 )
     */
    public void setIsLoanLimit(Integer isLoanLimit) {
        this.isLoanLimit = isLoanLimit;
    }

    /**
     * 获取审批额度值
     *
     * @return LOAN_LIMIT - 审批额度值
     */
    public Long getLoanLimit() {
        return loanLimit;
    }

    /**
     * 设置审批额度值
     *
     * @param loanLimit 审批额度值
     */
    public void setLoanLimit(Long loanLimit) {
        this.loanLimit = loanLimit;
    }

    /**
     * 获取审贷会通过方式(0 集体通过 1 多数通过)
     *
     * @return LOAN_MEETING_TYPE - 审贷会通过方式(0 集体通过 1 多数通过)
     */
    public Integer getLoanMeetingType() {
        return loanMeetingType;
    }

    /**
     * 设置审贷会通过方式(0 集体通过 1 多数通过)
     *
     * @param loanMeetingType 审贷会通过方式(0 集体通过 1 多数通过)
     */
    public void setLoanMeetingType(Integer loanMeetingType) {
        this.loanMeetingType = loanMeetingType;
    }

    public Integer getIsEnd() {
        return isEnd;
    }

    public void setIsEnd(Integer isEnd) {
        this.isEnd = isEnd;
    }

    @Override
    public Integer getPK() {
        return id;
    }


    public static final class AppApproveBuilder {
        private Integer id;
        private Integer appId;
        private Integer productApproveId;
        private Integer sort;
        private Integer status;
        private Date createTime;
        private Date completeTime;
        private Integer isReview;
        private String approveRoles;
        private Integer isRandomDivision;
        private Integer isLoanLimit;
        private Long loanLimit;
        private Integer loanMeetingType;
        private Integer isEnd;

        private AppApproveBuilder() {
        }

        public static AppApproveBuilder get() {
            return new AppApproveBuilder();
        }

        public AppApproveBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public AppApproveBuilder withAppId(Integer appId) {
            this.appId = appId;
            return this;
        }

        public AppApproveBuilder withProductApproveId(Integer productApproveId) {
            this.productApproveId = productApproveId;
            return this;
        }

        public AppApproveBuilder withSort(Integer sort) {
            this.sort = sort;
            return this;
        }

        public AppApproveBuilder withStatus(Integer status) {
            this.status = status;
            return this;
        }

        public AppApproveBuilder withCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public AppApproveBuilder withCompleteTime(Date completeTime) {
            this.completeTime = completeTime;
            return this;
        }

        public AppApproveBuilder withIsReview(Integer isReview) {
            this.isReview = isReview;
            return this;
        }

        public AppApproveBuilder withApproveRoles(String approveRoles) {
            this.approveRoles = approveRoles;
            return this;
        }

        public AppApproveBuilder withIsRandomDivision(Integer isRandomDivision) {
            this.isRandomDivision = isRandomDivision;
            return this;
        }

        public AppApproveBuilder withIsLoanLimit(Integer isLoanLimit) {
            this.isLoanLimit = isLoanLimit;
            return this;
        }

        public AppApproveBuilder withLoanLimit(Long loanLimit) {
            this.loanLimit = loanLimit;
            return this;
        }

        public AppApproveBuilder withLoanMeetingType(Integer loanMeetingType) {
            this.loanMeetingType = loanMeetingType;
            return this;
        }

        public AppApproveBuilder withIsEnd(Integer isEnd) {
            this.isEnd = isEnd;
            return this;
        }

        public AppApprove build() {
            AppApprove appApprove = new AppApprove();
            appApprove.setId(id);
            appApprove.setAppId(appId);
            appApprove.setProductApproveId(productApproveId);
            appApprove.setSort(sort);
            appApprove.setStatus(status);
            appApprove.setCreateTime(createTime);
            appApprove.setCompleteTime(completeTime);
            appApprove.setIsReview(isReview);
            appApprove.setApproveRoles(approveRoles);
            appApprove.setIsRandomDivision(isRandomDivision);
            appApprove.setIsLoanLimit(isLoanLimit);
            appApprove.setLoanLimit(loanLimit);
            appApprove.setLoanMeetingType(loanMeetingType);
            appApprove.setIsEnd(isEnd);
            return appApprove;
        }
    }
}