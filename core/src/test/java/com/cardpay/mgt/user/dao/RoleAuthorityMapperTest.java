package com.cardpay.mgt.user.dao;

import com.cardpay.util.TestEnv;
import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

import static org.junit.Assert.*;

public class RoleAuthorityMapperTest extends TestEnv {

    @Autowired
    private RoleAuthorityMapper roleAuthorityMapper;

    @Test
    public void insertArray() throws Exception {
        Map<String, Object> map = new HashedMap();
        map.put("roleId", 1);
        map.put("authorityIds", new Integer[]{1, 2});
        roleAuthorityMapper.insertArray(map);
    }



}