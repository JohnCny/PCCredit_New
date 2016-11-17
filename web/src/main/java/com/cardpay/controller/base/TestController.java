package com.cardpay.controller.base;
import com.cardpay.basic.common.webSocket.SystemWebSocketHandler;
import com.cardpay.mgt.model.TModel;
import com.cardpay.mgt.model.TestModel;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.socket.TextMessage;

import javax.servlet.http.HttpServletRequest;


/**
 * http://localhost/swagger-ui.html
 * Created by chenkai on 2016/11/15.
 */
@Api(value = "/test", description = "测试类")
@RestController
@RequestMapping("/test")

public class TestController extends BaseController<TModel> {


    @ApiOperation(value = "测试接口", notes = "测试spring-fox",  httpMethod = "GET", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 405, message = "请求类型异常")})
    @RequestMapping(value = "" ,method = RequestMethod.GET)
    //@ApiImplicitParams({ @ApiImplicitParam(name = "tModel", value = "testBean", required = true, dataType = "TModel")})
    public String test(@ApiParam(required = true, value ="对象" )@ModelAttribute TModel tModel,
                       @ApiParam(value ="Json" )@RequestBody TModel jsonModel,
                       @ApiParam(value = "测试数据") @RequestParam String str){
        return "dist/index";
    }

    @ApiOperation(value = "测试Dozer")
    @RequestMapping(value = "", method = RequestMethod.POST)
    public void testDozer(){
        TModel po = new TModel();
        po.setId(1);
        po.setName("测试");

        TestModel vo = dozerMapper.map(po, TestModel.class);
        System.out.println(vo.getModelName());
    }

}
