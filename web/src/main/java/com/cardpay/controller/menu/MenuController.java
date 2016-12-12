package com.cardpay.controller.menu;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.core.shrio.common.ShiroKit;
import com.cardpay.mgt.menu.model.TMenu;
import com.cardpay.mgt.menu.model.vo.TMenuAuthVo;
import com.cardpay.mgt.menu.model.vo.TMenuVo;
import com.cardpay.mgt.menu.service.TMenuService;
import com.cardpay.mgt.user.model.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 菜单Controller
 *
 * Created by yanwe on 2016/11/22.
 */
@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private TMenuService tMenuService;

    /**
     * 顶级id
     */
    private static final int TOP_ID = 0;

    @RequestMapping(value = "/all",method = RequestMethod.GET)
    @ApiOperation(value = "根据角色查询菜单层级信息接口", notes = "查询菜单层级信息",  httpMethod = "GET")
    public ResultTo selectMenuList(){
        ResultTo resultTo = new ResultTo();
        User user = (User) ShiroKit.getPrincipal();
        List<TMenuVo> menuLists = tMenuService.selectMenuListByAll(TOP_ID,user.getId());
        resultTo.setData(menuLists);
        return resultTo;
    }

    @RequestMapping(value = "/allAuth",method = RequestMethod.GET)
    @ApiOperation(value = "查询菜单层级和权限信息接口", notes = "查询菜单层级和权限信息",  httpMethod = "GET")
    public ResultTo selectMenuAndAuthList(){
        User user = (User) ShiroKit.getPrincipal();
        List<TMenuAuthVo> tMenuAuthVos = tMenuService.selectMenuListAndAuth(user.getId());
        ResultTo resultTo = new ResultTo();
        resultTo.setData(tMenuAuthVos);
        return resultTo;
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    @ApiOperation(value = "添加菜单", notes = "添加菜单",  httpMethod = "POST")
    public ResultTo addMenu(@ApiParam(value = "菜单", required = true) @ModelAttribute TMenu menu){
        User user = (User) ShiroKit.getPrincipal();
        ResultTo resultTo = tMenuService.addMenu(menu, user.getId());
        return resultTo;
    }

    @RequestMapping(value = "",method = RequestMethod.PUT)
    @ApiOperation(value = "更新菜单", notes = "更新菜单",  httpMethod = "PUT")
    public ResultTo updateMenu(@ApiParam(value = "菜单", required = true) @ModelAttribute TMenu menu){
        User user = (User) ShiroKit.getPrincipal();
        ResultTo resultTo = tMenuService.updateMenu(menu, user.getId());
        return resultTo;
    }

    @RequestMapping(value = "/recursionDelete",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除指定菜单下所有子菜单接口", notes = "递归删除层级信息",  httpMethod = "DELETE")
    public ResultTo recursionDelete(@ApiParam(value = "菜单id", required = true) Integer id){
        User user = (User) ShiroKit.getPrincipal();
        return tMenuService.recursionDelete(id,user.getId());
    }

}
