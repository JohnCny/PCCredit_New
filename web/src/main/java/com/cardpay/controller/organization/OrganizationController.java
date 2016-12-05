package com.cardpay.controller.organization;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.basic.util.ListSortUtil;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.organization.model.TOrganization;
import com.cardpay.mgt.organization.model.vo.TOrganizationVo;
import com.cardpay.mgt.organization.service.TOrganizationService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 机构Controller类
 * Created by chenkai on 2016/11/24.
 */
@Api(value = "/organization", description = "机构Controller类")
@RestController
@RequestMapping("/organization")
public class OrganizationController extends BaseController<TOrganization, Integer> {
    @Autowired
    private TOrganizationService tOrganizationService;

    @Autowired
    private static LogTemplate logger;

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
     * 递归删除层级信息
     * @param id 层级id
     * @return 1成功, 0失败
     */
    @RequestMapping(value = "/deleteOrganization", method = RequestMethod.DELETE)
    @ApiOperation(value = "递归删除层级接口", notes = "递归删除层级信息",  httpMethod = "DELETE")
    public ResultTo deleteOrganization(@ApiParam(value = "层级id", required = true) @RequestParam int id){
        int flag = tOrganizationService.deleteOrganization(id);
        logger.info(OrganizationController.class, "递归删除层级信息", "层级id:"+id);
        return new ResultTo().setData(flag);
    }
}
