package com.cardpay.mgt.message.service;

import com.cardpay.basic.common.constant.Constant;
import com.cardpay.mgt.message.dao.TMessageMapper;
import com.cardpay.mgt.message.service.impl.MessageServiceImpl;
import com.cardpay.util.TestEnv;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;


import static org.junit.Assert.*;

/**
 *消息服务测试类
 * @author wangpeng
 */
@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({MessageService.class})
public class MessageServiceTest {
    @Mock
    private TMessageMapper tMessageMapper;

    @InjectMocks
    private MessageServiceImpl messageService;

    @Test
    public void getReadMessage() throws Exception {
        PowerMockito.when(messageService.getReadMessage(10000)).thenReturn(1);
        int n = messageService.getReadMessage(10000);
        assertEquals(n, 1);
        Mockito.verify(tMessageMapper).getMessageByState(10000, Constant.MSG_READ);
    }

    @Test
    public void getUnreadMessage() throws Exception {
        PowerMockito.when(messageService.getUnreadMessage(10000)).thenReturn(1);
        int n = messageService.getUnreadMessage(10000);
        assertEquals(n, 1);
        Mockito.verify(tMessageMapper).getMessageByState(10000, Constant.MSG_UNREAD);
    }

}