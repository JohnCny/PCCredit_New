package com.cardpay.controller.organization;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.organization.model.TOrganization;
import com.cardpay.mgt.organization.model.TOrganizationVo;
import com.cardpay.mgt.organization.service.TOrganizationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * 机构Controller类
 * Created by chenkai on 2016/11/24.
 */
@Api(value = "/organization", description = "机构Controller类")
@Controller
@RequestMapping("/organization")
public class OrganizationController extends BaseController<TOrganization> {
    @Autowired
    private TOrganizationService tOrganizationService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiOperation(value = "查询机构接口", notes = "查询机构层级信息",  httpMethod = "GET", produces = "application/json")
    public ResultTo selectMenuList(@ApiParam(value = "查询层级数量") int level){
        ResultTo resultTo = new ResultTo();
        List<TOrganizationVo> organization = tOrganizationService.queryOrganization(0,level);
        resultTo.setData(organization);
        return resultTo;
    }
}
