package com.cardpay.mgt.user.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.user.model.AuthorityResources;
import com.cardpay.mgt.user.model.RoleAuthority;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 权限资源关系Dao层接口
 *
 * @author rankai
 */
public interface AuthorityResourcesMapper extends BasicMapper<AuthorityResources> {
}