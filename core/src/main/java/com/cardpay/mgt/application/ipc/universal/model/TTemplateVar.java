package com.cardpay.mgt.application.ipc.universal.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Table(name = "T_TEMPLATE_VAR")
@ApiModel(value="进件模板值表")
public class TTemplateVar {
    /**
     * 进件模板值id
     */
    @Column(name = "TEMPLATE_VAR_ID")
    @ApiModelProperty(value="进件模板值id",required = true)
    private Integer templateVarId;

    /**
     * 进件模板值名称
     */
    @Column(name = "TEMPLATE_VAR_NAME")
    @ApiModelProperty(value="进件模板值名称",required = true)
    private String templateVarName;

    /**
     * 进件模板值父节点id
     */
    @Column(name = "TEMPLATE_VAR_PARENT_ID")
    @ApiModelProperty(value="进件模板值父节点id",required = true)
    private Integer templateVarParentId;

    /**
     * 进件模板值节点顺序
     */
    @Column(name = "TEMPLATE_VAR_ORDER")
    @ApiModelProperty(value="进件模板值节点顺序",required = true)
    private Integer templateVarOrder;

    /**
     * 进件模板值输入类型(0 input 输入框 1 select 单选 2 check 多选3 datapicker 时间 4 mutilSelect 多选 5 text 文字 6 range区间)
     */
    @Column(name = "TEMPLATE_VAR_INPUT_TYPE")
    @ApiModelProperty(value="进件模板值输入类型(0 input 输入框 1 select 单选 2 check 多选3 datapicker 时间 4 mutilSelect 多选 5 text 文字 6 range区间)",required = true)
    private Integer templateVarInputType;

    /**
     * 进件模板值节点权重
     */
    @Column(name = "TEMPLATE_VAR_WEIGHT")
    @ApiModelProperty(value="进件模板值节点权重",required = true)
    private String templateVarWeight;

    /**
     * 进件模板值组id
     */
    @Column(name = "TEMPLATE_VAR_GROUP_ID")
    @ApiModelProperty(value="进件模板值组id",required = true)
    private Integer templateVarGroupId;

    /**
     * 进件模板值是否包含用户自定义子项(0 包含 1 包含)
     */
    @Column(name = "TEMPLATE_VAR_IS_HAS_CHILD")
    @ApiModelProperty(value="进件模板值是否包含用户自定义子项(0 包含 1 包含)",required = true)
    private Integer templateVarIsHasChild;

    /**
     * 进件模板值是否是进件计算项(0 否 1 是)
     */
    @Column(name = "TEMPLATE_VAR_IS_COMPUTE")
    @ApiModelProperty(value="进件模板值是否是进件计算项(0 否 1 是)",required = true)
    private Integer templateVarIsCompute;

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