package com.cardpay.mgt.application.balancecross.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Table(name = "T_BANLANCE_CROSS_VAR")
@ApiModel(value="进件资产负债和交叉检验模板表")
public class TBanlanceCrossVar {
    /**
     * 资产负债和交叉检验模板id
     */
    @Id
    @Column(name = "BALANCE_CROSS_VAR_ID")
    @ApiModelProperty(value="资产负债和交叉检验模板id",required = true)
    private Integer balanceCrossVarId;

    /**
     * 资产负债和交叉检验模板名称
     */
    @Column(name = "BALANCE_CROSS_VAR_NAME")
    @ApiModelProperty(value="资产负债和交叉检验模板名称",required = true)
    private String balanceCrossVarName;

    /**
     * 资产负债和交叉检验模板父节点id
     */
    @Column(name = "BALANCE_CROSS_VAR_PARENT_ID")
    @ApiModelProperty(value="资产负债和交叉检验模板父节点id",required = true)
    private Integer balanceCrossVarParentId;

    /**
     * 资产负债和交叉检验模板节点顺序
     */
    @Column(name = "BALANCE_CROSS_VAR_ORDER")
    @ApiModelProperty(value="资产负债和交叉检验模板节点顺序",required = true)
    private Integer balanceCrossVarOrder;

    /**
     * 资产负债和交叉检验模板输入类型(0 input 输入框 1 select 单选 2 check 多选3 datapicker 时间 4 mutilSelect 多选 5 text 文字 6 range区间)
     */
    @Column(name = "BALANCE_CROSS_VAR_TYPE")
    @ApiModelProperty(value="资产负债和交叉检验模板输入类型(0 input 输入框 1 select 单选 2 check 多选3 datapicker 时间 4 mutilSelect 多选 5 text 文字 6 range区间)",required = true)
    private Integer balanceCrossVarType;

    /**
     * 资产负债和交叉检验模板节点权重
     */
    @Column(name = "BALANCE_CROSS_VAR_WEIGHT")
    @ApiModelProperty(value="资产负债和交叉检验模板节点权重",required = true)
    private String balanceCrossVarWeight;

    /**
     * 资产负债和交叉检验模板节点值类型(0 int 1 float 2 money 3 string 4 bool)
     */
    @Column(name = "BALANCE_CROSS_VAR_VALUE_TYPE")
    @ApiModelProperty(value="资产负债和交叉检验模板节点值类型(0 int 1 float 2 money 3 string 4 bool)",required = true)
    private Integer balanceCrossVarValueType;

    /**
     * 资产负债和交叉检验模板组id
     */
    @Column(name = "BALANCE_CROSS_VARGROUP_ID")
    @ApiModelProperty(value="资产负债和交叉检验模板组id",required = true)
    private Integer balanceCrossVargroupId;

    /**
     * 资产负债和交叉检验是否包含用户自定义子项(0 包含 1 包含)
     */
    @Column(name = "BALANCE_CROSS_VARIS_HAS_CHILD")
    @ApiModelProperty(value="资产负债和交叉检验是否包含用户自定义子项(0 包含 1 包含)",required = true)
    private Integer balanceCrossVarisHasChild;

    /**
     * 资产负债和交叉检验是否是进件计算项(0 否 1 是)
     */
    @Column(name = "BALANCE_CROSS_VARIS_COMPUTE")
    @ApiModelProperty(value="资产负债和交叉检验是否是进件计算项(0 否 1 是)",required = true)
    private Integer balanceCrossVarisCompute;

    /**
     * 获取资产负债和交叉检验模板id
     *
     * @return BALANCE_CROSS_VAR_ID - 资产负债和交叉检验模板id
     */
    public Integer getBalanceCrossVarId() {
        return balanceCrossVarId;
    }

    /**
     * 设置资产负债和交叉检验模板id
     *
     * @param balanceCrossVarId 资产负债和交叉检验模板id
     */
    public void setBalanceCrossVarId(Integer balanceCrossVarId) {
        this.balanceCrossVarId = balanceCrossVarId;
    }

    /**
     * 获取资产负债和交叉检验模板名称
     *
     * @return BALANCE_CROSS_VAR_NAME - 资产负债和交叉检验模板名称
     */
    public String getBalanceCrossVarName() {
        return balanceCrossVarName;
    }

    /**
     * 设置资产负债和交叉检验模板名称
     *
     * @param balanceCrossVarName 资产负债和交叉检验模板名称
     */
    public void setBalanceCrossVarName(String balanceCrossVarName) {
        this.balanceCrossVarName = balanceCrossVarName;
    }

    /**
     * 获取资产负债和交叉检验模板父节点id
     *
     * @return BALANCE_CROSS_VAR_PARENT_ID - 资产负债和交叉检验模板父节点id
     */
    public Integer getBalanceCrossVarParentId() {
        return balanceCrossVarParentId;
    }

    /**
     * 设置资产负债和交叉检验模板父节点id
     *
     * @param balanceCrossVarParentId 资产负债和交叉检验模板父节点id
     */
    public void setBalanceCrossVarParentId(Integer balanceCrossVarParentId) {
        this.balanceCrossVarParentId = balanceCrossVarParentId;
    }

    /**
     * 获取资产负债和交叉检验模板节点顺序
     *
     * @return BALANCE_CROSS_VAR_ORDER - 资产负债和交叉检验模板节点顺序
     */
    public Integer getBalanceCrossVarOrder() {
        return balanceCrossVarOrder;
    }

    /**
     * 设置资产负债和交叉检验模板节点顺序
     *
     * @param balanceCrossVarOrder 资产负债和交叉检验模板节点顺序
     */
    public void setBalanceCrossVarOrder(Integer balanceCrossVarOrder) {
        this.balanceCrossVarOrder = balanceCrossVarOrder;
    }

    /**
     * 获取资产负债和交叉检验模板输入类型(0 input 输入框 1 select 单选 2 check 多选3 datapicker 时间 4 mutilSelect 多选 5 text 文字 6 range区间)
     *
     * @return BALANCE_CROSS_VAR_TYPE - 资产负债和交叉检验模板输入类型(0 input 输入框 1 select 单选 2 check 多选3 datapicker 时间 4 mutilSelect 多选 5 text 文字 6 range区间)
     */
    public Integer getBalanceCrossVarType() {
        return balanceCrossVarType;
    }

    /**
     * 设置资产负债和交叉检验模板输入类型(0 input 输入框 1 select 单选 2 check 多选3 datapicker 时间 4 mutilSelect 多选 5 text 文字 6 range区间)
     *
     * @param balanceCrossVarType 资产负债和交叉检验模板输入类型(0 input 输入框 1 select 单选 2 check 多选3 datapicker 时间 4 mutilSelect 多选 5 text 文字 6 range区间)
     */
    public void setBalanceCrossVarType(Integer balanceCrossVarType) {
        this.balanceCrossVarType = balanceCrossVarType;
    }

    /**
     * 获取资产负债和交叉检验模板节点权重
     *
     * @return BALANCE_CROSS_VAR_WEIGHT - 资产负债和交叉检验模板节点权重
     */
    public String getBalanceCrossVarWeight() {
        return balanceCrossVarWeight;
    }

    /**
     * 设置资产负债和交叉检验模板节点权重
     *
     * @param balanceCrossVarWeight 资产负债和交叉检验模板节点权重
     */
    public void setBalanceCrossVarWeight(String balanceCrossVarWeight) {
        this.balanceCrossVarWeight = balanceCrossVarWeight;
    }

    /**
     * 获取资产负债和交叉检验模板节点值类型(0 int 1 float 2 money 3 string 4 bool)
     *
     * @return BALANCE_CROSS_VAR_VALUE_TYPE - 资产负债和交叉检验模板节点值类型(0 int 1 float 2 money 3 string 4 bool)
     */
    public Integer getBalanceCrossVarValueType() {
        return balanceCrossVarValueType;
    }

    /**
     * 设置资产负债和交叉检验模板节点值类型(0 int 1 float 2 money 3 string 4 bool)
     *
     * @param balanceCrossVarValueType 资产负债和交叉检验模板节点值类型(0 int 1 float 2 money 3 string 4 bool)
     */
    public void setBalanceCrossVarValueType(Integer balanceCrossVarValueType) {
        this.balanceCrossVarValueType = balanceCrossVarValueType;
    }

    /**
     * 获取资产负债和交叉检验模板组id
     *
     * @return BALANCE_CROSS_VARGROUP_ID - 资产负债和交叉检验模板组id
     */
    public Integer getBalanceCrossVargroupId() {
        return balanceCrossVargroupId;
    }

    /**
     * 设置资产负债和交叉检验模板组id
     *
     * @param balanceCrossVargroupId 资产负债和交叉检验模板组id
     */
    public void setBalanceCrossVargroupId(Integer balanceCrossVargroupId) {
        this.balanceCrossVargroupId = balanceCrossVargroupId;
    }

    /**
     * 获取资产负债和交叉检验是否包含用户自定义子项(0 包含 1 包含)
     *
     * @return BALANCE_CROSS_VARIS_HAS_CHILD - 资产负债和交叉检验是否包含用户自定义子项(0 包含 1 包含)
     */
    public Integer getBalanceCrossVarisHasChild() {
        return balanceCrossVarisHasChild;
    }

    /**
     * 设置资产负债和交叉检验是否包含用户自定义子项(0 包含 1 包含)
     *
     * @param balanceCrossVarisHasChild 资产负债和交叉检验是否包含用户自定义子项(0 包含 1 包含)
     */
    public void setBalanceCrossVarisHasChild(Integer balanceCrossVarisHasChild) {
        this.balanceCrossVarisHasChild = balanceCrossVarisHasChild;
    }

    /**
     * 获取资产负债和交叉检验是否是进件计算项(0 否 1 是)
     *
     * @return BALANCE_CROSS_VARIS_COMPUTE - 资产负债和交叉检验是否是进件计算项(0 否 1 是)
     */
    public Integer getBalanceCrossVarisCompute() {
        return balanceCrossVarisCompute;
    }

    /**
     * 设置资产负债和交叉检验是否是进件计算项(0 否 1 是)
     *
     * @param balanceCrossVarisCompute 资产负债和交叉检验是否是进件计算项(0 否 1 是)
     */
    public void setBalanceCrossVarisCompute(Integer balanceCrossVarisCompute) {
        this.balanceCrossVarisCompute = balanceCrossVarisCompute;
    }
}