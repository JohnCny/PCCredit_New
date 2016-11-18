package com.cardpay.core.shrio.realm;

import com.cardpay.basic.common.constant.Constant;
import com.cardpay.basic.redis.RedisClient;
import com.cardpay.basic.util.FormatTimeUtil;
import com.cardpay.basic.common.log.LogBase;
import com.cardpay.core.shrio.util.PasswordUtil;
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
     * 构造方法
     * @param redisClient redisClient对象
     */
    public UserCredentialsMatcher(RedisClient redisClient) {
        this.redisClient = redisClient;
    }

    /**
     * @param authcToken AuthenticationToken
     * @param info       AuthenticationInfos
     * @return 登陆是否成功
     */
    @Override
    public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
        CaptchaAuthenticationToken token = (CaptchaAuthenticationToken) authcToken;
        String userName = token.getUsername();
        Object passwordRetry = redisClient.get(userName + "_login");
        int intPasswordRetry = 0;
        if (passwordRetry != null) {
            try {
                intPasswordRetry = Integer.parseInt(passwordRetry.toString());
            } catch (Exception e) {
                Date date = (Date) passwordRetry;
                Date nowDate = new Date();
                Long time = (Constant.LOGIN_TIMEOUT * 1000) - (nowDate.getTime() - date.getTime());
                throw new LockedAccountException(FormatTimeUtil.formatTime(time));
            }
        }

        String password = (String) getCredentials(info);
        //对用户输入的密码进行加密
        String tokenPassword = PasswordUtil.encryptPassword(String.copyValueOf(token.getPassword()));
        log.info("用户输入加密后密码:" + tokenPassword + "<<<>>>" + password);
        if (!equals(tokenPassword, password)) {
            int max = intPasswordRetry + 1;
            //判断密码错误次数是否达到锁定次数
            if (max == Constant.LOCK_COUNT) {
                redisClient.set(userName + "_login", new Date(), Constant.LOGIN_TIMEOUT);
                throw new LockedAccountException((Constant.LOGIN_TIMEOUT / 60 / 60) + "小时0分钟0秒");
            }
            //判断密码错误次数是否达到出现验证码的次数
            if (max >= Constant.CAPTCHA_COUNT) {
                redisClient.set(userName + "_login", max, Constant.LOGIN_TIMEOUT);
                throw new ExcessiveAttemptsException(String.valueOf(Constant.LOCK_COUNT - max));
            }
            redisClient.set(userName + "_login", max, Constant.LOGIN_TIMEOUT);
            return Boolean.FALSE;
        }
        if (passwordRetry != null) {
            redisClient.delete(userName + "_login");
        }
        return Boolean.TRUE;
    }
}