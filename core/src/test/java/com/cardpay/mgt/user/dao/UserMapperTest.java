package com.cardpay.mgt.user.dao;

import com.cardpay.mgt.user.model.User;
import com.cardpay.mgt.user.model.UserAuthority;
import com.cardpay.util.TestEnv;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class UserMapperTest extends TestEnv {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void selectByAuthority() throws Exception {
      /*  User user = new User();
        user.setId(1);
        List<UserAuthority> list = userMapper.selectByAuthority(user);
        Assert.assertTrue(list.size() >= 0);*/
    }

}