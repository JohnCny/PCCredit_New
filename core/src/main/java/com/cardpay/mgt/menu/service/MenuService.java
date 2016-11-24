package com.cardpay.mgt.menu.service;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.mgt.menu.dao.MenuMapper;
import com.cardpay.mgt.menu.model.Menu;
import com.cardpay.mgt.menu.model.MenuList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by yanwe on 2016/11/22.
 */
@Service
public class MenuService extends BaseServiceImpl<Menu> {

    @Autowired
    private MenuMapper menuMapper;

    public List<MenuList> selectMenuList(int topId, int level){
        menuMapper.createMenuView(topId,level);
        return menuMapper.selectMenuList(topId);
    }
}
