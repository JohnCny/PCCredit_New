package com.cardpay.mgt.user.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.user.model.AuthorityOperation;
import com.cardpay.mgt.user.model.RoleAuthority;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 权限资源操作关系Dao层接口
 *
 * @author rankai
 *         createTime 2016-12-2016/12/23 14:40
 */
public interface AuthorityOperationMapper extends BasicMapper<AuthorityOperation> {
}