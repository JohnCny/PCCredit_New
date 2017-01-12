package com.cardpay.mgt.customer.service.impl;

import com.cardpay.mgt.customer.dao.TCustomerTransferMapper;
import com.cardpay.mgt.customer.model.TCustomerBasic;
import com.cardpay.mgt.customer.model.TCustomerTransfer;
import com.cardpay.mgt.customer.model.vo.TCustomerVo;
import com.cardpay.mgt.message.service.impl.MessageServiceImpl;
import com.cardpay.mgt.user.model.User;
import com.cardpay.mgt.user.service.impl.UserServiceImpl;
import org.apache.commons.collections.map.HashedMap;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

/**
 * @author chenkai 2016/12/20 17:07
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({TCustomerTransferServiceImpl.class})
public class TCustomerTransferServiceImplTest {
    @Mock
    private TCustomerTransferMapper tCustomerTransferDao;

    @Mock
    private MessageServiceImpl messageService;

    @Mock
    private UserServiceImpl userService;

    @Mock
    private TCustomerBasicServiceImpl tCustomerBasicService;

    @InjectMocks
    private TCustomerTransferServiceImpl tCustomerTransferService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

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
        HashMap<String, Object> map = new HashMap();
        TCustomerTransfer tCustomerTransfer = new TCustomerTransfer();
        tCustomerTransfer.setOriginCustomerManager(1);
        User user = new User();
        user.setUserCname("1");
        TCustomerBasic tCustomerBasic = new TCustomerBasic();
        tCustomerBasic.setCname("1");
        whenNew(HashMap.class).withNoArguments().thenReturn(map);
        when(tCustomerTransferDao.accept(map)).thenReturn(-1);
        when(userService.selectByPrimaryKey(1)).thenReturn(user);
        when(tCustomerBasicService.selectByPrimaryKey(1)).thenReturn(tCustomerBasic);
        when(tCustomerTransferDao.selectByPrimaryKey(1)).thenReturn(tCustomerTransfer);
        messageService.sendMessage("客户移交结果", "test", tCustomerTransfer.getOriginCustomerManager()
                , 0, 0);
        int accept = tCustomerTransferService.accept("1", 1, );
        assertEquals(accept, -1);
    }
}