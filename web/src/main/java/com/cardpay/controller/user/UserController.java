package com.cardpay.controller.user;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.PasswordUtil;
import com.cardpay.mgt.user.model.User;
import com.cardpay.mgt.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 用户控制层
 *
 * @author rankai .
 */
@Controller
@RequestMapping("/user")
@Api(value = "/user", description = "用户控制层")
public class UserController extends BaseController<User, Integer> {

    private static final String UPDATE_PASSWORD_PAGE = "/user/change_password";

    private static final String RESET_PASSWORD_PAGE = "/user/forget";

    private static final String RESET_PASSWORD_SEND = "/user/forget";

    private static final String RESET_PASSWORD_CHECKED = "/user/forget";

    @Autowired
    private UserService userService;

    /**
     * 修改密码页面跳转
     *
     * @return 修改密码页面
     */
    @RequestMapping(value = "/updatePasswordPage", method = RequestMethod.GET)
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
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
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
    @RequestMapping(value = "/anon/resetPasswordPage", method = RequestMethod.GET)
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
    @RequestMapping(value = "/anon/resetPasswordPage", method = RequestMethod.GET)
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
    @RequestMapping(value = "/resetPassword/sendCode", method = RequestMethod.POST)
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
    @RequestMapping(value = "/resetPassword/checkedCode", method = RequestMethod.POST)
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
    @RequestMapping(value = "/anon/resetPasswordPage", method = RequestMethod.GET)
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
}
