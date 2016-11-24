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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 机构Controller类
 * Created by chenkai on 2016/11/24.
 */
@Api(value = "/api/organization", description = "机构Controller类")
@RestController
@RequestMapping("/api/organization")
public class TOrganizationController extends BaseController<TOrganization, Integer> {
    @Autowired
    @Qualifier("TOrganizationServiceImpl")
    private TOrganizationService tOrganizationService;

    /**
     * 查询机构层级信息接口
     * @param id 要查询的顶级层级ID
     * @param level 查询层级信息数量
     * @return 机构层级信息
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiOperation(value = "查询机构层级信息接口", notes = "查询机构层级信息",  httpMethod = "GET")
    public ResultTo queryOrganization(@ApiParam(value = "要查询的顶级层级ID")
                                          @RequestParam(value = "id", defaultValue = "0") int id
            , @ApiParam(value = "查询层级信息数量") @RequestParam(value = "level", defaultValue = "0") int level){
        List<TOrganizationVo> organization = tOrganizationService.queryOrganization(id, level);
        return new ResultTo().setData(organization);
    }

    /**
     * 变更层级位置接口
     * @param id 层级id
     * @param parentId 父层级id
     * @return 1成功, 0失败
     */
    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @ApiOperation(value = "变更层级位置接口", notes = "更新层级所在的层级位置",  httpMethod = "PUT")
    public ResultTo updateOrganization(@ApiParam(value = "层级id", required = true) @RequestParam int id
                , @ApiParam(value = "父层级id", required = true) @RequestParam int parentId){
        int flag = tOrganizationService.updateOrganization(id, parentId);
        return new ResultTo().setData(flag);
    }

    /**
     * 递归删除层级信息
     * @param id 层级id
     * @return 1成功, 0失败
     */
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    @ApiOperation(value = "递归删除层级接口", notes = "递归删除层级信息",  httpMethod = "DELETE")
    public ResultTo deleteOrganization(@ApiParam(value = "层级id", required = true) @RequestParam int id){
        int flag = tOrganizationService.deleteOrganization(id);
        return new ResultTo().setData(flag);
    }

}
