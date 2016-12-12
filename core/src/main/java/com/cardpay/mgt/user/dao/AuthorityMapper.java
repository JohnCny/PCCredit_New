package com.cardpay.mgt.user.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.user.model.Authority;
import com.cardpay.mgt.user.model.RoleAuthority;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 权限Dao层接口
 *
 * @author rankai
 */
public interface AuthorityMapper extends BasicMapper<Authority> {
    /**
     * 获取权限的分组信息
     *
     * @return 权限分组信息
     */
    List<String> selectAuthorityGroup();

    /**
     * 根据角色ID获得权限信息
     * @param roleId 角色ID
     * @return 权限集合
     */
    List<Authority> selectByRoleId(Integer roleId);

    /**
     * 根据菜单ID和用户查询权限
     *
     * @param userId 用户id
     * @param menuId 菜单id
     * @return 权限集合
     */
    List<Authority> selectMenuAuthorityByUser(@Param("userId")Integer userId,@Param("menuId") Integer menuId);

}