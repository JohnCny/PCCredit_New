package com.cardpay.mgt.product.dao;

import com.cardpay.util.TestEnv;
import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * 产品机构表Mapper测试
 * Created by chenkai on 2016/12/8.
 */
public class TProductOrganizationMapperTest extends TestEnv {
    @Autowired
    private TProductOrganizationMapper tProductOrganizationDao;

    @Test
    public void batchInsert() throws Exception {
        Map<String, Object> map = new HashedMap();
        List<Integer> list = new ArrayList<Integer>(){
            {
                add(1);
                add(2);
                add(3);
            }
        };
        map.put("productId", 1);
        map.put("orgIds", list);
        int flag = tProductOrganizationDao.batchInsertOrg(map);
        assertEquals(flag, 3);
    }

}