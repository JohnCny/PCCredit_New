package com.cardpay.mgt.user.dao;

import com.cardpay.mgt.user.model.Authority;
import com.cardpay.util.TestEnv;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

public class AuthorityMapperTest extends TestEnv {

    @Autowired
    private AuthorityMapper authorityMapper;

    @Test
    public void selectAuthorityGroup() throws Exception {
        List<String> list = authorityMapper.selectAuthorityGroup();
        Assert.assertTrue(list.size() > 0);

    }

    @Test
    public void selectByRoleId() throws Exception {
        List<Authority> authorities = authorityMapper.selectByRoleId(1);
        Assert.assertTrue(authorities.size() > 0);

    }

}