package com.cardpay.mgt.menu.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.menu.model.TMenu;
import com.cardpay.mgt.menu.model.TMenuAuth;
import com.cardpay.mgt.menu.model.vo.TMenuVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TMenuMapper extends BasicMapper<TMenu> {

    /**
     * 递归查询菜单列表(有限层级)
     *
     * @param parentId 顶级id
     * @return 菜单列表
     */
    List<TMenuVo> selectMenuListByLevel(@Param("parentId") int parentId);

    /**
     * 递归查询菜单列表(无限层级)
     *
     * @param parentId 顶级id
     * @param userId 用户id
     * @return 菜单列表
     */
    List<TMenuVo> selectMenuListByAll(@Param("parentId") Integer parentId,@Param("userId") Integer userId);

    /**
     * 根据用户查询所有菜单包含权限
     *
     * @param userId 用户id
     * @return 菜单列表包括权限
     */
    List<TMenuAuth> selectMenuListAndAuthByUser(@Param("userId") Integer userId);

    /**
     * 创建临时视图
     *
     * @param parentId 顶级id
     * @param level 层级
     */
    void createMenuView(@Param("parentId") int parentId, @Param("level") Integer level,@Param("userId") Integer userId);

    /**
     * 递归删除菜单
     *
     * @param id 起始id
     * @return 删除数量
     */
    Integer recursionDelete(@Param("id") Integer id);

}