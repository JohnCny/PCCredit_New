package com.cardpay.controller.product;

import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.product.model.TProductApprove;
import com.cardpay.mgt.product.service.TProductApproveService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 产品审批流程Controller
 *
 * @author chenkai on 2016/12/12.
 */
@Controller
@RequestMapping("/productApprove")
@Api(value = "/productApprove", description = "产品审批流程")
public class ProductApproveController extends BaseController<TProductApprove> {
    @Autowired //产品审批流程Service
    private TProductApproveService tProductApproveService;
}
