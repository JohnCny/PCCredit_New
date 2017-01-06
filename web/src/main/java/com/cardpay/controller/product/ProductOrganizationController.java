package com.cardpay.controller.product;

import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.product.model.ProductOrganization;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 产品机构关联Controller
 *
 * @author rankai
 *         createTime 2016-12-2016/12/23 14:40
 */
@Controller
@RequestMapping("/api/productOrganization")
@Api(value = "/api/productOrganization", description = "产品机构关联")
public class ProductOrganizationController extends BaseController<ProductOrganization> {


}
