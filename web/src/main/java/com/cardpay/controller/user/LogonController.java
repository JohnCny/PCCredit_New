package com.cardpay.controller.user;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.basic.util.DozerUtil;
import com.cardpay.basic.util.RequestUtil;
import com.cardpay.basic.util.datatable.DataTableCode;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.core.shiro.enums.ShiroEnum;
import com.cardpay.mgt.log.enums.LogEnum;
import com.cardpay.mgt.log.model.LoginLog;
import com.cardpay.mgt.log.service.LoginLogService;
import com.cardpay.mgt.organization.model.TOrganization;
import com.cardpay.mgt.organization.service.TOrganizationService;
import com.cardpay.mgt.user.model.Role;
import com.cardpay.mgt.user.model.User;
import com.cardpay.mgt.user.model.UserOrganization;
import com.cardpay.mgt.user.model.UserRole;
import com.cardpay.mgt.user.model.vo.RoleVo;
import com.cardpay.mgt.user.service.RoleService;
import com.cardpay.mgt.user.service.UserOrganizationService;
import com.cardpay.mgt.user.service.UserRoleService;
import com.cardpay.mgt.user.service.UserService;
import io.swagger.annotations.*;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

/**
 * 用户登陆controller
 *
 * @author rankai
 */
@RestController
@RequestMapping("/api/logon")
@Api(value = "/api/logon", description = "用认证(登陆)")
public class LogonController extends BaseController<User> {

    @Autowired
    private UserService userService;

    @Autowired
    private LoginLogService loginLogService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private UserOrganizationService userOrganizationService;

    @Autowired
    private TOrganizationService organizationService;

    /**
     * 系统登陆入口
     *
     * @param userName
     * @param password
     * @return 成功或失败
     */
    @PostMapping(value = "/login")
    @ApiOperation(value = "用户登陆", notes = "用户登陆POST请求", httpMethod = "POST")
    public ResultTo login(@RequestParam(value = "userName", required = false) String userName,
                          @RequestParam(value = "password", required = false) String password,
                          HttpServletRequest request) {
        LogTemplate.debug(this.getClass(), "userName", userName);
        LogTemplate.debug(this.getClass(), "password", password);
        if (StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
            LogTemplate.info(this.getClass(), "用户账号或密码为空,用户账号:", userName);
            return new ResultTo(ResultEnum.ACCOUNT_OR_PASSWORD_NULL);
        }
        LoginLog.LoginLogBuilder loginLogBuilder = LoginLog.LoginLogBuilder.get().withLoginAccount(userName)
                .withLoginOperation(1).withLoginTime(new Date()).withLoginIp(RequestUtil.getRemoteHost(request));
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password.toCharArray());
        try {
            ShiroKit.getSubject().login(token);
        } catch (UnknownAccountException e) {
            LogTemplate.info(this.getClass(), "账号不存在,账号:", userName);
            LoginLog loginLog = loginLogBuilder.withLoginResult(LogEnum.UNKNOWN_ACCOUNT.getValue()).build();
            loginLogService.insertSelective(loginLog);
            return new ResultTo(ResultEnum.UNKNOWN_ACCOUNT);
        } catch (IncorrectCredentialsException e) {
            LogTemplate.info(this.getClass(), "密码错误,账号:", userName);
            LoginLog loginLog = loginLogBuilder.withLoginResult(LogEnum.USER_PWD_ERROR.getValue()).build();
            loginLogService.insertSelective(loginLog);
            return new ResultTo(ResultEnum.USER_PWD_ERROR);
        } catch (LockedAccountException e) {
            LogTemplate.info(this.getClass(), "账号被锁定,账号:", userName);
            LoginLog loginLog = loginLogBuilder.withLoginResult(LogEnum.LOCKED_ACCOUNT.getValue()).build();
            loginLogService.insertSelective(loginLog);
            return new ResultTo(ResultEnum.LOCKED_ACCOUNT);
        } catch (DisabledAccountException e) {
            LogTemplate.info(this.getClass(), "账号未激活,账号:", userName);
            LoginLog loginLog = loginLogBuilder.withLoginResult(LogEnum.DISABLED_ACCOUNT.getValue()).build();
            loginLogService.insertSelective(loginLog);
            return new ResultTo(ResultEnum.DISABLED_ACCOUNT);
        }
        LogTemplate.info(this.getClass(), "登陆成功,账号:", userName);

        Map<String, Object> map = new HashedMap();

        User user = ShiroKit.getUser();
        ShiroKit.getSession().setAttribute(ShiroKit.USER_SESSION_KEY, user);
        user.setPassword(null);
        map.put("user", user);

        UserOrganization userOrganization = new UserOrganization();
        userOrganization.setUserId(user.getId());
        userOrganization.setIsDefault(1);
        UserOrganization selectOne = userOrganizationService.selectOne(userOrganization);
        TOrganization organization = organizationService.selectByPrimaryKey(selectOne.getOrganizationId());
        ShiroKit.getSession().setAttribute(ShiroKit.ORG_SESSION_KEY, organization);
        map.put("org", organization);

        UserRole userRole = new UserRole();
        userRole.setUserId(user.getId());
        UserRole selectUserOne = userRoleService.selectOne(userRole);
        Role role = roleService.selectByPrimaryKey(selectUserOne.getRoleId());
        ShiroKit.getSession().setAttribute(ShiroKit.ROLE_SESSION_KEY, role);
        map.put("roleType", role.getRoleStatus() == 1 ? role.getRoleType() : null);

        LoginLog loginLog = loginLogBuilder.withLoginResult(LogEnum.SUCCESS.getValue()).build();
        loginLogService.insertSelective(loginLog);

        Date date = new Date();
        user.setLastLoginTime(date);
        userService.updateSelectiveByPrimaryKey(user);

        return new ResultTo().setData(map);
    }

    /**
     * 退出登陆
     *
     * @return 登陆页面
     */
    @GetMapping(value = "/logout")
    public ResultTo logout(HttpServletRequest request) {
        User user = ShiroKit.getUser();
        LoginLog loginLog = LoginLog.LoginLogBuilder.get().withLoginAccount(user.getUsername())
                .withLoginOperation(0).withLoginTime(new Date()).withLoginIp(RequestUtil.getRemoteHost(request))
                .withLoginResult(LogEnum.SUCCESS.getValue()).build();
        loginLogService.insertSelective(loginLog);
        ShiroKit.getSession().removeAttribute(ShiroKit.USER_SESSION_KEY);
        ShiroKit.getSession().removeAttribute(ShiroKit.ROLE_SESSION_KEY);
        ShiroKit.getSubject().logout();
        return new ResultTo();
    }


    /**
     * 无权限跳转
     *
     * @return 无权限提示消息
     */
    @GetMapping(value = "/unauthorized")
    public ResultTo unauthorized() {
        return new ResultTo(ResultEnum.NO_PERMITTION);
    }

    /**
     * 没有登陆提示
     *
     * @return 没有登陆提示消息
     */
    @GetMapping(value = "/noLogin")
    public ResultTo noLogin() {
        return new ResultTo(ResultEnum.NO_LOGIN);
    }

    /**
     * 登陆选择机构信息
     *
     * @return
     */
    @GetMapping(params = "orgId")
    public ResultTo loginOrg(@RequestParam("orgId") Integer orgId) {
        TOrganization organization = organizationService.selectByPrimaryKey(orgId);
        ShiroKit.getSession().setAttribute(ShiroKit.ORG_SESSION_KEY, organization);
        return new ResultTo();
    }

}
