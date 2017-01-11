package com.cardpay.mgt.application.ipc.regular.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "T_APPLICATION_FIXED_ASSERT")
@ApiModel(value="固定资产清单表")
public class TApplicationFixedAssert extends GenericEntity<Integer> {
    /**
     * 固定资产id
     */
    @Id
    @Column(name = "FIXED_ASSERT_ID")
    @ApiModelProperty(value="固定资产id",required = true)
    private Integer fixedAssertId;

    /**
     * 固定置产名称
     */
    @Column(name = "FIXED_ASSERT_NAME")
    @ApiModelProperty(value="固定置产名称",required = true)
    private String fixedAssertName;

    /**
     * 固定资产购置时间
     */
    @Column(name = "FIXED_ASSERT_BUY_TIME")
    @ApiModelProperty(value="固定资产购置时间",required = true)
    private Date fixedAssertBuyTime;

    /**
     * 固定资产原始单价
     */
    @Column(name = "FIXED_ASSERT_ORIGIN_PRICE")
    @ApiModelProperty(value="固定资产原始单价",required = true)
    private BigDecimal fixedAssertOriginPrice;

    /**
     * 折旧率
     */
    @Column(name = "FIXED_ASSERT_DEPRECIATE")
    @ApiModelProperty(value="折旧率",required = true)
    private BigDecimal fixedAssertDepreciate;

    /**
     * 数量
     */
    @Column(name = "FIXED_ASSERT_COUNT")
    @ApiModelProperty(value="数量",required = true)
    private Integer fixedAssertCount;

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
     * 固定资产类型(0  房地产 1 设备及器材详单 2 车辆详单)
     */
    @Column(name = "FIXED_ASSERT_TYPE")
    @ApiModelProperty(value="固定资产类型(0  房地产 1 设备及器材详单 2 车辆详单)",required = true)
    private Integer fixedAssertType;

    /**
     * 获取固定资产id
     *
     * @return FIXED_ASSERT_ID - 固定资产id
     */
    public Integer getFixedAssertId() {
        return fixedAssertId;
    }

    /**
     * 设置固定资产id
     *
     * @param fixedAssertId 固定资产id
     */
    public void setFixedAssertId(Integer fixedAssertId) {
        this.fixedAssertId = fixedAssertId;
    }

    /**
     * 获取固定置产名称
     *
     * @return FIXED_ASSERT_NAME - 固定置产名称
     */
    public String getFixedAssertName() {
        return fixedAssertName;
    }

    /**
     * 设置固定置产名称
     *
     * @param fixedAssertName 固定置产名称
     */
    public void setFixedAssertName(String fixedAssertName) {
        this.fixedAssertName = fixedAssertName;
    }

    /**
     * 获取固定资产购置时间
     *
     * @return FIXED_ASSERT_BUY_TIME - 固定资产购置时间
     */
    public Date getFixedAssertBuyTime() {
        return fixedAssertBuyTime;
    }

    /**
     * 设置固定资产购置时间
     *
     * @param fixedAssertBuyTime 固定资产购置时间
     */
    public void setFixedAssertBuyTime(Date fixedAssertBuyTime) {
        this.fixedAssertBuyTime = fixedAssertBuyTime;
    }

    /**
     * 获取固定资产原始单价
     *
     * @return FIXED_ASSERT_ORIGIN_PRICE - 固定资产原始单价
     */
    public BigDecimal getFixedAssertOriginPrice() {
        return fixedAssertOriginPrice;
    }

    /**
     * 设置固定资产原始单价
     *
     * @param fixedAssertOriginPrice 固定资产原始单价
     */
    public void setFixedAssertOriginPrice(BigDecimal fixedAssertOriginPrice) {
        this.fixedAssertOriginPrice = fixedAssertOriginPrice;
    }

    /**
     * 获取折旧率
     *
     * @return FIXED_ASSERT_DEPRECIATE - 折旧率
     */
    public BigDecimal getFixedAssertDepreciate() {
        return fixedAssertDepreciate;
    }

    /**
     * 设置折旧率
     *
     * @param fixedAssertDepreciate 折旧率
     */
    public void setFixedAssertDepreciate(BigDecimal fixedAssertDepreciate) {
        this.fixedAssertDepreciate = fixedAssertDepreciate;
    }

    /**
     * 获取数量
     *
     * @return FIXED_ASSERT_COUNT - 数量
     */
    public Integer getFixedAssertCount() {
        return fixedAssertCount;
    }

    /**
     * 设置数量
     *
     * @param fixedAssertCount 数量
     */
    public void setFixedAssertCount(Integer fixedAssertCount) {
        this.fixedAssertCount = fixedAssertCount;
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
     * 获取固定资产类型(0  房地产 1 设备及器材详单 2 车辆详单)
     *
     * @return FIXED_ASSERT_TYPE - 固定资产类型(0  房地产 1 设备及器材详单 2 车辆详单)
     */
    public Integer getFixedAssertType() {
        return fixedAssertType;
    }

    /**
     * 设置固定资产类型(0  房地产 1 设备及器材详单 2 车辆详单)
     *
     * @param fixedAssertType 固定资产类型(0  房地产 1 设备及器材详单 2 车辆详单)
     */
    public void setFixedAssertType(Integer fixedAssertType) {
        this.fixedAssertType = fixedAssertType;
    }

    @Override
    public Integer getPK() {
        return fixedAssertId;
    }
}