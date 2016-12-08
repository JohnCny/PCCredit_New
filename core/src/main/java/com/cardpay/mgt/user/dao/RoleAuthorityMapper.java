package com.cardpay.mgt.user.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.user.model.RoleAuthority;
import com.cardpay.mgt.user.model.UserRole;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * 角色权限关系Dao层接口
 *
 * @author rankai
 */
public interface RoleAuthorityMapper extends BasicMapper<RoleAuthority> {
    /**
     * 批量增加角色和权限的关系
     *
     * @param roleId      角色ID
     * @param authorityIds 权限ID数组
     */
    void insertArray(int roleId, Integer[] authorityIds);
}