package com.cardpay.mgt.application.balancecross.model.vo;

import java.math.BigDecimal;

/**
 * 资产负债表和交叉权益表Option
 *
 * @author yanwe
 *         createTime 2017-01-2017/1/6 14:10
 */
public class BalanceCrossExtra {
    /**
     * 进件模板资产负债和交叉检验额外值id
     */
    private BigDecimal balanceCrossVarExtraId;

    /**
     * 进件资产负债和交叉检验值id
     */
    private Integer balanceCrossVarId;

    /**
     * 进件模板资产负债和交叉检验额外字段值name
     */
    private String balanceCrossExtraName;

    /**
     * 进件模板资产负债和交叉检验额外值字段value
     */
    private String balanceCrossExtraValue;

    /**
     * 进件id
     */
    private Integer applicationId;

    public BigDecimal getBalanceCrossVarExtraId() {
        return balanceCrossVarExtraId;
    }

    public void setBalanceCrossVarExtraId(BigDecimal balanceCrossVarExtraId) {
        this.balanceCrossVarExtraId = balanceCrossVarExtraId;
    }

    public Integer getBalanceCrossVarId() {
        return balanceCrossVarId;
    }

    public void setBalanceCrossVarId(Integer balanceCrossVarId) {
        this.balanceCrossVarId = balanceCrossVarId;
    }

    public String getBalanceCrossExtraName() {
        return balanceCrossExtraName;
    }

    public void setBalanceCrossExtraName(String balanceCrossExtraName) {
        this.balanceCrossExtraName = balanceCrossExtraName;
    }

    public String getBalanceCrossExtraValue() {
        return balanceCrossExtraValue;
    }

    public void setBalanceCrossExtraValue(String balanceCrossExtraValue) {
        this.balanceCrossExtraValue = balanceCrossExtraValue;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }
}
