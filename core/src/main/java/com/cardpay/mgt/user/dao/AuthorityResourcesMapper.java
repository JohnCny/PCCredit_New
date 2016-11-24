package com.cardpay.mgt.user.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.user.model.AuthorityResources;
import com.cardpay.mgt.user.model.RoleAuthority;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AuthorityResourcesMapper extends BasicMapper<AuthorityResources> {
    List<AuthorityResources> selectByAuthoritList(List<RoleAuthority> roleAuthorities);
}