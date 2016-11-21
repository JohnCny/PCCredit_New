package com.cardpay.core.shrio.realm;

import com.cardpay.basic.redis.RedisClient;
import com.cardpay.core.business.user.model.po.User;
import com.cardpay.core.shrio.token.CaptchaAuthenticationToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * 自定义ShiroReale,用户授权,权限加载处理类
 * @author rankai .
 */
@Component
public class ShiroRealm extends AuthorizingRealm {

//    @Autowired
//    private UserService userService;

    @Autowired
    private RedisClient redisClient;

    /**
     * 自定义密码校验器
     */
    @PostConstruct
    public void initCredentialsMatcher() {
        setCredentialsMatcher(new UserCredentialsMatcher(redisClient));
    }

    /**
     * 获取包含权限角色和权限集合数据的权限验证对象
     * @param principals  身份集合
     * @return 权限验证对象
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        //获取角色集合和权限列表集合
//        authorizationInfo.setRoles(userService.getRoles(user));
//        authorizationInfo.setStringPermissions(userService.getPermissions(user));
        return authorizationInfo;
    }

    /**
     * 判断登录信息，如果正常创建登录验证对象，否则抛出权限验证异常
     * @param authcToken 验证token
     * @return 登录验证对象
     * @throws AuthenticationException  权限验证异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
            throws AuthenticationException {
        CaptchaAuthenticationToken token = (CaptchaAuthenticationToken) authcToken;
//        String kaptchaUUID = token.getKaptchaUUID();
//        if (kaptchaUUID != null) {
//            //redis中获取验证码
//            Object object = redisClient.get(token.getUsername() + "_login");
//            int count = 0;
//            if (object != null) {
//                try {
//                    count = Integer.parseInt(object.toString());
//                } catch (Exception e) {
//                    count = Constant.LOCK_COUNT;
//                }
//            }
//            if (count >= Constant.CAPTCHA_COUNT) {
//                //验证验证码
//                CaptchaVerification.captchaValidate(kaptchaUUID, token.getCaptcha(), redisClient);
//            }
//        }
//        String userName = token.getUsername();
//        User user = userService.findByName(userName);
//        if (user != null) {
//            //判断账号是否激活
//            if (user.getActive() == 0) {
//                throw new NoActivationException();
//            }
//            return new SimpleAuthenticationInfo(user, user.getPassword(), getName());
//        } else {
//            throw new UnknownAccountException();// 没找到账号
//        }
        return null;
    }

    /**
     * 清除权限验证缓存
     * @param principals 身份集合
     */
    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    /**
     * 清除身份认证/登录缓存
     * @param principals 身份集合
     */
    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    /**
     * 清除缓存
     * @param principals
     */
    @Override
    public void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    /**
     * 获取权限验证缓存
     */
    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    /**
     * 清除登录验证缓存
     */
    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    /**
     * 清除权限验证和登录验证缓存
     */
    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }
}