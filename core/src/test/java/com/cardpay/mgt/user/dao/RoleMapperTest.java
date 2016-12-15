package com.cardpay.mgt.user.dao;

import com.cardpay.mgt.user.model.Role;
import com.cardpay.mgt.user.model.User;
import com.cardpay.util.TestEnv;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class RoleMapperTest extends TestEnv {

    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void selectByUser() throws Exception {
        User user = new User();
        user.setId(1);
        List<Role> roles = roleMapper.selectByUser(user);
        Assert.assertTrue(roles.size() > 0);
    }

}