package com.cardpay.controller.product;

import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.product.model.ProductType;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 产品类型Controller
 *
 * @author rankai
 */
@RestController
@RequestMapping("/api/productType")
@Api(value = "/api/productType", description = "产品类型")
public class ProductTypeController extends BaseController<ProductType> {
}
