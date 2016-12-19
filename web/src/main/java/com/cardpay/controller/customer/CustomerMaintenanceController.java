package com.cardpay.controller.customer;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.customer.customerbasic.model.TCustomerBasic;
import com.cardpay.mgt.customer.customerbasic.service.CustomerBasicService;
import com.cardpay.mgt.customer.customermaintenance.model.TCustomerMaintenance;
import com.cardpay.mgt.customer.customermaintenance.service.CustomerMaintenanceService;
import com.cardpay.mgt.manager.customermanager.model.TCustomerManager;
import com.cardpay.mgt.manager.customermanager.service.CustomerManagerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 客户维护controller
 *
 * @author wangpeng
 */
@Api(value = "/customerMaintenance", description = "客户维护")
@Controller
@RequestMapping("/customerMaintenance")
public class CustomerMaintenanceController extends BaseController<TCustomerMaintenance, Integer> {
    @Autowired
    private CustomerMaintenanceService customerMaintenanceService;

    @Autowired //客户Service
    private CustomerBasicService customerBasicService;

    @Autowired//客户经理Service
    private CustomerManagerService customerManagerService;

    /**
     * 维护类型
     *
     * @return 维护类型列表
     */
    @ResponseBody
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
    @ResponseBody
    @GetMapping("/maintenanceList")
    @ApiOperation(value = "获取客户维护记录列表", notes = "户维护记录", httpMethod = "GET")
    public ResultTo getMaintenanceList() {
        TCustomerMaintenance tCustomerMaintenance = new TCustomerMaintenance();
        tCustomerMaintenance.setOperationId(ShiroKit.getUserId());
        List<TCustomerMaintenance> list = customerMaintenanceService.select(tCustomerMaintenance);
        return new ResultTo().setData(list);
    }

    /**
     * 按条件查询客户维护信息
     *
     * @param tCustomerBasic 查询条件
     * @return 查询信息
     */
    @ResponseBody
    @GetMapping("/queryByCondition")
    @ApiOperation(value = "按条件查询客户维护列表", notes = "查询客户维护列表", httpMethod = "GET")
    public ResultTo queryByCondition(@ApiParam(value = "查询条件") @ModelAttribute TCustomerBasic tCustomerBasic) {
        //查询当前登录客户经理所属机构
        TCustomerManager tCustomerManager = new TCustomerManager();
        Integer managerId = ShiroKit.getUserId();
        tCustomerManager.setId(managerId);
        TCustomerManager manager = customerManagerService.selectOne(tCustomerManager);
        Integer organizationId = manager.getOrganizationId();

        //查询客户所属客户经理和所属机构信息
        TCustomerBasic tCustomerBasics = customerBasicService.selectOne(tCustomerBasic);
        Integer customerManagerId = tCustomerBasics.getCustomerManagerId();
        TCustomerManager customerManager = customerManagerService.selectByPrimaryKey(customerManagerId);
        Integer customerManagerOrganizationId = customerManager.getOrganizationId();

        //属于自己管辖 || 属于自己管理机构下的客户
        if (managerId.equals(customerManagerId) || organizationId.equals(customerManagerOrganizationId)) {
            TCustomerMaintenance tCustomerMaintenance = new TCustomerMaintenance();
            Integer tCustomerBasicsId = tCustomerBasics.getId();
            tCustomerMaintenance.setId(tCustomerBasicsId);
            List<TCustomerMaintenance> maintenanceList = customerMaintenanceService.select(tCustomerMaintenance);
            return new ResultTo().setData(maintenanceList);
        }
        return new ResultTo();
    }
}
