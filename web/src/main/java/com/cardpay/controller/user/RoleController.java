package com.cardpay.controller.user;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.basic.util.ErrorMessageUtil;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.user.model.Authority;
import com.cardpay.mgt.user.model.Role;
import com.cardpay.mgt.user.model.vo.AuthorityGroup;
import com.cardpay.mgt.user.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 角色控制层
 *
 * @author rankai
 * @create 2016-12-2016/12/21 10:22
 */
@Controller
@RequestMapping("/role")
@Api(value = "/role", description = "角色信息控制层")
public class RoleController extends BaseController<Role> {

    private static final String ROLE_PAGE = "/role/index";

    private static final String ROLE_ADD_PAGE = "/role/add";

    private static final String ROLE_UPDATE_PAGE = "/role/update";

    @Autowired
    private RoleService roleService;

    /**
     * 角色管理列表跳转
     *
     * @return 角色管理页面
     */
    @GetMapping("/rolePage")
    @ApiResponses({@ApiResponse(code = 405, message = "请求类型错误"), @ApiResponse(code = 500, message = "服务器异常")})
    @ApiOperation(value = "角色管理列表跳转", httpMethod = "GET")
    public String listPage() {
        return ROLE_PAGE;
    }

    /**
     * 获取角色分页数据
     *
     * @return 角色分页数据
     */
    @GetMapping("/pageList")
    @ApiResponses({@ApiResponse(code = 405, message = "请求类型错误"), @ApiResponse(code = 500, message = "服务器异常")})
    @ApiOperation(value = "获取角色分页数据", httpMethod = "GET")
    @ResponseBody
    public DataTablePage pageList() {
        return dataTablePage();
    }

    /**
     * 增加角色页面跳转
     *
     * @return 增加角色页面
     */
    @ApiResponses({@ApiResponse(code = 405, message = "请求类型错误"), @ApiResponse(code = 500, message = "服务器异常")})
    @ApiOperation(value = "增加角色页面跳转", httpMethod = "GET")
    @GetMapping("/addPage")
    public String addPage(ModelMap map) {
        map.put("authorityGroup", roleService.selectAuthorityGroup());
        return ROLE_ADD_PAGE;
    }

    /**
     * 增加角色时获取的权限组信息
     *
     * @return 权限组信息
     */
    @GetMapping(value = "/add")
    @ApiResponses({@ApiResponse(code = 405, message = "请求类型错误"), @ApiResponse(code = 500, message = "服务器异常")})
    @ApiOperation(value = "获取权限组", httpMethod = "GET")
    @ResponseBody
    public ResultTo authorityGroup() {
        List<AuthorityGroup> authorityGroups = roleService.selectAuthorityGroup();
        return new ResultTo().setData(authorityGroups);
    }

    /**
     * 成功或失败
     *
     * @param role 角色信息实体对象
     * @return 成功或失败
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @ApiResponses({@ApiResponse(code = 405, message = "请求类型错误"), @ApiResponse(code = 500, message = "服务器异常")})
    @ApiOperation(value = "增加角色信息", httpMethod = "POST")
    @ResponseBody
    public ResultTo add(@ApiParam("角色实体对象") Role role, BindingResult result, @ApiParam("权限ID数组") Integer authorityId[]) {
        Map<String, String> map = new HashMap<>();
        if (ErrorMessageUtil.setValidErrorMessage(map, result)) {
            LogTemplate.info(this.getClass(), "message", "增加角色参数有误");
            return new ResultTo(ResultEnum.PARAM_ERROR).setData(map);
        }
        if (!roleService.insertRole(role, authorityId)) {
            LogTemplate.info(this.getClass(), "message", "增加角色失败");
            return new ResultTo(ResultEnum.OPERATION_FAILED);
        }
        return new ResultTo();
    }

    /**
     * 根据角色ID获取角色信息
     *
     * @param roleId 角色ID
     * @return 角色信息
     */
    @RequestMapping(value = "/{roleId}/page", method = RequestMethod.GET)
    @ApiResponses({@ApiResponse(code = 405, message = "请求类型错误"), @ApiResponse(code = 500, message = "服务器异常")})
    @ApiOperation(value = "根据角色ID获取角色的权限信息", httpMethod = "GET")
    @ResponseBody
    public ResultTo updatePage(@ApiParam("角色ID") @PathVariable("roleId") Integer roleId) {
        Role role = roleService.selectByPrimaryKey(roleId);
        List<AuthorityGroup> list = roleService.selectRole(roleId);
        Map<String, Object> map = new HashedMap();
        map.put("role", role);
        map.put("authority", list);
        return new ResultTo().setData(map);
    }


    /**
     * 角色编辑页面跳转
     *
     * @return 角色编辑页面
     */
    @ApiResponses({@ApiResponse(code = 405, message = "请求类型错误"), @ApiResponse(code = 500, message = "服务器异常")})
    @ApiOperation(value = "角色编辑页面跳转", httpMethod = "GET")
    @GetMapping("/updatePage")
    public String updatePage() {
        return ROLE_UPDATE_PAGE;
    }

    /**
     * 根据权限分组名获取权限操作集合
     *
     * @param groupName
     * @return 权限操作集合
     */
    @RequestMapping(value = "/{groupName}/update", method = RequestMethod.GET)
    @ApiResponses({@ApiResponse(code = 405, message = "请求类型错误"), @ApiResponse(code = 500, message = "服务器异常")})
    @ApiOperation(value = "获取权限组", httpMethod = "POST")
    @ResponseBody
    public ResultTo operationList(@ApiParam("权限组名") @PathVariable("groupName") String groupName) {
        List<Authority> list = roleService.selectOperationList(groupName);
        return new ResultTo().setData(list);
    }

    /**
     * 增加或修改角色拥有的权限
     *
     * @param roleId         角色ID
     * @param oldAuthorityId 原权限ID
     * @param newAuthorityId 新权限ID
     * @return 成功或失败
     */
    @RequestMapping(method = RequestMethod.GET, params = {"roleId", "oldAuthorityId", "newAuthorityId"})
    @ApiResponses({@ApiResponse(code = 405, message = "请求类型错误"), @ApiResponse(code = 500, message = "服务器异常")})
    @ApiOperation(value = "获取权限组", httpMethod = "GET")
    @ResponseBody
    public ResultTo update(@ApiParam("角色ID") @RequestParam(value = "roleId") Integer roleId,
                           @ApiParam("原权限ID") @RequestParam(value = "oldAuthorityId", defaultValue = "-1") Integer oldAuthorityId,
                           @ApiParam("新权限ID") @RequestParam(value = "newAuthorityId", defaultValue = "-1") Integer newAuthorityId) {
        roleService.update(roleId, oldAuthorityId, newAuthorityId);
        return new ResultTo();
    }
}
