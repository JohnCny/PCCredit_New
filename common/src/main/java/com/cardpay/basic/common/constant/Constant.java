package com.cardpay.basic.common.constant;

/**
 * 用于定义全局常量 .
 *
 * @author licho
 */
public class Constant {
    //角色名定义
    /**
     * 管理员
     */
    public static final String ROLE_ADMIN = "admin";
    /**
     * 客户经理
     */
    public static final String ROLE_MANAGER = "manager";
    /**
     * 专家
     */
    public static final String ROLE_EXPERT = "expert";
    /**
     * 管理岗
     */
    public static final String ROLE_LEADER = "leader";

    /**
     * 初始密码
     */
    public static final String INIT_PASSWORD = "qkjr123";

    /**
     * 分页json编码格式
     */
    public static final String APPLICATION_JSON = "application/json;charset=utf-8";

    /**
     * 进件UUID基数
     */
    public static final String UUID = "5188290547340000";

    /**
     * 短信或邮箱验证码超时时间
     */
    public static final int TIME_OUT = 300;

    /**
     * email正则表达式
     */
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    /**
     * 手机号正则表达式
     */
    public static final String REGEX_PHONE = "^1(3[0-9]|5[0-35-9]|8[025-9])\\d{8}$";

    /**
     * 登陆锁定时间(6小时)
     */
    public static final int LOGIN_TIMEOUT = 6 * 60 * 60;

    /**
     * 登陆密码输入错误次数超过该设置值后将锁定
     */
    public static final int LOCK_COUNT = 6;

    /**
     * 登陆密码输入错误次数超过该设置值后将弹出验证码
     */
    public static final int CAPTCHA_COUNT = 3;

    /**
     * 表单重复提交，表单重复提交session key值，可以通过该值获取token来判断是否重复提交
     */
    public static final String TOKEN_REPEAT_SESSION_KEY = "token_repeat_session_key";

    /**
     * 定义websocket session数据名称
     */
    public static final String WEBSOCKET_USERID = "CardPayMessageWebsocketUserId";
}
