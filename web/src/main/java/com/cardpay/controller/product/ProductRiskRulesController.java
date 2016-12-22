package com.cardpay.controller.product;


import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.product.model.TProductRiskRules;
import com.cardpay.mgt.product.service.TProductRiskRulesService;
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
@RequestMapping("/productRisk")
@Api(value = "/productRisk", description = "产品贷后监控规则")
public class ProductRiskRulesController extends BaseController<TProductRiskRules> {
    @Autowired //产品产品风险规则Service
    private TProductRiskRulesService tProductRiskRulesService;
}
