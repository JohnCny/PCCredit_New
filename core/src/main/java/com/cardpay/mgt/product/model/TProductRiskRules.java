package com.cardpay.mgt.product.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "T_PRODUCT_RISK_RULES")
@ApiModel(value="产品风险规则")
public class TProductRiskRules extends GenericEntity<Integer> {
    /**
     * 产品风险规则id
     */
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select 你的序列名.nextval from dual")
    @ApiModelProperty(value="产品风险规则id",required = true)
    private Integer id;

    /**
     * 产品id
     */
    @Column(name = "PRODUCT_ID")
    @ApiModelProperty(value="产品id",required = true)
    private Integer productId;

    /**
     * 逾期多少期转入风险名单
     */
    @Column(name = "OVER_PERIOD_LIMIT")
    @ApiModelProperty(value="逾期多少期转入风险名单",required = true)
    private Integer overPeriodLimit;

    /**
     * 不良是否转入黑名单(0 否 1 是)
     */
    @Column(name = "IS_LOAN_BAD_TO_BLACK")
    @ApiModelProperty(value="不良是否转入黑名单(0 否 1 是)",required = true)
    private Integer isLoanBadToBlack;

    /**
     * 逾期率高于%多少时则预警，用小数表示
     */
    @Column(name = "OVERDUE_WARNING_LIMIT")
    @ApiModelProperty(value="逾期率高于%多少时则预警，用小数表示",required = true)
    private BigDecimal overdueWarningLimit;

    /**
     * 不良率高于%多少时则预警，用小数表示
     */
    @Column(name = "BADLOAN_WARNING_LIMIT")
    @ApiModelProperty(value="不良率高于%多少时则预警，用小数表示",required = true)
    private BigDecimal badloanWarningLimit;

    /**
     * 行业逾期率高于%多少则预警，用小数表示
     */
    @Column(name = "INDUSTRY_OVERDUE_WARNING_LIMIT")
    @ApiModelProperty(value="行业逾期率高于%多少则预警，用小数表示",required = true)
    private BigDecimal industryOverdueWarningLimit;

    /**
     * 行业不良率高于%多少则预警，用小数表示
     */
    @Column(name = "INDUSTRY_BADLOAN_WARNING_LIMIT")
    @ApiModelProperty(value="行业不良率高于%多少则预警，用小数表示",required = true)
    private BigDecimal industryBadloanWarningLimit;

    /**
     * 获取产品风险规则id
     *
     * @return ID - 产品风险规则id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置产品风险规则id
     *
     * @param id 产品风险规则id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取产品id
     *
     * @return PRODUCT_ID - 产品id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置产品id
     *
     * @param productId 产品id
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取逾期多少期转入风险名单
     *
     * @return OVER_PERIOD_LIMIT - 逾期多少期转入风险名单
     */
    public Integer getOverPeriodLimit() {
        return overPeriodLimit;
    }

    /**
     * 设置逾期多少期转入风险名单
     *
     * @param overPeriodLimit 逾期多少期转入风险名单
     */
    public void setOverPeriodLimit(Integer overPeriodLimit) {
        this.overPeriodLimit = overPeriodLimit;
    }

    /**
     * 获取不良是否转入黑名单(0 否 1 是)
     *
     * @return IS_LOAN_BAD_TO_BLACK - 不良是否转入黑名单(0 否 1 是)
     */
    public Integer getIsLoanBadToBlack() {
        return isLoanBadToBlack;
    }

    /**
     * 设置不良是否转入黑名单(0 否 1 是)
     *
     * @param isLoanBadToBlack 不良是否转入黑名单(0 否 1 是)
     */
    public void setIsLoanBadToBlack(Integer isLoanBadToBlack) {
        this.isLoanBadToBlack = isLoanBadToBlack;
    }

    /**
     * 获取逾期率高于%多少时则预警，用小数表示
     *
     * @return OVERDUE_WARNING_LIMIT - 逾期率高于%多少时则预警，用小数表示
     */
    public BigDecimal getOverdueWarningLimit() {
        return overdueWarningLimit;
    }

    /**
     * 设置逾期率高于%多少时则预警，用小数表示
     *
     * @param overdueWarningLimit 逾期率高于%多少时则预警，用小数表示
     */
    public void setOverdueWarningLimit(BigDecimal overdueWarningLimit) {
        this.overdueWarningLimit = overdueWarningLimit;
    }

    /**
     * 获取不良率高于%多少时则预警，用小数表示
     *
     * @return BADLOAN_WARNING_LIMIT - 不良率高于%多少时则预警，用小数表示
     */
    public BigDecimal getBadloanWarningLimit() {
        return badloanWarningLimit;
    }

    /**
     * 设置不良率高于%多少时则预警，用小数表示
     *
     * @param badloanWarningLimit 不良率高于%多少时则预警，用小数表示
     */
    public void setBadloanWarningLimit(BigDecimal badloanWarningLimit) {
        this.badloanWarningLimit = badloanWarningLimit;
    }

    /**
     * 获取行业逾期率高于%多少则预警，用小数表示
     *
     * @return INDUSTRY_OVERDUE_WARNING_LIMIT - 行业逾期率高于%多少则预警，用小数表示
     */
    public BigDecimal getIndustryOverdueWarningLimit() {
        return industryOverdueWarningLimit;
    }

    /**
     * 设置行业逾期率高于%多少则预警，用小数表示
     *
     * @param industryOverdueWarningLimit 行业逾期率高于%多少则预警，用小数表示
     */
    public void setIndustryOverdueWarningLimit(BigDecimal industryOverdueWarningLimit) {
        this.industryOverdueWarningLimit = industryOverdueWarningLimit;
    }

    /**
     * 获取行业不良率高于%多少则预警，用小数表示
     *
     * @return INDUSTRY_BADLOAN_WARNING_LIMIT - 行业不良率高于%多少则预警，用小数表示
     */
    public BigDecimal getIndustryBadloanWarningLimit() {
        return industryBadloanWarningLimit;
    }

    /**
     * 设置行业不良率高于%多少则预警，用小数表示
     *
     * @param industryBadloanWarningLimit 行业不良率高于%多少则预警，用小数表示
     */
    public void setIndustryBadloanWarningLimit(BigDecimal industryBadloanWarningLimit) {
        this.industryBadloanWarningLimit = industryBadloanWarningLimit;
    }

    @Override
    public Integer getPK() {
        return null;
    }
}