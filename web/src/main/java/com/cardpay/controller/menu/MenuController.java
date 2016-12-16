package com.cardpay.controller.menu;

import com.alibaba.fastjson.JSONArray;
import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.annotation.SystemControllerLog;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.menu.model.TMenu;
import com.cardpay.mgt.menu.model.vo.TMenuAuthVo;
import com.cardpay.mgt.menu.service.TMenuService;
import com.cardpay.mgt.user.model.User;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 菜单Controller
 *
 * Created by yanwe on 2016/11/22.
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    private TMenuService tMenuService;

    @ResponseBody
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    @ApiOperation(value = "根据角色查询菜单层级信息接口", notes = "查询菜单层级信息",  httpMethod = "GET")
    @SystemControllerLog(description = "查询全部菜单数据")
    public ResultTo selectMenuList(HttpSession session){
        ResultTo resultTo = new ResultTo();
        User user = (User) ShiroKit.getPrincipal();
        JSONArray menuLists = tMenuService.selectMenuListByAll(user.getId());
        resultTo.setDataMap("menus",menuLists).setDataMap("checkedMenu",session.getAttribute(getUserId().toString()));
        return resultTo;
    }

    @ResponseBody
    @RequestMapping(value = "/allAuth",method = RequestMethod.GET)
    @ApiOperation(value = "查询菜单层级和权限信息接口", notes = "查询菜单层级和权限信息",  httpMethod = "GET")
    public ResultTo selectMenuAndAuthList(){
        List<TMenuAuthVo> tMenuAuthVos = tMenuService.selectMenuListAndAuth(getUserId());
        ResultTo resultTo = new ResultTo();
        resultTo.setData(tMenuAuthVos);
        return resultTo;
    }

    @ResponseBody
    @RequestMapping(value = "",method = RequestMethod.POST)
    @ApiOperation(value = "添加菜单", notes = "添加菜单",  httpMethod = "POST")
    public ResultTo addMenu(@ApiParam(value = "菜单", required = true) @ModelAttribute TMenu menu){
        ResultTo resultTo = tMenuService.addMenu(menu, getUserId());
        return resultTo;
    }

    @ResponseBody
    @RequestMapping(value = "",method = RequestMethod.PUT)
    @ApiOperation(value = "更新菜单", notes = "更新菜单",  httpMethod = "PUT")
    public ResultTo updateMenu(@ApiParam(value = "菜单", required = true) @ModelAttribute TMenu menu){
        ResultTo resultTo = tMenuService.updateMenu(menu, getUserId());
        return resultTo;
    }

    @ResponseBody
    @RequestMapping(value = "/recursionDelete",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除指定菜单下所有子菜单接口", notes = "递归删除层级信息",  httpMethod = "DELETE")
    public ResultTo recursionDelete(@ApiParam(value = "菜单id", required = true) @RequestParam("menuId") Integer menuId){
        return tMenuService.recursionDelete(menuId,getUserId());
    }

    @ResponseBody
    @RequestMapping(value = "/checkedMenu",method = RequestMethod.GET)
    @ApiOperation(value = "记录选中菜单", notes = "记录选中菜单",  httpMethod = "GET")
    public ResultTo setCheckedMenu(HttpSession session,@ApiParam(value = "菜单id", required = true)
                                            @RequestParam("menuId") Integer menuId){
        session.setAttribute(getUserId().toString(),menuId);
        return new ResultTo();
    }

    private Integer getUserId(){
        User user = (User) ShiroKit.getPrincipal();
        return user.getId();
    }
    @RequestMapping("/test")
    @ResponseBody
    @SystemControllerLog
    public ResultTo test(String name){
        return  new ResultTo().setMsg(0,"name:"+name);
    }
}
