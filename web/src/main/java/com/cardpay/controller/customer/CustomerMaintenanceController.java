package com.cardpay.controller.customer;

import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.basic.common.annotation.SystemControllerLog;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.customer.model.TCustomerBasic;
import com.cardpay.mgt.customer.model.TCustomerMaintenance;
import com.cardpay.mgt.customer.service.TCustomerBasicService;
import com.cardpay.mgt.customer.service.TCustomerMaintenanceService;
import com.cardpay.mgt.customermanager.basic.model.TCustomerManager;
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
        DataTablePage queryCustomerByCondition = dataTablePage("queryCustomerByCondition", map);
        return queryCustomerByCondition;
    }

    /**
     * 新增维护记录
     *
     * @param tCustomerMaintenance 维护信息
     * @return 客户维护信息查询页面
     */
    @PostMapping
    @SystemControllerLog(description = "新增维护记录")
    @ApiOperation(value = "新增维护记录", notes = "新增维护记录", httpMethod = "POST")
    // TODO:　客户id(需要生成规则生成)
    public String insert(@ModelAttribute TCustomerMaintenance tCustomerMaintenance) {
        Integer managerId = ShiroKit.getUserId();
        TCustomerManagerBaseVo tCustomerManagerBaseVo = customerManagerService.selectBaseVoByUserId(managerId);
        tCustomerMaintenance.setCustomerCname("测试");
        tCustomerMaintenance.setOperationId(managerId);
        tCustomerMaintenance.setOperationName(tCustomerManagerBaseVo.getUser().getUserCname());
        tCustomerMaintenance.setOperationTime(new Date());
        customerMaintenanceService.insertSelective(tCustomerMaintenance);
        return "redirect:/customerMaintenance/index";
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
        TCustomerMaintenance tCustomerMaintenance = customerMaintenanceService.selectByPrimaryKey(customerId);
        modelAndView.addObject("tCustomerMaintenance", tCustomerMaintenance);
        return modelAndView;
    }

    /**
     * 跳转新增客户维护页面
     * @param customerId 客户id
     * @return 客户维护页面
     */
    @GetMapping
    @SystemControllerLog(description = "跳转新增客户维护页面")
    @ApiOperation(value = "跳转新增客户维护页面", notes = "跳转新增维护记录,返回参数名:tCustomerBasic", httpMethod = "GET")
    public ModelAndView returnMaintenance(@ApiParam("客户id") @RequestParam int customerId) {
        ModelAndView modelAndView = new ModelAndView("/customer/maintenanceNew");
        TCustomerBasic tCustomerBasic = tCustomerBasicService.selectByPrimaryKey(customerId);
        Map<String, List<SelectModel>> dropDownList = new HashMap<>();
        List<SelectModel> maintenanceType = customerMaintenanceService.getMaintenanceType();
        dropDownList.put("maintenanceType", maintenanceType);
        modelAndView.addObject("dropDownList", dropDownList);
        modelAndView.addObject("tCustomerBasic", tCustomerBasic);
        return modelAndView;
    }

    /**
     * 跳转新增维护页面
     *
     * @return
     */
    @GetMapping("/index")
    @ApiOperation(value = "跳转客户维护页面", notes = "客户维护页面", httpMethod = "GET")
    public ModelAndView returnNew() {
        return new ModelAndView("/customer/maintenance");
    }
}
