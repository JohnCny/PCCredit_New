package com.cardpay.controller.customer;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.basic.common.annotation.SystemControllerLog;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.customer.model.TCustomerBasic;
import com.cardpay.mgt.customer.model.TCustomerMaintenance;
import com.cardpay.mgt.customer.service.TCustomerBasicService;
import com.cardpay.mgt.customer.service.TCustomerMaintenanceService;
import com.cardpay.mgt.customermanager.basic.model.vo.TCustomerManagerBaseVo;
import com.cardpay.mgt.customermanager.basic.service.CustomerManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 客户维护controller
 *
 * @author chenkai
 */
@Api(value = "/customerMaintenance", description = "客户维护")
@Controller
@RequestMapping("/customerMaintenance")
public class CustomerMaintenanceController extends BaseController<TCustomerMaintenance> {
    @Autowired
    private TCustomerMaintenanceService customerMaintenanceService;

    @Autowired //客户经理信息
    private CustomerManagerService customerManagerService;

    @Autowired //客户Service
    private TCustomerBasicService tCustomerBasicService;

    /**
     * 按条件查询客户维护信息
     *
     * @return 查询信息
     */
    @ResponseBody
    @GetMapping("/condition")
    @SystemControllerLog(description = "按条件查询客户维护信息")
    @ApiOperation(value = "按条件查询客户维护列表", notes = "查询客户维护列表", httpMethod = "GET")
    public DataTablePage queryByCondition() {
        Map<String, Object> map = new HashMap<>();
        map.put("customerManagerId", ShiroKit.getUserId());
        return dataTablePage("queryCustomerByCondition", map);
    }

    /**
     * 新增维护记录
     *
     * @param tCustomerMaintenance 维护信息
     * @return 客户维护信息查询页面
     */
    @PostMapping
    @ResponseBody
    @SystemControllerLog(description = "新增维护记录")
    @ApiOperation(value = "新增维护记录", notes = "新增维护记录", httpMethod = "POST")
    public ResultTo insert(@ModelAttribute TCustomerMaintenance tCustomerMaintenance) {
        Integer userId = ShiroKit.getUserId();
        TCustomerManagerBaseVo tCustomerManagerBaseVo = customerManagerService.selectBaseVoByUserId(userId);
        tCustomerMaintenance.setOperationId(userId);
        tCustomerMaintenance.setOperationName(tCustomerManagerBaseVo.getUser().getUserCname());
        tCustomerMaintenance.setOperationTime(new Date());
        customerMaintenanceService.insertSelective(tCustomerMaintenance);
        return new ResultTo().setData(tCustomerMaintenance.getId());
    }

    /**
     * 跳转查看客户维护信息页面
     *
     * @param customerId 客户id
     * @return 客户维护页面
     */
    @GetMapping("/{id}")
    @SystemControllerLog(description = "跳转查看客户维护信息页面")
    @ApiOperation(value = "跳转查看客户维护信息页面", notes = "跳转查看客户维护信息页面, 返回参数名称:customerMaintenance", httpMethod = "GET")
    public ModelAndView returnUpdate(@PathVariable("id") int customerId) {
        ModelAndView modelAndView = new ModelAndView("/customer/maintenanceUpdate");
        TCustomerMaintenance manager = new TCustomerMaintenance();
        manager.setId(customerId);
        List<TCustomerMaintenance> customerMaintenance = customerMaintenanceService.select(manager);
        modelAndView.addObject("tCustomerMaintenance", customerMaintenance);
        return modelAndView;
    }

    /**
     * 跳转新增客户维护页面
     *
     * @param customerId 客户id
     * @return 客户维护页面
     */
    @GetMapping
    @SystemControllerLog(description = "跳转新增客户维护页面")
    @ApiOperation(value = "跳转新增客户维护页面", notes = "跳转新增维护记录,返回参数名:tCustomerBasic", httpMethod = "GET")
    public ModelAndView returnMaintenance(@ApiParam("客户id") @RequestParam int customerId) {
        Map<String, List<SelectModel>> dropDownList = new HashMap<>();
        List<SelectModel> maintenanceType = customerMaintenanceService.getMaintenanceType();

        ModelAndView modelAndView = new ModelAndView("/customer/maintenanceNew");
        TCustomerBasic tCustomerBasic = tCustomerBasicService.selectByPrimaryKey(customerId);

        dropDownList.put("maintenanceType", maintenanceType);
        modelAndView.addObject("dropDownList", dropDownList);
        modelAndView.addObject("tCustomerBasic", tCustomerBasic);
        return modelAndView;
    }

    /**
     * 跳转新增维护列表页
     *
     * @return
     */
    @GetMapping("/index")
    @ApiOperation(value = "跳转客户维护页面", notes = "客户维护列表页面", httpMethod = "GET")
    public ModelAndView returnNew() {
        return new ModelAndView("/customer/maintenance");
    }
}
