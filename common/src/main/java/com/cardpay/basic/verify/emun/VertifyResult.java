package com.cardpay.basic.verify.emun;

/**
 * 邮件发送结果宏定义
 * @author rankai .
 */
public enum VertifyResult {

    CODE_TIME("验证码过期"),
    CODE_ERROR("验证码错误"),
    SUCCESS("验证成功"),
    NUMBER_ERROR("您填写的不是合法的邮箱或手机号"),
    EMAIL_BINDING_ERROR("填写的绑定邮箱错误"),
    PHONE_BINDING_ERROR("填入的绑定手机号错误");

    private String value;
    private VertifyResult(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
