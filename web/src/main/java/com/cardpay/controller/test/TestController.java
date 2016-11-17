package com.cardpay.controller.test;

import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.model.TModel;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by chenkai on 2016/11/15.
 */
@Api(description = "测试类")
@RestController
@RequestMapping("/api/test")
public class TestController extends BaseController<TModel> {

    @ApiOperation(value = "测试接口", notes = "测试spring-fox",  httpMethod = "POST", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 405, message = "请求类型异常")})
    @RequestMapping(value = "a" ,method = RequestMethod.GET)
    public String test(@ApiParam(value = "测试数据", required = true) @RequestParam(value="test") String test){
        return "dist/index";
    }
    
}
