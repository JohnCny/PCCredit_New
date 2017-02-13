package com.cardpay.mgt.application.ipc.cashflowprofit.model.vo;


import com.cardpay.mgt.application.ipc.cashflowprofit.model.TApplicationCashProfitExt;
import com.cardpay.mgt.application.ipc.normal.model.TTemplateVarOption;

import java.util.List;

public class CashProfitTemplateVar {

    /**
     * 选项id
     */
    private Integer optionId;

    /**
     * children
     */
    private List<CashProfitTemplateVar> vars;

    /**
     * options
     */
    private List<TTemplateVarOption> options;

    /**
     * extras
     */
    private List<TApplicationCashProfitExt> extras;

    /**
     * 进件模板值id
     */
    private Integer templateVarId;

    /**
     * 进件模板值名称
     */
    private String templateVarName;

    /**
     * 进件模板值父节点id
     */
    private Integer templateVarParentId;

    /**
     * 进件模板值节点顺序
     */
    private Integer templateVarOrder;

    /**
     * 进件模板值输入类型(0 input 输入框 1 select 单选 2 check 多选3 datapicker 时间 4 mutilSelect 多选 5 text 文字 6 range区间)
     */
    private Integer templateVarInputType;

    /**
     * 进件模板值节点权重
     */
    private String templateVarWeight;

    /**
     * 进件模板值组id
     */
    private Integer templateVarGroupId;

    /**
     * 进件模板值是否包含用户自定义子项(0 包含 1 包含)
     */
    private Integer templateVarIsHasChild;

    /**
     * 进件模板值是否是进件计算项(0 否 1 是)
     */
    private Integer templateVarIsCompute;

    /**
     * application_var 主键
     * 进件模板利润现金值id
     */
    private Integer applicationCashProfitVarId;

    /**
     * 第一个月
     */
    private Integer varMonthOne;

    /**
     * 第二个月
     */
    private Integer varMonthTwo;

    /**
     * 第三个月
     */
    private Integer varMonthThree;

    /**
     * 第四个月
     */
    private Long varMonthFour;

    /**
     * 第五个月
     */
    private Long varMonthFive;

    /**
     * 第六个月
     */
    private Long varMonthSix;

    /**
     * 第七个月
     */
    private Integer varMonthSeven;

    /**
     * 第八个月
     */
    private Integer varMonthEight;

    /**
     * 第九个月
     */
    private Integer varMonthNine;

    /**
     * 第十个月
     */
    private Integer varMonthTen;

    /**
     * 第十一个月
     */
    private Integer varMonthEleven;

    /**
     * 第十二个月
     */
    private Integer varMonthTwelve;

    /**
     * 调查当月
     */
    private Integer varSurveyCurrentMonth;

    /**
     * 总计
     */
    private Integer varCrossValidateAll;

    /**
     * 月平均
     */
    private Integer varCrossValidateMonthAvg;

    /**
     * 进件id
     */
    private Integer applicationId;

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    public List<CashProfitTemplateVar> getVars() {
        return vars;
    }

    public void setVars(List<CashProfitTemplateVar> vars) {
        this.vars = vars;
    }

    public List<TTemplateVarOption> getOptions() {
        return options;
    }

    public void setOptions(List<TTemplateVarOption> options) {
        this.options = options;
    }

    public List<TApplicationCashProfitExt> getExtras() {
        return extras;
    }

    public void setExtras(List<TApplicationCashProfitExt> extras) {
        this.extras = extras;
    }

    public Integer getTemplateVarId() {
        return templateVarId;
    }

    public void setTemplateVarId(Integer templateVarId) {
        this.templateVarId = templateVarId;
    }

    public String getTemplateVarName() {
        return templateVarName;
    }

    public void setTemplateVarName(String templateVarName) {
        this.templateVarName = templateVarName;
    }

    public Integer getTemplateVarParentId() {
        return templateVarParentId;
    }

    public void setTemplateVarParentId(Integer templateVarParentId) {
        this.templateVarParentId = templateVarParentId;
    }

    public Integer getTemplateVarOrder() {
        return templateVarOrder;
    }

    public void setTemplateVarOrder(Integer templateVarOrder) {
        this.templateVarOrder = templateVarOrder;
    }

    public Integer getTemplateVarInputType() {
        return templateVarInputType;
    }

    public void setTemplateVarInputType(Integer templateVarInputType) {
        this.templateVarInputType = templateVarInputType;
    }

    public String getTemplateVarWeight() {
        return templateVarWeight;
    }

    public void setTemplateVarWeight(String templateVarWeight) {
        this.templateVarWeight = templateVarWeight;
    }

    public Integer getTemplateVarGroupId() {
        return templateVarGroupId;
    }

    public void setTemplateVarGroupId(Integer templateVarGroupId) {
        this.templateVarGroupId = templateVarGroupId;
    }

    public Integer getTemplateVarIsHasChild() {
        return templateVarIsHasChild;
    }

    public void setTemplateVarIsHasChild(Integer templateVarIsHasChild) {
        this.templateVarIsHasChild = templateVarIsHasChild;
    }

    public Integer getVarSurveyCurrentMonth() {
        return varSurveyCurrentMonth;
    }

    public void setVarSurveyCurrentMonth(Integer varSurveyCurrentMonth) {
        this.varSurveyCurrentMonth = varSurveyCurrentMonth;
    }

    public Integer getTemplateVarIsCompute() {
        return templateVarIsCompute;
    }

    public void setTemplateVarIsCompute(Integer templateVarIsCompute) {
        this.templateVarIsCompute = templateVarIsCompute;
    }

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
     * 获取第一个月
     *
     * @return VAR_MONTH_ONE - 第一个月
     */
    public Integer getVarMonthOne() {
        return varMonthOne;
    }

    /**
     * 设置第一个月
     *
     * @param varMonthOne 第一个月
     */
    public void setVarMonthOne(Integer varMonthOne) {
        this.varMonthOne = varMonthOne;
    }

    /**
     * 获取第二个月
     *
     * @return VAR_MONTH_TWO - 第二个月
     */
    public Integer getVarMonthTwo() {
        return varMonthTwo;
    }

    /**
     * 设置第二个月
     *
     * @param varMonthTwo 第二个月
     */
    public void setVarMonthTwo(Integer varMonthTwo) {
        this.varMonthTwo = varMonthTwo;
    }

    /**
     * 获取第三个月
     *
     * @return VAR_MONTH_THREE - 第三个月
     */
    public Integer getVarMonthThree() {
        return varMonthThree;
    }

    /**
     * 设置第三个月
     *
     * @param varMonthThree 第三个月
     */
    public void setVarMonthThree(Integer varMonthThree) {
        this.varMonthThree = varMonthThree;
    }

    /**
     * 获取第四个月
     *
     * @return VAR_MONTH_FOUR - 第四个月
     */
    public Long getVarMonthFour() {
        return varMonthFour;
    }

    /**
     * 设置第四个月
     *
     * @param varMonthFour 第四个月
     */
    public void setVarMonthFour(Long varMonthFour) {
        this.varMonthFour = varMonthFour;
    }

    /**
     * 获取第五个月
     *
     * @return VAR_MONTH_FIVE - 第五个月
     */
    public Long getVarMonthFive() {
        return varMonthFive;
    }

    /**
     * 设置第五个月
     *
     * @param varMonthFive 第五个月
     */
    public void setVarMonthFive(Long varMonthFive) {
        this.varMonthFive = varMonthFive;
    }

    /**
     * 获取第六个月
     *
     * @return VAR_MONTH_SIX - 第六个月
     */
    public Long getVarMonthSix() {
        return varMonthSix;
    }

    /**
     * 设置第六个月
     *
     * @param varMonthSix 第六个月
     */
    public void setVarMonthSix(Long varMonthSix) {
        this.varMonthSix = varMonthSix;
    }

    /**
     * 获取第七个月
     *
     * @return VAR_MONTH_SEVEN - 第七个月
     */
    public Integer getVarMonthSeven() {
        return varMonthSeven;
    }

    /**
     * 设置第七个月
     *
     * @param varMonthSeven 第七个月
     */
    public void setVarMonthSeven(Integer varMonthSeven) {
        this.varMonthSeven = varMonthSeven;
    }

    /**
     * 获取第八个月
     *
     * @return VAR_MONTH_EIGHT - 第八个月
     */
    public Integer getVarMonthEight() {
        return varMonthEight;
    }

    /**
     * 设置第八个月
     *
     * @param varMonthEight 第八个月
     */
    public void setVarMonthEight(Integer varMonthEight) {
        this.varMonthEight = varMonthEight;
    }

    /**
     * 获取第九个月
     *
     * @return VAR_MONTH_NINE - 第九个月
     */
    public Integer getVarMonthNine() {
        return varMonthNine;
    }

    /**
     * 设置第九个月
     *
     * @param varMonthNine 第九个月
     */
    public void setVarMonthNine(Integer varMonthNine) {
        this.varMonthNine = varMonthNine;
    }

    /**
     * 获取第十个月
     *
     * @return VAR_MONTH_TEN - 第十个月
     */
    public Integer getVarMonthTen() {
        return varMonthTen;
    }

    /**
     * 设置第十个月
     *
     * @param varMonthTen 第十个月
     */
    public void setVarMonthTen(Integer varMonthTen) {
        this.varMonthTen = varMonthTen;
    }

    /**
     * 获取第十一个月
     *
     * @return VAR_MONTH_ELEVEN - 第十一个月
     */
    public Integer getVarMonthEleven() {
        return varMonthEleven;
    }

    /**
     * 设置第十一个月
     *
     * @param varMonthEleven 第十一个月
     */
    public void setVarMonthEleven(Integer varMonthEleven) {
        this.varMonthEleven = varMonthEleven;
    }

    /**
     * 获取第十二个月
     *
     * @return VAR_MONTH_TWELVE - 第十二个月
     */
    public Integer getVarMonthTwelve() {
        return varMonthTwelve;
    }

    /**
     * 设置第十二个月
     *
     * @param varMonthTwelve 第十二个月
     */
    public void setVarMonthTwelve(Integer varMonthTwelve) {
        this.varMonthTwelve = varMonthTwelve;
    }

    /**
     * 获取总计
     *
     * @return VAR_CROSS_VALIDATE_ALL - 总计
     */
    public Integer getVarCrossValidateAll() {
        return varCrossValidateAll;
    }

    /**
     * 设置总计
     *
     * @param varCrossValidateAll 总计
     */
    public void setVarCrossValidateAll(Integer varCrossValidateAll) {
        this.varCrossValidateAll = varCrossValidateAll;
    }

    /**
     * 获取月平均
     *
     * @return VAR_CROSS_VALIDATE_MONTH_AVG - 月平均
     */
    public Integer getVarCrossValidateMonthAvg() {
        return varCrossValidateMonthAvg;
    }

    /**
     * 设置月平均
     *
     * @param varCrossValidateMonthAvg 月平均
     */
    public void setVarCrossValidateMonthAvg(Integer varCrossValidateMonthAvg) {
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