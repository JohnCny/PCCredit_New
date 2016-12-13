package com.cardpay.mgt.product.service.impl;

import com.cardpay.mgt.product.dao.TProductOrganizationMapper;
import com.cardpay.mgt.product.model.vo.TProductOrganizationVo;
import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 * 产品机构表插入
 * Created by chenkai on 2016/12/8.
 */
@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({TProductOrganizationServiceImpl.class})
public class TProductOrganizationServiceImplTest {
    @Mock
    private TProductOrganizationMapper tProductOrganizationDao;

    @InjectMocks
    private TProductOrganizationServiceImpl tProductOrganizationService;

    @Test
    public void batchInsert() throws Exception {
        Map<String, Object> map = new HashedMap();
        map.put("test", 1);
        when(tProductOrganizationDao.batchInsertOrg(map)).thenReturn(1);
        int flag = tProductOrganizationService.batchInsertOrg(map);
        assertEquals(1, flag);
    }

    @Test
    public void bathDeleteOrg() throws Exception {
        Map<String, Object> map = new HashedMap();
        map.put("productId", 1);
        when(tProductOrganizationDao.bathDeleteOrg(map)).thenReturn(1);
        int flag = tProductOrganizationService.bathDeleteOrg(map);
        assertEquals(1, flag);
    }

    @Test
    public void queryProductOrg() throws Exception {
        List<TProductOrganizationVo> list = new ArrayList<>();
        TProductOrganizationVo tProductOrganizationPo1 = new TProductOrganizationVo();
        tProductOrganizationPo1.setOrganizationId(2);
        tProductOrganizationPo1.setOrgParentId(1);
        list.add(tProductOrganizationPo1);

        TProductOrganizationVo tProductOrganizationPo = new TProductOrganizationVo();
        tProductOrganizationPo.setOrganizationId(1);
        tProductOrganizationPo.setOrgParentId(0);
        tProductOrganizationPo.setChild(list);
        List<TProductOrganizationVo> productOrganizationPoList = new ArrayList<TProductOrganizationVo>() {
            {
                add(tProductOrganizationPo);
            }
        };
        when(tProductOrganizationDao.queryProductOrg(1)).thenReturn(productOrganizationPoList);
        List<TProductOrganizationVo> tProductOrganizationPos = tProductOrganizationService.queryProductOrg(1, 0);
        assertTrue(tProductOrganizationPos.size() > 0);
    }
}