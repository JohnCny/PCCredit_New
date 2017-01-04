package com.cardpay.mgt.message.dao;

import com.cardpay.mgt.message.model.TMessage;
import com.cardpay.util.TestEnv;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * @author yanweichen
 */
public class TMessageMapperTest extends TestEnv {

    @Autowired
    private TMessageMapper tMessageMapper;

    @Test
    @Ignore
    public void getMessageByState() throws Exception {
        TMessage msg = new TMessage();
        msg.setIsBroadcast(0);
        msg.setMsgState(0);
        msg.setMsgLevel(0);
        msg.setMsgType(0);
        msg.setUserId(10000);
        msg.setMsgContent("单元测试");
        msg.setMsgTitle("单元测试");
        msg.setCreateTime(new Date());
        tMessageMapper.insertSelective(msg);

        Integer n = tMessageMapper.getMessageByState(10000, 0);
        assertTrue(n >= 1);
    }
}