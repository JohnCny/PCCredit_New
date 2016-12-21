package com.cardpay.mgt.customermaintenance.service;

import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.mgt.customer.dao.TCustomerMaintenanceMapper;
import com.cardpay.mgt.customer.service.TCustomerMaintenanceService;
import com.cardpay.mgt.customer.service.impl.TCustomerMaintenanceServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.util.List;

import static org.junit.Assert.*;

/**
 *客户维护服务测试类
 * @author wangpeng
 */
@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({TCustomerMaintenanceService.class})
public class CustomerMaintenanceServiceTest {
    @Mock
    private TCustomerMaintenanceMapper customerMaintenanceMapper;

    @InjectMocks
    private TCustomerMaintenanceServiceImpl customerMaintenanceService;

    @Test
    public void getMaintenanceType() throws Exception {
        List<SelectModel> selects = (List<SelectModel>)customerMaintenanceService.getMaintenanceType();
        assertEquals(selects.size(), 3);
    }

}