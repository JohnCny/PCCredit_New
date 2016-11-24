package com.cardpay.controller.test;
import com.cardpay.basic.base.model.EchatesTo;
import com.cardpay.basic.base.model.EchatesModel;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.test.model.TModel;
import com.cardpay.mgt.test.model.TestModel;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.cardpay.core.webSocket.SystemWebSocketHandler.sendMessageToUser;

/**
 * http://localhost/swagger-ui.html
 * Created by chenkai on 2016/11/15.
 */
@Api(value = "/test", description = "测试类")
@RestController
@RequestMapping("/test")
public class TestController extends BaseController<TModel,Integer> {

    @ApiOperation(value = "测试接口", notes = "测试spring-fox",  httpMethod = "GET", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 405, message = "请求类型异常")})
    @RequestMapping(value = "/test" ,method = RequestMethod.GET)
    //@ApiImplicitParams({ @ApiImplicitParam(name = "tModel", value = "testBean", required = true, dataType = "TModel")})
    public String test(@ApiParam(required = true, value ="对象" ) @ModelAttribute TModel tModel,
                       @ApiParam(value ="Json" ) @RequestBody TModel jsonModel,
                       @ApiParam(value = "测试数据") @RequestParam String str){
        return "dist/index";
    }

    @ApiOperation(value = "测试Dozer po转vo")
    @RequestMapping(value = "/dozer", method = RequestMethod.POST)
    public void testDozer(){
        TModel po = new TModel();
        po.setId(1);
        po.setName("测试");

        TestModel vo = dozerMapper.map(po, TestModel.class);
        System.out.println(vo.getModelName());
    }

    /**
     * http://localhost/testSocket.jsp
     */
    @ApiOperation(value = "测试给所有用户推送消息")
    @RequestMapping(value = "/push", method = RequestMethod.PUT)
    public EchatesTo testWebSocket(){
       // sendMessageToUsers("测试信息");
        EchatesTo echates = new EchatesTo();
        List<String> list = new ArrayList<String>(){
            {
                add("直接访问");
                add("邮件营销");
                add("联盟广告");
                add("视频广告");
            }
        };
        List<EchatesModel> list2 = new ArrayList<>();
        list2.add(new EchatesModel("直接访问", 335));
        list2.add(new EchatesModel("邮件营销", 310));
        list2.add(new EchatesModel("联盟广告", 234));
        echates.setData("某站点用户访问来源", "纯属虚构", list, list2);
        return echates;
    }

    @ApiOperation(value = "测试给指定用户推送消息")
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public void testSendWebSocket(){
        sendMessageToUser(1, "测试信息");
    }
}
