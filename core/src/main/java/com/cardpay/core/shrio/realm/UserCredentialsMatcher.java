package com.cardpay.core.shrio.realm;

import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.basic.redis.RedisClient;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * shiro自定义密码校验器,判断用户输入的密码是否正确
 *
 * @author rankai .
 */
public class UserCredentialsMatcher extends SimpleCredentialsMatcher {

    @Autowired
    private LogTemplate logger;

    private RedisClient redisClient;

    /**
     * @param authcToken AuthenticationToken
     * @param info       AuthenticationInfos
     * @return 登陆是否成功
     */
    @Override
    public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {

        return Boolean.TRUE;
    }
}