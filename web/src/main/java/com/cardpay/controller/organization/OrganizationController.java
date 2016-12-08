package com.cardpay.controller.organization;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.basic.util.ListSortUtil;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.fastdfs.FileManager;
import com.cardpay.core.shrio.common.ShiroKit;
import com.cardpay.mgt.organization.model.TOrganization;
import com.cardpay.mgt.organization.model.vo.TOrganizationVo;
import com.cardpay.mgt.organization.service.TOrganizationService;
import com.cardpay.mgt.user.model.User;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Date;
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
     * @param parentId 要查询的顶级层级ID
     * @param level 查询层级信息数量
     * @return 机构层级信息
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ApiOperation(value = "查询机构层级信息接口", notes = "查询机构层级信息",  httpMethod = "GET")
    public ResultTo queryOrganization(@ApiParam(value = "要查询的顶级层级ID(默认最高级)")
                                          @RequestParam(value = "parentId", defaultValue = "0") int parentId
            , @ApiParam(value = "查询层级信息数量(默认1层)") @RequestParam(value = "level", defaultValue = "1") int level){
        List<TOrganizationVo> organization = tOrganizationService.queryOrganization(parentId, level);
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

    /**
     * 新增机构
     * @param orgName 机构名称
     * @param directorId 负责id
     * @param directorName  负责名称
     * @param logisticsId 后勤id
     * @return 机构id
     */
    @RequestMapping(value = "/insertOrganization", method = RequestMethod.POST)
    @ApiOperation(value = "新增机构接口", httpMethod = "POST", notes = "新增机构(默认新增机构为最顶级机构)")
    public ResultTo insertOrganization(@ApiParam(value = "机构名称", required = true) String orgName
            ,@ApiParam(value = "负责id", required = true) int directorId
            ,@ApiParam(value = "负责名称", required = true) String directorName
            ,@ApiParam(value = "后勤id", required = true) int logisticsId
            ,@ApiParam(value = "机构类型(0 法人机构 1 分支机构)", required = true) int orgType){
        TOrganization tOrganization = new TOrganization();
        tOrganization.setOrgId("1234");
        tOrganization.setOrgName(orgName);
        tOrganization.setOrgDirectorId(directorId);
        tOrganization.setOrgDirectorName(directorName);
        tOrganization.setOrgLogisticsId(logisticsId);
        tOrganization.setOrgLevel(orgType);
        tOrganization.setOrgParentId(0);
        tOrganization.setCreateBy(ShiroKit.getUserId());
        tOrganization.setCreateTime(new Date());
        tOrganizationService.insert(tOrganization);
        logger.info(OrganizationController.class, "新增机构", "机构id:"+tOrganization.getId());
        return new ResultTo().setData(tOrganization.getId());
    }



}
