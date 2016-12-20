package com.cardpay.controller.base;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 默认跳转页面
 *
 * @author rankai
 * @create 2016-12-2016/12/19 14:30
 */
@Controller
@RequestMapping("/login")
public class BaseLoginController {

    private static final String RETURN_LOGIN = "/home/login";

    /**
     * 登陆页面跳转
     *
     * @return 登陆页面
     */
    @ApiOperation(value = "登陆页面跳转", notes = "登陆页面跳转GET请求", httpMethod = "GET")
    @ApiResponses(value = {@ApiResponse(code = 405, message = "请求类型异常")})
    @RequestMapping(method = RequestMethod.GET)
    public String login() {
        return RETURN_LOGIN;
    }
}
