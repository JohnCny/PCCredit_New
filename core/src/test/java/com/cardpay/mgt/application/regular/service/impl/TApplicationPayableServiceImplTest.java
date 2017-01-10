package com.cardpay.mgt.application.regular.service.impl;

import com.cardpay.mgt.application.regular.dao.TApplicationPayableMapper;
import com.cardpay.mgt.application.regular.model.TApplicationPayable;
import com.cardpay.mgt.application.regular.model.TApplicationTotal;
import com.cardpay.mgt.application.regular.model.vo.TApplicationPayableVo;
import com.cardpay.mgt.application.regular.service.TApplicationPayableService;
import com.cardpay.mgt.application.regular.service.TApplicationTotalService;
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

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;


/**
 * 应付预收表测试
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/10 10:10
 */
@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({TApplicationPayableService.class})
public class TApplicationPayableServiceImplTest {
    @Mock
    private TApplicationPayableMapper tApplicationPayableDao;

    @Mock
    private TApplicationTotalService tApplicationTotalService;

    @InjectMocks
    private TApplicationPayableServiceImpl tApplicationPayableService;

    @Test
    public void insertPayable() throws Exception {
        TApplicationPayable tApplicationFixedAssert = new TApplicationPayable();
        tApplicationFixedAssert.setApplicationId(1);
        TApplicationTotal tApplicationTotal = new TApplicationTotal();
        whenNew(TApplicationTotal.class).withNoArguments().thenReturn(tApplicationTotal);
        when(tApplicationTotalService.updateSelectiveByPrimaryKey(tApplicationTotal)).thenReturn(1);
        when(tApplicationPayableDao.insert(tApplicationFixedAssert)).thenReturn(1);
        int insertPayable = tApplicationPayableService.insertPayable(tApplicationFixedAssert, new BigDecimal(1.0));
        assertEquals(insertPayable, 1);
    }

    @Test
    public void updatePayable() throws Exception {
        TApplicationPayable tApplicationFixedAssert = new TApplicationPayable();
        tApplicationFixedAssert.setApplicationId(1);
        TApplicationTotal tApplicationTotal = new TApplicationTotal();
        whenNew(TApplicationTotal.class).withNoArguments().thenReturn(tApplicationTotal);
        when(tApplicationTotalService.updateSelectiveByPrimaryKey(tApplicationTotal)).thenReturn(1);
        when(tApplicationPayableDao.updateByPrimaryKeySelective(tApplicationFixedAssert)).thenReturn(1);
        int updatePayable = tApplicationPayableService.updatePayable(tApplicationFixedAssert, new BigDecimal(1.0));
        assertEquals(updatePayable, 1);
    }

    @Test
    public void deletePayable() throws Exception {
        TApplicationPayable tApplicationFixedAssert = new TApplicationPayable();
        tApplicationFixedAssert.setApplicationId(1);
        TApplicationTotal tApplicationTotal = new TApplicationTotal();
        whenNew(TApplicationTotal.class).withNoArguments().thenReturn(tApplicationTotal);
        when(tApplicationPayableDao.selectByPrimaryKey(1)).thenReturn(tApplicationFixedAssert);
        when(tApplicationTotalService.updateSelectiveByPrimaryKey(tApplicationTotal)).thenReturn(1);
        when(tApplicationPayableDao.deleteByPrimaryKey(1)).thenReturn(1);
        int deletePayable = tApplicationPayableService.deletePayable(1, new BigDecimal(1.0));
        assertEquals(deletePayable, 1);
    }

    @Test
    public void queryByApplicationId() throws Exception {
        Map<String, Object> map = new HashMap<>();
        List<TApplicationPayableVo> list = new ArrayList<>();
        list.add(new TApplicationPayableVo());
        when(tApplicationPayableDao.queryByApplicationId(map)).thenReturn(list);
        List<TApplicationPayableVo> list1 = tApplicationPayableService.queryByApplicationId(map);
        assertEquals(list, list1);
    }

}