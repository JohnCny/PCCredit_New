package com.cardpay.mgt.menu.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.menu.model.TMenu;
import com.cardpay.mgt.menu.model.TMenuVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TMenuMapper extends BasicMapper<TMenu> {

    /**
     * 递归查询菜单
     * @param parentId 顶级id
     * @return
     */
    List<TMenuVo> selectMenuList(@Param("parentId") int parentId);

    /**
     * 创建临时视图
     * @param parentId 顶级id
     * @param level 层级
     */
    void createMenuView(@Param("parentId") int parentId, @Param("level") int level);

    /**
     * 递归删除菜单
     * @param id 起始id
     * @return
     */
    Integer recursionDelete(@Param("id") Integer id);
}