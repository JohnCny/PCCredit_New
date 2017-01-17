package com.cardpay.mgt.user.service;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.user.model.User;
import com.cardpay.mgt.user.model.vo.UserUpdateVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 用户Service层接口
 *
 * @author rankai
 *         createTime 2016-12-2016/12/23 14:40
 */
public interface UserService extends BaseService<User> {

    /**
     * 获取用户的资源权限
     *
     * @param userId 用户ID
     * @param userId 机构ID
     * @return 用户的资源集合
     */
    Set<String> getUserAuthority(Integer userId, Integer orgId);

    /**
     * 获取用户的角色权限
     *
     * @param userId 用户ID
     * @param orgId  机构ID
     * @return 用户的角色资源集合
     */
    Set<String> getUserRole(Integer userId, Integer orgId);

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
     * @param address email或phone
     * @return 成功或失败
     */
    ResultTo sendCode(String address);

    /**
     * 验证用户输入的验证码是否正确
     *
     * @param userId 用户ID
     * @param code   验证码
     * @return 成功或失败
     */
    ResultTo checkedCode(Integer userId, String code);

    /**
     * 重置密码
     *
     * @param checkedCode Api接口验证
     * @param password    密码
     * @return 成功或失败
     */
    ResultTo resetPassword(String checkedCode, String password);

    /**
     * 增加用户
     *
     * @param user  User对象
     * @param orgId 机构ID
     * @return 成功或失败
     */
    boolean addUser(User user, Integer orgId, Integer roleId) throws RuntimeException;

    /**
     * 编辑用户
     *
     * @param user    User对象
     * @param orgIds  机构ID(组成结构:旧ID,新ID)
     * @param roleIds 角色ID(组成结构:旧ID,新ID)
     * @param file    角色ID(组成结构:旧ID,新ID)
     * @return 成功或失败
     */
    boolean updateUser(User user, String[] orgIds, String[] roleIds, MultipartFile file);

    /**
     * 带搜索的用户分页,自定义SQL(此处是反射应用,没有显示调用)
     *
     * @param map 参数map
     * @return 用户列表
     */
    List<User> userPageList(Map<String, Object> map);

    /**
     * 根据用户ID查询用户信息以及用户机构和角色信息
     *
     * @param userId 用户ID
     * @return 用户信息以及用户机构和角色信息
     */
    UserUpdateVo selectUserUpdateVo(Integer userId);
}
