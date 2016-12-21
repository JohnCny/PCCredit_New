package com.cardpay.controller.user;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.basic.mail.MailSend;
import com.cardpay.basic.util.RequestUtil;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.log.model.LoginLog;
import com.cardpay.mgt.log.service.LoginLogService;
import com.cardpay.mgt.user.model.User;
import com.cardpay.mgt.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用户登陆controller
 *
 * @author rankai
 * @create 2016-12-2016/12/21 10:22
 */
@Controller
@RequestMapping("/logon")
@Api(value = "/logon", description = "用认证(登陆)")
public class LogonController extends BaseController<User, Integer> {

    private static final String SESSION_KEY = "user";

    private static final String RETURN_LOGIN = "/home/login";

    @Autowired
    private UserService userService;

    @Autowired
    private LoginLogService loginLogService;

    @Autowired
    private MailSend mailSend;

    /**
     * 系统登陆入口
     *
     * @param userName
     * @param password
     * @return 成功或失败
     */
    @PostMapping(value = "/login")
    @ResponseBody
    @ApiOperation(value = "用户登陆", notes = "用户登陆POST请求", httpMethod = "POST")
    @ApiResponses(value = {@ApiResponse(code = 405, message = "请求类型异常")})
    public ResultTo login(@ApiParam(value = "登陆名") @RequestParam(value = "userName", required = false) String userName,
                          @ApiParam(value = "登陆密码") @RequestParam(value = "password", required = false) String password,
                          HttpServletRequest request) {
        LogTemplate.debug(this.getClass(), "userName", userName);
        LogTemplate.debug(this.getClass(), "password", password);
        if (StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
            LogTemplate.info(this.getClass(), "用户账号或密码为空,用户账号:", userName);
            return new ResultTo(ResultEnum.ACCOUNT_OR_PASSWORD_NULL);
        }
        LoginLog.LoginLogBuilder loginLogBuilder = LoginLog.LoginLogBuilder.get().withLoginAccount(userName)
                .withLoginOperation("登陆").withLoginTime(new Date()).withLoginIp(RequestUtil.getRemoteHost(request));
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password.toCharArray());
        try {
            ShiroKit.getSubject().login(token);
        } catch (UnknownAccountException e) {
            LogTemplate.info(this.getClass(), "账号不存在,账号:", userName);
            LoginLog loginLog = loginLogBuilder.withLoginResult("账号不存在").build();
            loginLogService.insertSelective(loginLog);
            return new ResultTo(ResultEnum.UNKNOWN_ACCOUNT);
        } catch (IncorrectCredentialsException e) {
            LogTemplate.info(this.getClass(), "密码错误,账号:", userName);
            LoginLog loginLog = loginLogBuilder.withLoginResult("密码错误").build();
            loginLogService.insertSelective(loginLog);
            return new ResultTo(ResultEnum.USER_PWD_ERROR);
        } catch (LockedAccountException e) {
            LogTemplate.info(this.getClass(), "账号被锁定,账号:", userName);
            LoginLog loginLog = loginLogBuilder.withLoginResult("账号被锁定").build();
            loginLogService.insertSelective(loginLog);
            return new ResultTo(ResultEnum.LOCKED_ACCOUNT);
        } catch (DisabledAccountException e) {
            LogTemplate.info(this.getClass(), "账号未激活,账号:", userName);
            LoginLog loginLog = loginLogBuilder.withLoginResult("账号未激活").build();
            loginLogService.insertSelective(loginLog);
            return new ResultTo(ResultEnum.DISABLED_ACCOUNT);
        }
        LogTemplate.info(this.getClass(), "登陆成功,账号:", userName);
        User user = ShiroKit.getUser();
        user.setPassword(null);
        ShiroKit.getSession().setAttribute(SESSION_KEY, user);
        LoginLog loginLog = loginLogBuilder.withLoginResult("登陆成功").build();
        loginLogService.insertSelective(loginLog);
        Date date = new Date();
        user.setLastLoginTime(date);
        userService.updateSelectiveByPrimaryKey(user);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String message = "您的账号[" + user.getUsername() + "]于[" + formatter.format(date) +
                "]成功登陆快贷平台,若非本人操做请立即修改密码[乾康快贷]";
        mailSend.send(user.getEmail(), message);
        return new ResultTo();
    }

    /**
     * 退出登陆
     *
     * @return 登陆页面
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    @ApiOperation(value = "用户登陆", notes = "用户登陆POST请求", httpMethod = "POST")
    @ApiResponses(value = {@ApiResponse(code = 405, message = "请求类型异常")})
    public String logout() {
        ShiroKit.getSession().removeAttribute(SESSION_KEY);
        ShiroKit.getSubject().logout();
        return RETURN_LOGIN;
    }


    /**
     * 无权限跳转
     *
     * @return 无权限提示消息
     */
    @RequestMapping(value = "/unauthorized", method = RequestMethod.GET)
    public ResultTo unauthorized() {
        return new ResultTo(ResultEnum.NO_PERMITTION);
    }
}
