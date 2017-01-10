package com.cardpay.mgt.user.service.impl;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.mail.MailSend;
import com.cardpay.basic.redis.RedisClient;
import com.cardpay.basic.redis.enums.RedisKeyPrefixEnum;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.user.dao.RoleMapper;
import com.cardpay.mgt.user.dao.UserMapper;
import com.cardpay.mgt.user.dao.UserOrganizationMapper;
import com.cardpay.mgt.user.dao.UserRoleMapper;
import com.cardpay.mgt.user.model.Role;
import com.cardpay.mgt.user.model.User;
import com.cardpay.mgt.user.model.UserAuthority;
import com.cardpay.mgt.user.model.UserOrganization;
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
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserServiceImpl.class, ShiroKit.class, User.class, TransactionAspectSupport.class})
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private BaseServiceImpl baseService;

    @Mock
    private UserMapper userMapper;

    @Mock
    private RoleMapper roleMapper;

    @Mock
    private RedisClient redisClient;

    @Mock
    private UserOrganizationMapper userOrganizationMapper;

    @Mock
    private UserRoleMapper userRoleMapper;

    @Mock
    private MailSend mailSend;

    private User user;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        user = User.UserBuilder.get().withId(1).withPassword("123").withUsername("test")
                .withEmail("rankai@qkjr.com.cn").build();
    }

    @Test
    public void getUserAuthority() throws Exception {
        UserAuthority userAuthority = new UserAuthority();
        userAuthority.setAuthorityName("Authority");
        userAuthority.setResoucreName("/Resoucre");
        userAuthority.setOperationName("Operation");
        List<UserAuthority> list = new ArrayList<>();
        list.add(userAuthority);
        PowerMockito.when(userMapper.selectByAuthority(user)).thenReturn(list);
        Set<String> set = userService.getUserAuthority(user);
        for (String str : set) {
            Assert.assertEquals(str, "Authority:/Resoucre:Operation");
        }
    }

    @Test
    public void getUserRole() throws Exception {
        Role role = new Role();
        role.setRoleName("Role");
        List<Role> list = new ArrayList<>();
        list.add(role);
        PowerMockito.when(roleMapper.selectByUser(user)).thenReturn(list);
        Set<String> set = userService.getUserRole(user);
        for (String str : set) {
            Assert.assertEquals(str, "Role");
        }
    }

    @Test
    public void updatePassword() throws Exception {
        PowerMockito.mockStatic(ShiroKit.class);
        PowerMockito.when(ShiroKit.getUserId()).thenReturn(1);
        User mockUser = PowerMockito.mock(User.class);
        mockUser.setPassword("e576017f5da64e43703b420dac217cb4");
        PowerMockito.when(userMapper.selectByPrimaryKey(1)).thenReturn(mockUser);
        ResultTo resultTo;

        resultTo = userService.updatePassword("321", "321");
        Assert.assertEquals(resultTo.getCode(), 5016);

        resultTo = userService.updatePassword("123", "321");
        Assert.assertEquals(resultTo.getCode(), 200);

        PowerMockito.when(userMapper.updateByPrimaryKeySelective(mockUser)).thenReturn(0);
        resultTo = userService.updatePassword("123", "321");
        Assert.assertEquals(resultTo.getCode(), 5020);
    }

    @Test
    public void sendCode() throws Exception {

        PowerMockito.when(userMapper.selectByPrimaryKey(1)).thenReturn(user);
        ResultTo resultTo;
        resultTo = userService.sendCode("rankai@qkjr.com.cn");
        Assert.assertEquals(resultTo.getCode(), 200);

        resultTo = userService.sendCode("mayuan@qkjr.com.cn");
        Assert.assertEquals(resultTo.getCode(), 5014);

        resultTo = userService.sendCode("mayuan");
        Assert.assertEquals(resultTo.getCode(), 5013);
    }

    @Test
    public void checkedCode() throws Exception {
/*        PowerMockito.when(redisClient.get(RedisKeyPrefixEnum.USER, "rankai@qkjr.com.cn")).thenReturn("123456");
        ResultTo resultTo;
        resultTo = userService.checkedCode("rankai@qkjr.com.cn", "123456");
        Assert.assertEquals(resultTo.getCode(), 200);

        resultTo = userService.checkedCode("rankai@qkjr.com.cn", "654321");
        Assert.assertEquals(resultTo.getCode(), 5009);

        PowerMockito.when(redisClient.get(RedisKeyPrefixEnum.USER, "rankai@qkjr.com.cn")).thenReturn(null);
        resultTo = userService.checkedCode("rankai@qkjr.com.cn", "123456");
        Assert.assertEquals(resultTo.getCode(), 5010);*/

    }

    @Test
    public void resetPassword() throws Exception {
    /*    PowerMockito.whenNew(User.class).withAnyArguments().thenReturn(user);
        PowerMockito.when(redisClient.get(RedisKeyPrefixEnum.USER, "d3gsd77df3m4ghg5")).thenReturn("");
        PowerMockito.when(userMapper.updateByPrimaryKeySelective(user)).thenReturn(1);
        ResultTo resultTo;
        resultTo = userService.resetPassword(1, "d3gsd77df3m4ghg5", "654321");
        Assert.assertEquals(resultTo.getCode(), 200);

        resultTo = userService.resetPassword(1, "aaaaaaaaaaaaaaaa", "654321");
        Assert.assertEquals(resultTo.getCode(), 5021);*/
    }

    @Test
    public void addUser() throws Exception {

        PowerMockito.mockStatic(ShiroKit.class);
        PowerMockito.when(ShiroKit.getPrincipal()).thenReturn(user);
        UserOrganization userOrganization = new UserOrganization();
        PowerMockito.whenNew(UserOrganization.class).withAnyArguments().thenReturn(userOrganization);
        UserRole userRole = new UserRole();
        PowerMockito.whenNew(UserRole.class).withAnyArguments().thenReturn(userRole);
        boolean flag;

        PowerMockito.when(userMapper.insertSelective(user)).thenReturn(1);
        PowerMockito.when(userOrganizationMapper.insertSelective(userOrganization)).thenReturn(1);
        PowerMockito.when(userRoleMapper.insertSelective(userRole)).thenReturn(1);
        flag = userService.addUser(user, 1, 1);
        Assert.assertTrue(flag);
    }

    @Test
    public void updateUser() throws Exception {
        PowerMockito.when(userMapper.updateByPrimaryKeySelective(user)).thenReturn(1);
        PowerMockito.when(userMapper.updateByPrimaryKeySelective(user)).thenReturn(1);
        PowerMockito.when(userMapper.updateByPrimaryKeySelective(user)).thenReturn(1);
        PowerMockito.when(userMapper.updateByPrimaryKeySelective(user)).thenReturn(1);
    }

}