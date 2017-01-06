package com.cardpay.mgt.application.balancecross.model.vo;

/**
 * 资产负债表和交叉权益表Option
 *
 * @author yanwe
 *         createTime 2017-01-2017/1/6 14:10
 */
public class BalanceCrossOption {

    /**
     * 资产负债和交叉检验模板id
     */
    private Integer balanceCrossVarId;

    /**
     * 资产负债和交叉检验模板名称
     */
    private String balanceCrossVarName;

    /**
     * 资产负债和交叉检验模板父节点id
     */
    private Integer balanceCrossVarParentId;

    /**
     * 资产负债和交叉检验模板节点顺序
     */
    private Integer balanceCrossVarOrder;

    /**
     * 资产负债和交叉检验模板输入类型(0 input 输入框 1 select 单选 2 check 多选3 datapicker 时间 4 mutilSelect 多选 5 text 文字 6 range区间)
     */
    private Integer balanceCrossVarType;

    /**
     * 资产负债和交叉检验模板节点权重
     */
    private String balanceCrossVarWeight;

    /**
     * 资产负债和交叉检验模板节点值类型(0 int 1 float 2 money 3 string 4 bool)
     */
    private Integer balanceCrossVarValueType;

    /**
     * 资产负债和交叉检验模板组id
     */
    private Integer balanceCrossVargroupId;

    /**
     * 资产负债和交叉检验是否包含用户自定义子项(0 包含 1 包含)
     */
    private Integer balanceCrossVarisHasChild;

    /**
     * 资产负债和交叉检验是否是进件计算项(0 否 1 是)
     */
    private Integer balanceCrossVarisCompute;

    public Integer getBalanceCrossVarId() {
        return balanceCrossVarId;
    }

    public void setBalanceCrossVarId(Integer balanceCrossVarId) {
        this.balanceCrossVarId = balanceCrossVarId;
    }

    public String getBalanceCrossVarName() {
        return balanceCrossVarName;
    }

    public void setBalanceCrossVarName(String balanceCrossVarName) {
        this.balanceCrossVarName = balanceCrossVarName;
    }

    public Integer getBalanceCrossVarParentId() {
        return balanceCrossVarParentId;
    }

    public void setBalanceCrossVarParentId(Integer balanceCrossVarParentId) {
        this.balanceCrossVarParentId = balanceCrossVarParentId;
    }

    public Integer getBalanceCrossVarOrder() {
        return balanceCrossVarOrder;
    }

    public void setBalanceCrossVarOrder(Integer balanceCrossVarOrder) {
        this.balanceCrossVarOrder = balanceCrossVarOrder;
    }

    public Integer getBalanceCrossVarType() {
        return balanceCrossVarType;
    }

    public void setBalanceCrossVarType(Integer balanceCrossVarType) {
        this.balanceCrossVarType = balanceCrossVarType;
    }

    public String getBalanceCrossVarWeight() {
        return balanceCrossVarWeight;
    }

    public void setBalanceCrossVarWeight(String balanceCrossVarWeight) {
        this.balanceCrossVarWeight = balanceCrossVarWeight;
    }

    public Integer getBalanceCrossVarValueType() {
        return balanceCrossVarValueType;
    }

    public void setBalanceCrossVarValueType(Integer balanceCrossVarValueType) {
        this.balanceCrossVarValueType = balanceCrossVarValueType;
    }

    public Integer getBalanceCrossVargroupId() {
        return balanceCrossVargroupId;
    }

    public void setBalanceCrossVargroupId(Integer balanceCrossVargroupId) {
        this.balanceCrossVargroupId = balanceCrossVargroupId;
    }

    public Integer getBalanceCrossVarisHasChild() {
        return balanceCrossVarisHasChild;
    }

    public void setBalanceCrossVarisHasChild(Integer balanceCrossVarisHasChild) {
        this.balanceCrossVarisHasChild = balanceCrossVarisHasChild;
    }

    public Integer getBalanceCrossVarisCompute() {
        return balanceCrossVarisCompute;
    }

    public void setBalanceCrossVarisCompute(Integer balanceCrossVarisCompute) {
        this.balanceCrossVarisCompute = balanceCrossVarisCompute;
    }
}
