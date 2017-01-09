package com.cardpay.controller.user;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.basic.util.ErrorMessageUtil;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.user.model.Role;
import com.cardpay.mgt.user.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 角色控制层
 *
 * @author rankai
 *         create 2016-12-2016/12/21 10:22
 */
@RestController
@RequestMapping("/api/role")
@Api(value = "/api/role", description = "角色信息控制层")
public class RoleController extends BaseController<Role> {

    @Autowired
    private RoleService roleService;

    /**
     * 获取角色分页数据
     *
     * @return 角色分页数据
     */
    @PostMapping("/pageList")
    @ApiOperation(value = "获取角色分页数据", httpMethod = "POST")
    public DataTablePage pageList() {
        return dataTablePage();
    }

    /**
     * 增加角色页面跳转
     *
     * @return 增加角色页面
     */
    @GetMapping("/add")
    @ApiOperation(value = "增加角色页面跳转", httpMethod = "GET")
    public ResultTo addPage() {
        return new ResultTo().setData(roleService.selectAuthorityGroup());
    }

    /**
     * 成功或失败
     *
     * @param role         角色信息实体对象
     * @param result       BindingResult
     * @param authorityIds 权限ID数组
     * @return 成功或失败
     */
    @PostMapping
    @ApiOperation(value = "增加角色信息", httpMethod = "POST")
    public ResultTo add(Role role, BindingResult result, Integer authorityIds[]) {
        Map<String, String> map = new HashMap<>();
        if (ErrorMessageUtil.setValidErrorMessage(map, result)) {
            LogTemplate.info(this.getClass(), "message", "增加角色参数有误");
            return new ResultTo(ResultEnum.PARAM_ERROR).setData(map);
        }
        role.setCreateBy(ShiroKit.getUserId());
        role.setCreateTime(new Date());
        if (!roleService.insertRole(role, authorityIds)) {
            LogTemplate.info(this.getClass(), "message", "增加角色失败");
            return new ResultTo(ResultEnum.OPERATION_FAILED);
        }
        return new ResultTo();
    }

    /**
     * 编辑角色页面跳转
     *
     * @param roleId 角色ID
     * @return 角色信息
     */
    @RequestMapping(value = "/{roleId}", method = RequestMethod.GET)
    @ApiOperation(value = "根据角色ID获取角色的权限信息", httpMethod = "GET")
    public ResultTo updatePage(@PathVariable("roleId") Integer roleId) {
        LogTemplate.debug(this.getClass(), "roleId", roleId);
        Map<String, Object> map = new HashedMap();
        map.put("role", roleService.selectByPrimaryKey(roleId));
        map.put("authority", roleService.selectAuthority(roleId));
        return new ResultTo().setData(map);
    }

    /**
     * 更新角色实现
     *
     * @param role         角色实体
     * @param result       BindingResult
     * @param authorityIds 要更新的权限(旧权限ID,新权限ID),无权限权限为-1
     * @return 成功或失败
     */
    @PutMapping
    @ApiOperation(value = "更新角色信息", httpMethod = "PUT")
    public ResultTo update(Role role, BindingResult result, String authorityIds[]) {
        Map<String, String> map = new HashMap<>();
        if (ErrorMessageUtil.setValidErrorMessage(map, result)) {
            LogTemplate.info(this.getClass(), "message", "更新角色参数有误");
            return new ResultTo(ResultEnum.PARAM_ERROR).setData(map);
        }
        if (roleService.updateAuthorityIds(role, authorityIds)) {
            return new ResultTo();
        }
        return new ResultTo(ResultEnum.OPERATION_FAILED);
    }

    /**
     * 增加或修改角色拥有的权限,无权限传-1
     *
     * @param roleId         角色ID
     * @param oldAuthorityId 原权限ID
     * @param newAuthorityId 新权限ID
     * @return 成功或失败
     */
    @RequestMapping(method = RequestMethod.GET, params = {"roleId", "old", "new"})
    @ApiOperation(value = "获取权限组", httpMethod = "GET")
    public ResultTo update(@RequestParam(value = "roleId") Integer roleId,
                           @RequestParam(value = "old", defaultValue = "-1") Integer oldAuthorityId,
                           @RequestParam(value = "new", defaultValue = "-1") Integer newAuthorityId) {
        roleService.update(roleId, oldAuthorityId, newAuthorityId);
        return new ResultTo();
    }
}
