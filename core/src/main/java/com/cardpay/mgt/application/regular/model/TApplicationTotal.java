package com.cardpay.mgt.application.regular.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "T_APPLICATION_TOTAL")
@ApiModel(value="总计表")
public class TApplicationTotal extends GenericEntity<Integer>{
    /**
     * 固定资产清单id
     */
    @Id
    @Column(name = "FIXED_ASSERT_TOTAL_ID")
    @ApiModelProperty(value="固定资产清单id",required = true)
    private Integer fixedAssertTotalId;

    /**
     * 总价值
     */
    @Column(name = "FIXED_ASSERT_TOTAL_VALUE")
    @ApiModelProperty(value="总价值",required = true)
    private BigDecimal fixedAssertTotalValue;

    /**
     * 折旧后价值
     */
    @Column(name = "FIXED_ASSERT_DEPRECIATE_VALUE")
    @ApiModelProperty(value="折旧后价值",required = true)
    private BigDecimal fixedAssertDepreciateValue;

    /**
     * 进件id
     */
    @Column(name = "APPLICATION_ID")
    @ApiModelProperty(value="进件id",required = true)
    private Integer applicationId;

    /**
     * 应收预付总计
     */
    @Column(name = "RECEIVE_TOTAL_VALUE")
    @ApiModelProperty(value="应收预付总计",required = true)
    private BigDecimal receiveTotalValue;

    /**
     * 应付预收总计
     */
    @Column(name = "PAYABLE_TOTAL_VALUE")
    @ApiModelProperty(value="应付预收总计",required = true)
    private BigDecimal payableTotalValue;

    /**
     * 库存总量
     */
    @Column(name = "STOCK_TOTAL")
    @ApiModelProperty(value="库存总量",required = true)
    private Integer stockTotal;

    /**
     * 库存总价值
     */
    @Column(name = "STOCK_TOTAL_VALUE")
    @ApiModelProperty(value="库存总价值",required = true)
    private BigDecimal stockTotalValue;

    /**
     * 获取固定资产清单id
     *
     * @return FIXED_ASSERT_TOTAL_ID - 固定资产清单id
     */
    public Integer getFixedAssertTotalId() {
        return fixedAssertTotalId;
    }

    /**
     * 设置固定资产清单id
     *
     * @param fixedAssertTotalId 固定资产清单id
     */
    public void setFixedAssertTotalId(Integer fixedAssertTotalId) {
        this.fixedAssertTotalId = fixedAssertTotalId;
    }

    /**
     * 获取总价值
     *
     * @return FIXED_ASSERT_TOTAL_VALUE - 总价值
     */
    public BigDecimal getFixedAssertTotalValue() {
        return fixedAssertTotalValue;
    }

    /**
     * 设置总价值
     *
     * @param fixedAssertTotalValue 总价值
     */
    public void setFixedAssertTotalValue(BigDecimal fixedAssertTotalValue) {
        this.fixedAssertTotalValue = fixedAssertTotalValue;
    }

    /**
     * 获取折旧后价值
     *
     * @return FIXED_ASSERT_DEPRECIATE_VALUE - 折旧后价值
     */
    public BigDecimal getFixedAssertDepreciateValue() {
        return fixedAssertDepreciateValue;
    }

    /**
     * 设置折旧后价值
     *
     * @param fixedAssertDepreciateValue 折旧后价值
     */
    public void setFixedAssertDepreciateValue(BigDecimal fixedAssertDepreciateValue) {
        this.fixedAssertDepreciateValue = fixedAssertDepreciateValue;
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
     * 获取应收预付总计
     *
     * @return RECEIVE_TOTAL_VALUE - 应收预付总计
     */
    public BigDecimal getReceiveTotalValue() {
        return receiveTotalValue;
    }

    /**
     * 设置应收预付总计
     *
     * @param receiveTotalValue 应收预付总计
     */
    public void setReceiveTotalValue(BigDecimal receiveTotalValue) {
        this.receiveTotalValue = receiveTotalValue;
    }

    /**
     * 获取应付预收总计
     *
     * @return PAYABLE_TOTAL_VALUE - 应付预收总计
     */
    public BigDecimal getPayableTotalValue() {
        return payableTotalValue;
    }

    /**
     * 设置应付预收总计
     *
     * @param payableTotalValue 应付预收总计
     */
    public void setPayableTotalValue(BigDecimal payableTotalValue) {
        this.payableTotalValue = payableTotalValue;
    }

    /**
     * 获取库存总量
     *
     * @return STOCK_TOTAL - 库存总量
     */
    public Integer getStockTotal() {
        return stockTotal;
    }

    /**
     * 设置库存总量
     *
     * @param stockTotal 库存总量
     */
    public void setStockTotal(Integer stockTotal) {
        this.stockTotal = stockTotal;
    }

    /**
     * 获取库存总价值
     *
     * @return STOCK_TOTAL_VALUE - 库存总价值
     */
    public BigDecimal getStockTotalValue() {
        return stockTotalValue;
    }

    /**
     * 设置库存总价值
     *
     * @param stockTotalValue 库存总价值
     */
    public void setStockTotalValue(BigDecimal stockTotalValue) {
        this.stockTotalValue = stockTotalValue;
    }

    @Override
    public Integer getPK() {
        return fixedAssertTotalId;
    }
}