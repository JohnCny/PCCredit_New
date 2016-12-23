package com.cardpay.controller.customer;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.basic.common.annotation.SystemControllerLog;
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

import java.util.List;

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

    @Autowired //客户Service
    private TCustomerBasicService customerBasicService;

    @Autowired//客户经理Service
    private CustomerManagerService customerManagerService;

    /**
     * 维护类型
     *
     * @return 维护类型列表
     */
    @ResponseBody
    @GetMapping("/maintenanceTypeList")
    @SystemControllerLog
    @ApiOperation(value = "维护类型类型", notes = "维护类型", httpMethod = "GET")
    public ResultTo getMaintenanceTypeList() {
        List<SelectModel> maintenanceType = customerMaintenanceService.getMaintenanceType();
        return new ResultTo().setData(maintenanceType);
    }

    /**
     * 按条件查询客户维护信息
     *
     * @param tCustomerBasic 查询条件
     * @return 查询信息
     */
    @ResponseBody
    @GetMapping()
    @SystemControllerLog
    @ApiOperation(value = "按条件查询客户维护列表", notes = "查询客户维护列表", httpMethod = "GET")
    public ResultTo queryByCondition(@ApiParam(value = "查询条件") @ModelAttribute TCustomerBasic tCustomerBasic) {
        tCustomerBasic.setCustomerManagerId(ShiroKit.getUserId());
        List<TCustomerMaintenanceVo> tCustomerMaintenanceVos = customerMaintenanceService.queryCustomerByCondition(tCustomerBasic);
        return new ResultTo().setData(tCustomerMaintenanceVos);
    }

    /**
     * 新增维护记录
     * @param tCustomerMaintenance 维护信息
     * @return 客户维护信息查询页面
     */
    @PostMapping()
    @SystemControllerLog
    @ApiOperation(value = "新增维护记录", notes = "新增维护记录", httpMethod = "POST")
    public String insert(@ModelAttribute TCustomerMaintenance tCustomerMaintenance){
        customerMaintenanceService.insertSelective(tCustomerMaintenance);
        return "redirect:/maintenanceTypeList";
    }

    /**
     *
     * @param customerId
     * @return
     */
   @GetMapping("/{id}")
   @SystemControllerLog(description = "跳转新增维护记录")
   @ApiOperation(value = "新增维护记录", notes = "新增维护记录", httpMethod = "GET")
    public ModelAndView returnUpdate(@PathVariable("id") int customerId){
       ModelAndView modelAndView = new ModelAndView("");

       return modelAndView;
   }
}
