package com.cardpay.controller.product;

import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.product.model.ProductLoanMonitorRules;
import com.cardpay.mgt.product.service.ProductLoanMonitorRulesService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 产品贷后监控规则Controller
 *
 * @author rankai
 *         createTime 2016-12-2016/12/23 14:40
 */
@Controller
@RequestMapping("/api/productLoanMonitor")
@Api(value = "/api/productLoanMonitor", description = "产品贷后监控规则")
public class ProductLoanMonitorRulesController extends BaseController<ProductLoanMonitorRules> {

}
