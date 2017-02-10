package com.cardpay.mgt.application.ipc.normal.model.vo;


import com.cardpay.mgt.application.ipc.normal.model.TApplicationTemplateVarExt;
import com.cardpay.mgt.application.ipc.normal.model.TTemplateVarOption;

import java.util.List;

public class TemplateVar {

    /**
     * 进件Id
     */
    private Integer applicationId;

    /**
     * 选项id
     */
    private Integer optionId;

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
     * 值
     */
    private String templateVarValue;

    /**
     * application_var Id
     */
    private Integer applicationTemplateVarId;

    /**
     * children
     */
    private List<TemplateVar> vars;

    /**
     * options
     */
    private List<TTemplateVarOption> options;

    /**
     * extras
     */
    private List<TApplicationTemplateVarExt> extras;

    public Integer getApplicationTemplateVarId() {
        return applicationTemplateVarId;
    }

    public void setApplicationTemplateVarId(Integer applicationTemplateVarId) {
        this.applicationTemplateVarId = applicationTemplateVarId;
    }

    public String getTemplateVarValue() {
        return templateVarValue;
    }

    public void setTemplateVarValue(String templateVarValue) {
        this.templateVarValue = templateVarValue;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getOptionId() {
        return optionId;
    }

    public void setOptionId(Integer optionId) {
        this.optionId = optionId;
    }

    public List<TemplateVar> getVars() {
        return vars;
    }

    public void setVars(List<TemplateVar> vars) {
        this.vars = vars;
    }

    public List<TTemplateVarOption> getOptions() {
        return options;
    }

    public void setOptions(List<TTemplateVarOption> options) {
        this.options = options;
    }

    public List<TApplicationTemplateVarExt> getExtras() {
        return extras;
    }

    public void setExtras(List<TApplicationTemplateVarExt> extras) {
        this.extras = extras;
    }

    /**
     * 获取进件模板值id
     *
     * @return TEMPLATE_VAR_ID - 进件模板值id
     */
    public Integer getTemplateVarId() {
        return templateVarId;
    }

    /**
     * 设置进件模板值id
     *
     * @param templateVarId 进件模板值id
     */
    public void setTemplateVarId(Integer templateVarId) {
        this.templateVarId = templateVarId;
    }

    /**
     * 获取进件模板值名称
     *
     * @return TEMPLATE_VAR_NAME - 进件模板值名称
     */
    public String getTemplateVarName() {
        return templateVarName;
    }

    /**
     * 设置进件模板值名称
     *
     * @param templateVarName 进件模板值名称
     */
    public void setTemplateVarName(String templateVarName) {
        this.templateVarName = templateVarName;
    }

    /**
     * 获取进件模板值父节点id
     *
     * @return TEMPLATE_VAR_PARENT_ID - 进件模板值父节点id
     */
    public Integer getTemplateVarParentId() {
        return templateVarParentId;
    }

    /**
     * 设置进件模板值父节点id
     *
     * @param templateVarParentId 进件模板值父节点id
     */
    public void setTemplateVarParentId(Integer templateVarParentId) {
        this.templateVarParentId = templateVarParentId;
    }

    /**
     * 获取进件模板值节点顺序
     *
     * @return TEMPLATE_VAR_ORDER - 进件模板值节点顺序
     */
    public Integer getTemplateVarOrder() {
        return templateVarOrder;
    }

    /**
     * 设置进件模板值节点顺序
     *
     * @param templateVarOrder 进件模板值节点顺序
     */
    public void setTemplateVarOrder(Integer templateVarOrder) {
        this.templateVarOrder = templateVarOrder;
    }

    /**
     * 获取进件模板值输入类型(0 input 输入框 1 select 单选 2 check 多选3 datapicker 时间 4 mutilSelect 多选 5 text 文字 6 range区间)
     *
     * @return TEMPLATE_VAR_INPUT_TYPE - 进件模板值输入类型(0 input 输入框 1 select 单选 2 check 多选3 datapicker 时间 4 mutilSelect 多选 5 text 文字 6 range区间)
     */
    public Integer getTemplateVarInputType() {
        return templateVarInputType;
    }

    /**
     * 设置进件模板值输入类型(0 input 输入框 1 select 单选 2 check 多选3 datapicker 时间 4 mutilSelect 多选 5 text 文字 6 range区间)
     *
     * @param templateVarInputType 进件模板值输入类型(0 input 输入框 1 select 单选 2 check 多选3 datapicker 时间 4 mutilSelect 多选 5 text 文字 6 range区间)
     */
    public void setTemplateVarInputType(Integer templateVarInputType) {
        this.templateVarInputType = templateVarInputType;
    }

    /**
     * 获取进件模板值节点权重
     *
     * @return TEMPLATE_VAR_WEIGHT - 进件模板值节点权重
     */
    public String getTemplateVarWeight() {
        return templateVarWeight;
    }

    /**
     * 设置进件模板值节点权重
     *
     * @param templateVarWeight 进件模板值节点权重
     */
    public void setTemplateVarWeight(String templateVarWeight) {
        this.templateVarWeight = templateVarWeight;
    }

    /**
     * 获取进件模板值组id
     *
     * @return TEMPLATE_VAR_GROUP_ID - 进件模板值组id
     */
    public Integer getTemplateVarGroupId() {
        return templateVarGroupId;
    }

    /**
     * 设置进件模板值组id
     *
     * @param templateVarGroupId 进件模板值组id
     */
    public void setTemplateVarGroupId(Integer templateVarGroupId) {
        this.templateVarGroupId = templateVarGroupId;
    }

    /**
     * 获取进件模板值是否包含用户自定义子项(0 包含 1 包含)
     *
     * @return TEMPLATE_VAR_IS_HAS_CHILD - 进件模板值是否包含用户自定义子项(0 包含 1 包含)
     */
    public Integer getTemplateVarIsHasChild() {
        return templateVarIsHasChild;
    }

    /**
     * 设置进件模板值是否包含用户自定义子项(0 包含 1 包含)
     *
     * @param templateVarIsHasChild 进件模板值是否包含用户自定义子项(0 包含 1 包含)
     */
    public void setTemplateVarIsHasChild(Integer templateVarIsHasChild) {
        this.templateVarIsHasChild = templateVarIsHasChild;
    }

    /**
     * 获取进件模板值是否是进件计算项(0 否 1 是)
     *
     * @return TEMPLATE_VAR_IS_COMPUTE - 进件模板值是否是进件计算项(0 否 1 是)
     */
    public Integer getTemplateVarIsCompute() {
        return templateVarIsCompute;
    }

    /**
     * 设置进件模板值是否是进件计算项(0 否 1 是)
     *
     * @param templateVarIsCompute 进件模板值是否是进件计算项(0 否 1 是)
     */
    public void setTemplateVarIsCompute(Integer templateVarIsCompute) {
        this.templateVarIsCompute = templateVarIsCompute;
    }
}