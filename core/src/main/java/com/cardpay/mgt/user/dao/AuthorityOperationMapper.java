package com.cardpay.mgt.user.dao;

import com.cardpay.mgt.user.model.AuthorityOperation;
import com.cardpay.mgt.user.model.RoleAuthority;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AuthorityOperationMapper extends Mapper<AuthorityOperation> {
    List<AuthorityOperation> selectByAuthoritList(List<RoleAuthority> roleAuthorities);
}