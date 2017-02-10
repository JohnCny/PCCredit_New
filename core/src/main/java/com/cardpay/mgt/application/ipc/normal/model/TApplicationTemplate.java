package com.cardpay.mgt.application.ipc.normal.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Table(name = "T_APPLICATION_TEMPLATE")
@ApiModel(value="模板")
public class TApplicationTemplate {
    /**
     * 模板id
     */
    @Id
    @Column(name = "TEMPLATE_ID")
    @ApiModelProperty(value="模板id",required = true)
    private Integer templateId;

    /**
     * 进件模板名称
     */
    @Column(name = "TEMPLATE_NAME")
    @ApiModelProperty(value="进件模板名称",required = true)
    private String templateName;

    /**
     * 进件模板描述
     */
    @Column(name = "TEMPLATE_DESCRIPTION")
    @ApiModelProperty(value="进件模板描述",required = true)
    private String templateDescription;

    /**
     * 进件模板类型(0 建议，1 基本状况 2 资产负债 3 申请表)
     */
    @Column(name = "TEMPLATE_TYPE")
    @ApiModelProperty(value="进件模板类型(0 建议，1 基本状况 2 资产负债 3 申请表)",required = true)
    private Integer templateType;

    /**
     * 进件模板是否需要生成(0 不需要 1 需要)
     */
    @Column(name = "IS_NEED_GENERATE")
    @ApiModelProperty(value="进件模板是否需要生成(0 不需要 1 需要)",required = true)
    private Integer isNeedGenerate;

    /**
     * 获取模板id
     *
     * @return TEMPLATE_ID - 模板id
     */
    public Integer getTemplateId() {
        return templateId;
    }

    /**
     * 设置模板id
     *
     * @param templateId 模板id
     */
    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    /**
     * 获取进件模板名称
     *
     * @return TEMPLATE_NAME - 进件模板名称
     */
    public String getTemplateName() {
        return templateName;
    }

    /**
     * 设置进件模板名称
     *
     * @param templateName 进件模板名称
     */
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    /**
     * 获取进件模板描述
     *
     * @return TEMPLATE_DESCRIPTION - 进件模板描述
     */
    public String getTemplateDescription() {
        return templateDescription;
    }

    /**
     * 设置进件模板描述
     *
     * @param templateDescription 进件模板描述
     */
    public void setTemplateDescription(String templateDescription) {
        this.templateDescription = templateDescription;
    }

    /**
     * 获取进件模板类型(0 建议，1 基本状况 2 资产负债 3 申请表)
     *
     * @return TEMPLATE_TYPE - 进件模板类型(0 建议，1 基本状况 2 资产负债 3 申请表)
     */
    public Integer getTemplateType() {
        return templateType;
    }

    /**
     * 设置进件模板类型(0 建议，1 基本状况 2 资产负债 3 申请表)
     *
     * @param templateType 进件模板类型(0 建议，1 基本状况 2 资产负债 3 申请表)
     */
    public void setTemplateType(Integer templateType) {
        this.templateType = templateType;
    }

    /**
     * 获取进件模板是否需要生成(0 不需要 1 需要)
     *
     * @return IS_NEED_GENERATE - 进件模板是否需要生成(0 不需要 1 需要)
     */
    public Integer getIsNeedGenerate() {
        return isNeedGenerate;
    }

    /**
     * 设置进件模板是否需要生成(0 不需要 1 需要)
     *
     * @param isNeedGenerate 进件模板是否需要生成(0 不需要 1 需要)
     */
    public void setIsNeedGenerate(Integer isNeedGenerate) {
        this.isNeedGenerate = isNeedGenerate;
    }
}