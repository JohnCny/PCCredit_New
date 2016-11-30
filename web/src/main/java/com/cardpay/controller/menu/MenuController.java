package com.cardpay.controller.menu;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.menu.model.TMenu;
import com.cardpay.mgt.menu.model.TMenuVo;
import com.cardpay.mgt.menu.service.TMenuService;
import com.cardpay.mgt.parse.service.ParseCreditReportService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.io.IOException;
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

    @Autowired
    private ParseCreditReportService parseCreditReportService;

    @ResponseBody
    @RequestMapping("/all")
    @ApiOperation(value = "查询菜单层级信息接口", notes = "查询菜单层级信息",  httpMethod = "GET")
    public ResultTo selectMenuList(@ApiParam(value = "查询深度", required = true) Integer level){
        ResultTo resultTo = new ResultTo();
        List<TMenuVo> menuLists = tMenuService.selectMenuList(0,level);
        resultTo.setData(menuLists);
        return resultTo;
    }

    @ResponseBody
    @RequestMapping("/recursionDelete")
    @ApiOperation(value = "删除指定菜单下所有子菜单接口", notes = "递归删除层级信息",  httpMethod = "DELETE")
    public ResultTo recursionDelete(@ApiParam(value = "菜单id", required = true) Integer id){
        ResultTo resultTo = new ResultTo();
        Integer deleteNum = tMenuService.recursionDelete(id);
        resultTo.setData(deleteNum);
        return resultTo;
    }

    @ResponseBody
    @RequestMapping("/creditReport")
    public ResultTo creditReport(Integer id) {
        ResultTo resultTo = new ResultTo();
        parseCreditReportService.parseCreditReport(id);
        return resultTo;
    }
}
