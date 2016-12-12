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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户控制层
 *
 * @author rankai .
 */
@RestController
@RequestMapping("/user")
@Api(value = "/user", description = "用户控制层")
public class UserController extends BaseController<User, Integer> {

    @Autowired
    private UserService userService;

    /**
     * 用户修改密码
     *
     * @param oldPassword 原始密码
     * @param newPassword 新密码
     * @return 成功或失败
     */
    @RequestMapping(method = RequestMethod.POST, params = "updatePassword")
    @ApiResponses(value = {@ApiResponse(code = 405, message = "请求类型异常"), @ApiResponse(code = 500, message = "服务器异常")})
    @ApiOperation(value = "修改密码", httpMethod = "POST")
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
     * 根据登录名查询用户
     *
     * @param userName 用户名
     * @return 不存在返回null, 存在返回用户Id
     */
    @RequestMapping(value = "/anon/{userName}", method = RequestMethod.GET)
    @ApiResponses(value = {@ApiResponse(code = 405, message = "请求类型异常"), @ApiResponse(code = 500, message = "服务器异常")})
    @ApiOperation(value = "根据登录名查询用户", httpMethod = "GET", notes = "不存在返回null, 存在返回用户Id")
    public ResultTo isHaveLoginName(@ApiParam("用户名") @PathVariable("userName") String userName) {
        LogTemplate.debug(this.getClass(), "userName", userName);
        User user = new User();
        user.setUsername(userName);
        User userOne = userService.selectOne(user);
        return new ResultTo().setData(userOne == null ? null : user.getId());
    }

    /**
     * 发送验证码
     *
     * @param userId  用户Id
     * @param address 用户Email或Phone
     * @return 成功或失败
     */
    @RequestMapping(value = "/anon/sendCode", method = RequestMethod.POST, params = "resetPassword")
    @ApiResponses(value = {@ApiResponse(code = 405, message = "请求类型异常"), @ApiResponse(code = 500, message = "服务器异常")})
    @ApiOperation(value = "发送验证码", httpMethod = "POST")
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
    @RequestMapping(value = "/anon/checkedCode", method = RequestMethod.POST, params = "resetPassword")
    @ApiResponses(value = {@ApiResponse(code = 405, message = "请求类型异常"), @ApiResponse(code = 500, message = "服务器异常")})
    @ApiOperation(value = "验证验证码", httpMethod = "POST")
    public ResultTo checkedCode(@ApiParam("用户的邮箱或手机号") @RequestParam("address") String address,
                                @ApiParam("验证码") @RequestParam("code") String code) {
        LogTemplate.debug(this.getClass(), "address", address);
        LogTemplate.debug(this.getClass(), "code", code);
        return userService.checkedCode(address, code);
    }

    /**
     * 重置密码
     *
     * @param userId   用户ID
     * @param password 密码
     * @return 成功或失败
     */
    @RequestMapping(value = "/anon/{userId}", method = RequestMethod.POST, params = "resetPassword")
    public ResultTo resetPassword(@ApiParam("用户Id") @PathVariable("userId") Integer userId,
                                  @ApiParam("要重置的密码") @RequestParam("password") String password) {
        LogTemplate.debug(this.getClass(), "userId", userId);
        LogTemplate.debug(this.getClass(), "password", password);
        User user = new User();
        user.setId(userId);
        user.setPassword(password);
        PasswordUtil.encryptPassword(user);
        Integer count = userService.updateSelectiveByPrimaryKey(user);
        if (count == 0 || count == null) {
            return new ResultTo(ResultEnum.OPERATION_FAILED);
        }
        return new ResultTo();
    }
}
