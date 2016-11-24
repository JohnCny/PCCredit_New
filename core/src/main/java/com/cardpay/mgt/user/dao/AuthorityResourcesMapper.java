package com.cardpay.mgt.user.dao;

import com.cardpay.mgt.user.model.AuthorityResources;
import com.cardpay.mgt.user.model.RoleAuthority;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface AuthorityResourcesMapper extends Mapper<AuthorityResources> {
    List<AuthorityResources> selectByAuthoritList(List<RoleAuthority> roleAuthorities);
}