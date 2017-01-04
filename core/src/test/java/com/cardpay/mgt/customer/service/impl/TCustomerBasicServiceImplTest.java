package com.cardpay.mgt.customer.service.impl;

import com.cardpay.mgt.customer.dao.TCustomerBasicMapper;
import com.cardpay.mgt.customer.model.TCustomerBasic;
import com.cardpay.mgt.customer.model.vo.TCustomerTransferVo;
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
 * 客户基本信息测试类
 *
 * @author chenkai
 */
@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({TCustomerBasicService.class})
public class TCustomerBasicServiceImplTest {

    @Test
    public void queryCustomerByCondition() throws Exception {

    }

    @Mock
    private TCustomerBasicMapper customerBasicMapper;

    @InjectMocks
    private TCustomerBasicServiceImpl customerBasicService;

    @Test
    public void isIdCardExist() throws Exception {
        when(customerBasicMapper.isIdCardExist(1)).thenReturn(1);
        boolean idCardExist = customerBasicService.isIdCardExist(1);
        assertTrue(idCardExist);
    }

    @Test
    public void queryCustomer() throws Exception {
        List<TCustomerTransferVo> list = new ArrayList<>();
        list.add(new TCustomerTransferVo());
        when(customerBasicMapper.queryCustomer(1)).thenReturn(list);
        List<TCustomerTransferVo> tCustomerBasics = customerBasicService.queryCustomer(1);
        assertTrue(tCustomerBasics.size() > 0);
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