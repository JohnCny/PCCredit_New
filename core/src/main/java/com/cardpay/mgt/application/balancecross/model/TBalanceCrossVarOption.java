package com.cardpay.mgt.application.balancecross.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Table(name = "T_BALANCE_CROSS_VAR_OPTION")
@ApiModel(value="null")
public class TBalanceCrossVarOption {
    /**
     * 建议和基本状况选项id
     */
    @Id
    @Column(name = "BALANCE_CROSS_OPTION_ID")
    @ApiModelProperty(value="建议和基本状况选项id",required = true)
    private Integer balanceCrossOptionId;

    /**
     * 建议和基本状况选项所属值id
     */
    @Column(name = "BALANCE_CROSS_VAR_ID")
    @ApiModelProperty(value="建议和基本状况选项所属值id",required = true)
    private Integer balanceCrossVarId;

    /**
     * 建议和基本状况选项名称
     */
    @Column(name = "BALANCE_CROSS_OPTION_NAME")
    @ApiModelProperty(value="建议和基本状况选项名称",required = true)
    private String balanceCrossOptionName;

    /**
     * 建议和基本状况选项value
     */
    @Column(name = "BALANCE_CROSS_OPTION_VALUE")
    @ApiModelProperty(value="建议和基本状况选项value",required = true)
    private String balanceCrossOptionValue;

    /**
     * 建议和基本状况选项value类型
     */
    @Column(name = "BALANCE_CROSS_VALUE_TYPE")
    @ApiModelProperty(value="建议和基本状况选项value类型",required = true)
    private Integer balanceCrossValueType;

    /**
     * 建议和基本状况选项描述
     */
    @Column(name = "BALANCE_CROSS_OPTION_DESC")
    @ApiModelProperty(value="建议和基本状况选项描述",required = true)
    private String balanceCrossOptionDesc;

    /**
     * 获取建议和基本状况选项id
     *
     * @return BALANCE_CROSS_OPTION_ID - 建议和基本状况选项id
     */
    public Integer getBalanceCrossOptionId() {
        return balanceCrossOptionId;
    }

    /**
     * 设置建议和基本状况选项id
     *
     * @param balanceCrossOptionId 建议和基本状况选项id
     */
    public void setBalanceCrossOptionId(Integer balanceCrossOptionId) {
        this.balanceCrossOptionId = balanceCrossOptionId;
    }

    /**
     * 获取建议和基本状况选项所属值id
     *
     * @return BALANCE_CROSS_VAR_ID - 建议和基本状况选项所属值id
     */
    public Integer getBalanceCrossVarId() {
        return balanceCrossVarId;
    }

    /**
     * 设置建议和基本状况选项所属值id
     *
     * @param balanceCrossVarId 建议和基本状况选项所属值id
     */
    public void setBalanceCrossVarId(Integer balanceCrossVarId) {
        this.balanceCrossVarId = balanceCrossVarId;
    }

    /**
     * 获取建议和基本状况选项名称
     *
     * @return BALANCE_CROSS_OPTION_NAME - 建议和基本状况选项名称
     */
    public String getBalanceCrossOptionName() {
        return balanceCrossOptionName;
    }

    /**
     * 设置建议和基本状况选项名称
     *
     * @param balanceCrossOptionName 建议和基本状况选项名称
     */
    public void setBalanceCrossOptionName(String balanceCrossOptionName) {
        this.balanceCrossOptionName = balanceCrossOptionName;
    }

    /**
     * 获取建议和基本状况选项value
     *
     * @return BALANCE_CROSS_OPTION_VALUE - 建议和基本状况选项value
     */
    public String getBalanceCrossOptionValue() {
        return balanceCrossOptionValue;
    }

    /**
     * 设置建议和基本状况选项value
     *
     * @param balanceCrossOptionValue 建议和基本状况选项value
     */
    public void setBalanceCrossOptionValue(String balanceCrossOptionValue) {
        this.balanceCrossOptionValue = balanceCrossOptionValue;
    }

    /**
     * 获取建议和基本状况选项value类型
     *
     * @return BALANCE_CROSS_VALUE_TYPE - 建议和基本状况选项value类型
     */
    public Integer getBalanceCrossValueType() {
        return balanceCrossValueType;
    }

    /**
     * 设置建议和基本状况选项value类型
     *
     * @param balanceCrossValueType 建议和基本状况选项value类型
     */
    public void setBalanceCrossValueType(Integer balanceCrossValueType) {
        this.balanceCrossValueType = balanceCrossValueType;
    }

    /**
     * 获取建议和基本状况选项描述
     *
     * @return BALANCE_CROSS_OPTION_DESC - 建议和基本状况选项描述
     */
    public String getBalanceCrossOptionDesc() {
        return balanceCrossOptionDesc;
    }

    /**
     * 设置建议和基本状况选项描述
     *
     * @param balanceCrossOptionDesc 建议和基本状况选项描述
     */
    public void setBalanceCrossOptionDesc(String balanceCrossOptionDesc) {
        this.balanceCrossOptionDesc = balanceCrossOptionDesc;
    }
}