package com.cardpay.core.shiro.realm;

import com.cardpay.core.shiro.common.ShiroFactory;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.user.model.User;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.PostConstruct;
import java.util.Set;

/**
 * 自定义ShiroReale,用户授权,权限加载处理类
 * @author rankai .
 */
public class ShiroRealm extends AuthorizingRealm {

    /**
     * 判断登录信息，如果正常创建登录验证对象，否则抛出权限验证异常
     *
     * @param authcToken 验证token
     * @return 登录验证对象
     * @throws AuthenticationException 权限验证异常
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
            throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
        String username = token.getUsername();
        User selectUser = User.UserBuilder.get().withUsername(username).build();
        User user = ShiroFactory.get().getUserService().selectOne(selectUser);
        if (user == null) {
            throw new UnknownAccountException();
        }
        return new SimpleAuthenticationInfo(user, user, getName());
    }

    /**
     * 获取包含权限角色和权限集合数据的权限验证对象
     *
     * @param principals 身份集合
     * @return 权限验证对象
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User user = (User) ShiroKit.getPrincipal();
        //获取角色集合和权限列表集合
        Set<String> userRole = ShiroFactory.get().getUserService().getUserRole(user);
        Set<String> userAuthority = ShiroFactory.get().getUserService().getUserAuthority(user);
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(userRole);
        authorizationInfo.setStringPermissions(userAuthority);
        return authorizationInfo;
    }

    /**
     * 自定义密码校验器
     */
    @PostConstruct
    public void initCredentialsMatcher() {
        setCredentialsMatcher(new UserCredentialsMatcher());
    }

    /**
     * 清除权限验证缓存
     *
     * @param principals 身份集合
     */
    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    /**
     * 清除身份认证/登录缓存
     *
     * @param principals 身份集合
     */
    @Override
    public void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    /**
     * 清除缓存
     *
     * @param principals PrincipalCollection
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