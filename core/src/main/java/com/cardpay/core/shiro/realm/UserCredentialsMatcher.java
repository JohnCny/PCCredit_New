package com.cardpay.core.shiro.realm;

import com.cardpay.core.shiro.common.PasswordUtil;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.user.model.User;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * shiro自定义密码校验器,判断用户输入的密码是否正确
 *
 * @author rankai .
 */
public class UserCredentialsMatcher extends SimpleCredentialsMatcher {

    /**
     * @param authcToken AuthenticationToken
     * @param info       AuthenticationInfo
     * @return 登陆是否成功
     */
    @Override
    public boolean doCredentialsMatch(AuthenticationToken authcToken, AuthenticationInfo info) {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        User user = (User) getCredentials(info);
        if (user.getPassword().equals(PasswordUtil.encryptPassword(String.copyValueOf(token.getPassword())))) {
            if (user.getStatus() == ShiroKit.LOCKED_ACCOUNT) {
                throw new LockedAccountException();
            }
            if (user.getStatus() == ShiroKit.DISABLED_ACCOUNT) {
                throw new DisabledAccountException();
            }
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}