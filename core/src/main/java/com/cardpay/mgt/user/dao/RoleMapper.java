package com.cardpay.mgt.user.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.user.model.Role;
import com.cardpay.mgt.user.model.UserRole;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleMapper extends BasicMapper<Role> {
    /**
     * 根据用户角色关系表获取用户的角色信息
     *
     * @param userRoles 用户角色的关系集合
     * @return 用户的角色集合
     */
    List<Role> selectByUserRoleList(List<UserRole> userRoles);
}