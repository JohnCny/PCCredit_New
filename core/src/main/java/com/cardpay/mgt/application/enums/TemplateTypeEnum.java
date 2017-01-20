package com.cardpay.mgt.application.enums;

/**
 * 进件模板类型枚举
 *
 * @author yanwe
 *         createTime 2017-01-2017/1/11 17:35
 */
public enum TemplateTypeEnum {

    NORMAL("普通模板",1),
    CASHFLOW_PROFIT("现金流类型模板",2),
    APPLICATION_FROM("申请表类型模板",3);

    private String templateName;
    private Integer templateType;

    TemplateTypeEnum(String templateName, Integer templateType) {
        this.templateName = templateName;
        this.templateType = templateType;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public Integer getTemplateType() {
        return templateType;
    }

    public void setTemplateType(Integer templateType) {
        this.templateType = templateType;
    }

    public static TemplateTypeEnum getTemplateTypeEnumById(Integer templateId){
        switch (templateId){
            case 1:
                return NORMAL;
            case 2:
                return CASHFLOW_PROFIT;
            case 3:
                return APPLICATION_FROM;
            default:
                break;
        }
        throw new IllegalArgumentException("未找到对应模板类型枚举");
    }
}
