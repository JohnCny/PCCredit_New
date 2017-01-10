package com.cardpay.mgt.application.regular.service.impl;

import com.cardpay.mgt.application.regular.dao.TApplicationReceiveMapper;
import com.cardpay.mgt.application.regular.model.TApplicationPayable;
import com.cardpay.mgt.application.regular.model.TApplicationReceive;
import com.cardpay.mgt.application.regular.model.TApplicationTotal;
import com.cardpay.mgt.application.regular.model.vo.TApplicationPayableVo;
import com.cardpay.mgt.application.regular.model.vo.TApplicationReceiveVo;
import com.cardpay.mgt.application.regular.service.TApplicationReceiveService;
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
 * 应收预付表测试类
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/10 10:20
 */
@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({TApplicationReceiveService.class})
public class TApplicationReceiveServiceImplTest {
    @Mock
    private TApplicationReceiveMapper tApplicationReceiveDao;

    @Mock
    private TApplicationTotalService tApplicationTotalService;

    @InjectMocks
    private TApplicationReceiveServiceImpl tApplicationReceiveService;

    @Test
    public void insertReceive() throws Exception {
        TApplicationReceive applicationReceive = new TApplicationReceive();
        applicationReceive.setApplicationId(1);
        TApplicationTotal tApplicationTotal = new TApplicationTotal();
        whenNew(TApplicationTotal.class).withNoArguments().thenReturn(tApplicationTotal);
        when(tApplicationTotalService.updateSelectiveByPrimaryKey(tApplicationTotal)).thenReturn(1);
        when(tApplicationReceiveDao.insert(applicationReceive)).thenReturn(1);
        int insertReceive = tApplicationReceiveService.insertReceive(applicationReceive, new BigDecimal(1.0));
        assertEquals(insertReceive, 1);
    }

    @Test
    public void updateReceive() throws Exception {
        TApplicationReceive applicationReceive = new TApplicationReceive();
        applicationReceive.setApplicationId(1);
        TApplicationTotal tApplicationTotal = new TApplicationTotal();
        whenNew(TApplicationTotal.class).withNoArguments().thenReturn(tApplicationTotal);
        when(tApplicationTotalService.updateSelectiveByPrimaryKey(tApplicationTotal)).thenReturn(1);
        when(tApplicationReceiveDao.updateByPrimaryKeySelective(applicationReceive)).thenReturn(1);
        int insertReceive = tApplicationReceiveService.updateReceive(applicationReceive, new BigDecimal(1.0));
        assertEquals(insertReceive, 1);
    }

    @Test
    public void deleteReceive() throws Exception {
        TApplicationReceive applicationReceive = new TApplicationReceive();
        applicationReceive.setApplicationId(1);
        TApplicationTotal tApplicationTotal = new TApplicationTotal();
        whenNew(TApplicationTotal.class).withNoArguments().thenReturn(tApplicationTotal);
        when(tApplicationReceiveDao.selectByPrimaryKey(1)).thenReturn(applicationReceive);
        when(tApplicationTotalService.updateSelectiveByPrimaryKey(tApplicationTotal)).thenReturn(1);
        when(tApplicationReceiveDao.deleteByPrimaryKey(1)).thenReturn(1);
        int deleteReceive = tApplicationReceiveService.deleteReceive(1, new BigDecimal(1.0));
        assertEquals(deleteReceive, 1);
    }

    @Test
    public void queryByApplicationId() throws Exception {
        Map<String, Object> map = new HashMap<>();
        List<TApplicationReceiveVo> list = new ArrayList<>();
        list.add(new TApplicationReceiveVo());
        when(tApplicationReceiveDao.queryByApplicationId(map)).thenReturn(list);
        List<TApplicationReceiveVo> list1 = tApplicationReceiveService.queryByApplicationId(map);
        assertEquals(list, list1);
    }

}