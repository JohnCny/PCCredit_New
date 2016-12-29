package com.cardpay.mgt.user.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.user.model.Authority;
import com.cardpay.mgt.user.model.Role;
import com.cardpay.mgt.user.model.vo.AuthorityGroup;

import java.util.List;

/**
 * 角色Service层接口
 *
 * @author rankai
 */
public interface RoleService extends BaseService<Role> {

    /**
     * 获取权限的分组信息
     *
     * @return 权限分组信息
     */
    List<AuthorityGroup> selectAuthorityGroup();

    /**
     * 根据权限分组名获得权限操作
     *
     * @param groupName 权限分组名
     * @return 权限分组名集合
     */
    List<Authority> selectOperationList(String groupName);

    /**
     * 增加或修改角色拥有的权限
     *
     * @param roleId         角色ID
     * @param oldAuthorityId 原权限ID
     * @param newAuthorityId 新权限ID
     * @return 成功或失败
     */
    boolean update(Integer roleId, Integer oldAuthorityId, Integer newAuthorityId);

    /**
     * 增加角色
     *
     * @param role        角色对象
     * @param authorityId 权限ID数组
     * @return 成功失败
     */
    boolean insertRole(Role role, Integer[] authorityId);

    /**
     * 根据角色ID获取权限分组信息
     *
     * @param roleId 角色ID
     * @return 权限信息
     */
    List<AuthorityGroup> selectRole(Integer roleId);
}
