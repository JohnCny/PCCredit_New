package com.cardpay.controller.user;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.basic.util.ErrorMessageUtil;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.PasswordUtil;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.organization.service.TOrganizationService;
import com.cardpay.mgt.user.model.User;
import com.cardpay.mgt.user.model.UserOrganization;
import com.cardpay.mgt.user.model.UserRole;
import com.cardpay.mgt.user.service.RoleService;
import com.cardpay.mgt.user.service.UserOrganizationService;
import com.cardpay.mgt.user.service.UserRoleService;
import com.cardpay.mgt.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * 用户控制层
 *
 * @author rankai
 * @create 2016-12-2016/12/21 10:22
 */
@Controller
@RequestMapping("/user")
@Api(value = "/user", description = "用户控制层")
public class UserController extends BaseController<User> {

    private static final String UPDATE_PASSWORD_PAGE = "/user/changePassword";

    private static final String RESET_PASSWORD_PAGE = "/user/forget";

    private static final String RESET_PASSWORD_SEND = "/user/forgetSend";

    private static final String RESET_PASSWORD_CHECKED = "/user/forgetChecked";

    private static final String USER_INDEX = "/user/index";

    private static final String USER_ROLE = "/user/role";

    private static final String ADD_USER = "/user/add";

    private static final String UPDATE_USER = "/user/update";

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private UserOrganizationService userOrganizationService;

    @Autowired
    private TOrganizationService organizationService;


    /**
     * 跳转用户列表页面
     *
     * @return 用户列表页面
     */
    @GetMapping()
    @ApiResponses(value = {@ApiResponse(code = 405, message = "请求类型异常"), @ApiResponse(code = 500, message = "服务器异常")})
    @ApiOperation(value = "用户列表页面", httpMethod = "GET")
    public String userPage() {
        return USER_INDEX;
    }

    /**
     * 用户分页
     *
     * @return 分页后的数据
     */
    @GetMapping("/pageList")
    @ResponseBody
    @ApiResponses(value = {@ApiResponse(code = 405, message = "请求类型异常"), @ApiResponse(code = 500, message = "服务器异常")})
    @ApiOperation(value = "用户分页数据", httpMethod = "GET")
    public DataTablePage pageList() {
        return dataTablePage("userPageList");
    }

    /**
     * 用户异步更新
     *
     * @param user User对象
     * @return 成功或失败
     */
    @PutMapping("/lock")
    @ResponseBody
    @ApiResponses(value = {@ApiResponse(code = 405, message = "请求类型异常"), @ApiResponse(code = 500, message = "服务器异常")})
    @ApiOperation(value = "用户异步更新", httpMethod = "GET")
    public ResultTo update(User user) {
        if (StringUtils.isNotEmpty(user.getPassword())) {
            user.setPassword(ShiroKit.DEFAULT_PASSWORD);
            PasswordUtil.encryptPassword(user);
        }
        if (userService.updateSelectiveByPrimaryKey(user) > 0) {
            return new ResultTo();
        }
        return new ResultTo(ResultEnum.OPERATION_FAILED);
    }

    /**
     * 增加用户页面跳转
     *
     * @param map ModelMap对象
     * @return 增加用户页面
     */
    @ApiResponses(value = {@ApiResponse(code = 405, message = "请求类型异常"), @ApiResponse(code = 500, message = "服务器异常")})
    @ApiOperation(value = "增加用户页面跳转", httpMethod = "GET")
    @GetMapping(value = "/addUser")
    public String addUserPage(ModelMap map) {
        map.put("roleAll", roleService.selectAll());
        return ADD_USER;
    }

    /**
     * 增加用实现
     *
     * @param user   User对象
     * @param result 错误信息
     * @param orgId  机构ID
     * @return 成功或失败
     */
    @ApiResponses(value = {@ApiResponse(code = 405, message = "请求类型异常"), @ApiResponse(code = 500, message = "服务器异常")})
    @ApiOperation(value = "增加用实现", httpMethod = "POST")
    @PostMapping
    @ResponseBody
    public ResultTo addUser(@ApiParam("user对象") User user, BindingResult result,
                            @ApiParam(value = "机构ID") @RequestParam("orgId") Integer orgId,
                            @ApiParam(value = "角色ID") @RequestParam("roleId") Integer roleId) {
        if (orgId == null || roleId == null) {
            LogTemplate.info(this.getClass(), "orgId", orgId);
            LogTemplate.info(this.getClass(), "roleId", roleId);
            return new ResultTo(ResultEnum.PARAM_ERROR);
        }
        Map<String, String> map = new HashedMap();
        if (ErrorMessageUtil.setValidErrorMessage(map, result)) {
            return new ResultTo(ResultEnum.PARAM_ERROR).setData(map);
        }
        if (userService.addUser(user, orgId, roleId)) {
            return new ResultTo();
        }
        return new ResultTo(ResultEnum.OPERATION_FAILED);
    }

    /**
     * 编辑用户页面跳转
     *
     * @param map    ModelMap对象
     * @param userId 用户ID
     * @return 编辑用户页面
     */
    @RequestMapping(value = "/{userId}/updateUser")
    @ApiResponses(value = {@ApiResponse(code = 405, message = "请求类型异常"), @ApiResponse(code = 500, message = "服务器异常")})
    @ApiOperation(value = "编辑用户页面跳转", httpMethod = "POST")
    public String updateUserPage(ModelMap map, @ApiParam("用户ID") @PathVariable("userId") Integer userId) {
        UserOrganization userOrganization = new UserOrganization();
        userOrganization.setUserId(userId);
        UserOrganization newUserOrganization = userOrganizationService.selectOne(userOrganization);
        map.put("org", organizationService.selectByPrimaryKey(newUserOrganization.getOrganizationId()));
        map.put("roleAll", roleService.selectAll());
        map.put("user", userService.selectByPrimaryKey(userId));
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        map.put("userRole", userRoleService.selectOne(userRole));
        return UPDATE_USER;
    }

    /**
     * 编辑用户页面实现
     *
     * @param user  User对象
     * @param orgId 机构Id
     * @return 成功或失败
     */
    @PutMapping
    @ApiResponses(value = {@ApiResponse(code = 405, message = "请求类型异常"), @ApiResponse(code = 500, message = "服务器异常")})
    @ApiOperation(value = "编辑用户实现", httpMethod = "POST")
    @ResponseBody
    public ResultTo updateUser(@ApiParam("User对象") User user, BindingResult result,
                               @ApiParam(value = "机构ID(结构:旧ID,新ID)") @RequestParam(value = "orgId", required = false) String orgId,
                               @ApiParam(value = "角色ID(结构:旧ID,新ID)") @RequestParam(value = "roleId", required = false) String roleId) {
        LogTemplate.debug(this.getClass(), "orgId", orgId);
        LogTemplate.debug(this.getClass(), "roleId", roleId);
        Map<String, String> map = new HashedMap();
        if (ErrorMessageUtil.setValidErrorMessage(map, result)) {
            return new ResultTo(ResultEnum.PARAM_ERROR).setData(map);
        }
        String[] orgIds = new String[0], roleIds = new String[0];
        if (orgId != null) {
            orgIds = orgId.split(",");
            if (orgIds.length != 2) {
                return new ResultTo(ResultEnum.PARAM_ERROR);
            }
        }
        if (roleId != null) {
            roleIds = roleId.split(",");
            if (roleIds.length != 2) {
                return new ResultTo(ResultEnum.PARAM_ERROR);
            }
        }
        if (userService.updateUser(user, orgIds, roleIds)) {
            return new ResultTo();
        }
        return new ResultTo(ResultEnum.OPERATION_FAILED);
    }


    /**
     * 用户角色页面跳转
     *
     * @return 用户角色页面
     */
    @ApiResponses(value = {@ApiResponse(code = 405, message = "请求类型异常"), @ApiResponse(code = 500, message = "服务器异常")})
    @ApiOperation(value = "用户角色页面跳转", httpMethod = "GET")
    @RequestMapping(value = "/{userId}/role", method = RequestMethod.GET)
    public String userRolePage(ModelMap map, @PathVariable("userId") Integer userId) {
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        map.put("userId", userId);
        map.put("roleAll", roleService.selectAll());
        map.put("userRole", userRoleService.select(userRole));
        return USER_ROLE;
    }

    /**
     * 更新用户角色信息
     *
     * @return 成功或失败
     */
    @ApiResponses(value = {@ApiResponse(code = 405, message = "请求类型异常"), @ApiResponse(code = 500, message = "服务器异常")})
    @ApiOperation(value = "用户角色页面跳转", httpMethod = "GET")
    @RequestMapping(value = "/{userId}/updateUserRole", method = RequestMethod.GET, params = "roleId")
    @ResponseBody
    public ResultTo updateUserRole(@PathVariable("userId") Integer userId, @RequestParam("roleId") Integer roleId) {
        UserRole userRole = new UserRole();
        userRole.setRoleId(roleId);
        userRole.setUserId(userId);
        if (userRoleService.updateUserRole(userRole)) {
            return new ResultTo();
        }
        return new ResultTo(ResultEnum.OPERATION_FAILED);
    }

    /**
     * 修改密码页面跳转
     *
     * @return 修改密码页面
     */
    @GetMapping(value = "/updatePasswordPage")
    @ApiResponses(value = {@ApiResponse(code = 405, message = "请求类型异常"), @ApiResponse(code = 500, message = "服务器异常")})
    @ApiOperation(value = "修改密码页面跳转", httpMethod = "GET")
    public String updatePassword() {
        return UPDATE_PASSWORD_PAGE;
    }

    /**
     * 用户修改密码
     *
     * @param oldPassword 原始密码
     * @param newPassword 新密码
     * @return 成功或失败
     */
    @PostMapping(value = "/updatePassword")
    @ApiResponses(value = {@ApiResponse(code = 405, message = "请求类型异常"), @ApiResponse(code = 500, message = "服务器异常")})
    @ApiOperation(value = "修改密码", httpMethod = "POST")
    @ResponseBody
    public ResultTo updatePassword(@ApiParam("原始密码") @RequestParam("oldPassword") String oldPassword,
                                   @ApiParam("新密码") @RequestParam("newPassword") String newPassword) {
        LogTemplate.debug(this.getClass(), "oldPassword", oldPassword);
        LogTemplate.debug(this.getClass(), "newPassword", PasswordUtil.encryptPassword(newPassword));
        if (StringUtils.isBlank(oldPassword) || StringUtils.isBlank(newPassword)) {
            return new ResultTo(ResultEnum.REQUIRED_PARAMETER_EMPTY);
        }
        return userService.updatePassword(oldPassword, newPassword);
    }

    /**
     * 忘记密码页面跳转
     *
     * @return 忘记密码页面1
     */
    @ApiResponses(value = {@ApiResponse(code = 405, message = "请求类型异常"), @ApiResponse(code = 500, message = "服务器异常")})
    @ApiOperation(value = "忘记密码页面跳转", httpMethod = "GET")
    @GetMapping(value = "/anon/resetPasswordPage")
    public String resetPasswordPage() {
        return RESET_PASSWORD_PAGE;
    }

    /**
     * 根据登录名查询用户
     *
     * @param userName 用户名
     * @return 不存在返回null, 存在返回用户Id
     */
    @RequestMapping(value = "/resetPassword/{userName}", method = RequestMethod.GET)
    @ApiResponses(value = {@ApiResponse(code = 405, message = "请求类型异常"), @ApiResponse(code = 500, message = "服务器异常")})
    @ApiOperation(value = "根据登录名查询用户", httpMethod = "GET", notes = "不存在返回null, 存在返回用户Id")
    @ResponseBody
    public ResultTo isHaveLoginName(@ApiParam("用户名") @PathVariable("userName") String userName) {
        LogTemplate.debug(this.getClass(), "userName", userName);
        User user = new User();
        user.setUsername(userName);
        User userOne = userService.selectOne(user);
        return new ResultTo().setData(userOne == null ? null : userOne.getId());
    }


    /**
     * 发送验证码页面
     *
     * @return 发送验证码页面
     */
    @ApiResponses(value = {@ApiResponse(code = 405, message = "请求类型异常"), @ApiResponse(code = 500, message = "服务器异常")})
    @ApiOperation(value = "忘记密码页面跳转", httpMethod = "GET")
    @GetMapping(value = "/anon/sendCodePage")
    public String sendCodePage() {
        return RESET_PASSWORD_SEND;
    }

    /**
     * 发送验证码
     *
     * @param userId  用户Id
     * @param address 用户Email或Phone
     * @return 成功或失败
     */
    @PostMapping(value = "/resetPassword/sendCode")
    @ApiResponses(value = {@ApiResponse(code = 405, message = "请求类型异常"), @ApiResponse(code = 500, message = "服务器异常")})
    @ApiOperation(value = "发送验证码", httpMethod = "POST")
    @ResponseBody
    public ResultTo sendCode(@ApiParam("用户Id") @RequestParam("userId") Integer userId,
                             @ApiParam("用户邮箱或手机号") @RequestParam("address") String address) {
        LogTemplate.debug(this.getClass(), "userId", userId);
        LogTemplate.debug(this.getClass(), "address", address);
        return userService.sendCode(userId, address);
    }

    /**
     * 验证验证码
     *
     * @param address 用户邮箱或手机号
     * @param code    验证码
     * @return 成功或失败
     */
    @PostMapping(value = "/resetPassword/checkedCode")
    @ApiResponses(value = {@ApiResponse(code = 405, message = "请求类型异常"), @ApiResponse(code = 500, message = "服务器异常")})
    @ApiOperation(value = "验证验证码", httpMethod = "POST")
    @ResponseBody
    public ResultTo checkedCode(@ApiParam("用户的邮箱或手机号") @RequestParam("address") String address,
                                @ApiParam("验证码") @RequestParam("code") String code) {
        LogTemplate.debug(this.getClass(), "address", address);
        LogTemplate.debug(this.getClass(), "code", code);
        return userService.checkedCode(address, code);
    }

    /**
     * 重置密码界面
     *
     * @return 重置密码界面
     */
    @ApiResponses(value = {@ApiResponse(code = 405, message = "请求类型异常"), @ApiResponse(code = 500, message = "服务器异常")})
    @ApiOperation(value = "忘记密码页面跳转", httpMethod = "GET")
    @GetMapping(value = "/anon/checkedCodedPage")
    public String resetPassword() {
        return RESET_PASSWORD_CHECKED;
    }


    /**
     * 重置密码
     *
     * @param userId      用户ID
     * @param checkedCode Api接口验证
     * @param password    密码
     * @return 成功或失败
     */
    @RequestMapping(value = "/resetPassword/{checkedCode}", method = RequestMethod.POST)
    @ApiResponses(value = {@ApiResponse(code = 405, message = "请求类型异常"), @ApiResponse(code = 500, message = "服务器异常")})
    @ApiOperation(value = "重置密码", httpMethod = "POST")
    @ResponseBody
    public ResultTo resetPassword(@ApiParam("用户Id") @RequestParam("userId") Integer userId,
                                  @ApiParam("Api接口验证") @PathVariable("checkedCode") String checkedCode,
                                  @ApiParam("要重置的密码") @RequestParam("password") String password) {
        LogTemplate.debug(this.getClass(), "userId", userId);
        LogTemplate.debug(this.getClass(), "checkedCode", checkedCode);
        LogTemplate.debug(this.getClass(), "password", password);
        return userService.resetPassword(userId, checkedCode, password);
    }

    /**
     * 用户身份证验重
     *
     * @param idCard
     * @return 存在 ture
     */
    @PostMapping("/isIdCard")
    @ApiResponses(value = {@ApiResponse(code = 405, message = "请求类型异常"), @ApiResponse(code = 500, message = "服务器异常")})
    @ApiOperation(value = "用户身份证号码验重", httpMethod = "POST")
    @ResponseBody
    public ResultTo isIdCard(@RequestParam("idCard") String idCard) {
        User user = new User();
        user.setIdCardNumber(idCard);
        if (userService.selectOne(user) != null) {
            return new ResultTo().setData(Boolean.TRUE);
        }
        return new ResultTo().setData(Boolean.FALSE);
    }
}
