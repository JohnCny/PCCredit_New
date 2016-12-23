package com.cardpay.controller.customer;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.basic.common.annotation.SystemControllerLog;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.customer.model.TCustomerBasic;
import com.cardpay.mgt.customer.model.vo.TCustomerMaintenanceVo;
import com.cardpay.mgt.customer.service.TCustomerBasicService;
import com.cardpay.mgt.customer.model.TCustomerMaintenance;
import com.cardpay.mgt.customer.service.TCustomerMaintenanceService;
import com.cardpay.mgt.customermanager.basic.service.CustomerManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    /**
     * 按条件查询客户维护信息
     *
     * @return 查询信息
     */
    @ResponseBody
    @GetMapping("/index")
    @SystemControllerLog(description = "按条件查询客户维护信息")
    @ApiOperation(value = "按条件查询客户维护列表", notes = "查询客户维护列表", httpMethod = "GET")
    public ResultTo queryByCondition() {
        Map<String, Object> map = new HashMap<>();
        map.put("customerManagerId", ShiroKit.getUserId());
        DataTablePage queryCustomerByCondition = dataTablePage("queryCustomerByCondition", map);
        return new ResultTo().setData(queryCustomerByCondition);
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
    public String insert(@ModelAttribute TCustomerMaintenance tCustomerMaintenance) {
        customerMaintenanceService.insertSelective(tCustomerMaintenance);
        return "redirect:/customerMaintenance";
    }

    /**
     * 跳转查看客户维护信息页面
     *
     * @param id 客户id
     * @return 客户维护页面
     */
    @GetMapping("/{id}")
    @SystemControllerLog(description = "跳转查看客户维护信息页面")
    @ApiOperation(value = "跳转查看客户维护信息页面", notes = "跳转查看客户维护信息页面, 返回参数名称:customerMaintenance", httpMethod = "GET")
    public ModelAndView returnUpdate(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView("/customer/maintenanceUpdate");
        TCustomerMaintenance tCustomerMaintenance = customerMaintenanceService.selectByPrimaryKey(id);
        modelAndView.addObject("customerMaintenance", tCustomerMaintenance);
        return modelAndView;
    }

    /**
     * 跳转客户维护页面
     *
     * @return 客户维护页面
     */
    @GetMapping
    @SystemControllerLog(description = "跳转客户维护页面")
    @ApiOperation(value = "跳转客户维护页面", notes = "客户维护页面", httpMethod = "GET")
    public ModelAndView returnMaintenance() {
        ModelAndView modelAndView = new ModelAndView("/customer/maintenance");
        Map<String, List<SelectModel>> dropDownList = new HashMap<>();
        List<SelectModel> maintenanceType = customerMaintenanceService.getMaintenanceType();
        dropDownList.put("maintenanceType", maintenanceType);
        modelAndView.addObject("dropDownList", dropDownList);
        return modelAndView;
    }
}
