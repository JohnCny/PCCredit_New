package com.cardpay.controller.menu;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.menu.model.TMenu;
import com.cardpay.mgt.menu.model.TMenuVo;
import com.cardpay.mgt.menu.service.impl.TMenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by yanwe on 2016/11/22.
 */
@RestController
@RequestMapping("/menu")
public class MenuController extends BaseController<TMenu,Integer>{

    @Autowired
    private TMenuServiceImpl tMenuService;

    @RequestMapping("/all")
    public ResultTo selectMenuList(int level){
        ResultTo resultTo = new ResultTo();
        List<TMenuVo> menuLists = tMenuService.selectMenuList(0,level);
        resultTo.setData(menuLists);
        return resultTo;
    }
}
