package com.cardpay.mgt.user.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.user.model.RoleAuthority;
import com.cardpay.mgt.user.model.UserRole;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Map;

/**
 * 角色权限关系Dao层接口
 *
 * @author rankai
 *         createTime 2016-12-2016/12/23 14:40
 */
public interface RoleAuthorityMapper extends BasicMapper<RoleAuthority> {
    /**
     * 批量增加角色和权限的关系
     *
     * @param map 参数Map
     */
    void insertArray(Map<String, Object> map);
}