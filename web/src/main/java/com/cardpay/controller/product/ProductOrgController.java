package com.cardpay.controller.product;

import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.product.model.ProductOrganization;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 产品机构关联Controller
 *
 * @author rankai
 */
@RestController
@RequestMapping("/api/productOrg")
@Api(value = "/api/productOrg", description = "产品机构关联")
public class ProductOrgController extends BaseController<ProductOrganization> {


}
