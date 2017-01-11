package com.cardpay.mgt.application.ipc.regular.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "T_APPLICATION_RECEIVE")
@ApiModel(value="进件应收预付表")
public class TApplicationReceive extends GenericEntity<Integer>{
    /**
     * 应收预付id
     */
    @Id
    @Column(name = "RECEIVE_ID")
    @ApiModelProperty(value="应收预付id",required = true)
    private Integer receiveId;

    /**
     * 应收预付名称
     */
    @Column(name = "RECEIVE_NAME")
    @ApiModelProperty(value="应收预付名称",required = true)
    private String receiveName;

    /**
     * 进件id
     */
    @Column(name = "APPLICATION_ID")
    @ApiModelProperty(value="进件id",required = true)
    private Integer applicationId;

    /**
     * 应收预付发生时间
     */
    @Column(name = "RECEIVE_START_TIME")
    @ApiModelProperty(value="应收预付发生时间",required = true)
    private Date receiveStartTime;

    /**
     * 应收预付到期时间
     */
    @Column(name = "RECEIVE_END_TIME")
    @ApiModelProperty(value="应收预付到期时间",required = true)
    private Date receiveEndTime;

    /**
     * 应收预付金额
     */
    @Column(name = "RECEIVE_AMOUNT")
    @ApiModelProperty(value="应收预付金额",required = true)
    private BigDecimal receiveAmount;

    /**
     * 原因
     */
    @Column(name = "RECEIVE_REASON")
    @ApiModelProperty(value="原因",required = true)
    private String receiveReason;

    /**
     * 应收预付联系方式
     */
    @Column(name = "RECEIVE_TEL")
    @ApiModelProperty(value="应收预付联系方式",required = true)
    private String receiveTel;

    /**
     * 关系或生意模式
     */
    @Column(name = "RECEIVE_RELATION")
    @ApiModelProperty(value="关系或生意模式",required = true)
    private String receiveRelation;

    /**
     * 获取应收预付id
     *
     * @return RECEIVE_ID - 应收预付id
     */
    public Integer getReceiveId() {
        return receiveId;
    }

    /**
     * 设置应收预付id
     *
     * @param receiveId 应收预付id
     */
    public void setReceiveId(Integer receiveId) {
        this.receiveId = receiveId;
    }

    /**
     * 获取应收预付名称
     *
     * @return RECEIVE_NAME - 应收预付名称
     */
    public String getReceiveName() {
        return receiveName;
    }

    /**
     * 设置应收预付名称
     *
     * @param receiveName 应收预付名称
     */
    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
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
     * 获取应收预付发生时间
     *
     * @return RECEIVE_START_TIME - 应收预付发生时间
     */
    public Date getReceiveStartTime() {
        return receiveStartTime;
    }

    /**
     * 设置应收预付发生时间
     *
     * @param receiveStartTime 应收预付发生时间
     */
    public void setReceiveStartTime(Date receiveStartTime) {
        this.receiveStartTime = receiveStartTime;
    }

    /**
     * 获取应收预付到期时间
     *
     * @return RECEIVE_END_TIME - 应收预付到期时间
     */
    public Date getReceiveEndTime() {
        return receiveEndTime;
    }

    /**
     * 设置应收预付到期时间
     *
     * @param receiveEndTime 应收预付到期时间
     */
    public void setReceiveEndTime(Date receiveEndTime) {
        this.receiveEndTime = receiveEndTime;
    }

    /**
     * 获取应收预付金额
     *
     * @return RECEIVE_AMOUNT - 应收预付金额
     */
    public BigDecimal getReceiveAmount() {
        return receiveAmount;
    }

    /**
     * 设置应收预付金额
     *
     * @param receiveAmount 应收预付金额
     */
    public void setReceiveAmount(BigDecimal receiveAmount) {
        this.receiveAmount = receiveAmount;
    }

    /**
     * 获取原因
     *
     * @return RECEIVE_REASON - 原因
     */
    public String getReceiveReason() {
        return receiveReason;
    }

    /**
     * 设置原因
     *
     * @param receiveReason 原因
     */
    public void setReceiveReason(String receiveReason) {
        this.receiveReason = receiveReason;
    }

    /**
     * 获取应收预付联系方式
     *
     * @return RECEIVE_TEL - 应收预付联系方式
     */
    public String getReceiveTel() {
        return receiveTel;
    }

    /**
     * 设置应收预付联系方式
     *
     * @param receiveTel 应收预付联系方式
     */
    public void setReceiveTel(String receiveTel) {
        this.receiveTel = receiveTel;
    }

    /**
     * 获取关系或生意模式
     *
     * @return RECEIVE_RELATION - 关系或生意模式
     */
    public String getReceiveRelation() {
        return receiveRelation;
    }

    /**
     * 设置关系或生意模式
     *
     * @param receiveRelation 关系或生意模式
     */
    public void setReceiveRelation(String receiveRelation) {
        this.receiveRelation = receiveRelation;
    }

    @Override
    public Integer getPK() {
        return receiveId;
    }
}