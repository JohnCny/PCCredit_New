package com.cardpay.controller.organization;

import com.alibaba.fastjson.JSONArray;
import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.menu.model.TMenu;
import com.cardpay.mgt.organization.model.TOrganization;
import com.cardpay.mgt.organization.model.vo.TOrganizationVo;
import com.cardpay.mgt.organization.service.TOrganizationService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 机构Controller类
 *
 * @author chenkai on 2016/11/24.
 */
@Api(value = "/organization", description = "机构")
@Controller
@RequestMapping("/organization")
public class OrganizationController extends BaseController<TOrganization> {
    @Autowired
    private TOrganizationService tOrganizationService;

    @Autowired
    private static LogTemplate logger;

    /**
     * 查询所有机构层级信息接口
     *
     * @param topId 顶级id
     * @return 所有机构层级信息
     */
    @ResponseBody
    @GetMapping
    @ApiOperation(value = "查询所有机构层级信息接口", notes = "查询机构层级信息", httpMethod = "GET")
    public ResultTo queryOrganization(@ApiParam(value = "顶级ID(默认最高级开始)") @RequestParam(defaultValue = "0") int topId) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("topId", topId);
        List<TOrganizationVo> organization = tOrganizationService.queryAll(map);
        return new ResultTo().setData(organization);
    }

    /**
     * 删除机构以及其资机构信息
     *
     * @param organizationId 层级id
     * @return 1成功, 0失败
     */
    @ResponseBody
    @DeleteMapping("/{id}")
    @ApiOperation(value = "递归删除层级接口", notes = "删除机构以及其资机构信息", httpMethod = "DELETE")
    public ResultTo deleteOrganization(@ApiParam(value = "层级id", required = true) @PathVariable("id") int organizationId) {
        int flag = tOrganizationService.deleteOrganization(organizationId);
        logger.info(OrganizationController.class, "递归删除层级信息", "层级id:" + organizationId);
        return new ResultTo().setData(flag);
    }

    /**
     * 新增机构
     *
     * @param tOrganization 机构信息
     * @return 机构id
     */
    @ResponseBody
    @PostMapping
    @ApiOperation(value = "新增机构接口", httpMethod = "POST", notes = "新增机构(默认新增机构为最顶级机构)")
    public ResultTo insertOrganization(@ApiParam("机构信息") @ModelAttribute TOrganization tOrganization) {
        tOrganization.setOrgParentId(0);
        tOrganization.setCreateBy(ShiroKit.getUserId());
        tOrganization.setCreateTime(new Date());
        tOrganizationService.insertSelective(tOrganization);
        logger.info(OrganizationController.class, "新增机构", "机构id:" + tOrganization.getId());
        return new ResultTo().setData(tOrganization.getId());
    }

    /**
     * 获取机构列表
     *
     * @return 机构列表
     */
    @GetMapping("/orgAll")
    @ResponseBody
    @ApiOperation(value = "根据父ID获取机构列表", httpMethod = "GET", notes = "默认父ID为0")
    public ResultTo getAllForTree() {
        List<TOrganization> tOrganizations = tOrganizationService.selectAll();
        return new ResultTo().setData(tOrganizations);
    }

    /**
     * 跳转机构管理主页
     *
     * @return 跳转机构管理主页
     */
    @GetMapping("/toAdd")
    @ApiOperation(value = "跳转机构管理主页", notes = "跳转机构管理主页", httpMethod = "GET")
    public ModelAndView toAdd() {
        return new ModelAndView("/organization/insert");
    }

    /**
     * 跳转机构管理主页
     *
     * @return 跳转机构管理主页
     */
    @GetMapping("/index")
    @ApiOperation(value = "跳转机构管理主页", notes = "跳转机构管理主页", httpMethod = "GET")
    public ModelAndView index() {
        return new ModelAndView("/organization/index");
    }

    /**
     * 机构分页信息
     *
     * @return
     */
    @GetMapping("/pageList")
    @ResponseBody
    @ApiOperation(value = "机构分页信息", notes = "机构分页信息", httpMethod = "GET")
    public DataTablePage pageList() {
        return dataTablePage("queryAll");
    }

    /**
     * 按id查询机构信息
     *
     * @param organizationId 机构Id
     * @return 机构信息
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "按id查询机构信息", notes = "按id查询机构信息", httpMethod = "GET")
    public ModelAndView queryById(@ApiParam(value = "机构id", required = true) @PathVariable("id") int organizationId) {
        ModelAndView modelAndView = new ModelAndView("/organization/update");
        TOrganization tOrganization = tOrganizationService.selectByPrimaryKey(organizationId);
        modelAndView.addObject("tOrganization", tOrganization);
        return modelAndView;
    }

    /**
     * 更新机构信息
     *
     * @param tOrganization 机构信息
     * @return 数据库变记录
     */
    @PutMapping
    @ResponseBody
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
    @ResponseBody
    @ApiOperation(value = "更新机构信息", notes = "更新机构信息", httpMethod = "PUT")
    public ResultTo move(@ApiParam("机构信息") @RequestBody String organization) {
        List<TOrganization> tOrganizations = JSONArray.parseArray(organization, TOrganization.class);
        for (TOrganization tOrganization : tOrganizations) {
            tOrganizationService.updateSelectiveByPrimaryKey(tOrganization);
        }
        return new ResultTo();
    }
}
