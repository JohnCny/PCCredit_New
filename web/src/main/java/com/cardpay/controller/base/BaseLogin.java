package com.cardpay.controller.base;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * BaseLogin
 *
 * @author rankai
 */
@Controller
@RequestMapping("/")
public class BaseLogin {
    @GetMapping
    public void baseLogin() {
    }
}
