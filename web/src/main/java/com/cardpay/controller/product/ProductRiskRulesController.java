package com.cardpay.controller.product;


import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.product.model.ProductRiskRules;
import com.cardpay.mgt.product.service.ProductRiskRulesService;
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
@RequestMapping("/api/productRisk")
@Api(value = "/api/productRisk", description = "产品贷后监控规则")
public class ProductRiskRulesController extends BaseController<ProductRiskRules> {

}
