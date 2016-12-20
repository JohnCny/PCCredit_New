package com.cardpay.controller.manager;

import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.manager.customermanager.model.TCustomerManager;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户经理管理controller
 *
 * @author wangpeng
 */
@Api(value = "/customerManager", description = "客户经理管理")
@RestController
@RequestMapping("/customerManager")
public class CustomerManagerController extends BaseController<TCustomerManager, Integer> {
}
