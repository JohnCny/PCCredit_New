package com.cardpay.controller.customerbasic;

import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.customerbasic.model.po.TCustomerBasic;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户controller
 * @author wangpeng
 */
@Api(value = "/customerbasic", description = "客户")
@RestController
@RequestMapping("/customerbasic")
public class CustomerBasicController extends BaseController<TCustomerBasic, Long> {
}
