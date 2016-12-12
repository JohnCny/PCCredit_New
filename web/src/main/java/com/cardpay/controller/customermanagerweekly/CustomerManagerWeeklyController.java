package com.cardpay.controller.customermanagerweekly;

import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.customermanagerweekly.model.po.TCustomerManagerWeekly;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户经理周报controller
 * @author wangpeng
 */
@Api(value = "/customermanagerweekly", description = "客户经理周报")
@RestController
@RequestMapping("/customermanagerweekly")
public class CustomerManagerWeeklyController extends BaseController<TCustomerManagerWeekly, Integer> {
}
