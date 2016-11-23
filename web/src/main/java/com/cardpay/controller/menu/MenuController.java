package com.cardpay.controller.menu;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.menu.model.Menu;
import com.cardpay.mgt.menu.model.MenuList;
import com.cardpay.mgt.menu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by yanwe on 2016/11/22.
 */
@RestController
@RequestMapping("/api/menu")
public class MenuController extends BaseController<Menu>{

    @Autowired
    private MenuService menuService;

    @RequestMapping("/all")
    public ResultTo selectMenuList(int level){
        ResultTo resultTo = new ResultTo();
        List<MenuList> menuLists = menuService.selectMenuList(0,level);
        resultTo.setData(menuLists);
        return resultTo;
    }
}
