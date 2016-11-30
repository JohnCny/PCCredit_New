package com.cardpay.mgt.user.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.user.model.Authority;
import com.cardpay.mgt.user.model.RoleAuthority;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 权限Dao层接口
 *
 * @author rankai
 */
public interface AuthorityMapper extends BasicMapper<Authority> {
    /**
     * 根据角色权限关系表获取权限集合
     *
     * @param roleAuthorities 角色权限关系集合
     * @return 权限集合
     */
    List<Authority> selectByList(List<RoleAuthority> roleAuthorities);
}