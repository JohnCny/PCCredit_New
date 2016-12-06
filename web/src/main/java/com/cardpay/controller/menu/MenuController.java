package com.cardpay.controller.menu;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.mgt.modeifyhistory.service.TModifyHistoryService;
import com.cardpay.mgt.modeifyhistory.util.CompareBeanUtil;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.menu.model.TMenu;
import com.cardpay.mgt.menu.model.TMenuVo;
import com.cardpay.mgt.menu.service.TMenuService;
import com.cardpay.mgt.parse.service.ParseCreditReportService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.InvocationTargetException;
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
    private TMenuService tMenuService;

    @ResponseBody
    @RequestMapping(value = "/all",method = RequestMethod.GET)
    @ApiOperation(value = "查询菜单层级信息接口", notes = "查询菜单层级信息",  httpMethod = "GET")
    public ResultTo selectMenuList(@ApiParam(value = "查询深度", required = true) Integer level){
        ResultTo resultTo = new ResultTo();
        List<TMenuVo> menuLists = tMenuService.selectMenuList(0,level);
        resultTo.setData(menuLists);
        return resultTo;
    }

    @ResponseBody
    @RequestMapping(value = "/recursionDelete",method = RequestMethod.DELETE)
    @ApiOperation(value = "删除指定菜单下所有子菜单接口", notes = "递归删除层级信息",  httpMethod = "DELETE")
    public ResultTo recursionDelete(@ApiParam(value = "菜单id", required = true) Integer id){
        ResultTo resultTo = new ResultTo();
        Integer deleteNum = tMenuService.recursionDelete(id);
        resultTo.setData(deleteNum);
        return resultTo;
    }

    @ResponseBody
    @RequestMapping("/creditReport")
    public ResultTo creditReport() {
        ResultTo resultTo = new ResultTo();
        //需要记录并且是从数据库取的值 必须使用Clone方法 或者自己Clone再传
        TMenu tMenu = tMenuService.selectByPrimaryKeyClone(73);
        tMenu.setMenuName("修改测试菜单");
        tMenu.setMenuNameZh("修改了中文名字");
        //记录修改过程
        compareBean(tMenu,"test","测测测");
        return resultTo;
    }
}
