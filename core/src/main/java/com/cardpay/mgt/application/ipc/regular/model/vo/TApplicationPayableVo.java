package com.cardpay.mgt.application.ipc.regular.model.vo;

import com.cardpay.basic.base.model.GenericEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 应付预收表Vo
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/9 17:11
 */
public class TApplicationPayableVo extends GenericEntity<Integer> {

    /**
     * 应付预收id
     */
    private Integer payableId;

    /**
     * 应付预收名称
     */
    private String payableName;

    /**
     * 进件id
     */
    private Integer applicationId;

    /**
     * 应付预收发生时间
     */
    private Date payableStartTime;

    /**
     * 应付预收到期时间
     */
    private Date payableEndTime;

    /**
     * 应付预收金额
     */
    private BigDecimal payableAmount;

    /**
     * 原因
     */
    private String payableReason;

    /**
     * 应付预收联系方式
     */
    private String payableTel;

    /**
     * 关系或生意模式
     */
    private String payableRelation;

    /**
     * 应付预收总计
     */
    private BigDecimal payableTotalValue;

    public Integer getPayableId() {
        return payableId;
    }

    public void setPayableId(Integer payableId) {
        this.payableId = payableId;
    }

    public String getPayableName() {
        return payableName;
    }

    public void setPayableName(String payableName) {
        this.payableName = payableName;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Date getPayableStartTime() {
        return payableStartTime;
    }

    public void setPayableStartTime(Date payableStartTime) {
        this.payableStartTime = payableStartTime;
    }

    public Date getPayableEndTime() {
        return payableEndTime;
    }

    public void setPayableEndTime(Date payableEndTime) {
        this.payableEndTime = payableEndTime;
    }

    public BigDecimal getPayableAmount() {
        return payableAmount;
    }

    public void setPayableAmount(BigDecimal payableAmount) {
        this.payableAmount = payableAmount;
    }

    public String getPayableReason() {
        return payableReason;
    }

    public void setPayableReason(String payableReason) {
        this.payableReason = payableReason;
    }

    public String getPayableTel() {
        return payableTel;
    }

    public void setPayableTel(String payableTel) {
        this.payableTel = payableTel;
    }

    public String getPayableRelation() {
        return payableRelation;
    }

    public void setPayableRelation(String payableRelation) {
        this.payableRelation = payableRelation;
    }

    public BigDecimal getPayableTotalValue() {
        return payableTotalValue;
    }

    public void setPayableTotalValue(BigDecimal payableTotalValue) {
        this.payableTotalValue = payableTotalValue;
    }

    @Override
    public Integer getPK() {
        return payableId;
    }
}
