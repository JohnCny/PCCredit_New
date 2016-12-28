package com.cardpay.controller.message;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.core.webSocket.SystemWebSocketHandler;
import com.cardpay.mgt.message.model.po.TMessage;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消息controller
 *
 * @author yanweichen
 */
@Api(value = "/message", description = "消息")
@RestController
@RequestMapping("/message")
public class MessageController extends BaseController<TMessage> {

    @GetMapping
    public ResultTo sendMsg(){
        ResultTo resultTo = new ResultTo();
        SystemWebSocketHandler.sendMessageToUser(ShiroKit.getUserId(),"测测测测测");
        return resultTo;
    }
}
