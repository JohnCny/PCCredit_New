package com.cardpay.controller.login;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shrio.common.ShiroKit;
import com.cardpay.mgt.user.model.User;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户登陆controller
 *
 * @author rankai
 */
@Controller
@RequestMapping("/logon")
@Api(value = "用认证(登陆)")
public class LogonController extends BaseController<User, Integer> {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    @ResponseBody
    public ResultTo login(@RequestParam(value = "userName", required = false) String userName, @RequestParam(value = "password", required = false) String password) {
        LogTemplate.debug(this.getClass(), "收到用户登陆请求,用户账号:", userName);
        if (StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
            LogTemplate.info(this.getClass(), "用户账号或密码为空,用户账号:", userName);
            return new ResultTo(ResultEnum.ACCOUNT_OR_PASSWORD_NULL.getValue());
        }
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password.toCharArray());
        try {
            ShiroKit.getSubject().login(token);
        } catch (UnknownAccountException e) {
            LogTemplate.info(this.getClass(), "账号不存在,账号:", userName);
            return new ResultTo(ResultEnum.UNKNOWN_ACCOUNT.getValue());
        } catch (IncorrectCredentialsException e) {
            LogTemplate.info(this.getClass(), "密码错误,账号:", userName);
            return new ResultTo(ResultEnum.USER_PWD_ERROR.getValue());
        } catch (LockedAccountException e) {
            LogTemplate.info(this.getClass(), "账号被锁定,账号:", userName);
            return new ResultTo(ResultEnum.LOCKED_ACCOUNT.getValue());
        } catch (DisabledAccountException e) {
            LogTemplate.info(this.getClass(), "账号未激活,账号:", userName);
            return new ResultTo(ResultEnum.DISABLED_ACCOUNT.getValue());
        }
        LogTemplate.info(this.getClass(), "登陆成功,账号:", userName);
        ShiroKit.getSubject().hasRole("");
        return new ResultTo();
    }

    @RequestMapping("/test")
    public void test() {
        boolean aSuper = ShiroKit.getSubject().hasRole("super");
        System.out.println("测试++++++++++++++++++++++++++++++++++++++++++++++++++++" + aSuper);
    }

}
