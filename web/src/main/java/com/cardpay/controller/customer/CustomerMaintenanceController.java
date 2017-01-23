package com.cardpay.controller.customer;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.basic.common.annotation.SystemControllerLog;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.customer.model.TCustomerMaintenance;
import com.cardpay.mgt.customer.service.TCustomerBasicService;
import com.cardpay.mgt.customer.service.TCustomerMaintenanceService;
import com.cardpay.mgt.customermanager.basic.model.vo.TCustomerManagerBaseVo;
import com.cardpay.mgt.customermanager.basic.service.CustomerManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 客户维护controller
 *
 * @author chenkai
 */
@Api(value = "/api/customerMaintenance", description = "客户维护")
@RestController
@RequestMapping("/api/customerMaintenance")
public class CustomerMaintenanceController extends BaseController<TCustomerMaintenance> {
    /**
     * 客户维护
     */
    @Autowired
    private TCustomerMaintenanceService customerMaintenanceService;

    /**
     * 客户经理信息
     */
    @Autowired
    private CustomerManagerService customerManagerService;
    /**
     * 客户信息
     */
    @Autowired
    private TCustomerBasicService customerBasicService;

    /**
     * 按条件查询客户维护信息
     *
     * @return 查询信息
     */
    @RequestMapping("/condition/{customerType}")
    @SystemControllerLog("按条件查询客户维护信息")
    @ApiOperation(value = "按条件查询客户维护列表", notes = "查询客户维护列表", httpMethod = "GET")
    public DataTablePage queryByCondition(@PathVariable("customerType") int customerType) {
        Map<String, Object> map = new HashMap<>();
        Integer managerId = customerBasicService.getManagerId(ShiroKit.getUserId());
        map.put("customerType", customerType);
        map.put("customerManagerId", managerId);
        return dataTablePage("queryCustomerCondition", map);
    }

    /**
     * 新增维护记录
     *
     * @param tCustomerMaintenance 维护信息
     * @return 维护记录Id
     */
    @PostMapping
    @SystemControllerLog("新增维护记录")
    @ApiOperation(value = "新增维护记录", notes = "新增维护记录", httpMethod = "POST")
    public ResultTo insert(@ModelAttribute TCustomerMaintenance tCustomerMaintenance) {
        Integer userId = ShiroKit.getUserId();
        TCustomerManagerBaseVo tCustomerManagerBaseVo = customerManagerService.selectBaseVoByUserId(userId);
        tCustomerMaintenance.setOperationId(userId);
        tCustomerMaintenance.setOperationName(tCustomerManagerBaseVo.getUser().getUserCname());
        tCustomerMaintenance.setOperationTime(new Date());
        Integer mark = customerMaintenanceService.insertSelective(tCustomerMaintenance);
        return mark != 0 ? new ResultTo().setData(tCustomerMaintenance.getId()) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 按id查询客户维护信息列表
     * @param customerId 客户id
     * @return 客户维护信息列表
     */
    @GetMapping("/{id}")
    @SystemControllerLog("按id查询客户维护列表")
    @ApiOperation(value = "按id查询客户维护列表", notes = "按id查询客户维护列表", httpMethod = "GET")
    public ResultTo returnUpdate(@PathVariable("id") int customerId) {
        TCustomerMaintenance manager = new TCustomerMaintenance();
        manager.setId(customerId);
        List<TCustomerMaintenance> customerMaintenance = customerMaintenanceService.select(manager);
        return new ResultTo().setData(customerMaintenance);
    }

    /**
     * 查询客户维护类型
     *
     * @return 查询客户维护类型
     */
    @GetMapping("/maintenanceType")
    @ApiOperation(value = "查询客户维护类型", notes = "查询客户维护类型", httpMethod = "GET")
    public ResultTo maintenanceType() {
        List<SelectModel> maintenanceType = customerMaintenanceService.getMaintenanceType();
        return new ResultTo().setData(maintenanceType);
    }

}
