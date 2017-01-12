package com.cardpay.controller.product;


import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.util.ErrorMessageUtil;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.product.model.Product;
import com.cardpay.mgt.product.model.ProductRiskRules;
import com.cardpay.mgt.product.service.ProductRiskService;
import com.cardpay.mgt.product.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 产品贷后监控规则Controller
 *
 * @author rankai
 */
@RestController
@RequestMapping("/api/productRisk")
@Api(value = "/api/productRisk", description = "产品风险属性")
public class ProductRiskController extends BaseController<ProductRiskRules> {

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductRiskService productRiskService;

    /**
     * 增加产品风险控制规则
     *
     * @param productRiskRules ProductRiskRules
     * @param result           BindingResult
     * @param productId        产品ID
     * @return 成功或失败
     */
    @PostMapping
    @ApiOperation(value = "增加产品风险属性", httpMethod = "POST")
    public ResultTo risk(ProductRiskRules productRiskRules, BindingResult result,
                         @RequestParam("productId") Integer productId) {
        Map<String, String> map = new HashedMap();
        if (ErrorMessageUtil.setValidErrorMessage(map, result)) {
            return new ResultTo(ResultEnum.PARAM_ERROR).setData(map);
        }
        productRiskRules.setProductId(productId);
        productRiskService.insertSelective(productRiskRules);
        Product product = productService.selectByPrimaryKey(productId);
        product.setProductState(1);
        productService.updateSelectiveByPrimaryKey(product);
        return new ResultTo();
    }
}
