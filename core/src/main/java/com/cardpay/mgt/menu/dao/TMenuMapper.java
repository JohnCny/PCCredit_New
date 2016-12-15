package com.cardpay.mgt.menu.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.menu.model.TMenu;
import com.cardpay.mgt.menu.model.TMenuAuth;
import com.cardpay.mgt.menu.model.vo.TMenuVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TMenuMapper extends BasicMapper<TMenu> {

    /**
     * 根据用户Id查询菜单列表(有限层级)
     *
     * @param parentId 顶级id
     * @param level 深度
     * @param userId 用户id
     * @return 菜单列表
     */
    List<TMenuVo> selectMenuListByUserLevel(@Param("parentId") int parentId, @Param("level") Integer level, @Param("userId") Integer userId);

    /**
     * 根据用户Id查询菜单列表(无限层级)
     *
     * @param userId 用户id
     * @return 菜单列表
     */
    List<TMenuVo> selectMenuListByUserAll(@Param("userId") Integer userId);


    /**
     * 根据角色Id查询菜单列表
     *
     * @param roleId 角色id
     * @return 菜单列表
     */
    List<TMenuVo> selectMenuListByRoleAll(@Param("roleId") Integer roleId);

    /**
     * 根据用户查询所有菜单包含权限
     *
     * @param userId 用户id
     * @return 菜单列表包括权限
     */
    List<TMenuAuth> selectMenuListAndAuthByUser(@Param("userId") Integer userId);

    /**
     * 递归删除菜单
     *
     * @param id 起始id
     * @return 删除数量
     */
    Integer recursionDelete(@Param("id") Integer id);

}