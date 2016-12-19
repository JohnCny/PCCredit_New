package com.cardpay.core.token.common;

import com.cardpay.basic.redis.RedisClient;
import com.cardpay.mgt.user.service.UserService;
import com.cardpay.mgt.user.service.UserTokenService;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

/**
 * Token工厂
 *
 * @author rankai .
 */
public class TokenFactory {

    private static WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();

    private static final TokenFactory TOKEN_FACTORY = new TokenFactory();

    private TokenFactory() {
    }

    public static TokenFactory get() {
        return TOKEN_FACTORY;
    }

    private RedisClient redisClient = context.getBean(RedisClient.class);

    private UserTokenService userTokenService = context.getBean(UserTokenService.class);

    private UserService userService = context.getBean(UserService.class);

    public RedisClient getRedisClient() {
        return redisClient;
    }

    public UserTokenService getUserTokenService() {
        return userTokenService;
    }

    public UserService getUserService() {
        return userService;
    }
}
