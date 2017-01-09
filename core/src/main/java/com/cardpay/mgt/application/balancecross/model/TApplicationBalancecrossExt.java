package com.cardpay.mgt.application.balancecross.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "T_APPLICATION_BALANCECROSS_EXT")
@ApiModel(value="进件模板资产负债和交叉检验额外表")
public class TApplicationBalancecrossExt {
    /**
     * 进件模板资产负债和交叉检验额外值id
     */
    @Column(name = "BALANCE_CROSS_VAR_EXTRA_ID")
    @ApiModelProperty(value="进件模板资产负债和交叉检验额外值id",required = true)
    private BigDecimal balanceCrossVarExtraId;

    /**
     * 进件资产负债和交叉检验值id
     */
    @Column(name = "BALANCE_CROSS_VAR_ID")
    @ApiModelProperty(value="进件资产负债和交叉检验值id",required = true)
    private Integer balanceCrossVarId;

    /**
     * 进件模板资产负债和交叉检验额外字段值name
     */
    @Column(name = "BALANCE_CROSS_EXTRA_NAME")
    @ApiModelProperty(value="进件模板资产负债和交叉检验额外字段值name",required = true)
    private String balanceCrossExtraName;

    /**
     * 进件模板资产负债和交叉检验额外值字段value
     */
    @Column(name = "BALANCE_CROSS_EXTRA_VALUE")
    @ApiModelProperty(value="进件模板资产负债和交叉检验额外值字段value",required = true)
    private String balanceCrossExtraValue;

    /**
     * 进件id
     */
    @Column(name = "APPLICATION_ID")
    @ApiModelProperty(value="进件id",required = true)
    private Integer applicationId;

    /**
     * 获取进件模板资产负债和交叉检验额外值id
     *
     * @return BALANCE_CROSS_VAR_EXTRA_ID - 进件模板资产负债和交叉检验额外值id
     */
    public BigDecimal getBalanceCrossVarExtraId() {
        return balanceCrossVarExtraId;
    }

    /**
     * 设置进件模板资产负债和交叉检验额外值id
     *
     * @param balanceCrossVarExtraId 进件模板资产负债和交叉检验额外值id
     */
    public void setBalanceCrossVarExtraId(BigDecimal balanceCrossVarExtraId) {
        this.balanceCrossVarExtraId = balanceCrossVarExtraId;
    }

    /**
     * 获取进件资产负债和交叉检验值id
     *
     * @return BALANCE_CROSS_VAR_ID - 进件资产负债和交叉检验值id
     */
    public Integer getBalanceCrossVarId() {
        return balanceCrossVarId;
    }

    /**
     * 设置进件资产负债和交叉检验值id
     *
     * @param balanceCrossVarId 进件资产负债和交叉检验值id
     */
    public void setBalanceCrossVarId(Integer balanceCrossVarId) {
        this.balanceCrossVarId = balanceCrossVarId;
    }

    /**
     * 获取进件模板资产负债和交叉检验额外字段值name
     *
     * @return BALANCE_CROSS_EXTRA_NAME - 进件模板资产负债和交叉检验额外字段值name
     */
    public String getBalanceCrossExtraName() {
        return balanceCrossExtraName;
    }

    /**
     * 设置进件模板资产负债和交叉检验额外字段值name
     *
     * @param balanceCrossExtraName 进件模板资产负债和交叉检验额外字段值name
     */
    public void setBalanceCrossExtraName(String balanceCrossExtraName) {
        this.balanceCrossExtraName = balanceCrossExtraName;
    }

    /**
     * 获取进件模板资产负债和交叉检验额外值字段value
     *
     * @return BALANCE_CROSS_EXTRA_VALUE - 进件模板资产负债和交叉检验额外值字段value
     */
    public String getBalanceCrossExtraValue() {
        return balanceCrossExtraValue;
    }

    /**
     * 设置进件模板资产负债和交叉检验额外值字段value
     *
     * @param balanceCrossExtraValue 进件模板资产负债和交叉检验额外值字段value
     */
    public void setBalanceCrossExtraValue(String balanceCrossExtraValue) {
        this.balanceCrossExtraValue = balanceCrossExtraValue;
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