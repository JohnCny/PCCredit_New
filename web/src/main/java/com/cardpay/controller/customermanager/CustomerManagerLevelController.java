package com.cardpay.controller.customermanager;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.customermanager.level.model.TCustomerManagerLevel;
import com.cardpay.mgt.customermanager.level.service.CustomerManagerLevelService;
import com.cardpay.mgt.datadictionary.model.TDataDictionary;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * 客户经理级别controller
 *
 * @author yanweichen
 */
@Api(value = "/customerManagerLevel", description = "客户经理级别")
@RestController
@RequestMapping("/customerManagerLevel")
public class CustomerManagerLevelController extends BaseController<TCustomerManagerLevel> {

    @Autowired
    private CustomerManagerLevelService customerManagerLevelService;

    /**
     * 获取客户经理级别分页数据
     *
     * @return 分页数据
     */
    @ResponseBody
    @RequestMapping(value = "/pageList",method = RequestMethod.GET)
    @ApiOperation(value = "获取客户经理级别分页数据", notes = "获取客户经理级别分页数据",  httpMethod = "GET")
    public DataTablePage pageList(){
        return dataTablePage();
    }

    /**
     * 前往添加客户经理级别页面接口
     *
     * @return 页面
     */
    @RequestMapping(value = "/toAdd",method = RequestMethod.GET)
    @ApiOperation(value = "前往添加客户经理级别页面接口", notes = "前往添加客户经理级别页面",  httpMethod = "GET")
    public ModelAndView toAdd(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("");
        return modelAndView;
    }

    /**
     * 添加客户经理级别接口
     *
     * @param tCustomerManagerLevel 客户经理级别信息
     * @return 页面
     */
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "添加客户经理级别接口", notes = "添加客户经理级别",  httpMethod = "POST")
    public ModelAndView add(@ApiParam("客户经理级别信息") @ModelAttribute TCustomerManagerLevel tCustomerManagerLevel){
        customerManagerLevelService.insert(tCustomerManagerLevel);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("");
        return modelAndView;
    }

    /**
     * 删除客户经理级别接口
     *
     * @param levelId 客户经理级别id
     * @return 删除结果
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE)
    @ApiOperation(value = "删除客户经理级别接口", notes = "删除客户经理级别",  httpMethod = "DELETE")
    public ResultTo delete(@RequestParam("dataId") Integer levelId){
        ResultTo resultTo = new ResultTo();
        Integer result = customerManagerLevelService.deleteByPrimaryKey(levelId);
        resultTo.setIsSuccess(result);
        return resultTo;
    }

    /**
     * 前往更新客户经理级别接口
     *
     * @param dataId 客户经理级别id
     * @return 页面和数据
     */
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "前往更新客户经理级别接口", notes = "根据ID获取客户经理级别信息,前往更新客户经理级别",  httpMethod = "GET")
    public ModelAndView toUpdate(@ModelAttribute Integer dataId){
        TCustomerManagerLevel customerManagerLevel = customerManagerLevelService.selectByPrimaryKey(dataId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("customerManagerLevel",customerManagerLevel);
        modelAndView.setViewName("");
        return modelAndView;
    }

    /**
     * 更新客户经理级别接口
     *
     * @param customerManagerLevel 客户经理级别信息
     * @return 页面
     */
    @RequestMapping(method = RequestMethod.PUT)
    @ApiOperation(value = "更新客户经理级别接口", notes = "根据ID更新客户经理级别信息",  httpMethod = "PUT")
    public ModelAndView update(@ModelAttribute TCustomerManagerLevel customerManagerLevel){
        customerManagerLevelService.updateByPrimaryKey(customerManagerLevel);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("");
        return modelAndView;
    }

}
