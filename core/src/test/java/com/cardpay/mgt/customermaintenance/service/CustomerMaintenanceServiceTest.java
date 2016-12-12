package com.cardpay.mgt.customermaintenance.service;

import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.basic.common.constant.Constant;
import com.cardpay.basic.common.constant.ConstantEnum;
import com.cardpay.mgt.customermaintenance.dao.TCustomerMaintenanceMapper;
import com.cardpay.mgt.customermaintenance.service.impl.CustomerMaintenanceServiceImpl;
import com.cardpay.mgt.message.service.MessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.util.List;

import static org.junit.Assert.*;

/**
 *客户维护服务测试类
 * @author wangpeng
 */
@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({CustomerMaintenanceService.class})
public class CustomerMaintenanceServiceTest {
    @Mock
    private TCustomerMaintenanceMapper customerMaintenanceMapper;

    @InjectMocks
    private CustomerMaintenanceServiceImpl customerMaintenanceService;

    @Test
    public void getMaintenanceType() throws Exception {
        List<SelectModel> selects = (List<SelectModel>)customerMaintenanceService.getMaintenanceType();
        assertEquals(selects.size(), 3);
    }

}