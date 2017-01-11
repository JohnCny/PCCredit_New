package com.cardpay.mgt.application.ipc.normal.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Table(name = "T_TEMPLATE_VAR_OPTION")
@ApiModel(value="null")
public class TTemplateVarOption {
    /**
     * 进件模板选项id
     */
    @Id
    @Column(name = "TEMPLATE_VAR_OPTION_ID")
    @ApiModelProperty(value="进件模板选项id",required = true)
    private Integer templateVarOptionId;

    /**
     * 进件模板选项所属值id
     */
    @Column(name = "TEMPLATE_VAR_ID")
    @ApiModelProperty(value="进件模板选项所属值id",required = true)
    private Integer templateVarId;

    /**
     * 进件模板选项名称
     */
    @Column(name = "TEMPLATE_VAR_OPTION_NAME")
    @ApiModelProperty(value="进件模板选项名称",required = true)
    private String templateVarOptionName;

    /**
     * 进件模板选项value
     */
    @Column(name = "TEMPLATE_VAR_OPTION_VALUE")
    @ApiModelProperty(value="进件模板选项value",required = true)
    private String templateVarOptionValue;

    /**
     * 进件模板选项value类型
     */
    @Column(name = "TEMPLATE_VAR_VALUE_TYPE")
    @ApiModelProperty(value="进件模板选项value类型",required = true)
    private Integer templateVarValueType;

    /**
     * 进件模板选项描述
     */
    @Column(name = "TEMPLATE_VAR_OPTION_DESC")
    @ApiModelProperty(value="进件模板选项描述",required = true)
    private String templateVarOptionDesc;

    /**
     * 获取进件模板选项id
     *
     * @return TEMPLATE_VAR_OPTION_ID - 进件模板选项id
     */
    public Integer getTemplateVarOptionId() {
        return templateVarOptionId;
    }

    /**
     * 设置进件模板选项id
     *
     * @param templateVarOptionId 进件模板选项id
     */
    public void setTemplateVarOptionId(Integer templateVarOptionId) {
        this.templateVarOptionId = templateVarOptionId;
    }

    /**
     * 获取进件模板选项所属值id
     *
     * @return TEMPLATE_VAR_ID - 进件模板选项所属值id
     */
    public Integer getTemplateVarId() {
        return templateVarId;
    }

    /**
     * 设置进件模板选项所属值id
     *
     * @param templateVarId 进件模板选项所属值id
     */
    public void setTemplateVarId(Integer templateVarId) {
        this.templateVarId = templateVarId;
    }

    /**
     * 获取进件模板选项名称
     *
     * @return TEMPLATE_VAR_OPTION_NAME - 进件模板选项名称
     */
    public String getTemplateVarOptionName() {
        return templateVarOptionName;
    }

    /**
     * 设置进件模板选项名称
     *
     * @param templateVarOptionName 进件模板选项名称
     */
    public void setTemplateVarOptionName(String templateVarOptionName) {
        this.templateVarOptionName = templateVarOptionName;
    }

    /**
     * 获取进件模板选项value
     *
     * @return TEMPLATE_VAR_OPTION_VALUE - 进件模板选项value
     */
    public String getTemplateVarOptionValue() {
        return templateVarOptionValue;
    }

    /**
     * 设置进件模板选项value
     *
     * @param templateVarOptionValue 进件模板选项value
     */
    public void setTemplateVarOptionValue(String templateVarOptionValue) {
        this.templateVarOptionValue = templateVarOptionValue;
    }

    /**
     * 获取进件模板选项value类型
     *
     * @return TEMPLATE_VAR_VALUE_TYPE - 进件模板选项value类型
     */
    public Integer getTemplateVarValueType() {
        return templateVarValueType;
    }

    /**
     * 设置进件模板选项value类型
     *
     * @param templateVarValueType 进件模板选项value类型
     */
    public void setTemplateVarValueType(Integer templateVarValueType) {
        this.templateVarValueType = templateVarValueType;
    }

    /**
     * 获取进件模板选项描述
     *
     * @return TEMPLATE_VAR_OPTION_DESC - 进件模板选项描述
     */
    public String getTemplateVarOptionDesc() {
        return templateVarOptionDesc;
    }

    /**
     * 设置进件模板选项描述
     *
     * @param templateVarOptionDesc 进件模板选项描述
     */
    public void setTemplateVarOptionDesc(String templateVarOptionDesc) {
        this.templateVarOptionDesc = templateVarOptionDesc;
    }
}