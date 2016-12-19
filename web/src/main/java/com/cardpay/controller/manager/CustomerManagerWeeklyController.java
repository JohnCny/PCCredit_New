package com.cardpay.controller.manager;

import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.manager.customermanagerweekly.model.TCustomerManagerWeekly;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户经理周报controller
 *
 * @author wangpeng
 */
@Api(value = "/customerManagerWeekly", description = "客户经理周报")
@RestController
@RequestMapping("/customerManagerWeekly")
public class CustomerManagerWeeklyController extends BaseController<TCustomerManagerWeekly, Integer> {
}
