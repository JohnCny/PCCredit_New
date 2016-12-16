package com.cardpay.app.controller.login;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * App用户登陆操作
 * @author rankai .
 */
@RestController
@RequestMapping("/app/logon")
@Api(value = "/app/logon", description = "用认证(登陆)")
public class Login {

}
