package com.cardpay.controller.base;

import com.cardpay.mgt.model.TModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by yanwe on 2016/11/14.
 */
@RestController
@RequestMapping("/test")
public class TestController extends BaseController<TModel> {
    @ApiOperation(value = "测试接口3", notes = "接受对象", produces = "application/json",  httpMethod = "POST")
    @ApiResponses(value = {@ApiResponse(code = 405, message = "invalid input")})
    @RequestMapping("/a")
    public String test(){
        return "dist/index";
    }
}
