package com.cardpay.mgt.application.ipc.regular.model.vo;

import com.cardpay.basic.base.model.GenericEntity;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 固定资产清单表Vo
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/9 16:26
 */
public class TApplicationFixedAssertVo extends GenericEntity<Integer>{
    /**
     * 固定资产id
     */
    private Integer fixedAssertId;

    /**
     * 固定置产名称
     */
    private String fixedAssertName;

    /**
     * 固定资产购置时间
     */
    private Date fixedAssertBuyTime;

    /**
     * 固定资产原始单价
     */
    private BigDecimal fixedAssertOriginPrice;

    /**
     * 折旧率
     */
    private BigDecimal fixedAssertDepreciate;

    /**
     * 数量
     */
    private Integer fixedAssertCount;

    /**
     * 总价值
     */
    private BigDecimal fixedAssertTotalValue;

    /**
     * 折旧后价值
     */
    private BigDecimal fixedAssertDepreciateValue;

    /**
     * 进件id
     */
    private Integer applicationId;

    /**
     * 固定资产类型(0  房地产 1 设备及器材详单 2 车辆详单)
     */
    private Integer fixedAssertType;

    /**
     * 总价值(总计表)
     */
    private BigDecimal totalValue;

    /**
     * 折旧后价值(总计表)
     */
    private BigDecimal depreciateValue;

    public Integer getFixedAssertId() {
        return fixedAssertId;
    }

    public void setFixedAssertId(Integer fixedAssertId) {
        this.fixedAssertId = fixedAssertId;
    }

    public String getFixedAssertName() {
        return fixedAssertName;
    }

    public void setFixedAssertName(String fixedAssertName) {
        this.fixedAssertName = fixedAssertName;
    }

    public Date getFixedAssertBuyTime() {
        return fixedAssertBuyTime;
    }

    public void setFixedAssertBuyTime(Date fixedAssertBuyTime) {
        this.fixedAssertBuyTime = fixedAssertBuyTime;
    }

    public BigDecimal getFixedAssertOriginPrice() {
        return fixedAssertOriginPrice;
    }

    public void setFixedAssertOriginPrice(BigDecimal fixedAssertOriginPrice) {
        this.fixedAssertOriginPrice = fixedAssertOriginPrice;
    }

    public BigDecimal getFixedAssertDepreciate() {
        return fixedAssertDepreciate;
    }

    public void setFixedAssertDepreciate(BigDecimal fixedAssertDepreciate) {
        this.fixedAssertDepreciate = fixedAssertDepreciate;
    }

    public Integer getFixedAssertCount() {
        return fixedAssertCount;
    }

    public void setFixedAssertCount(Integer fixedAssertCount) {
        this.fixedAssertCount = fixedAssertCount;
    }

    public BigDecimal getFixedAssertTotalValue() {
        return fixedAssertTotalValue;
    }

    public void setFixedAssertTotalValue(BigDecimal fixedAssertTotalValue) {
        this.fixedAssertTotalValue = fixedAssertTotalValue;
    }

    public BigDecimal getFixedAssertDepreciateValue() {
        return fixedAssertDepreciateValue;
    }

    public void setFixedAssertDepreciateValue(BigDecimal fixedAssertDepreciateValue) {
        this.fixedAssertDepreciateValue = fixedAssertDepreciateValue;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getFixedAssertType() {
        return fixedAssertType;
    }

    public void setFixedAssertType(Integer fixedAssertType) {
        this.fixedAssertType = fixedAssertType;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
    }

    public BigDecimal getDepreciateValue() {
        return depreciateValue;
    }

    public void setDepreciateValue(BigDecimal depreciateValue) {
        this.depreciateValue = depreciateValue;
    }

    @Override
    public Integer getPK() {
        return fixedAssertId;
    }
}
