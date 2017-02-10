package com.cardpay.mgt.application.ipc.regular.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "T_APPLICATION_PAYABLE")
@ApiModel(value="进件应付预收表")
public class TApplicationPayable extends GenericEntity<Integer>{
    /**
     * 应付预收id
     */
    @Id
    @Column(name = "PAYABLE_ID")
    @ApiModelProperty(value="应付预收id",required = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select APPLICATION_PAYABLE_SEQ.nextval from dual")
    private Integer payableId;

    /**
     * 应付预收名称
     */
    @Column(name = "PAYABLE_NAME")
    @ApiModelProperty(value="应付预收名称",required = true)
    private String payableName;

    /**
     * 进件id
     */
    @Column(name = "APPLICATION_ID")
    @ApiModelProperty(value="进件id",required = true)
    private Integer applicationId;

    /**
     * 应付预收发生时间
     */
    @Column(name = "PAYABLE_START_TIME")
    @ApiModelProperty(value="应付预收发生时间",required = true)
    private Date payableStartTime;

    /**
     * 应付预收到期时间
     */
    @Column(name = "PAYABLE_END_TIME")
    @ApiModelProperty(value="应付预收到期时间",required = true)
    private Date payableEndTime;

    /**
     * 应付预收金额
     */
    @Column(name = "PAYABLE_AMOUNT")
    @ApiModelProperty(value="应付预收金额",required = true)
    private BigDecimal payableAmount;

    /**
     * 原因
     */
    @Column(name = "PAYABLE_REASON")
    @ApiModelProperty(value="原因",required = true)
    private String payableReason;

    /**
     * 应付预收联系方式
     */
    @Column(name = "PAYABLE_TEL")
    @ApiModelProperty(value="应付预收联系方式",required = true)
    private String payableTel;

    /**
     * 关系或生意模式
     */
    @Column(name = "PAYABLE_RELATION")
    @ApiModelProperty(value="关系或生意模式",required = true)
    private String payableRelation;

    /**
     * 获取应付预收id
     *
     * @return PAYABLE_ID - 应付预收id
     */
    public Integer getPayableId() {
        return payableId;
    }

    /**
     * 设置应付预收id
     *
     * @param payableId 应付预收id
     */
    public void setPayableId(Integer payableId) {
        this.payableId = payableId;
    }

    /**
     * 获取应付预收名称
     *
     * @return PAYABLE_NAME - 应付预收名称
     */
    public String getPayableName() {
        return payableName;
    }

    /**
     * 设置应付预收名称
     *
     * @param payableName 应付预收名称
     */
    public void setPayableName(String payableName) {
        this.payableName = payableName;
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
     * 获取应付预收发生时间
     *
     * @return PAYABLE_START_TIME - 应付预收发生时间
     */
    public Date getPayableStartTime() {
        return payableStartTime;
    }

    /**
     * 设置应付预收发生时间
     *
     * @param payableStartTime 应付预收发生时间
     */
    public void setPayableStartTime(Date payableStartTime) {
        this.payableStartTime = payableStartTime;
    }

    /**
     * 获取应付预收到期时间
     *
     * @return PAYABLE_END_TIME - 应付预收到期时间
     */
    public Date getPayableEndTime() {
        return payableEndTime;
    }

    /**
     * 设置应付预收到期时间
     *
     * @param payableEndTime 应付预收到期时间
     */
    public void setPayableEndTime(Date payableEndTime) {
        this.payableEndTime = payableEndTime;
    }

    /**
     * 获取应付预收金额
     *
     * @return PAYABLE_AMOUNT - 应付预收金额
     */
    public BigDecimal getPayableAmount() {
        return payableAmount;
    }

    /**
     * 设置应付预收金额
     *
     * @param payableAmount 应付预收金额
     */
    public void setPayableAmount(BigDecimal payableAmount) {
        this.payableAmount = payableAmount;
    }

    /**
     * 获取原因
     *
     * @return PAYABLE_REASON - 原因
     */
    public String getPayableReason() {
        return payableReason;
    }

    /**
     * 设置原因
     *
     * @param payableReason 原因
     */
    public void setPayableReason(String payableReason) {
        this.payableReason = payableReason;
    }

    /**
     * 获取应付预收联系方式
     *
     * @return PAYABLE_TEL - 应付预收联系方式
     */
    public String getPayableTel() {
        return payableTel;
    }

    /**
     * 设置应付预收联系方式
     *
     * @param payableTel 应付预收联系方式
     */
    public void setPayableTel(String payableTel) {
        this.payableTel = payableTel;
    }

    /**
     * 获取关系或生意模式
     *
     * @return PAYABLE_RELATION - 关系或生意模式
     */
    public String getPayableRelation() {
        return payableRelation;
    }

    /**
     * 设置关系或生意模式
     *
     * @param payableRelation 关系或生意模式
     */
    public void setPayableRelation(String payableRelation) {
        this.payableRelation = payableRelation;
    }

    @Override
    public Integer getPK() {
        return payableId;
    }
}