package com.cardpay.mgt.menu.service.impl;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.menu.dao.TMenuMapper;
import com.cardpay.mgt.menu.model.TMenu;
import com.cardpay.mgt.menu.model.TMenuVo;
import com.cardpay.mgt.menu.service.TMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单Service实现类
 *
 * Created by yanwe on 2016/11/22.
 */
@Service
public class TMenuServiceImpl extends BaseService<TMenu> implements TMenuService{

    @Autowired
    private TMenuMapper tMenuMapper;

    @Override
    public List<TMenuVo> selectMenuList(int topId, int level){
        tMenuMapper.createMenuView(topId,level);
        return tMenuMapper.selectMenuList(topId);
    }
}
