package com.cardpay.core.shrio.common;

import com.cardpay.mgt.user.model.User;
import org.apache.poi.ss.formula.functions.T;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

/**
 * Shiro综合工具类
 *
 * @author rankai .
 */
public class ShiroKit {

    /**
     * 获取
     *
     * @return
     */
    public static Object getPrincipal() {
        return SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 获取当前 Subject
     *
     * @return Subject
     */
    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    /**
     * 从shiro获取session
     *
     * @return Session
     */
    public static Session getSession() {
        return getSubject().getSession();
    }

    /**
     * 验证当前用户是否属于该角色？,使用时与lacksRole 搭配使用
     *
     * @param roleName 角色名
     * @return 属于该角色：true，否则false
     */
    public static boolean hasRole(String roleName) {
        return getSubject() != null && roleName != null && roleName.length() > 0 && getSubject().hasRole(roleName);
    }

    /**
     * 验证当前用户是否拥有指定权限,使用时与lacksPermission 搭配使用
     *
     * @param permission 权限名
     * @return 拥有权限：true，否则false
     */
    public static boolean hasPermission(String permission) {
        return getSubject() != null && permission != null && permission.length() > 0
                && getSubject().isPermitted(permission);
    }

    /**
     * 清除当前用户的授权信息
     */
    public static void clearAuthorizationInfo() {
        if (SecurityUtils.getSubject().isAuthenticated()) {
            clearAuthorizationInfo();
        }
    }

    /**
     * 获取当前登录用户信息
     * @return 当前登录用户信息
     */
    public static User getUser (){
        return (User)SecurityUtils.getSubject().getPrincipal();
    }

    /**
     * 获取当前登录用户id
     * @return 用户id
     */
    public static int getUserId (){
        User user = (User) SecurityUtils.getSubject().getPrincipal();
        return user.getId();
    }

}
