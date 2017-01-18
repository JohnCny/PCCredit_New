package com.cardpay.mgt.menu.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.menu.model.TMenu;
import com.cardpay.mgt.menu.model.TMenuAuth;
import com.cardpay.mgt.menu.model.vo.TMenuVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 菜单管理mapper
 * @auth yanweicheng
 */
public interface TMenuMapper extends BasicMapper<TMenu> {

    /**
     * 根据角色Id查询菜单列表
     *
     * @param roleId 角色id
     * @return 菜单列表
     */
    List<TMenuVo> selectMenuListByRoleAll(@Param("roleId") Integer roleId);

    /**
     * 根据角色查询所有菜单包含权限
     *
     * @param roleId 角色Id
     * @return 菜单列表包括权限
     */
    List<TMenuAuth> selectMenuListAndAuthByRole(@Param("roleId") Integer roleId);

    /**
     * 递归删除菜单
     *
     * @param id 起始id
     * @return 删除数量
     */
    Integer recursionDelete(@Param("id") Integer id);

    /**
     * 初始化机构菜单
     *
     * @param userId 操作人
     * @param orgId 机构id
     * @return 初始化结果
     */
    Integer initMenu(@Param("userId") Integer userId,@Param("orgId") Integer orgId);
}