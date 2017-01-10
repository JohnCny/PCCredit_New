package com.cardpay.mgt.product.dao;

import com.cardpay.mgt.product.model.vo.ProductOrganizationVo;
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
public class ProductOrganizationMapperTest extends TestEnv {
    @Autowired
    private ProductOrgMapper tProductOrganizationDao;

    @Test
    public void batchInsert() throws Exception {
        Map<String, Object> map = new HashedMap();
        List<Integer> list = new ArrayList<Integer>() {
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

    @Test
    public void bathDeleteOrg() throws Exception {
        Map<String, Object> map = new HashedMap();
        List<Integer> list = new ArrayList<Integer>() {
            {
                add(2);
                add(3);
                add(4);
            }
        };
        map.put("productId", 1);
        map.put("orgIds", list);
        int flag = tProductOrganizationDao.bathDeleteOrg(map);
        assertTrue(flag > 0);
    }

    @Test
    public void queryProductOrg() throws Exception {
        List<ProductOrganizationVo> productOrganizationPos = tProductOrganizationDao.queryProductOrg(1);
        assertTrue(productOrganizationPos.size() > 0);
    }

}