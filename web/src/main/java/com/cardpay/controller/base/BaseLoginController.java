package com.cardpay.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 默认跳转页面
 *
 * @author rankai
 * @create 2016-12-2016/12/19 14:30
 */
@Controller
public class BaseLoginController {

    private static final String BASE_LOGIN_REDIRECT = "redirect:/returnWebPage?viewName=/home/login";

    /**
     * 默认跳转页面
     *
     * @return 请求转发
     */
    @GetMapping()
    public String login() {
        return BASE_LOGIN_REDIRECT;
    }
}
