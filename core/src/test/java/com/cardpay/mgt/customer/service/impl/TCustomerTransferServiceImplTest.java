package com.cardpay.mgt.customer.service.impl;

import com.cardpay.mgt.customer.dao.TCustomerTransferMapper;
import com.cardpay.mgt.customer.model.vo.TCustomerTransferVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * @author chenkai 2016/12/20 17:07
 */
@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({TCustomerTransferServiceImpl.class})
public class TCustomerTransferServiceImplTest {
    @Mock
    private TCustomerTransferMapper tCustomerTransferDao;

    @InjectMocks
    private TCustomerTransferServiceImpl tCustomerTransferService;


    @Test
    public void getTransferStatus() throws Exception {

    }

    @Test
    public void queryTransfer() throws Exception {
        List<TCustomerTransferVo> tCustomerTransferVos = new ArrayList<>();
        tCustomerTransferVos.add(new TCustomerTransferVo());
        when(tCustomerTransferDao.queryTransfer(0, 1)).thenReturn(tCustomerTransferVos);
        List<TCustomerTransferVo> tCustomerTransferVos1 = tCustomerTransferService.queryTransfer(0, 1);
        assertTrue(tCustomerTransferVos1.size() > 0);
    }

}