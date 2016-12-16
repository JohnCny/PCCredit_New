package com.cardpay.controller.customer.customermaintenance;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.customer.customermaintenance.model.po.TCustomerMaintenance;
import com.cardpay.mgt.customer.customermaintenance.service.CustomerMaintenanceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 客户维护controller
 * @author wangpeng
 */
@Api(value = "/customermaintenance", description = "客户维护")
@RestController
@RequestMapping("/customermaintenance")
public class CustomerMaintenanceController extends BaseController<TCustomerMaintenance, Long> {
    @Autowired
    CustomerMaintenanceService customerMaintenanceService;

    /**
     * 维护类型类型
     * @return 维护类型列表
     */
    @RequestMapping("/maintenanceTypelist")
    public ResultTo getMaintenanceTypeList(){
        Map<String,Object> map = new HashMap<String,Object>();
        ResultTo resultTo = new ResultTo();
        map.put("maintenanceTypeList",customerMaintenanceService.getMaintenanceType());
        resultTo.setData(map);
        return resultTo;
    }

    /**
     * 获取客户维护记录列表
     * @return
     */
    @ResponseBody
    @RequestMapping("/maintenancelist")
    @ApiOperation(value = "查询客户维护列表", notes = "客户维护列表",  httpMethod = "GET")
    public ResultTo getMaintenanceList(){
        Map<String,Object> map = new HashMap<String,Object>();
        ResultTo resultTo = new ResultTo();
        TCustomerMaintenance record = new TCustomerMaintenance();
        record.setOperationId(ShiroKit.getUserId());
        map.put("maintenanceList",customerMaintenanceService.select(record));
        resultTo.setData(map);
        return resultTo;
    }
}
