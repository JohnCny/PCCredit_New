package com.cardpay.core.shiro.enums;

/**
 * shrio相关的宏定义
 * @author johnmyiqn
 */
public class ShrioEnum {
    /**
     * 统一盐值
     */
    public static final String SALT = "qkjr2016";
    /**
     * 没有权限要跳转的页面
     */
    public static final String UNAUTHORIZED_PAGE = "/error/403";

    /**
     * Session超时跳转页面
     */
    public static final String Unauthenticated_page = "/error/timeout";

}
