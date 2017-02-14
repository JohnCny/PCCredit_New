package com.cardpay.mgt.application.ipc.cashflowprofit.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

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
    private Integer cashProfitVarId;

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
    private String extraMonthOne;

    /**
     * 额外第二个月
     */
    @Column(name = "EXTRA_MONTH_TWO")
    @ApiModelProperty(value="额外第二个月",required = true)
    private String extraMonthTwo;

    /**
     * 额外第三个月
     */
    @Column(name = "EXTRA_MONTH_THREE")
    @ApiModelProperty(value="额外第三个月",required = true)
    private String extraMonthThree;

    /**
     * 额外第四个月
     */
    @Column(name = "EXTRA_MONTH_FOUR")
    @ApiModelProperty(value="额外第四个月",required = true)
    private String extraMonthFour;

    /**
     * 额外第五个月
     */
    @Column(name = "EXTRA_MONTH_FIVE")
    @ApiModelProperty(value="额外第五个月",required = true)
    private String extraMonthFive;

    /**
     * 额外第六个月
     */
    @Column(name = "EXTRA_MONTH_SIX")
    @ApiModelProperty(value="额外第六个月",required = true)
    private String extraMonthSix;

    /**
     * 额外第七个月
     */
    @Column(name = "EXTRA_MONTH_SEVEN")
    @ApiModelProperty(value="额外第七个月",required = true)
    private String extraMonthSeven;

    /**
     * 额外第八个月
     */
    @Column(name = "EXTRA_MONTH_EIGHT")
    @ApiModelProperty(value="额外第八个月",required = true)
    private String extraMonthEight;

    /**
     * 额外第九个月
     */
    @Column(name = "EXTRA_MONTH_NINE")
    @ApiModelProperty(value="额外第九个月",required = true)
    private String extraMonthNine;

    /**
     * 额外第十个月
     */
    @Column(name = "EXTRA_MONTH_TEN")
    @ApiModelProperty(value="额外第十个月",required = true)
    private String extraMonthTen;

    /**
     * 额外第十一个月
     */
    @Column(name = "EXTRA_MONTH_ELEVEN")
    @ApiModelProperty(value="额外第十一个月",required = true)
    private String extraMonthEleven;

    /**
     * 额外第十二个月
     */
    @Column(name = "EXTRA_MONTH_TWELVE")
    @ApiModelProperty(value="额外第十二个月",required = true)
    private String extraMonthTwelve;

    /**
     * 额外调查当月
     */
    @Column(name = "EXTRA_SURVEY_CURRENT_MONTH")
    @ApiModelProperty(value="额外调查当月",required = true)
    private String extraSurveyCurrentMonth;

    /**
     * 额外总计
     */
    @Column(name = "EXTRA_CROSS_VALIDATE_ALL")
    @ApiModelProperty(value="额外总计",required = true)
    private String extraCrossValidateAll;

    /**
     * 额外月平均
     */
    @Column(name = "EXTRA_CROSS_VALIDATE_MONTH_AVG")
    @ApiModelProperty(value="额外月平均",required = true)
    private String extraCrossValidateMonthAvg;

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
    public Integer getCashProfitVarId() {
        return cashProfitVarId;
    }

    /**
     * 设置进件利润现金值id
     *
     * @param cashProfitVarId 进件利润现金值id
     */
    public void setCashProfitVarId(Integer cashProfitVarId) {
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
    public String getExtraMonthOne() {
        return extraMonthOne;
    }

    /**
     * 设置额外第一个月
     *
     * @param extraMonthOne 额外第一个月
     */
    public void setExtraMonthOne(String extraMonthOne) {
        this.extraMonthOne = extraMonthOne;
    }

    /**
     * 获取额外第二个月
     *
     * @return EXTRA_MONTH_TWO - 额外第二个月
     */
    public String getExtraMonthTwo() {
        return extraMonthTwo;
    }

    /**
     * 设置额外第二个月
     *
     * @param extraMonthTwo 额外第二个月
     */
    public void setExtraMonthTwo(String extraMonthTwo) {
        this.extraMonthTwo = extraMonthTwo;
    }

    /**
     * 获取额外第三个月
     *
     * @return EXTRA_MONTH_THREE - 额外第三个月
     */
    public String getExtraMonthThree() {
        return extraMonthThree;
    }

    /**
     * 设置额外第三个月
     *
     * @param extraMonthThree 额外第三个月
     */
    public void setExtraMonthThree(String extraMonthThree) {
        this.extraMonthThree = extraMonthThree;
    }

    /**
     * 获取额外第四个月
     *
     * @return EXTRA_MONTH_FOUR - 额外第四个月
     */
    public String getExtraMonthFour() {
        return extraMonthFour;
    }

    /**
     * 设置额外第四个月
     *
     * @param extraMonthFour 额外第四个月
     */
    public void setExtraMonthFour(String extraMonthFour) {
        this.extraMonthFour = extraMonthFour;
    }

    /**
     * 获取额外第五个月
     *
     * @return EXTRA_MONTH_FIVE - 额外第五个月
     */
    public String getExtraMonthFive() {
        return extraMonthFive;
    }

    /**
     * 设置额外第五个月
     *
     * @param extraMonthFive 额外第五个月
     */
    public void setExtraMonthFive(String extraMonthFive) {
        this.extraMonthFive = extraMonthFive;
    }

    /**
     * 获取额外第六个月
     *
     * @return EXTRA_MONTH_SIX - 额外第六个月
     */
    public String getExtraMonthSix() {
        return extraMonthSix;
    }

    /**
     * 设置额外第六个月
     *
     * @param extraMonthSix 额外第六个月
     */
    public void setExtraMonthSix(String extraMonthSix) {
        this.extraMonthSix = extraMonthSix;
    }

    /**
     * 获取额外第七个月
     *
     * @return EXTRA_MONTH_SEVEN - 额外第七个月
     */
    public String getExtraMonthSeven() {
        return extraMonthSeven;
    }

    /**
     * 设置额外第七个月
     *
     * @param extraMonthSeven 额外第七个月
     */
    public void setExtraMonthSeven(String extraMonthSeven) {
        this.extraMonthSeven = extraMonthSeven;
    }

    /**
     * 获取额外第八个月
     *
     * @return EXTRA_MONTH_EIGHT - 额外第八个月
     */
    public String getExtraMonthEight() {
        return extraMonthEight;
    }

    /**
     * 设置额外第八个月
     *
     * @param extraMonthEight 额外第八个月
     */
    public void setExtraMonthEight(String extraMonthEight) {
        this.extraMonthEight = extraMonthEight;
    }

    /**
     * 获取额外第九个月
     *
     * @return EXTRA_MONTH_NINE - 额外第九个月
     */
    public String getExtraMonthNine() {
        return extraMonthNine;
    }

    /**
     * 设置额外第九个月
     *
     * @param extraMonthNine 额外第九个月
     */
    public void setExtraMonthNine(String extraMonthNine) {
        this.extraMonthNine = extraMonthNine;
    }

    /**
     * 获取额外第十个月
     *
     * @return EXTRA_MONTH_TEN - 额外第十个月
     */
    public String getExtraMonthTen() {
        return extraMonthTen;
    }

    /**
     * 设置额外第十个月
     *
     * @param extraMonthTen 额外第十个月
     */
    public void setExtraMonthTen(String extraMonthTen) {
        this.extraMonthTen = extraMonthTen;
    }

    /**
     * 获取额外第十一个月
     *
     * @return EXTRA_MONTH_ELEVEN - 额外第十一个月
     */
    public String getExtraMonthEleven() {
        return extraMonthEleven;
    }

    /**
     * 设置额外第十一个月
     *
     * @param extraMonthEleven 额外第十一个月
     */
    public void setExtraMonthEleven(String extraMonthEleven) {
        this.extraMonthEleven = extraMonthEleven;
    }

    /**
     * 获取额外第十二个月
     *
     * @return EXTRA_MONTH_TWELVE - 额外第十二个月
     */
    public String getExtraMonthTwelve() {
        return extraMonthTwelve;
    }

    /**
     * 设置额外第十二个月
     *
     * @param extraMonthTwelve 额外第十二个月
     */
    public void setExtraMonthTwelve(String extraMonthTwelve) {
        this.extraMonthTwelve = extraMonthTwelve;
    }

    /**
     * 获取额外调查当月
     *
     * @return EXTRA_SURVEY_CURRENT_MONTH - 额外调查当月
     */
    public String getExtraSurveyCurrentMonth() {
        return extraSurveyCurrentMonth;
    }

    /**
     * 设置额外调查当月
     *
     * @param extraSurveyCurrentMonth 额外调查当月
     */
    public void setExtraSurveyCurrentMonth(String extraSurveyCurrentMonth) {
        this.extraSurveyCurrentMonth = extraSurveyCurrentMonth;
    }

    /**
     * 获取额外总计
     *
     * @return EXTRA_CROSS_VALIDATE_ALL - 额外总计
     */
    public String getExtraCrossValidateAll() {
        return extraCrossValidateAll;
    }

    /**
     * 设置额外总计
     *
     * @param extraCrossValidateAll 额外总计
     */
    public void setExtraCrossValidateAll(String extraCrossValidateAll) {
        this.extraCrossValidateAll = extraCrossValidateAll;
    }

    /**
     * 获取额外月平均
     *
     * @return EXTRA_CROSS_VALIDATE_MONTH_AVG - 额外月平均
     */
    public String getExtraCrossValidateMonthAvg() {
        return extraCrossValidateMonthAvg;
    }

    /**
     * 设置额外月平均
     *
     * @param extraCrossValidateMonthAvg 额外月平均
     */
    public void setExtraCrossValidateMonthAvg(String extraCrossValidateMonthAvg) {
        this.extraCrossValidateMonthAvg = extraCrossValidateMonthAvg;
    }
}