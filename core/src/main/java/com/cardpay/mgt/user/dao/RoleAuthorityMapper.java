package com.cardpay.mgt.user.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.user.model.RoleAuthority;
import com.cardpay.mgt.user.model.UserRole;

import java.util.List;

/**
 * 角色权限关系Dao层接口
 *
 * @author rankai
 */
public interface RoleAuthorityMapper extends BasicMapper<RoleAuthority> {
    /**
     * 根据用户的角色集合获取演角色权限集合
     *
     * @param userRoles 角色集合
     * @return 觉得权限集合
     */
    List<RoleAuthority> selectByRoleList(List<UserRole> userRoles);
}