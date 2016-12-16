package com.cardpay.core.shiro.common;

import com.cardpay.mgt.user.service.UserService;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * Shiro工厂类
 * @author rankai .
 */
public final class ShiroFactory {

    private static WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();

    private static final ShiroFactory SHIRO_FACTORY = new ShiroFactory();

    private ShiroFactory() {
    }

    public static ShiroFactory get() {
        return SHIRO_FACTORY;
    }

    private UserService userService = context.getBean(UserService.class);

    public UserService getUserService() {
        return userService;
    }
}
