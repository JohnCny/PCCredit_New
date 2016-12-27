package com.cardpay.mgt.customer.service.impl;

import com.cardpay.basic.common.constant.ConstantEnum;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.customer.dao.TCustomerTransferMapper;
import com.cardpay.mgt.customer.model.vo.TCustomerVo;
import org.apache.commons.collections.map.HashedMap;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
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
    public void queryTransfer() throws Exception {
        Map<String, Object> map = new HashedMap();
        map.put("managerId", 1);
       List<TCustomerVo> tCustomerTransferVos = new ArrayList<>();
        tCustomerTransferVos.add(new TCustomerVo());
        when(tCustomerTransferDao.queryTransfer(map)).thenReturn(tCustomerTransferVos);
        List<TCustomerVo> customerVos = tCustomerTransferService.queryTransfer(map);
        assertTrue(customerVos.size() > 0);
    }

    @Test
    public void accept() throws Exception {
        Map<String, Object> map = new HashedMap();
        List<Integer> idList = new ArrayList<>();
        idList.add(1);
        map.put("customerIds", idList);
        map.put("transferStatus", ConstantEnum.TransferStatus.STATUS1.getVal());
        when(tCustomerTransferDao.accept(map)).thenReturn(1);
        int accept = tCustomerTransferService.accept("1", 2);
        assertEquals(accept, 0);
    }
}