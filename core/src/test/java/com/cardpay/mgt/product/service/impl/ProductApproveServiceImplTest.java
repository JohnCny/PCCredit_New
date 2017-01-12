package com.cardpay.mgt.product.service.impl;

import com.cardpay.mgt.product.dao.ProductApproveMapper;
import com.cardpay.mgt.user.dao.RoleMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ProductApproveServiceImpl.class})
public class ProductApproveServiceImplTest {

    @InjectMocks
    private ProductApproveServiceImpl productApproveService;

    @Mock
    private ProductApproveMapper productApproveMapper;

    @Mock
    private RoleMapper roleMapper;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getApprove() throws Exception {

    }

    @Test
    public void addApprove() throws Exception {

    }

    @Test
    public void updateApprove() throws Exception {

    }

}