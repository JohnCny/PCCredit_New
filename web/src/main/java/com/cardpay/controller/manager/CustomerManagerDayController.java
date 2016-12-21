package com.cardpay.controller.manager;

import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.manager.customermanagerday.model.TCustomerManagerDay;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户经理日报controller
 *
 * @author yanweichen
 */
@Api(value = "/customerManagerDay", description = "客户经理日报")
@RestController
@RequestMapping("/customerManagerDay")
public class CustomerManagerDayController extends BaseController<TCustomerManagerDay, Integer> {
}
