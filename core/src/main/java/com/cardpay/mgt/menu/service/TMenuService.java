package com.cardpay.mgt.menu.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.menu.dao.TMenuMapper;
import com.cardpay.mgt.menu.model.TMenu;
import com.cardpay.mgt.menu.model.TMenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 菜单Service
 *
 * Created by yanwe on 2016/11/22.
 */
@Service
public class TMenuService extends BaseService<TMenu>{

    @Autowired
    private TMenuMapper tMenuMapper;

    public List<TMenuVo> selectMenuList(int topId, int level){
        tMenuMapper.createMenuView(topId,level);
        return tMenuMapper.selectMenuList(topId);
    }
}
