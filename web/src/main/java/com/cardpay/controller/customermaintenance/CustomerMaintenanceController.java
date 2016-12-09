package com.cardpay.controller.customermaintenance;

import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.customermaintenance.model.po.TCustomerMaintenance;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户维护controller
 * @author wangpeng
 */
@Api(value = "/customermaintenance", description = "客户维护")
@RestController
@RequestMapping("/customermaintenance")
public class CustomerMaintenanceController extends BaseController<TCustomerMaintenance, Long> {
}
