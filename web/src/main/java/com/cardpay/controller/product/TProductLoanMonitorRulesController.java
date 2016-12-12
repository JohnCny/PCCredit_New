package com.cardpay.controller.product;

import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.product.model.TProductLoanMonitorRules;
import com.cardpay.mgt.product.service.TProductLoanMonitorRulesService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 产品贷后监控规则Controller类
 * Created by chenkai on 2016/12/12.
 */
@RestController
@RequestMapping("/productLoanMonitor")
@Api(value = "/productLoanMonitor", description = "产品贷后监控规则Controller类")
public class TProductLoanMonitorRulesController extends BaseController<TProductLoanMonitorRules, Integer> {
    @Autowired //产品贷后监控规则Service
    private TProductLoanMonitorRulesService tProductLoanMonitorRulesService;
}
