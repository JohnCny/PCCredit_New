package com.cardpay.controller.customermanager;

import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.customermanager.weekly.model.TCustomerManagerWeekly;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户经理周报controller
 *
 * @author yanweichen
 */
@Api(value = "/api/customerManagerWeekly", description = "客户经理周报")
@RestController
@RequestMapping("/api/customerManagerWeekly")
public class CustomerManagerWeeklyController extends BaseController<TCustomerManagerWeekly> {
}
