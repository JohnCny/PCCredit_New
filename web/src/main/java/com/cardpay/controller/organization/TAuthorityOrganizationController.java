package com.cardpay.controller.organization;

import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.organization.model.TAuthorityOrganization;
import com.cardpay.mgt.organization.service.TAuthorityOrganizationService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 权限机构关联表Controller类
 * Created by chenkai on 2016/11/24.
 */
@Api(value = "/api/tAuthorityOrganization", description = "权限机构关联表Controller类")
@Controller
@RequestMapping("/api/tAuthorityOrganization")
public class TAuthorityOrganizationController extends BaseController<TAuthorityOrganization, Integer>{
    @Autowired
    @Qualifier("TAuthorityOrganizationServiceImpl")
    private TAuthorityOrganizationService tAuthorityOrganizationService;



}
