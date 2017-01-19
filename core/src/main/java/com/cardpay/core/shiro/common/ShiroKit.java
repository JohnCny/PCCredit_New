package com.cardpay.core.shiro.common;

import com.cardpay.mgt.organization.model.TOrganization;
import com.cardpay.mgt.user.model.Role;
import com.cardpay.mgt.user.model.User;
import com.cardpay.mgt.user.model.UserOrganization;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import java.util.List;

/**
 * Shiro综合工具类
 *
 * @author rankai .
 */
public class ShiroKit {

    /**
     * 初始密码
     */
    public static final String DEFAULT_PASSWORD = "123";

    /**
     * 登陆用户Session的Key
     */
    public static final String USER_SESSION_KEY = "userSession";

    /**
     * 用户登陆的ORG_Session
     */
    public static final String ORG_SESSION_KEY = "orgSession";

    /**
     * 登陆用户Session的Key
     */
    public static final String ROLE_SESSION_KEY = "roleSession";

    /**
     * 用户登陆的ORG_Session(顶级)
     */
    public static final String TOP_ORG_SESSION_KEY = "topOrgSession";

    /**
     * 账号锁定
     */
    public static final int LOCKED_ACCOUNT = 1;
    /**
     * 账号禁用
     */
    public static final int DISABLED_ACCOUNT = 1;

    /**
     * 获取
     *
     * @return Object
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
     *
     * @return 当前登录用户信息
     */
    public static User getUser() {
        return (User) getPrincipal();
    }

    /**
     * 获取当前登录用户id
     *
     * @return 用户id
     */
    public static Integer getUserId() {
        User user = (User) getPrincipal();
        return user == null ? null : user.getId();
    }

    /**
     * 获取当前登陆用户的角色信息
     *
     * @return 当前登陆用户的角色信息
     */
    public static Role getRole() {
        return (Role) getSession().getAttribute(ROLE_SESSION_KEY);
    }

    /**
     * 获取当前用户所选机构
     *
     * @return 当前用户所选机构
     */
    public static TOrganization getOrg() {
        Object object = getSession().getAttribute(ORG_SESSION_KEY);
        if (object == null) {
            ShiroFactory shiroFactory = ShiroFactory.get();
            UserOrganization userOrganization = new UserOrganization();
            userOrganization.setUserId(getUserId());
            userOrganization.setIsDefault(1);
            UserOrganization selectOne = shiroFactory.getUserOrganizationService().selectOne(userOrganization);
            if (selectOne != null) {
                TOrganization tOrganization = shiroFactory.getOrganizationService().selectByPrimaryKey(selectOne.getOrganizationId());
                getSession().setAttribute(ORG_SESSION_KEY, tOrganization);
                return tOrganization;
            }
            return null;
        }
        return (TOrganization) object;
    }

    /**
     * 获取当前用户所选机构ID
     *
     * @return 前用户所选机构ID
     */
    public static Integer getOrgId() {
        TOrganization org = getOrg();
        return org == null ? null : org.getId();
    }

    /**
     * 获取当前登陆用户的顶级机构ID
     *
     * @return
     */
    public static Integer getTopOrgId() {
        return (Integer) getSession().getAttribute(TOP_ORG_SESSION_KEY);
    }
}
