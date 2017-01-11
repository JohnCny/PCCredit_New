package com.cardpay.mgt.application.enums;

/**
 * 进件模板类型枚举
 *
 * @author yanwe
 *         createTime 2017-01-2017/1/11 17:35
 */
public enum TemplateTypeEnum {

    NORMAL("普通模板",1),
    CASHFLOW_PROFIT("现金流类型模板",2);

    private String templateName;
    private Integer templateId;

    TemplateTypeEnum(String templateName, Integer templateId) {
        this.templateName = templateName;
        this.templateId = templateId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public Integer getTemplateId() {
        return templateId;
    }

    public void setTemplateId(Integer templateId) {
        this.templateId = templateId;
    }

    public static TemplateTypeEnum getTemplateTypeEnumById(Integer templateId){
        switch (templateId){
            case 1:
                return NORMAL;
            case 2:
                return CASHFLOW_PROFIT;
            default:
                break;
        }
        throw new IllegalArgumentException("未找到对应模板类型枚举");
    }
}
