package com.cardpay.mgt.user.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.user.model.RoleAuthority;
import com.cardpay.mgt.user.model.UserRole;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface RoleAuthorityMapper extends BasicMapper<RoleAuthority> {

    List<RoleAuthority> selectByRoleList(List<UserRole> userRoles);
}