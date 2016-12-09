package com.cardpay.mgt.menu.service;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.menu.model.TMenu;
import com.cardpay.mgt.menu.model.vo.TMenuAuthVo;
import com.cardpay.mgt.menu.model.vo.TMenuVo;

import java.util.List;

/**
 * 菜单Service
 * Created by yanwe on 2016/11/24.
 */
public interface TMenuService extends BaseService<TMenu>{

    /**
     * 查询菜单列表(有限层级)
     *
     * @param topId 顶级id
     * @param level 查询深度
     * @param userId 用户id
     * @return 菜单列表
     */
    List<TMenuVo> selectMenuListByLevel(int topId,int level,int userId);

    /**
     * 查询菜单列表(无限层级)
     *
     * @param topId 顶级id
     * @param userId 用户id
     * @return 菜单列表
     */
    List<TMenuVo> selectMenuListByAll(int topId,int userId);

    /**
     * 查询层级菜单包含的权限
     *
     * @param userId 用户id
     * @return 菜单列表包含权限
     */
    List<TMenuAuthVo> selectMenuListAndAuth(int userId);

    /**
     * 递归删除菜单
     *
     * @param menuId 起始id
     * @return 删除结果
     */
    ResultTo recursionDelete(Integer menuId, Integer userId);

    /**
     * 添加菜单
     *
     * @param menu 菜单
     * @param userId 用户id
     * @return 添加结果
     */
    ResultTo addMenu(TMenu menu, Integer userId);

    /**
     * 更新菜单
     *
     * @param menu 菜单
     * @param userId 用户id
     * @return 更新结果
     */
    ResultTo updateMenu(TMenu menu, Integer userId);

}
