package com.cardpay.mgt.process.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.persistence.*;

@Table(name = "T_APP_APPROVE_USER")
@ApiModel(value = "null")
public class AppApproveUser extends GenericEntity<Integer> {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select 你的序列名.nextval from dual")
    @ApiModelProperty(value = "null", required = true)
    private Integer id;

    @Column(name = "USER_ID")
    @ApiModelProperty(value = "null", required = true)
    private Integer userId;

    @Column(name = "APP_APPROVE_ID")
    @ApiModelProperty(value = "null", required = true)
    private Integer appApproveId;

    /**
     * 状态 0待审批1已审批
     */
    @Column(name = "STATUS")
    @ApiModelProperty(value = "状态 0待审批1已审批", required = true)
    private Integer status;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

    /**
     * 操作时间
     */
    @Column(name = "COMPLETE_TIME")
    @ApiModelProperty(value = "操作时间", required = true)
    private Date completeTime;

    /**
     * 是否为复核 0否1是
     */
    @Column(name = "IS_REVIEW")
    @ApiModelProperty(value = "是否为复核 0否1是", required = true)
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
     * @return APP_APPROVE_ID
     */
    public Integer getAppApproveId() {
        return appApproveId;
    }

    /**
     * @param appApproveId
     */
    public void setAppApproveId(Integer appApproveId) {
        this.appApproveId = appApproveId;
    }

    /**
     * 获取状态 0待审批1已审批
     *
     * @return STATUS - 状态 0待审批1已审批
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态 0待审批1已审批
     *
     * @param status 状态 0待审批1已审批
     */
    public void setStatus(Integer status) {
        this.status = status;
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
     * 获取操作时间
     *
     * @return COMPLETE_TIME - 操作时间
     */
    public Date getCompleteTime() {
        return completeTime;
    }

    /**
     * 设置操作时间
     *
     * @param completeTime 操作时间
     */
    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    /**
     * 获取是否为复核 0否1是
     *
     * @return IS_REVIEW - 是否为复核 0否1是
     */
    public Integer getIsReview() {
        return isReview;
    }

    /**
     * 设置是否为复核 0否1是
     *
     * @param isReview 是否为复核 0否1是
     */
    public void setIsReview(Integer isReview) {
        this.isReview = isReview;
    }

    @Override
    public Integer getPK() {
        return id;
    }
}