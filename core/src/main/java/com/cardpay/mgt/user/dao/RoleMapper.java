package com.cardpay.mgt.user.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.user.model.Role;
import com.cardpay.mgt.user.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色Dao层接口
 *
 * @author rankai
 *         createTime 2016-12-2016/12/23 14:40
 */
public interface RoleMapper extends BasicMapper<Role> {

    /**
     * 根据用户ID获得用户角色集合
     *
     * @param userId 用户对象
     * @param orgId  机构对象
     * @return 角色集合
     */
    List<String> selectByUser(@Param("userId") Integer userId, @Param("orgId") Integer orgId);

}