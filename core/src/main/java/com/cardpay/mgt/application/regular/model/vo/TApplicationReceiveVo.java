package com.cardpay.mgt.application.regular.model.vo;

import com.cardpay.basic.base.model.GenericEntity;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 进件应收预付表Vo
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/9 17:15
 */
public class TApplicationReceiveVo extends GenericEntity<Integer> {
    /**
     * 应收预付id
     */
    private Integer receiveId;

    /**
     * 应收预付名称
     */
    private String receiveName;

    /**
     * 进件id
     */
    private Integer applicationId;

    /**
     * 应收预付发生时间
     */
    private Date receiveStartTime;

    /**
     * 应收预付到期时间
     */
    private Date receiveEndTime;

    /**
     * 应收预付金额
     */
    private BigDecimal receiveAmount;

    /**
     * 原因
     */
    private String receiveReason;

    /**
     * 应收预付联系方式
     */
    private String receiveTel;

    /**
     * 关系或生意模式
     */
    private String receiveRelation;

    /**
     * 应收预付总计
     */
    private BigDecimal receiveTotalValue;

    public Integer getReceiveId() {
        return receiveId;
    }

    public void setReceiveId(Integer receiveId) {
        this.receiveId = receiveId;
    }

    public String getReceiveName() {
        return receiveName;
    }

    public void setReceiveName(String receiveName) {
        this.receiveName = receiveName;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Date getReceiveStartTime() {
        return receiveStartTime;
    }

    public void setReceiveStartTime(Date receiveStartTime) {
        this.receiveStartTime = receiveStartTime;
    }

    public Date getReceiveEndTime() {
        return receiveEndTime;
    }

    public void setReceiveEndTime(Date receiveEndTime) {
        this.receiveEndTime = receiveEndTime;
    }

    public BigDecimal getReceiveAmount() {
        return receiveAmount;
    }

    public void setReceiveAmount(BigDecimal receiveAmount) {
        this.receiveAmount = receiveAmount;
    }

    public String getReceiveReason() {
        return receiveReason;
    }

    public void setReceiveReason(String receiveReason) {
        this.receiveReason = receiveReason;
    }

    public String getReceiveTel() {
        return receiveTel;
    }

    public void setReceiveTel(String receiveTel) {
        this.receiveTel = receiveTel;
    }

    public String getReceiveRelation() {
        return receiveRelation;
    }

    public void setReceiveRelation(String receiveRelation) {
        this.receiveRelation = receiveRelation;
    }

    public BigDecimal getReceiveTotalValue() {
        return receiveTotalValue;
    }

    public void setReceiveTotalValue(BigDecimal receiveTotalValue) {
        this.receiveTotalValue = receiveTotalValue;
    }

    @Override
    public Integer getPK() {
        return null;
    }
}
