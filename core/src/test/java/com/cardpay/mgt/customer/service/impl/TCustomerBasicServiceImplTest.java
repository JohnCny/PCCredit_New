package com.cardpay.mgt.customer.service.impl;

import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.basic.common.interceptor.mapper.ReturnMapParam;
import com.cardpay.mgt.customer.dao.TCustomerBasicMapper;
import com.cardpay.mgt.customer.model.TCustomerBasic;
import com.cardpay.mgt.customer.service.TCustomerBasicService;
import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 *客户基本信息测试类
 * @author chenkai
 */
@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({TCustomerBasicService.class})
public class TCustomerBasicServiceImplTest {
    @Mock
    private TCustomerBasicMapper customerBasicMapper;

    @InjectMocks
    private TCustomerBasicServiceImpl customerBasicService;

    @Test
    public void getProspectiveCustomers() throws Exception {
        List<TCustomerBasic> lists = new ArrayList<TCustomerBasic>(){
            {
                add(new TCustomerBasic());
            }
        };
        when(customerBasicService.getProspectiveCustomers(1000)).thenReturn(lists);
        List<TCustomerBasic> selects = customerBasicService.getProspectiveCustomers(1000);
        assertEquals(selects.size(), 1);
        Mockito.verify(customerBasicMapper).getProspectiveCustomers(1000);
    }

    @Test
    public void isIdCardExist() throws Exception {
        when(customerBasicMapper.isIdCardExist(1)).thenReturn(1);
        boolean idCardExist = customerBasicService.isIdCardExist(1);
        assertTrue(idCardExist);
    }

    @Test
    public void queryCustomer() throws Exception {
        ReturnMapParam returnMapParam = new ReturnMapParam("id", "name");
        returnMapParam.put("managerId", 1);
        Map<Integer, String> map = new HashedMap();
        map.put(1, "1");
        when(customerBasicMapper.queryCustomer(returnMapParam)).thenReturn(map);
        Map map1 = customerBasicService.queryCustomer(returnMapParam);
        assertEquals(map, map1);
    }

    @Test
    public void updateStatus() throws Exception {
        Map<String, Object> map = new HashedMap();
        map.put("status", 1);
        map.put("customerIds", 1);
        when(customerBasicMapper.updateStatus(map)).thenReturn(1);
        int i = customerBasicService.updateStatus(map);
        assertEquals(i, 1);
    }
}