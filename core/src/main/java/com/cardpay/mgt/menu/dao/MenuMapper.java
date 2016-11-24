package com.cardpay.mgt.menu.dao;

import com.cardpay.mgt.menu.model.Menu;
import com.cardpay.mgt.menu.model.MenuList;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface MenuMapper extends Mapper<Menu>{

    /**
     * 递归查询菜单
     * @param id 顶级id
     * @return
     */
    List<MenuList> selectMenuList(int id);

    /**
     * 创建临时视图
     * @param id 顶级id
     * @param level 层级
     */
    void createMenuView(@Param("id") int id,@Param("level") int level);
}