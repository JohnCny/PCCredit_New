package com.cardpay.core.shrio.realm;

import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.basic.redis.RedisClient;
import com.cardpay.core.shrio.common.PasswordUtil;
import com.cardpay.mgt.user.model.User;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * shiro自定义密码校验器,判断用户输入的密码是否正确
 *
 * @author rankai .
 */
public class UserCredentialsMatcher extends SimpleCredentialsMatcher {

    /**
     * @param authcToken AuthenticationToken
     * @param info       AuthenticationInfos
     * @return 登陆是否成功
     */
    @Override
    public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        User user = (User) getCredentials(info);
        if (user.getPassword().equals(PasswordUtil.encryptPassword(String.copyValueOf(token.getPassword())))) {
            if (user.getStatus() == 1) {
                throw new LockedAccountException();
            }
            if (user.getStatus()==3){
                throw new DisabledAccountException();
            }
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}