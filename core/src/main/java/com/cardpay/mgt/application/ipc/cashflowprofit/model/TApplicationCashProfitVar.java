package com.cardpay.mgt.application.ipc.cashflowprofit.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Table(name = "T_APPLICATION_CASHPROFIT_VAR")
@ApiModel(value="进件标准利润表和现金流表")
public class TApplicationCashProfitVar {
    /**
     * 进件模板利润现金值id
     */
    @Id
    @Column(name = "APPLICATION_CASH_PROFIT_VAR_ID")
    @ApiModelProperty(value="进件模板利润现金值id",required = true)
    private Integer applicationCashProfitVarId;

    /**
     * 利润现金模板值id
     */
    @Column(name = "CASH_PROFIT_VAR_ID")
    @ApiModelProperty(value="利润现金模板值id",required = true)
    private Integer cashProfitVarId;

    /**
     * 建议模板值value
     */
    @Column(name = "CASH_PROFIT_VAR_VALUE")
    @ApiModelProperty(value="建议模板值value",required = true)
    private String cashProfitVarValue;

    /**
     * 建议选项值id
     */
    @Column(name = "CASH_PROFIT_OPTION_ID")
    @ApiModelProperty(value="建议选项值id",required = true)
    private Integer cashProfitOptionId;

    /**
     * 第一个月
     */
    @Column(name = "VAR_MONTH_ONE")
    @ApiModelProperty(value="第一个月",required = true)
    private String varMonthOne;

    /**
     * 第二个月
     */
    @Column(name = "VAR_MONTH_TWO")
    @ApiModelProperty(value="第二个月",required = true)
    private String varMonthTwo;

    /**
     * 第三个月
     */
    @Column(name = "VAR_MONTH_THREE")
    @ApiModelProperty(value="第三个月",required = true)
    private String varMonthThree;

    /**
     * 第四个月
     */
    @Column(name = "VAR_MONTH_FOUR")
    @ApiModelProperty(value="第四个月",required = true)
    private String varMonthFour;

    /**
     * 第五个月
     */
    @Column(name = "VAR_MONTH_FIVE")
    @ApiModelProperty(value="第五个月",required = true)
    private String varMonthFive;

    /**
     * 第六个月
     */
    @Column(name = "VAR_MONTH_SIX")
    @ApiModelProperty(value="第六个月",required = true)
    private String varMonthSix;

    /**
     * 第七个月
     */
    @Column(name = "VAR_MONTH_SEVEN")
    @ApiModelProperty(value="第七个月",required = true)
    private String varMonthSeven;

    /**
     * 第八个月
     */
    @Column(name = "VAR_MONTH_EIGHT")
    @ApiModelProperty(value="第八个月",required = true)
    private String varMonthEight;

    /**
     * 第九个月
     */
    @Column(name = "VAR_MONTH_NINE")
    @ApiModelProperty(value="第九个月",required = true)
    private String varMonthNine;

    /**
     * 第十个月
     */
    @Column(name = "VAR_MONTH_TEN")
    @ApiModelProperty(value="第十个月",required = true)
    private String varMonthTen;

    /**
     * 第十一个月
     */
    @Column(name = "VAR_MONTH_ELEVEN")
    @ApiModelProperty(value="第十一个月",required = true)
    private String varMonthEleven;

    /**
     * 第十二个月
     */
    @Column(name = "VAR_MONTH_TWELVE")
    @ApiModelProperty(value="第十二个月",required = true)
    private String varMonthTwelve;

    /**
     * 调查当月
     */
    @Column(name = "VAR_SURVEY_CURRENT_MONTH")
    @ApiModelProperty(value="调查当月",required = true)
    private String varSurveyCurrentMonth;

    /**
     * 总计
     */
    @Column(name = "VAR_CROSS_VALIDATE_ALL")
    @ApiModelProperty(value="总计",required = true)
    private String varCrossValidateAll;

    /**
     * 月平均
     */
    @Column(name = "VAR_CROSS_VALIDATE_MONTH_AVG")
    @ApiModelProperty(value="月平均",required = true)
    private String varCrossValidateMonthAvg;

    /**
     * 进件id
     */
    @Column(name = "APPLICATION_ID")
    @ApiModelProperty(value="进件id",required = true)
    private Integer applicationId;

    /**
     * 获取进件模板利润现金值id
     *
     * @return APPLICATION_CASH_PROFIT_VAR_ID - 进件模板利润现金值id
     */
    public Integer getApplicationCashProfitVarId() {
        return applicationCashProfitVarId;
    }

    /**
     * 设置进件模板利润现金值id
     *
     * @param applicationCashProfitVarId 进件模板利润现金值id
     */
    public void setApplicationCashProfitVarId(Integer applicationCashProfitVarId) {
        this.applicationCashProfitVarId = applicationCashProfitVarId;
    }

    /**
     * 获取利润现金模板值id
     *
     * @return CASH_PROFIT_VAR_ID - 利润现金模板值id
     */
    public Integer getCashProfitVarId() {
        return cashProfitVarId;
    }

    /**
     * 设置利润现金模板值id
     *
     * @param cashProfitVarId 利润现金模板值id
     */
    public void setCashProfitVarId(Integer cashProfitVarId) {
        this.cashProfitVarId = cashProfitVarId;
    }

    /**
     * 获取建议模板值value
     *
     * @return CASH_PROFIT_VAR_VALUE - 建议模板值value
     */
    public String getCashProfitVarValue() {
        return cashProfitVarValue;
    }

    /**
     * 设置建议模板值value
     *
     * @param cashProfitVarValue 建议模板值value
     */
    public void setCashProfitVarValue(String cashProfitVarValue) {
        this.cashProfitVarValue = cashProfitVarValue;
    }

    /**
     * 获取建议选项值id
     *
     * @return CASH_PROFIT_OPTION_ID - 建议选项值id
     */
    public Integer getCashProfitOptionId() {
        return cashProfitOptionId;
    }

    /**
     * 设置建议选项值id
     *
     * @param cashProfitOptionId 建议选项值id
     */
    public void setCashProfitOptionId(Integer cashProfitOptionId) {
        this.cashProfitOptionId = cashProfitOptionId;
    }

    /**
     * 获取第一个月
     *
     * @return VAR_MONTH_ONE - 第一个月
     */
    public String getVarMonthOne() {
        return varMonthOne;
    }

    /**
     * 设置第一个月
     *
     * @param varMonthOne 第一个月
     */
    public void setVarMonthOne(String varMonthOne) {
        this.varMonthOne = varMonthOne;
    }

    /**
     * 获取第二个月
     *
     * @return VAR_MONTH_TWO - 第二个月
     */
    public String getVarMonthTwo() {
        return varMonthTwo;
    }

    /**
     * 设置第二个月
     *
     * @param varMonthTwo 第二个月
     */
    public void setVarMonthTwo(String varMonthTwo) {
        this.varMonthTwo = varMonthTwo;
    }

    /**
     * 获取第三个月
     *
     * @return VAR_MONTH_THREE - 第三个月
     */
    public String getVarMonthThree() {
        return varMonthThree;
    }

    /**
     * 设置第三个月
     *
     * @param varMonthThree 第三个月
     */
    public void setVarMonthThree(String varMonthThree) {
        this.varMonthThree = varMonthThree;
    }

    /**
     * 获取第四个月
     *
     * @return VAR_MONTH_FOUR - 第四个月
     */
    public String getVarMonthFour() {
        return varMonthFour;
    }

    /**
     * 设置第四个月
     *
     * @param varMonthFour 第四个月
     */
    public void setVarMonthFour(String varMonthFour) {
        this.varMonthFour = varMonthFour;
    }

    /**
     * 获取第五个月
     *
     * @return VAR_MONTH_FIVE - 第五个月
     */
    public String getVarMonthFive() {
        return varMonthFive;
    }

    /**
     * 设置第五个月
     *
     * @param varMonthFive 第五个月
     */
    public void setVarMonthFive(String varMonthFive) {
        this.varMonthFive = varMonthFive;
    }

    /**
     * 获取第六个月
     *
     * @return VAR_MONTH_SIX - 第六个月
     */
    public String getVarMonthSix() {
        return varMonthSix;
    }

    /**
     * 设置第六个月
     *
     * @param varMonthSix 第六个月
     */
    public void setVarMonthSix(String varMonthSix) {
        this.varMonthSix = varMonthSix;
    }

    /**
     * 获取第七个月
     *
     * @return VAR_MONTH_SEVEN - 第七个月
     */
    public String getVarMonthSeven() {
        return varMonthSeven;
    }

    /**
     * 设置第七个月
     *
     * @param varMonthSeven 第七个月
     */
    public void setVarMonthSeven(String varMonthSeven) {
        this.varMonthSeven = varMonthSeven;
    }

    /**
     * 获取第八个月
     *
     * @return VAR_MONTH_EIGHT - 第八个月
     */
    public String getVarMonthEight() {
        return varMonthEight;
    }

    /**
     * 设置第八个月
     *
     * @param varMonthEight 第八个月
     */
    public void setVarMonthEight(String varMonthEight) {
        this.varMonthEight = varMonthEight;
    }

    /**
     * 获取第九个月
     *
     * @return VAR_MONTH_NINE - 第九个月
     */
    public String getVarMonthNine() {
        return varMonthNine;
    }

    /**
     * 设置第九个月
     *
     * @param varMonthNine 第九个月
     */
    public void setVarMonthNine(String varMonthNine) {
        this.varMonthNine = varMonthNine;
    }

    /**
     * 获取第十个月
     *
     * @return VAR_MONTH_TEN - 第十个月
     */
    public String getVarMonthTen() {
        return varMonthTen;
    }

    /**
     * 设置第十个月
     *
     * @param varMonthTen 第十个月
     */
    public void setVarMonthTen(String varMonthTen) {
        this.varMonthTen = varMonthTen;
    }

    /**
     * 获取第十一个月
     *
     * @return VAR_MONTH_ELEVEN - 第十一个月
     */
    public String getVarMonthEleven() {
        return varMonthEleven;
    }

    /**
     * 设置第十一个月
     *
     * @param varMonthEleven 第十一个月
     */
    public void setVarMonthEleven(String varMonthEleven) {
        this.varMonthEleven = varMonthEleven;
    }

    /**
     * 获取第十二个月
     *
     * @return VAR_MONTH_TWELVE - 第十二个月
     */
    public String getVarMonthTwelve() {
        return varMonthTwelve;
    }

    /**
     * 设置第十二个月
     *
     * @param varMonthTwelve 第十二个月
     */
    public void setVarMonthTwelve(String varMonthTwelve) {
        this.varMonthTwelve = varMonthTwelve;
    }

    /**
     * 获取调查当月
     *
     * @return VAR_SURVEY_CURRENT_MONTH - 调查当月
     */
    public String getVarSurveyCurrentMonth() {
        return varSurveyCurrentMonth;
    }

    /**
     * 设置调查当月
     *
     * @param varSurveyCurrentMonth 调查当月
     */
    public void setVarSurveyCurrentMonth(String varSurveyCurrentMonth) {
        this.varSurveyCurrentMonth = varSurveyCurrentMonth;
    }

    /**
     * 获取总计
     *
     * @return VAR_CROSS_VALIDATE_ALL - 总计
     */
    public String getVarCrossValidateAll() {
        return varCrossValidateAll;
    }

    /**
     * 设置总计
     *
     * @param varCrossValidateAll 总计
     */
    public void setVarCrossValidateAll(String varCrossValidateAll) {
        this.varCrossValidateAll = varCrossValidateAll;
    }

    /**
     * 获取月平均
     *
     * @return VAR_CROSS_VALIDATE_MONTH_AVG - 月平均
     */
    public String getVarCrossValidateMonthAvg() {
        return varCrossValidateMonthAvg;
    }

    /**
     * 设置月平均
     *
     * @param varCrossValidateMonthAvg 月平均
     */
    public void setVarCrossValidateMonthAvg(String varCrossValidateMonthAvg) {
        this.varCrossValidateMonthAvg = varCrossValidateMonthAvg;
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
}