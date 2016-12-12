package com.cardpay.controller.CustomerManager;

import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.customermanager.model.po.TCustomerManager;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户经理管理controller
 * @author wangpeng
 */
@Api(value = "/customermanager", description = "客户经理管理")
@RestController
@RequestMapping("/customermanager")
public class CustomerManagerController extends BaseController<TCustomerManager, Long> {
}
