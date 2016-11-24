package com.cardpay.core.shrio.common;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * Shiro工厂类
 *
 * @author rankai .
 */
public class ShiroFactory {

    private static WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();

    private static final ShiroFactory SHIRO_FACTORY = new ShiroFactory();

    private ShiroFactory() {
    }

    public static ShiroFactory get() {
        return SHIRO_FACTORY;
    }

}
