package com.cardpay.controller.customer;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.customer.customermaintenance.model.TCustomerMaintenance;
import com.cardpay.mgt.customer.customermaintenance.service.CustomerMaintenanceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 客户维护controller
 *
 * @author wangpeng
 */
@Api(value = "/customerMaintenance", description = "客户维护")
@RestController
@RequestMapping("/customerMaintenance")
public class CustomerMaintenanceController extends BaseController<TCustomerMaintenance, Long> {
    @Autowired
    private CustomerMaintenanceService customerMaintenanceService;

    /**
     * 维护类型
     *
     * @return 维护类型列表
     */
    @GetMapping("/maintenanceTypeList")
    @ApiOperation(value = "维护类型类型", notes = "维护类型", httpMethod = "GET")
    public ResultTo getMaintenanceTypeList() {
        List<SelectModel> maintenanceType = customerMaintenanceService.getMaintenanceType();
        return new ResultTo().setData(maintenanceType);
    }


    /**
     * 获取客户维护记录列表
     *
     * @return 客户维护记录列表
     */
    @RequestMapping("/maintenanceList")
    @ApiOperation(value = "获取客户维护记录列表", notes = "户维护记录", httpMethod = "GET")
    public ResultTo getMaintenanceList() {
        TCustomerMaintenance tCustomerMaintenance = new TCustomerMaintenance();
        tCustomerMaintenance.setOperationId(ShiroKit.getUserId());
        List<TCustomerMaintenance> list = customerMaintenanceService.select(tCustomerMaintenance);
        return new ResultTo().setData(list);
    }
}
