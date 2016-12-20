package com.cardpay.mgt.customertransfer.service;

import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.mgt.customer.dao.TCustomerTransferMapper;
import com.cardpay.mgt.customer.service.TCustomerTransferService;
import com.cardpay.mgt.customer.service.impl.TCustomerTransferServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.util.List;

import static org.junit.Assert.*;

/**
 *客户移交测试类
 * @author wangpeng
 */
@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({TCustomerTransferService.class})
public class CustomerTransferServiceTest {
    @Mock
    private TCustomerTransferMapper customerTransferMapper;

    @InjectMocks
    private TCustomerTransferServiceImpl customerTransferService;

    @Test
    public void getTransferStatus() throws Exception {
        List<SelectModel> selects = (List<SelectModel>)customerTransferService.getTransferStatus();
        assertEquals(selects.size(), 3);
    }

}