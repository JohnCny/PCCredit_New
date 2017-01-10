package com.cardpay.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * BaseLogin
 *
 * @author rankai
 *         createTime 2017-01-2017/1/4 19:39
 */
@Controller
@RequestMapping("/")
public class BaseLogin {

    @GetMapping
    public void baseLogin() {
    }
}
