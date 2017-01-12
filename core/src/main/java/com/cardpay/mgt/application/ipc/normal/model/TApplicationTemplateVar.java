package com.cardpay.mgt.application.ipc.normal.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "T_APPLICATION_TEMPLATE_VAR")
@ApiModel(value="进件模板数据表")
public class TApplicationTemplateVar {
    /**
     * 进件模板值id
     */
    @Id
    @Column(name = "APPLICATION_TEMPLATE_VAR_ID")
    @ApiModelProperty(value="进件模板值id",required = true)
    private Integer applicationTemplateVarId;

    /**
     * 进件模板值id
     */
    @Column(name = "TEMPLATE_VAR_ID")
    @ApiModelProperty(value="进件模板值id",required = true)
    private Integer templateVarId;

    /**
     * 进件模板值value
     */
    @Column(name = "TEMPLATE_VAR_VALUE")
    @ApiModelProperty(value="进件模板值value",required = true)
    private String templateVarValue;

    /**
     * 进件模板值选项值id
     */
    @Column(name = "TEMPLATE_OPTION_ID")
    @ApiModelProperty(value="进件模板值选项值id",required = true)
    private Integer templateOptionId;

    /**
     * 进件id
     */
    @Column(name = "APPLICATION_ID")
    @ApiModelProperty(value="进件id",required = true)
    private Integer applicationId;

    /**
     * 获取进件模板值id
     *
     * @return APPLICATION_TEMPLATE_VAR_ID - 进件模板值id
     */
    public Integer getApplicationTemplateVarId() {
        return applicationTemplateVarId;
    }

    /**
     * 设置进件模板值id
     *
     * @param applicationTemplateVarId 进件模板值id
     */
    public void setApplicationTemplateVarId(Integer applicationTemplateVarId) {
        this.applicationTemplateVarId = applicationTemplateVarId;
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
     * 获取进件模板值value
     *
     * @return TEMPLATE_VAR_VALUE - 进件模板值value
     */
    public String getTemplateVarValue() {
        return templateVarValue;
    }

    /**
     * 设置进件模板值value
     *
     * @param templateVarValue 进件模板值value
     */
    public void setTemplateVarValue(String templateVarValue) {
        this.templateVarValue = templateVarValue;
    }

    /**
     * 获取进件模板值选项值id
     *
     * @return TEMPLATE_OPTION_ID - 进件模板值选项值id
     */
    public Integer getTemplateOptionId() {
        return templateOptionId;
    }

    /**
     * 设置进件模板值选项值id
     *
     * @param templateOptionId 进件模板值选项值id
     */
    public void setTemplateOptionId(Integer templateOptionId) {
        this.templateOptionId = templateOptionId;
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