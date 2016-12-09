package com.cardpay.controller.customermanagerday;

import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.customermanagerday.model.po.TCustomerManagerDay;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户经理日报controller
 * @author wangpeng
 */
@Api(value = "/customermanagerday", description = "客户经理日报")
@RestController
@RequestMapping("/customermanagerday")
public class CustomerManagerDayController extends BaseController<TCustomerManagerDay, Integer>  {
}
