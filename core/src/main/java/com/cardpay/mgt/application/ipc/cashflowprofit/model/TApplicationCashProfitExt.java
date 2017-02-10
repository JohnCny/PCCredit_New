package com.cardpay.mgt.application.ipc.cashflowprofit.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "T_APPLICATION_CASHPROFIT_EXT")
@ApiModel(value="进件模板资产负债和交叉检验额外表")
public class TApplicationCashProfitExt {
    /**
     * 进件利润现金额外值id
     */
    @Id
    @Column(name = "CASH_PROFIT_VAR_EXTRA_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select APP_TEMPLATE_CASH_VAR_EXT_SEQ.NEXTVAL from dual")
    @ApiModelProperty(value="进件利润现金额外值id",required = true)
    private Integer cashProfitVarExtraId;

    /**
     * 进件利润现金值id
     */
    @Column(name = "CASH_PROFIT_VAR_ID")
    @ApiModelProperty(value="进件利润现金值id",required = true)
    private BigDecimal cashProfitVarId;

    /**
     * 建议额外字段值name
     */
    @Column(name = "CASH_PROFIT_EXTRA_NAME")
    @ApiModelProperty(value="建议额外字段值name",required = true)
    private String cashProfitExtraName;

    /**
     * 建议额外值字段value
     */
    @Column(name = "CASH_PROFIT_VAR_VALUE")
    @ApiModelProperty(value="建议额外值字段value",required = true)
    private String cashProfitVarValue;

    /**
     * 进件id
     */
    @Column(name = "APPLICATION_ID")
    @ApiModelProperty(value="进件id",required = true)
    private Integer applicationId;

    /**
     * 额外第一个月
     */
    @Column(name = "EXTRA_MONTH_ONE")
    @ApiModelProperty(value="额外第一个月",required = true)
    private BigDecimal extraMonthOne;

    /**
     * 额外第二个月
     */
    @Column(name = "EXTRA_MONTH_TWO")
    @ApiModelProperty(value="额外第二个月",required = true)
    private BigDecimal extraMonthTwo;

    /**
     * 额外第三个月
     */
    @Column(name = "EXTRA_MONTH_THREE")
    @ApiModelProperty(value="额外第三个月",required = true)
    private BigDecimal extraMonthThree;

    /**
     * 额外第四个月
     */
    @Column(name = "EXTRA_MONTH_FOUR")
    @ApiModelProperty(value="额外第四个月",required = true)
    private Long extraMonthFour;

    /**
     * 额外第五个月
     */
    @Column(name = "EXTRA_MONTH_FIVE")
    @ApiModelProperty(value="额外第五个月",required = true)
    private Long extraMonthFive;

    /**
     * 额外第六个月
     */
    @Column(name = "EXTRA_MONTH_SIX")
    @ApiModelProperty(value="额外第六个月",required = true)
    private Long extraMonthSix;

    /**
     * 额外第七个月
     */
    @Column(name = "EXTRA_MONTH_SEVEN")
    @ApiModelProperty(value="额外第七个月",required = true)
    private BigDecimal extraMonthSeven;

    /**
     * 额外第八个月
     */
    @Column(name = "EXTRA_MONTH_EIGHT")
    @ApiModelProperty(value="额外第八个月",required = true)
    private BigDecimal extraMonthEight;

    /**
     * 额外第九个月
     */
    @Column(name = "EXTRA_MONTH_NINE")
    @ApiModelProperty(value="额外第九个月",required = true)
    private BigDecimal extraMonthNine;

    /**
     * 额外第十个月
     */
    @Column(name = "EXTRA_MONTH_TEN")
    @ApiModelProperty(value="额外第十个月",required = true)
    private BigDecimal extraMonthTen;

    /**
     * 额外第十一个月
     */
    @Column(name = "EXTRA_MONTH_ELEVEN")
    @ApiModelProperty(value="额外第十一个月",required = true)
    private BigDecimal extraMonthEleven;

    /**
     * 额外第十二个月
     */
    @Column(name = "EXTRA_MONTH_TWELVE")
    @ApiModelProperty(value="额外第十二个月",required = true)
    private BigDecimal extraMonthTwelve;

    /**
     * 额外总计
     */
    @Column(name = "EXTRA_CROSS_VALIDATE_ALL")
    @ApiModelProperty(value="额外总计",required = true)
    private BigDecimal extraCrossValidateAll;

    /**
     * 额外月平均
     */
    @Column(name = "EXTRA_CROSS_VALIDATE_MONTH_AVG")
    @ApiModelProperty(value="额外月平均",required = true)
    private BigDecimal extraCrossValidateMonthAvg;

    /**
     * 获取进件利润现金额外值id
     *
     * @return CASH_PROFIT_VAR_EXTRA_ID - 进件利润现金额外值id
     */
    public Integer getCashProfitVarExtraId() {
        return cashProfitVarExtraId;
    }

    /**
     * 设置进件利润现金额外值id
     *
     * @param cashProfitVarExtraId 进件利润现金额外值id
     */
    public void setCashProfitVarExtraId(Integer cashProfitVarExtraId) {
        this.cashProfitVarExtraId = cashProfitVarExtraId;
    }

    /**
     * 获取进件利润现金值id
     *
     * @return CASH_PROFIT_VAR_ID - 进件利润现金值id
     */
    public BigDecimal getCashProfitVarId() {
        return cashProfitVarId;
    }

    /**
     * 设置进件利润现金值id
     *
     * @param cashProfitVarId 进件利润现金值id
     */
    public void setCashProfitVarId(BigDecimal cashProfitVarId) {
        this.cashProfitVarId = cashProfitVarId;
    }

    /**
     * 获取建议额外字段值name
     *
     * @return CASH_PROFIT_EXTRA_NAME - 建议额外字段值name
     */
    public String getCashProfitExtraName() {
        return cashProfitExtraName;
    }

    /**
     * 设置建议额外字段值name
     *
     * @param cashProfitExtraName 建议额外字段值name
     */
    public void setCashProfitExtraName(String cashProfitExtraName) {
        this.cashProfitExtraName = cashProfitExtraName;
    }

    /**
     * 获取建议额外值字段value
     *
     * @return CASH_PROFIT_VAR_VALUE - 建议额外值字段value
     */
    public String getCashProfitVarValue() {
        return cashProfitVarValue;
    }

    /**
     * 设置建议额外值字段value
     *
     * @param cashProfitVarValue 建议额外值字段value
     */
    public void setCashProfitVarValue(String cashProfitVarValue) {
        this.cashProfitVarValue = cashProfitVarValue;
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
     * 获取额外第一个月
     *
     * @return EXTRA_MONTH_ONE - 额外第一个月
     */
    public BigDecimal getExtraMonthOne() {
        return extraMonthOne;
    }

    /**
     * 设置额外第一个月
     *
     * @param extraMonthOne 额外第一个月
     */
    public void setExtraMonthOne(BigDecimal extraMonthOne) {
        this.extraMonthOne = extraMonthOne;
    }

    /**
     * 获取额外第二个月
     *
     * @return EXTRA_MONTH_TWO - 额外第二个月
     */
    public BigDecimal getExtraMonthTwo() {
        return extraMonthTwo;
    }

    /**
     * 设置额外第二个月
     *
     * @param extraMonthTwo 额外第二个月
     */
    public void setExtraMonthTwo(BigDecimal extraMonthTwo) {
        this.extraMonthTwo = extraMonthTwo;
    }

    /**
     * 获取额外第三个月
     *
     * @return EXTRA_MONTH_THREE - 额外第三个月
     */
    public BigDecimal getExtraMonthThree() {
        return extraMonthThree;
    }

    /**
     * 设置额外第三个月
     *
     * @param extraMonthThree 额外第三个月
     */
    public void setExtraMonthThree(BigDecimal extraMonthThree) {
        this.extraMonthThree = extraMonthThree;
    }

    /**
     * 获取额外第四个月
     *
     * @return EXTRA_MONTH_FOUR - 额外第四个月
     */
    public Long getExtraMonthFour() {
        return extraMonthFour;
    }

    /**
     * 设置额外第四个月
     *
     * @param extraMonthFour 额外第四个月
     */
    public void setExtraMonthFour(Long extraMonthFour) {
        this.extraMonthFour = extraMonthFour;
    }

    /**
     * 获取额外第五个月
     *
     * @return EXTRA_MONTH_FIVE - 额外第五个月
     */
    public Long getExtraMonthFive() {
        return extraMonthFive;
    }

    /**
     * 设置额外第五个月
     *
     * @param extraMonthFive 额外第五个月
     */
    public void setExtraMonthFive(Long extraMonthFive) {
        this.extraMonthFive = extraMonthFive;
    }

    /**
     * 获取额外第六个月
     *
     * @return EXTRA_MONTH_SIX - 额外第六个月
     */
    public Long getExtraMonthSix() {
        return extraMonthSix;
    }

    /**
     * 设置额外第六个月
     *
     * @param extraMonthSix 额外第六个月
     */
    public void setExtraMonthSix(Long extraMonthSix) {
        this.extraMonthSix = extraMonthSix;
    }

    /**
     * 获取额外第七个月
     *
     * @return EXTRA_MONTH_SEVEN - 额外第七个月
     */
    public BigDecimal getExtraMonthSeven() {
        return extraMonthSeven;
    }

    /**
     * 设置额外第七个月
     *
     * @param extraMonthSeven 额外第七个月
     */
    public void setExtraMonthSeven(BigDecimal extraMonthSeven) {
        this.extraMonthSeven = extraMonthSeven;
    }

    /**
     * 获取额外第八个月
     *
     * @return EXTRA_MONTH_EIGHT - 额外第八个月
     */
    public BigDecimal getExtraMonthEight() {
        return extraMonthEight;
    }

    /**
     * 设置额外第八个月
     *
     * @param extraMonthEight 额外第八个月
     */
    public void setExtraMonthEight(BigDecimal extraMonthEight) {
        this.extraMonthEight = extraMonthEight;
    }

    /**
     * 获取额外第九个月
     *
     * @return EXTRA_MONTH_NINE - 额外第九个月
     */
    public BigDecimal getExtraMonthNine() {
        return extraMonthNine;
    }

    /**
     * 设置额外第九个月
     *
     * @param extraMonthNine 额外第九个月
     */
    public void setExtraMonthNine(BigDecimal extraMonthNine) {
        this.extraMonthNine = extraMonthNine;
    }

    /**
     * 获取额外第十个月
     *
     * @return EXTRA_MONTH_TEN - 额外第十个月
     */
    public BigDecimal getExtraMonthTen() {
        return extraMonthTen;
    }

    /**
     * 设置额外第十个月
     *
     * @param extraMonthTen 额外第十个月
     */
    public void setExtraMonthTen(BigDecimal extraMonthTen) {
        this.extraMonthTen = extraMonthTen;
    }

    /**
     * 获取额外第十一个月
     *
     * @return EXTRA_MONTH_ELEVEN - 额外第十一个月
     */
    public BigDecimal getExtraMonthEleven() {
        return extraMonthEleven;
    }

    /**
     * 设置额外第十一个月
     *
     * @param extraMonthEleven 额外第十一个月
     */
    public void setExtraMonthEleven(BigDecimal extraMonthEleven) {
        this.extraMonthEleven = extraMonthEleven;
    }

    /**
     * 获取额外第十二个月
     *
     * @return EXTRA_MONTH_TWELVE - 额外第十二个月
     */
    public BigDecimal getExtraMonthTwelve() {
        return extraMonthTwelve;
    }

    /**
     * 设置额外第十二个月
     *
     * @param extraMonthTwelve 额外第十二个月
     */
    public void setExtraMonthTwelve(BigDecimal extraMonthTwelve) {
        this.extraMonthTwelve = extraMonthTwelve;
    }

    /**
     * 获取额外总计
     *
     * @return EXTRA_CROSS_VALIDATE_ALL - 额外总计
     */
    public BigDecimal getExtraCrossValidateAll() {
        return extraCrossValidateAll;
    }

    /**
     * 设置额外总计
     *
     * @param extraCrossValidateAll 额外总计
     */
    public void setExtraCrossValidateAll(BigDecimal extraCrossValidateAll) {
        this.extraCrossValidateAll = extraCrossValidateAll;
    }

    /**
     * 获取额外月平均
     *
     * @return EXTRA_CROSS_VALIDATE_MONTH_AVG - 额外月平均
     */
    public BigDecimal getExtraCrossValidateMonthAvg() {
        return extraCrossValidateMonthAvg;
    }

    /**
     * 设置额外月平均
     *
     * @param extraCrossValidateMonthAvg 额外月平均
     */
    public void setExtraCrossValidateMonthAvg(BigDecimal extraCrossValidateMonthAvg) {
        this.extraCrossValidateMonthAvg = extraCrossValidateMonthAvg;
    }
}