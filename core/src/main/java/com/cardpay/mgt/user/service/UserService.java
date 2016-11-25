package com.cardpay.mgt.user.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.user.model.User;

import java.util.Set;

/**
 * User的Service接口
 *
 * @author rankai
 */
public interface UserService extends BaseService<User> {

    /**
     * 获取用户的资源权限
     *
     * @param user User对象
     * @return 用户的资源集合
     */
    Set<String> getUserAuthority(User user);

    /**
     * 获取用户的角色权限
     *
     * @param user User对象
     * @return 用户的角色资源集合
     */
    Set<String> getUserRole(User user);
}
