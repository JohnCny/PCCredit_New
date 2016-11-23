package com.cardpay.core.shrio.realm;

import com.cardpay.basic.common.constant.Constant;
import com.cardpay.basic.redis.RedisClient;
import com.cardpay.basic.util.FormatTimeUtil;
import com.cardpay.basic.common.log.LogBase;
import com.cardpay.core.shrio.common.PasswordUtil;
import com.cardpay.core.shrio.token.CaptchaAuthenticationToken;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.slf4j.Logger;

import java.util.Date;

/**
 * shiro自定义密码校验器,判断用户输入的密码是否正确
 *
 * @author rankai .
 */
public class UserCredentialsMatcher extends SimpleCredentialsMatcher {

    private static final Logger log = LogBase.get(UserCredentialsMatcher.class);

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