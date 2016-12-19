package com.cardpay.controller.product;

import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.product.model.TProductType;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 产品类型Controller
 *
 * @author chenkai on 2016/12/13.
 */
@RestController
@RequestMapping("/productType")
@Api(value = "/productType", description = "产品类型")
public class ProductTypeController extends BaseController<TProductType, Integer> {
}
