package com.cardpay.mgt.message.service;

import com.cardpay.basic.common.constant.Constant;
import com.cardpay.mgt.message.model.po.TMessage;
import com.cardpay.mgt.message.service.impl.MessageServiceImpl;
import com.cardpay.util.TestEnv;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

/**
 *消息服务测试类
 * @author wangpeng
 */
public class MessageServiceTest extends TestEnv {
    @Autowired
    private MessageServiceImpl messageService;

    @Test
    public void getReadMessage() throws Exception {
        TMessage msg = new TMessage();
        msg.setIsBroadcast(0);
        msg.setMsgState(Constant.MSG_READ);
        msg.setMsgLevel(0);
        msg.setMsgType(0);
        msg.setUserId(10000);
        msg.setMsgContent("单元测试");
        msg.setMsgTitle("单元测试");
        msg.setCreateTime(new Date());
        messageService.insertSelective(msg);

        Integer n = messageService.getReadMessage(10000);
        assertTrue(n >= 1);
    }

    @Test
    public void getUnreadMessage() throws Exception {
        TMessage msg = new TMessage();
        msg.setIsBroadcast(0);
        msg.setMsgState(Constant.MSG_UNREAD);
        msg.setMsgLevel(0);
        msg.setMsgType(0);
        msg.setUserId(10000);
        msg.setMsgContent("单元测试");
        msg.setMsgTitle("单元测试");
        msg.setCreateTime(new Date());
        messageService.insertSelective(msg);

        Integer n = messageService.getReadMessage(10000);
        assertTrue(n >= 1);
    }

}