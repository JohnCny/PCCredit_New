package com.cardpay.mgt.user.service.impl;

import com.cardpay.mgt.user.dao.UserRoleMapper;
import com.cardpay.mgt.user.model.UserRole;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserRoleServiceImpl.class})
public class UserRoleServiceImplTest {

    @InjectMocks
    private UserRoleServiceImpl userRoleService;

    @Mock
    private UserRoleMapper userRoleMapper;

    private UserRole userRole;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        userRole = new UserRole();
    }

    @Test
    public void updateUserRole() throws Exception {
        PowerMockito.when(userRoleMapper.selectOne(userRole)).thenReturn(null);
        PowerMockito.when(userRoleMapper.insertSelective(userRole)).thenReturn(1);
        boolean flag;
        flag = userRoleService.updateUserRole(userRole);
        Assert.assertTrue(flag);

        PowerMockito.when(userRoleMapper.selectOne(userRole)).thenReturn(null);
        PowerMockito.when(userRoleMapper.insertSelective(userRole)).thenReturn(0);
        flag = userRoleService.updateUserRole(userRole);
        Assert.assertFalse(flag);

        PowerMockito.when(userRoleMapper.selectOne(userRole)).thenReturn(userRole);
        PowerMockito.when(userRoleMapper.delete(userRole)).thenReturn(1);
        flag = userRoleService.updateUserRole(userRole);
        Assert.assertTrue(flag);

        PowerMockito.when(userRoleMapper.selectOne(userRole)).thenReturn(userRole);
        PowerMockito.when(userRoleMapper.delete(userRole)).thenReturn(0);
        flag = userRoleService.updateUserRole(userRole);
        Assert.assertFalse(flag);

    }

}