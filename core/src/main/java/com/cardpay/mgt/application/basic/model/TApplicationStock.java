package com.cardpay.mgt.application.basic.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "T_APPLICATION_STOCK")
@ApiModel(value="库存表")
public class TApplicationStock extends GenericEntity<Integer>{
    /**
     * 库存id
     */
    @Id
    @Column(name = "STOCK_ID")
    @ApiModelProperty(value="库存id",required = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select APPLICATION_STOCK_SEQ.nextval from dual")
    private Integer stockId;

    /**
     * 库存货物名称
     */
    @Column(name = "STOCK_NAME")
    @ApiModelProperty(value="库存货物名称",required = true)
    private String stockName;

    /**
     * 库存数量
     */
    @Column(name = "STOCK_COUNT")
    @ApiModelProperty(value="库存数量",required = true)
    private Integer stockCount;

    /**
     * 库存买进单价
     */
    @Column(name = "STOCK_PRICE")
    @ApiModelProperty(value="库存买进单价",required = true)
    private BigDecimal stockPrice;

    /**
     * 库存买进总单价
     */
    @Column(name = "STOCK_TOTAL_VALUE")
    @ApiModelProperty(value="库存买进总单价",required = true)
    private BigDecimal stockTotalValue;

    /**
     * 进件id
     */
    @Column(name = "APPLICATION_ID")
    @ApiModelProperty(value="进件id",required = true)
    private Integer applicationId;

    /**
     * 获取库存id
     *
     * @return STOCK_ID - 库存id
     */
    public Integer getStockId() {
        return stockId;
    }

    /**
     * 设置库存id
     *
     * @param stockId 库存id
     */
    public void setStockId(Integer stockId) {
        this.stockId = stockId;
    }

    /**
     * 获取库存货物名称
     *
     * @return STOCK_NAME - 库存货物名称
     */
    public String getStockName() {
        return stockName;
    }

    /**
     * 设置库存货物名称
     *
     * @param stockName 库存货物名称
     */
    public void setStockName(String stockName) {
        this.stockName = stockName;
    }

    /**
     * 获取库存数量
     *
     * @return STOCK_COUNT - 库存数量
     */
    public Integer getStockCount() {
        return stockCount;
    }

    /**
     * 设置库存数量
     *
     * @param stockCount 库存数量
     */
    public void setStockCount(Integer stockCount) {
        this.stockCount = stockCount;
    }

    /**
     * 获取库存买进单价
     *
     * @return STOCK_PRICE - 库存买进单价
     */
    public BigDecimal getStockPrice() {
        return stockPrice;
    }

    /**
     * 设置库存买进单价
     *
     * @param stockPrice 库存买进单价
     */
    public void setStockPrice(BigDecimal stockPrice) {
        this.stockPrice = stockPrice;
    }

    /**
     * 获取库存买进总单价
     *
     * @return STOCK_TOTAL_VALUE - 库存买进总单价
     */
    public BigDecimal getStockTotalValue() {
        return stockTotalValue;
    }

    /**
     * 设置库存买进总单价
     *
     * @param stockTotalValue 库存买进总单价
     */
    public void setStockTotalValue(BigDecimal stockTotalValue) {
        this.stockTotalValue = stockTotalValue;
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

    @Override
    public Integer getPK() {
        return stockId;
    }
}