package com.cardpay.mgt.organization.service.impl;

import com.cardpay.mgt.organization.dao.TOrganizationMapper;
import com.cardpay.mgt.organization.model.vo.TOrganizationVo;
import com.cardpay.mgt.organization.service.TOrganizationService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


/**
 * Created by chenkai on 2016/11/30.
 */
@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({TOrganizationServiceImpl.class})
public class TOrganizationServiceImplTest {
    @Mock
    private TOrganizationMapper tOrganizationDao;

    @InjectMocks
    private TOrganizationServiceImpl tOrganizationService;


    @Test
    public void queryOrganization() throws Exception {
        List<TOrganizationVo> list = new ArrayList<>();
        TOrganizationVo tOrganizationVo = new TOrganizationVo();
        list.add(tOrganizationVo);
        when(tOrganizationDao.queryOrganization(1)).thenReturn(list);
        List<TOrganizationVo> tOrganizationVos = tOrganizationService.queryOrganization(1, 3);
        assertTrue(tOrganizationVos.size() > 0);
        verify(tOrganizationDao).createOrganizationView(1, 3);

    }

    @Test
    public void deleteOrganization() throws Exception {
//        when(tOrganizationDao.deleteOrganization(1)).thenReturn(1);
//        int flag = tOrganizationService.deleteOrganization(1);
//        assertEquals(1, flag);
    }

    @Test
    @Ignore
    public void queryAll() throws Exception {
        TOrganizationVo tOrganizationVo1 = new TOrganizationVo();
        List<TOrganizationVo> list = new ArrayList<>();
        tOrganizationVo1.setId(2);
        tOrganizationVo1.setOrgParentId(1);
        list.add(tOrganizationVo1);

        TOrganizationVo tOrganizationVo = new TOrganizationVo();
        tOrganizationVo.setId(1);
        tOrganizationVo.setOrgParentId(0);
        tOrganizationVo.setOrganizationList(list);

     /*   List<TOrganizationVo> list1 = new ArrayList<>();
        list1.add(tOrganizationVo);
        when(tOrganizationDao.queryAll()).thenReturn(list1);
        List<TOrganizationVo> tOrganizationVos = tOrganizationService.queryAll(0);
        assertTrue(tOrganizationVos.size() > 0);*/
    }

}