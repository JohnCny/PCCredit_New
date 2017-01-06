package com.cardpay.controller.product;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.product.model.ProductApprove;
import com.cardpay.mgt.product.service.ProductApproveService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 产品审批流程Controller
 *
 * @author rankai
 *         createTime 2016-12-2016/12/23 14:40
 */
@Controller
@RequestMapping("/api/productApprove")
@Api(value = "/api/productApprove", description = "产品审批流程")
public class ProductApproveController extends BaseController<ProductApprove> {


}
