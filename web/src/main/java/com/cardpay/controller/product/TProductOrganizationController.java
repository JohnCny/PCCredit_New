package com.cardpay.controller.product;

import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.product.model.TProductOrganization;
import com.cardpay.mgt.product.service.TProductOrganizationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenkai on 2016/12/12.
 */
@RestController
@RequestMapping("/productOrganization")
@Api(value = "/productOrganization", description = "产品机构关联Controller类")
public class TProductOrganizationController extends BaseController<TProductOrganization, Integer> {
    @Autowired //产品机构关联Service
    private TProductOrganizationService tProductOrganizationService;
}
