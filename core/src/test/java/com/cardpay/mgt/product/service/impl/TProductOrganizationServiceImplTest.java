package com.cardpay.mgt.product.service.impl;

import com.cardpay.mgt.product.dao.TProductOrganizationMapper;
import org.apache.commons.collections.map.HashedMap;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;

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
        when(tProductOrganizationDao.batchInsert(map)).thenReturn(1);
        int flag = tProductOrganizationService.batchInsert(map);
        assertEquals(1, flag);
    }

}