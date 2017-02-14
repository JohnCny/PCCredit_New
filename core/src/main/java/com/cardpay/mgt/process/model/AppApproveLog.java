package com.cardpay.mgt.process.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.persistence.*;

@Table(name = "T_APP_APPROVE_LOG")
@ApiModel(value = "null")
public class AppApproveLog extends GenericEntity<Integer> {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select T_APP_APPROVE_LOG_SEQ.nextval from dual")
    @ApiModelProperty(value = "null", required = true)
    private Integer id;

    @Column(name = "APPLICATION_ID")
    @ApiModelProperty(value = "null", required = true)
    private Integer applicationId;

    @Column(name = "USER_ID")
    @ApiModelProperty(value = "null", required = true)
    private Integer userId;

    @Column(name = "RESULT")
    @ApiModelProperty(value = "null", required = true)
    private Short result;

    @Column(name = "CREATE_TIME")
    @ApiModelProperty(value = "null", required = true)
    private Date createTime;

    @Column(name = "COMPLETE_TIME")
    @ApiModelProperty(value = "null", required = true)
    private Date completeTime;

    @Column(name = "ORDER")
    @ApiModelProperty(value = "null", required = true)
    private Integer order;

    @Column(name = "IS_REVIEW")
    @ApiModelProperty(value = "null", required = true)
    private Integer isReview;

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
     * @return APPLICATION_ID
     */
    public Integer getApplicationId() {
        return applicationId;
    }

    /**
     * @param applicationId
     */
    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * @return USER_ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return RESULT
     */
    public Short getResult() {
        return result;
    }

    /**
     * @param result
     */
    public void setResult(Short result) {
        this.result = result;
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
     * @return COMPLETE_TIME
     */
    public Date getCompleteTime() {
        return completeTime;
    }

    /**
     * @param completeTime
     */
    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    /**
     * @return ORDER
     */
    public Integer getOrder() {
        return order;
    }

    /**
     * @param order
     */
    public void setOrder(Integer order) {
        this.order = order;
    }

    /**
     * @return IS_REVIEW
     */
    public Integer getIsReview() {
        return isReview;
    }

    /**
     * @param isReview
     */
    public void setIsReview(Integer isReview) {
        this.isReview = isReview;
    }

    @Override
    public Integer getPK() {
        return id;
    }
}