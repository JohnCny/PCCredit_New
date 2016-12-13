package com.cardpay.basic.common.enums;

/**
 * APi返回状态定义
 *
 * @author rankai .
 */
public enum ResultEnum {
    /**
     * api接口成功
     */
    SUCCESS(200),
    /**
     * 没有权限
     */
    NO_AUTHORITY(401),
    /**
     * 未找到
     */
    NOT_FOUND(404),
    /**
     * 服务器错误
     */
    SERVICE_ERROR(500),
    /**
     * token失效
     */
    TOKEN_ERROR(5001),
    /**
     * 参数错误
     */
    PARAM_ERROR(5002),
    /**
     * 用户已存在
     */
    USER_EXIST(5003),
    /**
     * 用户或者密码错误
     */
    USER_PWD_ERROR(5004),
    /**
     * 账号未激活
     */
    NO_ACTIVATION_EXCEPTION(5005),
    /**
     * 账号不存在
     */
    UNKNOWN_ACCOUNT(5006),
    /**
     * 账号被锁定
     */
    LOCKED_ACCOUNT(5007),
    /**
     * 登陆密码错误次数过多
     */
    TOO_MANY_ERRORS(5008),
    /**
     * 验证码错误
     */
    CAPTCHA_ERROR(5009),
    /**
     * 验证码超时
     */
    CAPTCHA_TIMEOUT(5010),
    /**
     * 客户输入验证码为空
     */
    CAPTCHA_NULL(5010),
    /**
     * 没有登陆
     */
    NO_LOGIN(5011),
    /**
     * 没有权限
     */
    NO_PERMITTION(5012),
    /**
     * 不是合法的邮箱或手机号
     */
    NUMBER_ERROR(5013),
    /**
     * 填写的绑定邮箱错误
     */
    BOUND_MAILBOX_ERROR(5014),
    /**
     * 填入的绑定手机号错误
     */
    BOUND_PHONE_ERROR(5015),
    /**
     * 修改密码:原密码错误
     */
    OLD_PASSWORD_ERROR(5016),
    /**
     * 账号未激活
     */
    DISABLED_ACCOUNT(5017),
    /**
     * 账号或密码为空
     */
    ACCOUNT_OR_PASSWORD_NULL(5018),

    /**
     * 必填参数不能为空
     */
    REQUIRED_PARAMETER_EMPTY(5019),

    /**
     * 操作失败
     */
    OPERATION_FAILED(5020),
    /**
     * 请求超时
     */
    API_TIMEOUT(5021);

    private int value; // 自定义数据域，private为了封装

    private ResultEnum(int val) {
        this.value = val;
    }

    /**
     * 获取对应的值
     *
     * @return 对应值value
     */
    public int getValue() {
        return value;
    }
}
