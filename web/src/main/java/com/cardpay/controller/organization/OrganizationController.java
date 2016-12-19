package com.cardpay.controller.organization;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.organization.model.TOrganization;
import com.cardpay.mgt.organization.model.vo.TOrganizationVo;
import com.cardpay.mgt.organization.service.TOrganizationService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * 机构Controller类
 *
 * @author chenkai on 2016/11/24.
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
     * 动态查询机构层级信息接口
     *
     * @param parentId 要查询的顶级层级ID
     * @param level    查询层级信息数量
     * @return 机构层级信息
     */
    @GetMapping("/movementOrganization")
    @ApiOperation(value = "动态查询机构层级信息接口", notes = "查询机构层级信息", httpMethod = "GET")
    public ResultTo changeQueryOrganization(@ApiParam(value = "要查询的顶级层级ID(默认最高级)")
                                            @RequestParam(value = "parentId", defaultValue = "0") int parentId
            , @ApiParam(value = "查询层级信息数量(默认1层)") @RequestParam(value = "level", defaultValue = "1") int level) {
        List<TOrganizationVo> organization = tOrganizationService.queryOrganization(parentId, level);
        return new ResultTo().setData(organization);
    }

    /**
     * 查询所有机构层级信息接口
     *
     * @param topId 顶级id
     * @return 所有机构层级信息
     */
    @GetMapping("/")
    @ApiOperation(value = "查询所有机构层级信息接口", notes = "查询机构层级信息", httpMethod = "GET")
    public ResultTo queryOrganization(@ApiParam(value = "顶级ID(默认最高级开始)") @RequestParam(defaultValue = "0") int topId) {
        List<TOrganizationVo> organization = tOrganizationService.queryAll(topId);
        return new ResultTo().setData(organization);
    }

    /**
     * 递归删除层级信息
     *
     * @param id 层级id
     * @return 1成功, 0失败
     */
    @DeleteMapping("/")
    @ApiOperation(value = "递归删除层级接口", notes = "递归删除层级信息", httpMethod = "DELETE")
    public ResultTo deleteOrganization(@ApiParam(value = "层级id", required = true) @RequestParam int id) {
        int flag = tOrganizationService.deleteOrganization(id);
        logger.info(OrganizationController.class, "递归删除层级信息", "层级id:" + id);
        return new ResultTo().setData(flag);
    }

    /**
     * 新增机构
     *
     * @param tOrganization 机构信息
     * @return 机构id
     */
    @PostMapping("/")
    @ApiOperation(value = "新增机构接口", httpMethod = "POST", notes = "新增机构(默认新增机构为最顶级机构)")
    public ResultTo insertOrganization(@ApiParam("机构信息") @ModelAttribute TOrganization tOrganization) {
        tOrganization.setOrgId("1234");
        tOrganization.setOrgParentId(0);
        tOrganization.setCreateBy(ShiroKit.getUserId());
        tOrganization.setCreateTime(new Date());
        tOrganizationService.insertSelective(tOrganization);
        logger.info(OrganizationController.class, "新增机构", "机构id:" + tOrganization.getId());
        return new ResultTo().setData(tOrganization.getId());
    }
}
