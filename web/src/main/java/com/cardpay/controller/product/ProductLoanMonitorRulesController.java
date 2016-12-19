package com.cardpay.controller.product;

import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.product.model.TProductLoanMonitorRules;
import com.cardpay.mgt.product.service.TProductLoanMonitorRulesService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 产品贷后监控规则Controller类
 *
 * @author chenkai on 2016/12/12.
 */
@Controller
@RequestMapping("/productLoanMonitor")
@Api(value = "/productLoanMonitor", description = "产品贷后监控规则")
public class ProductLoanMonitorRulesController extends BaseController<TProductLoanMonitorRules, Integer> {
    @Autowired //产品贷后监控规则Service
    private TProductLoanMonitorRulesService tProductLoanMonitorRulesService;
}
