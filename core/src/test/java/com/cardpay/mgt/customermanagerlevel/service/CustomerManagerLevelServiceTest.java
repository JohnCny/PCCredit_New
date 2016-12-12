package com.cardpay.mgt.customermanagerlevel.service;

import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.mgt.customermanagerlevel.dao.TCustomerManagerLevelMapper;
import com.cardpay.mgt.customermanagerlevel.service.impl.CustomerManagerLevelServiceImpl;
import com.cardpay.mgt.message.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 *客户经理级别测试类
 * @author wangpeng
 */
@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({CustomerManagerLevelService.class})
public class CustomerManagerLevelServiceTest {
    @Mock
    private TCustomerManagerLevelMapper customerManagerLevelMapper;

    @InjectMocks
    private CustomerManagerLevelServiceImpl customerManagerLevelService;

    @Test
    public void getCustomerManagerLevel() throws Exception {
        List<SelectModel> lists = new ArrayList<SelectModel>(){
            {
                add(new SelectModel());
            }
        };
        PowerMockito.when(customerManagerLevelService.getCustomerManagerLevel()).thenReturn(lists);
        List<SelectModel> selects = (List<SelectModel>)customerManagerLevelService.getCustomerManagerLevel();
        assertEquals(selects.size(), 1);
        Mockito.verify(customerManagerLevelMapper.selectAll());
    }

}