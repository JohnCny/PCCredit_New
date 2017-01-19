package com.cardpay.controller.product;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.util.ErrorMessageUtil;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.product.model.ProductLoanMonitorRules;
import com.cardpay.mgt.product.service.ProductLoanService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 产品贷后监控规则Controller
 *
 * @author rankai
 */
@RestController
@RequestMapping("/api/productLoan")
@Api(value = "/api/productLoan", description = "产品贷后监控规则")
public class ProductLoanController extends BaseController<ProductLoanMonitorRules> {

    @Autowired
    private ProductLoanService productLoanService;

    /**
     * 增加产品贷后页面数据
     *
     * @param productId 产品ID
     * @return 产品贷后页面数据
     */
    @RequestMapping(value = "/{productId}", method = RequestMethod.GET)
    @ApiOperation(value = "增加产品贷后页面数据", httpMethod = "GET")
    public ResultTo loan(@PathVariable("productId") Integer productId) {
        return new ResultTo();
    }

    /**
     * 增加产品贷后
     *
     * @param productLoanMonitorRules ProductLoanMonitorRules实体对象
     * @param result                  BindingResult
     * @param productId               产品ID
     * @return 成功或失败
     */
    @PostMapping
    @ApiOperation(value = "增加产品贷后", httpMethod = "POST")
    public ResultTo loan(ProductLoanMonitorRules productLoanMonitorRules, BindingResult result,
                         @RequestParam("productId") Integer productId) {
        Map<String, String> map = new HashedMap();
        if (ErrorMessageUtil.setValidErrorMessage(map, result)) {
            return new ResultTo(ResultEnum.PARAM_ERROR).setData(map);
        }
        productLoanMonitorRules.setProductId(productId);
        productLoanService.insertSelective(productLoanMonitorRules);
        return new ResultTo();
    }

    /**
     * 编辑页面所需要的数据
     *
     * @param productId 产品ID
     * @return 产品贷后页面数据
     */
    @GetMapping(params = "productId")
    @ApiOperation(value = "增加产品贷后页面数据", httpMethod = "GET")
    public ResultTo updateGet(@RequestParam("productId") Integer productId) {
        ProductLoanMonitorRules productLoanMonitorRules = new ProductLoanMonitorRules();
        productLoanMonitorRules.setProductId(productId);
        return new ResultTo().setData(productLoanService.selectOne(productLoanMonitorRules));
    }

    /**
     * 编辑产品贷后
     *
     * @param productLoanMonitorRules ProductLoanMonitorRules
     * @param result                  BindingResult
     * @return 成功或失败
     */
    @PutMapping
    @ApiOperation(value = "编辑产品贷后", httpMethod = "PUT")
    public ResultTo update(ProductLoanMonitorRules productLoanMonitorRules, BindingResult result) {
        Map<String, String> map = new HashedMap();
        if (ErrorMessageUtil.setValidErrorMessage(map, result)) {
            return new ResultTo(ResultEnum.PARAM_ERROR).setData(map);
        }
        productLoanService.updateSelectiveByPrimaryKey(productLoanMonitorRules);
        return new ResultTo();
    }
}
