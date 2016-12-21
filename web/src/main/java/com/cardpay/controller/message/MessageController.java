package com.cardpay.controller.message;

import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.message.model.po.TMessage;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 消息controller
 * @author yanweichen
 */
@Api(value = "/message", description = "消息")
@RestController
@RequestMapping("/message")
public class MessageController  extends BaseController<TMessage, Integer> {
}
