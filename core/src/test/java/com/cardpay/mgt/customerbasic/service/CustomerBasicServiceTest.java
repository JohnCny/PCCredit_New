package com.cardpay.mgt.customerbasic.service;

import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.mgt.customer.basic.dao.TCustomerBasicMapper;
import com.cardpay.mgt.customer.model.TCustomerBasic;
import com.cardpay.mgt.customer.service.CustomerBasicService;
import com.cardpay.mgt.customer.service.impl.CustomerBasicServiceImpl;
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
 *客户基本信息测试类
 * @author wangpeng
 */
@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({CustomerBasicService.class})
public class CustomerBasicServiceTest {
    @Mock
    private TCustomerBasicMapper customerBasicMapper;

    @InjectMocks
    private CustomerBasicServiceImpl customerBasicService;

    @Test
    public void getCert() throws Exception {
        List<SelectModel> selects = (List<SelectModel>)customerBasicService.getCert();
        assertEquals(selects.size(), 3);
    }

    @Test
    public void getEducationDegree() throws Exception {
        List<SelectModel> selects = (List<SelectModel>)customerBasicService.getEducationDegree();
        assertEquals(selects.size(), 9);
    }

    @Test
    public void getMarriageStatus() throws Exception {
        List<SelectModel> selects = (List<SelectModel>)customerBasicService.getMarriageStatus();
        assertEquals(selects.size(), 4);
    }

    @Test
    public void getCustomerStatus() throws Exception {
        List<SelectModel> selects = (List<SelectModel>)customerBasicService.getCustomerStatus();
        assertEquals(selects.size(), 4);
    }

    @Test
    public void getProspectiveCustomers() throws Exception {
        List<TCustomerBasic> lists = new ArrayList<TCustomerBasic>(){
            {
                add(new TCustomerBasic());
            }
        };
        PowerMockito.when(customerBasicService.getProspectiveCustomers(1000)).thenReturn(lists);
        List<TCustomerBasic> selects = customerBasicService.getProspectiveCustomers(1000);
        assertEquals(selects.size(), 1);
        Mockito.verify(customerBasicMapper).getProspectiveCustomers(1000);
    }

}