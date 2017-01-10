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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 产品贷后监控规则Controller
 *
 * @author rankai
 */
@Controller
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
    @RequestMapping(value = "/{productId}/loan", method = RequestMethod.GET)
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
    @PostMapping(value = "/loan")
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

}
