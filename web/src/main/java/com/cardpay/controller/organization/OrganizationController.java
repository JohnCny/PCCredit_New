package com.cardpay.controller.organization;

import com.alibaba.fastjson.JSONArray;
import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.annotation.SystemControllerLog;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.core.shiro.enums.ShiroEnum;
import com.cardpay.mgt.menu.service.TMenuService;
import com.cardpay.mgt.organization.model.TOrganization;
import com.cardpay.mgt.organization.model.vo.TOrganizationVo;
import com.cardpay.mgt.organization.service.TOrganizationService;
import com.cardpay.mgt.user.model.User;
import com.cardpay.mgt.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 机构Controller类
 *
 * @author chenkai
 */
@Api(value = "/api/organization", description = "机构")
@RestController
@RequestMapping("/api/organization")
public class OrganizationController extends BaseController<TOrganization> {
    /**
     * 机构service
     */
    @Autowired
    private TOrganizationService tOrganizationService;

    @Autowired
    private UserService userService;

    /**
     * 菜单
     */
    @Autowired
    private TMenuService tMenuService;

    /**
     * 查询所有机构层级信息接口
     *
     * @param topId 顶级id
     * @return 所有机构层级信息
     */
    @GetMapping
    @ApiOperation(value = "查询所有机构层级信息接口", notes = "查询机构层级信息", httpMethod = "GET")
    public ResultTo queryOrganization(@ApiParam(value = "顶级ID(默认最高级开始)") @RequestParam(defaultValue = "0") int topId) {
        List<TOrganizationVo> organization;
        if (ShiroKit.getRole().getRoleType().equals(ShiroEnum.SUPER.getValue())) {
            organization = tOrganizationService.queryAll(topId);
        } else {
            organization = tOrganizationService.queryOrgChildren(ShiroKit.getTopOrgId());
        }
        return new ResultTo().setData(organization);
    }

    /**
     * 机构分页信息
     *
     * @return 机构列表
     */
    @PostMapping("/pageList")
    public DataTablePage pageList(@RequestParam(defaultValue = "0") int orgId) {
        Map<String, Object> map = new HashMap<>();
        map.put("orgId", orgId);
        return dataTablePage("selectOrganization", map);
    }

    /**
     * 删除机构以及其资机构信息
     *
     * @param organizationId 层级id
     * @return 1成功, 0失败
     */
    @SystemControllerLog("删除机构以及其资机构信息")
    @DeleteMapping("/{id}")
    @ApiOperation(value = "递归删除层级接口", notes = "删除机构以及其资机构信息", httpMethod = "DELETE")
    public ResultTo deleteOrganization(@ApiParam(value = "机构id", required = true) @PathVariable("id") int organizationId) {
        int flag = tOrganizationService.deleteOrganization(organizationId);
        LogTemplate.info(OrganizationController.class, "递归删除层级信息", "层级id:" + organizationId);
        return flag != 0 ? new ResultTo().setData(flag) : new ResultTo(ResultEnum.SERVICE_ERROR)
                .setDataMap("message", "请先移除此机构成员或其子机构");
    }

    /**
     * 新增机构
     *
     * @param tOrganization 机构信息
     * @return 机构id
     */
    @PostMapping
    @SystemControllerLog("新增机构")
    @ApiOperation(value = "新增机构接口", httpMethod = "POST", notes = "新增机构(默认新增机构为最顶级机构)")
    public ResultTo insertOrganization(@ApiParam("机构信息") @ModelAttribute TOrganization tOrganization
            , @ModelAttribute User user) {
        tOrganization.setCreateBy(ShiroKit.getUserId());
        tOrganization.setCreateTime(new Date());
        tOrganizationService.insertSelective(tOrganization);
        Integer tOrganizationId = tOrganization.getId();
        LogTemplate.info(OrganizationController.class, "新增机构", "机构id:" + tOrganizationId);
        int orgParentId = tOrganization.getOrgParentId();
        if (orgParentId == 0) {
            userService.addUserByOrg(user, tOrganizationId);
            tMenuService.initMenu(tOrganizationId);
            tOrganization.setOrgDirectorId(user.getId());
            tOrganization.setOrgDirectorName(user.getUserCname());
            tOrganizationService.updateSelectiveByPrimaryKey(tOrganization);
            tMenuService.updateMenuCache(tOrganizationId);
        }
        return new ResultTo().setData(tOrganizationId);
    }

    /**
     * 获取机构列表
     *
     * @return 机构列表
     */
    @GetMapping("/orgAll")
    public ResultTo getAllForTree() {
        List<TOrganization> tOrganizations = tOrganizationService.selectAll();
        return new ResultTo().setData(tOrganizations);
    }

    /**
     * 按id查询机构信息
     *
     * @param organizationId 机构Id
     * @return 机构信息
     */
    @GetMapping("/{id}")
    @SystemControllerLog("按id查询机构信息")
    @ApiOperation(value = "按id查询机构信息", notes = "按id查询机构信息", httpMethod = "GET")
    public ResultTo queryById(@ApiParam(value = "机构id", required = true) @PathVariable("id") int organizationId) {
        TOrganizationVo tOrganizationVos = tOrganizationService.queryByOrgId(organizationId);
        return new ResultTo().setData(tOrganizationVos);
    }

    /**
     * 更新机构信息
     *
     * @param tOrganization 机构信息
     * @return 数据库变记录
     */
    @PutMapping
    @SystemControllerLog("更新机构信息")
    @ApiOperation(value = "更新机构信息", notes = "更新机构信息", httpMethod = "PUT")
    public ResultTo update(@ApiParam("机构信息") @ModelAttribute TOrganization tOrganization) {
        Integer count = tOrganizationService.updateSelectiveByPrimaryKey(tOrganization);
        return count != 0 ? new ResultTo().setData(count) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 拖拽更新机构层级信息
     *
     * @param organization 机构信息
     * @return 数据库变记录
     */
    @PutMapping("/move")
    @SystemControllerLog("拖拽更新机构层级信息")
    @ApiOperation(value = "更新机构信息", notes = "更新机构信息", httpMethod = "PUT")
    public ResultTo move(@ApiParam("机构信息") @RequestBody String organization) {
        List<TOrganization> tOrganizations = JSONArray.parseArray(organization, TOrganization.class);
        int flag = 0;
        for (TOrganization tOrganization : tOrganizations) {
            flag = tOrganizationService.updateSelectiveByPrimaryKey(tOrganization);
            flag++;
        }
        return flag != 0 ? new ResultTo().setData(flag) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 查询此用户负责的机构信息
     *
     * @return 机构信息
     */
    @GetMapping("/principalOrganization")
    public ResultTo bossTeam() {
        List<TOrganization> organizationList = tOrganizationService.queryIfOrgPrincipal(ShiroKit.getUserId());
        return new ResultTo().setData(organizationList);
    }

}
