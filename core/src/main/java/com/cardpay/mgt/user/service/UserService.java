package com.cardpay.mgt.user.service;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.user.model.User;

import java.util.Set;

/**
 * 用户Service层接口
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

    /**
     * 用户修改密码
     *
     * @param oldPassword 原始密码
     * @param newPassword 新密码
     * @return 成功或失败
     */
    ResultTo updatePassword(String oldPassword, String newPassword);

    /**
     * 发送验证码
     *
     * @param userId  用户Id
     * @param address email或phone
     * @return 成功或失败
     */
    ResultTo sendCode(Integer userId, String address);

    /**
     * 验证用户输入的验证码是否正确
     *
     * @param address email或phone
     * @param code    验证码
     * @return 成功或失败
     */
    ResultTo checkedCode(String address, String code);
}
