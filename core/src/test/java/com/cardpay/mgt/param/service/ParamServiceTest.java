package com.cardpay.mgt.param.service;

import com.cardpay.mgt.message.service.MessageService;
import com.cardpay.mgt.param.dao.TBusinessParamMapper;
import com.cardpay.mgt.param.model.po.TBusinessParam;
import com.cardpay.mgt.param.service.impl.ParamServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.assertEquals;

/**
 *业务参数服务测试类
 * @author wangpeng
 */
@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({MessageService.class})
public class ParamServiceTest {

    @Mock
    private TBusinessParamMapper tBusinessParamMapper;

    @InjectMocks
    private ParamServiceImpl paramService;

    @Test
    public void getByName() throws Exception {
        TBusinessParam bp = new TBusinessParam();
        bp.setNameZh("测试业务参数");
        PowerMockito.when(paramService.getByName("test parameter")).thenReturn(bp);
        TBusinessParam bp2 = paramService.getByName("test parameter");
        assertEquals(bp.getNameZh(), bp2.getNameZh());
        Mockito.verify(tBusinessParamMapper).getByName("test parameter");
    }

}