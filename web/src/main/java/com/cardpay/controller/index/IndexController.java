package com.cardpay.controller.index;

import com.cardpay.core.shiro.common.ShiroKit;
import io.swagger.annotations.Api;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author rankai
 * @create 2016-12-2016/12/19 15:12
 */
@Controller
@RequestMapping("index")
@Api(value = "/index", description = "首页请求地址")
public class IndexController {

    private static final String ADMIN_INDEX_PAGE = "/dashboard/admin";

    public String index() {
        Subject subject = ShiroKit.getSubject();
        if (subject.hasRole("admin")) {
            return ADMIN_INDEX_PAGE;
        }
        return "/error/404";
    }
}
