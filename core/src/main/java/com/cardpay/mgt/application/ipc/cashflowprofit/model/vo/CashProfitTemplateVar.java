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
    private String varMonthOne;

    /**
     * 第二个月
     */
    private String varMonthTwo;

    /**
     * 第三个月
     */
    private String varMonthThree;

    /**
     * 第四个月
     */
    private String varMonthFour;

    /**
     * 第五个月
     */
    private String varMonthFive;

    /**
     * 第六个月
     */
    private String varMonthSix;

    /**
     * 第七个月
     */
    private String varMonthSeven;

    /**
     * 第八个月
     */
    private String varMonthEight;

    /**
     * 第九个月
     */
    private String varMonthNine;

    /**
     * 第十个月
     */
    private String varMonthTen;

    /**
     * 第十一个月
     */
    private String varMonthEleven;

    /**
     * 第十二个月
     */
    private String varMonthTwelve;

    /**
     * 调查当月
     */
    private String varSurveyCurrentMonth;

    /**
     * 总计
     */
    private String varCrossValidateAll;

    /**
     * 月平均
     */
    private String varCrossValidateMonthAvg;

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

    public String getVarMonthOne() {
        return varMonthOne;
    }

    public void setVarMonthOne(String varMonthOne) {
        this.varMonthOne = varMonthOne;
    }

    public String getVarMonthTwo() {
        return varMonthTwo;
    }

    public void setVarMonthTwo(String varMonthTwo) {
        this.varMonthTwo = varMonthTwo;
    }

    public String getVarMonthThree() {
        return varMonthThree;
    }

    public void setVarMonthThree(String varMonthThree) {
        this.varMonthThree = varMonthThree;
    }

    public String getVarMonthFour() {
        return varMonthFour;
    }

    public void setVarMonthFour(String varMonthFour) {
        this.varMonthFour = varMonthFour;
    }

    public String getVarMonthFive() {
        return varMonthFive;
    }

    public void setVarMonthFive(String varMonthFive) {
        this.varMonthFive = varMonthFive;
    }

    public String getVarMonthSix() {
        return varMonthSix;
    }

    public void setVarMonthSix(String varMonthSix) {
        this.varMonthSix = varMonthSix;
    }

    public String getVarMonthSeven() {
        return varMonthSeven;
    }

    public void setVarMonthSeven(String varMonthSeven) {
        this.varMonthSeven = varMonthSeven;
    }

    public String getVarMonthEight() {
        return varMonthEight;
    }

    public void setVarMonthEight(String varMonthEight) {
        this.varMonthEight = varMonthEight;
    }

    public String getVarMonthNine() {
        return varMonthNine;
    }

    public void setVarMonthNine(String varMonthNine) {
        this.varMonthNine = varMonthNine;
    }

    public String getVarMonthTen() {
        return varMonthTen;
    }

    public void setVarMonthTen(String varMonthTen) {
        this.varMonthTen = varMonthTen;
    }

    public String getVarMonthEleven() {
        return varMonthEleven;
    }

    public void setVarMonthEleven(String varMonthEleven) {
        this.varMonthEleven = varMonthEleven;
    }

    public String getVarMonthTwelve() {
        return varMonthTwelve;
    }

    public void setVarMonthTwelve(String varMonthTwelve) {
        this.varMonthTwelve = varMonthTwelve;
    }

    public String getVarSurveyCurrentMonth() {
        return varSurveyCurrentMonth;
    }

    public void setVarSurveyCurrentMonth(String varSurveyCurrentMonth) {
        this.varSurveyCurrentMonth = varSurveyCurrentMonth;
    }

    public String getVarCrossValidateAll() {
        return varCrossValidateAll;
    }

    public void setVarCrossValidateAll(String varCrossValidateAll) {
        this.varCrossValidateAll = varCrossValidateAll;
    }

    public String getVarCrossValidateMonthAvg() {
        return varCrossValidateMonthAvg;
    }

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