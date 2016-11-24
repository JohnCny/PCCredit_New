package com.cardpay.controller.menu;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.menu.model.TMenu;
import com.cardpay.mgt.menu.model.TMenuVo;
import com.cardpay.mgt.menu.service.TMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 菜单Controller
 *
 * Created by yanwe on 2016/11/22.
 */
@Controller
@RequestMapping("/menu")
public class MenuController extends BaseController<TMenu,Integer>{

    @Autowired
    @Qualifier("TMenuServiceImpl")
    private TMenuService tMenuService;

    @ResponseBody
    @RequestMapping("/all")
    public ResultTo selectMenuList(Integer level){
        ResultTo resultTo = new ResultTo();
        List<TMenuVo> menuLists = tMenuService.selectMenuList(0,level);
        resultTo.setData(menuLists);
        return resultTo;
    }

    @ResponseBody
    @RequestMapping("/recursionDelete")
    public ResultTo recursionDelete(Integer id){
        ResultTo resultTo = new ResultTo();
        Integer deleteNum = tMenuService.recursionDelete(id);
        resultTo.setData(deleteNum);
        return resultTo;
    }
}
