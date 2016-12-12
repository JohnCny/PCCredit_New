package com.cardpay.controller.product;

import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.product.model.TProductApprove;
import com.cardpay.mgt.product.service.TProductApproveService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 产品审批流程Controller
 * Created by chenkai on 2016/12/12.
 */
@RestController
@RequestMapping("/productApprove")
@Api(value = "/productApprove", description = "产品审批流程Controller类")
public class TProductApproveController extends BaseController<TProductApprove, Integer> {
    @Autowired //产品审批流程Service
    private TProductApproveService tProductApproveService;
}
