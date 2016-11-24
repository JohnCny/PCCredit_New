package com.cardpay.controller.business.user;

import com.cardpay.controller.base.BaseController;
import com.cardpay.core.business.user.model.po.TUser;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户controller
 * @author wangpeng
 */
@Api(value = "/user", description = "用户")
@RestController
@RequestMapping("/user")
public class UserController extends BaseController<TUser> {
}
