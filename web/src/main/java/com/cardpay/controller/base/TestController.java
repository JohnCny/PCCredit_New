package com.cardpay.controller.base;

import com.cardpay.mgt.model.TModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yanwe on 2016/11/14.
 */
@RestController
@RequestMapping("test")
public class TestController extends BaseController<TModel> {

    @RequestMapping("/a")
    public String test(){
        return "success";
    }
}
