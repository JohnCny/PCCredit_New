package com.cardpay.core.shiro.common;

import com.cardpay.mgt.user.model.User;
import org.junit.Assert;
import org.junit.Test;

public class PasswordUtilTest {

    @Test
    public void encryptPassword() throws Exception {
        String password = "123";
        String str = PasswordUtil.encryptPassword(password);
        Assert.assertEquals(str, "e576017f5da64e43703b420dac217cb4");
    }

    @Test
    public void encryptPassword1() throws Exception {
  /*      User user = new User();
        user.setPassword("123");
        String str = PasswordUtil.encryptPassword(user);
        Assert.assertEquals(str, "e576017f5da64e43703b420dac217cb4");*/
    }

}