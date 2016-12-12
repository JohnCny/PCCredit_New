package com.cardpay.mgt.user.service.impl;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.mail.MailSend;
import com.cardpay.basic.redis.RedisClient;
import com.cardpay.basic.redis.enums.RedisKeyPrefixEnum;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.user.dao.RoleMapper;
import com.cardpay.mgt.user.dao.UserMapper;
import com.cardpay.mgt.user.model.Role;
import com.cardpay.mgt.user.model.User;
import com.cardpay.mgt.user.model.UserAuthority;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@RunWith(PowerMockRunner.class)
@PrepareForTest({UserServiceImpl.class, ShiroKit.class, User.class})
public class UserServiceImplTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private RoleMapper roleMapper;

    @Mock
    private UserMapper userMapper;

    @Mock
    private RedisClient redisClient;

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
        user.setPassword("e576017f5da64e43703b420dac217cb4");
        PowerMockito.mockStatic(ShiroKit.class);
        PowerMockito.when(ShiroKit.getPrincipal()).thenReturn(user);
        User mockUser = PowerMockito.mock(User.class);
        PowerMockito.whenNew(User.class).withAnyArguments().thenReturn(mockUser);
        PowerMockito.when(userMapper.updateByPrimaryKeySelective(mockUser)).thenReturn(1);
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
    public void sendCode() {
        PowerMockito.when(userMapper.selectByPrimaryKey(1)).thenReturn(user);
        ResultTo resultTo;
        resultTo = userService.sendCode(1, "rankai@qkjr.com.cn");
        Assert.assertEquals(resultTo.getCode(), 200);

        resultTo = userService.sendCode(1, "mayuan@qkjr.com.cn");
        Assert.assertEquals(resultTo.getCode(), 5014);

        resultTo = userService.sendCode(1, "mayuan");
        Assert.assertEquals(resultTo.getCode(), 5013);
    }

    @Test
    public void checkedCode() {
        PowerMockito.when(redisClient.get(RedisKeyPrefixEnum.USER, "rankai@qkjr.com.cn")).thenReturn("123456");
        ResultTo resultTo;
        resultTo = userService.checkedCode("rankai@qkjr.com.cn", "123456");
        Assert.assertEquals(resultTo.getCode(), 200);

        resultTo = userService.checkedCode("rankai@qkjr.com.cn", "654321");
        Assert.assertEquals(resultTo.getCode(), 5009);

        PowerMockito.when(redisClient.get(RedisKeyPrefixEnum.USER, "rankai@qkjr.com.cn")).thenReturn(null);
        resultTo = userService.checkedCode("rankai@qkjr.com.cn", "123456");
        Assert.assertEquals(resultTo.getCode(), 5010);

    }

}