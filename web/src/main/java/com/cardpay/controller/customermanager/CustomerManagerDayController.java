package com.cardpay.controller.customermanager;

import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.customermanager.daily.model.TCustomerManagerDay;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户经理日报controller
 *
 * @author yanweichen
 */
@Api(value = "/api/customerManagerDay", description = "客户经理日报")
@RestController
@RequestMapping("/api/customerManagerDay")
public class CustomerManagerDayController extends BaseController<TCustomerManagerDay> {
}
