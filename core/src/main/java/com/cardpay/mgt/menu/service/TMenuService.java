package com.cardpay.mgt.menu.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.menu.model.TMenu;
import com.cardpay.mgt.menu.model.TMenuVo;

import java.util.List;

/**
 * 菜单Service
 * Created by yanwe on 2016/11/24.
 */
public interface TMenuService extends BaseService<TMenu>{

    /**
     * 根据节点位置层级信息查询菜单列表
     *
     * @param topId 开始节点
     * @param level 查询深度
     * @return 菜单列表
     */
    List<TMenuVo> selectMenuList(int topId, int level);

    /**
     * 递归删除菜单
     * @param id 起始id
     * @return
     */
    Integer recursionDelete(Integer id);
}
