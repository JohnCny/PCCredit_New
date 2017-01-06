package com.cardpay.mgt.application.balancecross.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "T_APPLICATION_BALANCECROSS_VAR")
@ApiModel(value="进件模板资产负债值表")
public class TApplicationBalancecrossVar {
    /**
     * 进件资产负债和交叉检验模板值id
     */
    @Id
    @Column(name = "APPLICATION_BALACECROSS_VAR_ID")
    @ApiModelProperty(value="进件资产负债和交叉检验模板值id",required = true)
    private BigDecimal applicationBalacecrossVarId;

    /**
     * 进件资产负债和交叉检验模板id
     */
    @Column(name = "BALANCE_CROSS_VAR_ID")
    @ApiModelProperty(value="进件资产负债和交叉检验模板id",required = true)
    private Integer balanceCrossVarId;

    /**
     * 进件资产负债和交叉检验模板值value
     */
    @Column(name = "BALANCE_CROSS_VAR_VALUE")
    @ApiModelProperty(value="进件资产负债和交叉检验模板值value",required = true)
    private String balanceCrossVarValue;

    /**
     * 进件资产负债和交叉检验选项值id
     */
    @Column(name = "BALANCE_CROSS_OPTION_ID")
    @ApiModelProperty(value="进件资产负债和交叉检验选项值id",required = true)
    private Integer balanceCrossOptionId;

    /**
     * 进件id
     */
    @Column(name = "APPLICATION_ID")
    @ApiModelProperty(value="进件id",required = true)
    private Integer applicationId;

    /**
     * 获取进件资产负债和交叉检验模板值id
     *
     * @return APPLICATION_BALACECROSS_VAR_ID - 进件资产负债和交叉检验模板值id
     */
    public BigDecimal getApplicationBalacecrossVarId() {
        return applicationBalacecrossVarId;
    }

    /**
     * 设置进件资产负债和交叉检验模板值id
     *
     * @param applicationBalacecrossVarId 进件资产负债和交叉检验模板值id
     */
    public void setApplicationBalacecrossVarId(BigDecimal applicationBalacecrossVarId) {
        this.applicationBalacecrossVarId = applicationBalacecrossVarId;
    }

    /**
     * 获取进件资产负债和交叉检验模板id
     *
     * @return BALANCE_CORSS_VAR_ID - 进件资产负债和交叉检验模板id
     */
    public Integer getBalanceCrossVarId() {
        return balanceCrossVarId;
    }

    /**
     * 设置进件资产负债和交叉检验模板id
     *
     * @param balanceCrossVarId 进件资产负债和交叉检验模板id
     */
    public void setBalanceCrossVarId(Integer balanceCrossVarId) {
        this.balanceCrossVarId = balanceCrossVarId;
    }

    /**
     * 获取进件资产负债和交叉检验模板值value
     *
     * @return BALANCE_CROSS_VAR_VALUE - 进件资产负债和交叉检验模板值value
     */
    public String getBalanceCrossVarValue() {
        return balanceCrossVarValue;
    }

    /**
     * 设置进件资产负债和交叉检验模板值value
     *
     * @param balanceCrossVarValue 进件资产负债和交叉检验模板值value
     */
    public void setBalanceCrossVarValue(String balanceCrossVarValue) {
        this.balanceCrossVarValue = balanceCrossVarValue;
    }

    /**
     * 获取进件资产负债和交叉检验选项值id
     *
     * @return BALANCE_CROSS_OPTION_ID - 进件资产负债和交叉检验选项值id
     */
    public Integer getBalanceCrossOptionId() {
        return balanceCrossOptionId;
    }

    /**
     * 设置进件资产负债和交叉检验选项值id
     *
     * @param balanceCrossOptionId 进件资产负债和交叉检验选项值id
     */
    public void setBalanceCrossOptionId(Integer balanceCrossOptionId) {
        this.balanceCrossOptionId = balanceCrossOptionId;
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