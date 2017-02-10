package com.cardpay.mgt.application.ipc.normal.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "T_APPLICATION_TEMPLATE_VAR_EXT")
@ApiModel(value="进件模板值额外表")
public class TApplicationTemplateVarExt {
    /**
     * 进件模板额外值id
     */
    @Id
    @Column(name = "EXTRA_VAR_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select APP_TEMPLATE_VAR_EXT_SEQ.NEXTVAL from dual")
    @ApiModelProperty(value="进件模板额外值id",required = true)
    private BigDecimal extraVarId;

    /**
     * 进件模板值id
     */
    @Column(name = "TEMPLATE_VAR_ID")
    @ApiModelProperty(value="进件模板值id",required = true)
    private Integer templateVarId;

    /**
     * 进件模板值name
     */
    @Column(name = "TEMPLATE_VAR_EXTRA_NAME")
    @ApiModelProperty(value="进件模板值name",required = true)
    private String templateVarExtraName;

    /**
     * 进件模板字段value
     */
    @Column(name = "TEMPLATE_VAR_EXTRA_VALUE")
    @ApiModelProperty(value="进件模板字段value",required = true)
    private String templateVarExtraValue;

    /**
     * 进件id
     */
    @Column(name = "APPLICATION_ID")
    @ApiModelProperty(value="进件id",required = true)
    private Integer applicationId;

    /**
     * 获取进件模板额外值id
     *
     * @return EXTRA_VAR_ID - 进件模板额外值id
     */
    public BigDecimal getExtraVarId() {
        return extraVarId;
    }

    /**
     * 设置进件模板额外值id
     *
     * @param extraVarId 进件模板额外值id
     */
    public void setExtraVarId(BigDecimal extraVarId) {
        this.extraVarId = extraVarId;
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
     * 获取进件模板值name
     *
     * @return TEMPLATE_VAR_EXTRA_NAME - 进件模板值name
     */
    public String getTemplateVarExtraName() {
        return templateVarExtraName;
    }

    /**
     * 设置进件模板值name
     *
     * @param templateVarExtraName 进件模板值name
     */
    public void setTemplateVarExtraName(String templateVarExtraName) {
        this.templateVarExtraName = templateVarExtraName;
    }

    /**
     * 获取进件模板字段value
     *
     * @return TEMPLATE_VAR_EXTRA_VALUE - 进件模板字段value
     */
    public String getTemplateVarExtraValue() {
        return templateVarExtraValue;
    }

    /**
     * 设置进件模板字段value
     *
     * @param templateVarExtraValue 进件模板字段value
     */
    public void setTemplateVarExtraValue(String templateVarExtraValue) {
        this.templateVarExtraValue = templateVarExtraValue;
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