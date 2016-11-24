package com.cardpay.mgt.menu.dao;

import com.cardpay.mgt.menu.model.TMenu;
import com.cardpay.mgt.menu.model.TMenuVo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface TMenuMapper extends Mapper<TMenu> {

    /**
     * 递归查询菜单
     * @param id 顶级id
     * @return
     */
    List<TMenuVo> selectMenuList(int id);

    /**
     * 创建临时视图
     * @param id 顶级id
     * @param level 层级
     */
    void createMenuView(@Param("id") int id, @Param("level") int level);
}