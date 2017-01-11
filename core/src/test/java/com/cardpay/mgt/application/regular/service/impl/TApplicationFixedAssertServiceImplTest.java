package com.cardpay.mgt.application.regular.service.impl;

import com.cardpay.mgt.application.regular.dao.TApplicationFixedAssertMapper;
import com.cardpay.mgt.application.regular.model.TApplicationFixedAssert;
import com.cardpay.mgt.application.regular.model.TApplicationTotal;
import com.cardpay.mgt.application.regular.model.vo.TApplicationFixedAssertVo;
import com.cardpay.mgt.application.regular.service.TApplicationFixedAssertService;
import com.cardpay.mgt.application.regular.service.TApplicationTotalService;
import com.cardpay.mgt.customer.service.TCustomerBasicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

/**
 * 固定资产清单表测试
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/10 9:51
 */
@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({TApplicationFixedAssertService.class})
public class TApplicationFixedAssertServiceImplTest {
    @Mock
    private TApplicationFixedAssertMapper tApplicationFixedAssertDao;

    @Mock
    private TApplicationTotalService tApplicationTotalService;

    @InjectMocks
    private TApplicationFixedAssertServiceImpl tApplicationFixedAssertService;

    @Test
    public void insertFixedAssert() throws Exception {
        TApplicationFixedAssert tApplicationFixedAssert = new TApplicationFixedAssert();
        tApplicationFixedAssert.setApplicationId(1);
        TApplicationTotal tApplicationTotal = new TApplicationTotal();
        whenNew(TApplicationTotal.class).withNoArguments().thenReturn(tApplicationTotal);
        when(tApplicationTotalService.updateSelectiveByPrimaryKey(tApplicationTotal)).thenReturn(1);
        when(tApplicationFixedAssertDao.insert(tApplicationFixedAssert)).thenReturn(1);
        int insertFixedAssert = tApplicationFixedAssertService.insertFixedAssert(tApplicationFixedAssert, new BigDecimal(1.0), new BigDecimal(1.0));
        assertEquals(insertFixedAssert, 1);
    }

    @Test
    public void updateFixedAssert() throws Exception {
        TApplicationFixedAssert tApplicationFixedAssert = new TApplicationFixedAssert();
        tApplicationFixedAssert.setApplicationId(1);
        TApplicationTotal tApplicationTotal = new TApplicationTotal();
        whenNew(TApplicationTotal.class).withNoArguments().thenReturn(tApplicationTotal);
        when(tApplicationTotalService.updateSelectiveByPrimaryKey(tApplicationTotal)).thenReturn(1);
        when(tApplicationFixedAssertDao.updateByPrimaryKeySelective(tApplicationFixedAssert)).thenReturn(1);
        int updateFixedAssert = tApplicationFixedAssertService.updateFixedAssert(tApplicationFixedAssert, new BigDecimal(1.0), new BigDecimal(1.0));
        assertEquals(updateFixedAssert, 1);
    }

    @Test
    public void deleteFixedAssert() throws Exception {
        TApplicationFixedAssert tApplicationFixedAssert = new TApplicationFixedAssert();
        tApplicationFixedAssert.setApplicationId(1);
        TApplicationTotal tApplicationTotal = new TApplicationTotal();
        whenNew(TApplicationTotal.class).withNoArguments().thenReturn(tApplicationTotal);
        when(tApplicationFixedAssertService.selectByPrimaryKey(1)).thenReturn(tApplicationFixedAssert);
        when(tApplicationTotalService.updateSelectiveByPrimaryKey(tApplicationTotal)).thenReturn(1);
        when(tApplicationFixedAssertDao.deleteByPrimaryKey(1)).thenReturn(1);
        int deleteFixedAssert = tApplicationFixedAssertService.deleteFixedAssert(1, new BigDecimal(1.0), new BigDecimal(1.0));
        assertEquals(deleteFixedAssert, 1);
    }

    @Test
    public void queryByApplicationId() throws Exception {
        Map<String, Object> map = new HashMap<>();
        List<TApplicationFixedAssertVo> list = new ArrayList<>();
        list.add(new TApplicationFixedAssertVo());
        when(tApplicationFixedAssertDao.queryByApplicationId(map)).thenReturn(list);
        List<TApplicationFixedAssertVo> list1 = tApplicationFixedAssertService.queryByApplicationId(map);
        assertEquals(list, list1);
    }

}