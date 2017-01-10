package com.cardpay.controller.menu;

import com.alibaba.fastjson.JSONArray;
import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.annotation.SystemControllerLog;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.menu.model.TMenu;
import com.cardpay.mgt.menu.model.vo.TMenuAuthVo;
import com.cardpay.mgt.menu.service.TMenuService;
import com.cardpay.mgt.user.model.User;
import com.cardpay.mgt.user.model.UserRole;
import com.cardpay.mgt.user.service.RoleService;
import com.cardpay.mgt.user.service.UserRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * 菜单Controller
 *
 * @author yanwe 2016年12月21日09:11:29
 */
@RestController
@RequestMapping("/api/menu")
@Api(value = "/api/menu", description = "菜单")
public class MenuController {

    @Autowired
    private TMenuService tMenuService;

    /**
     * 根据角色查询菜单层级信息接口
     *
     * @param session session
     * @return 菜单层级信息
     */
    @GetMapping(value = "/all")
    @ApiOperation(value = "根据角色查询菜单层级信息接口", notes = "查询菜单层级信息",  httpMethod = "GET")
    @SystemControllerLog(description = "查询全部菜单数据")
    public ResultTo selectMenuList(HttpSession session){
        ResultTo resultTo = new ResultTo();
        User user = (User) ShiroKit.getPrincipal();
        JSONArray menuLists = tMenuService.selectMenuListByAll(user.getId());
        resultTo.setDataMap("menus",menuLists).setDataMap("checkedMenu",session.getAttribute(ShiroKit.getUserId().toString()));
        return resultTo;
    }

    /**
     * 查询菜单层级和权限信息接口
     *
     * @return 菜单层级和权限信息
     */
    @GetMapping("/allAuth")
    @ApiOperation(value = "查询菜单层级和权限信息接口", notes = "查询菜单层级和权限信息",  httpMethod = "GET")
    public ResultTo selectMenuAndAuthList(@ApiParam(value = "角色Id", required = true) @RequestParam("roleId") Integer roleId){
        List<TMenuAuthVo> tMenuAuthVos = tMenuService.selectMenuListAndAuth(roleId);
        ResultTo resultTo = new ResultTo();
        resultTo.setData(tMenuAuthVos);
        return resultTo;
    }

    /**
     * 添加菜单
     *
     * @param menu 菜单信息
     * @return 添加菜单结果
     */
    @PostMapping
    @ApiOperation(value = "添加菜单", notes = "添加菜单",  httpMethod = "POST")
    public ResultTo addMenu(@ApiParam(value = "菜单", required = true) @ModelAttribute TMenu menu){
        ResultTo resultTo = tMenuService.addMenu(menu, ShiroKit.getUserId());
        return resultTo;
    }

    /**
     * 更新菜单
     *
     * @param menus 菜单信息
     * @return 更新结果
     */
    @PutMapping
    @ApiOperation(value = "更新菜单", notes = "更新菜单",  httpMethod = "PUT")
    public ResultTo updateMenu(@ApiParam(value = "菜单", required = true) @RequestBody String menus){
        List<TMenu> tMenus = JSONArray.parseArray(menus, TMenu.class);
        boolean result = tMenuService.updateMenu(tMenus, ShiroKit.getUserId());
        ResultTo resultTo = new ResultTo();
        resultTo.setCode(result? ResultEnum.SUCCESS.getValue():ResultEnum.NO_PERMITTION.getValue());
        return resultTo;
    }

    /**
     * 删除指定菜单下所有子菜单接口
     *
     * @param menuId 菜单id
     * @return 删除结果
     */
    @DeleteMapping("/recursionDelete")
    @ApiOperation(value = "删除指定菜单下所有子菜单接口", notes = "递归删除层级信息",  httpMethod = "DELETE")
    public ResultTo recursionDelete(@ApiParam(value = "菜单id", required = true) @RequestParam("menuId") Integer menuId){
        return tMenuService.recursionDelete(menuId,ShiroKit.getUserId());
    }

    /**
     * 记录选中的菜单
     *
     * @param session session
     * @param menuId 菜单Id
     * @return 记录结果
     */
    @GetMapping("/checkedMenu")
    @ApiOperation(value = "记录选中菜单", notes = "记录选中菜单",  httpMethod = "GET")
    public ResultTo setCheckedMenu(HttpSession session,@ApiParam(value = "菜单id", required = true)
                                            @RequestParam("menuId") Integer menuId){
        session.setAttribute(ShiroKit.getUserId().toString(),menuId);
        return new ResultTo();
    }

    /**
     * 刷新菜单缓存
     *
     * @return 刷新菜单缓存
     */
    @GetMapping("/refresh")
    @ApiOperation(value = "刷新菜单缓存", notes = "刷新菜单缓存",  httpMethod = "GET")
    public ResultTo refresh(){
        ResultTo resultTo = new ResultTo();
        tMenuService.updateMenuCache();
        return resultTo;
    }
}
