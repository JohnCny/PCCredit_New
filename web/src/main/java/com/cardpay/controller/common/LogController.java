package com.cardpay.controller.common;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;

/**
 * 日志controller
 *
 * @author rankai
 * @create 2016-12-2016/12/21 10:22
 */

@Controller
@RequestMapping("/log")
@Api(value = "/log", description = "日志操作")
public class LogController {


    /**
     * 登陆日志的跳转页面
     *
     * @return 登陆日志的页面
     */
    @GetMapping("/loginPage")
    public String loginLogPage() {
        return "";
    }

    public void loginLog(WebRequest request) {

    }

}
