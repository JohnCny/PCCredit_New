package com.cardpay.mgt.customermaintenance.service;

import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.mgt.customer.customermaintenance.dao.TCustomerMaintenanceMapper;
import com.cardpay.mgt.customer.customermaintenance.service.CustomerMaintenanceService;
import com.cardpay.mgt.customer.customermaintenance.service.impl.CustomerMaintenanceServiceImpl;
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