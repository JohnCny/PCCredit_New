package com.cardpay.mgt.application.regular.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.mgt.application.regular.model.TApplicationReceive;
import com.cardpay.mgt.application.regular.model.TApplicationTotal;
import com.cardpay.mgt.application.regular.service.TApplicationReceiveService;
import com.cardpay.mgt.application.regular.service.TApplicationTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 应收预付表Service实现类
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/9 16:49
 */
@Service
public class TApplicationReceiveServiceImpl extends BaseServiceImpl<TApplicationReceive> implements TApplicationReceiveService {
    @Autowired
    private TApplicationReceiveService tApplicationReceiveService;
    /**
     * 总计表
     */
    @Autowired
    private TApplicationTotalService tApplicationTotalService;


    @Override
    public int insertFixedAssert(TApplicationReceive applicationReceive, BigDecimal receiveTotalValue) {
        TApplicationTotal tApplicationTotal = new TApplicationTotal();
        tApplicationTotal.setApplicationId(applicationReceive.getApplicationId());
        tApplicationTotal.setReceiveTotalValue(receiveTotalValue);
        tApplicationTotalService.updateSelectiveByPrimaryKey(tApplicationTotal);
        return tApplicationReceiveService.insert(applicationReceive);
    }

    @Override
    public int updateFixedAssert(TApplicationReceive applicationReceive, BigDecimal receiveTotalValue) {
        TApplicationTotal tApplicationTotal = new TApplicationTotal();
        tApplicationTotal.setApplicationId(applicationReceive.getApplicationId());
        tApplicationTotal.setReceiveTotalValue(receiveTotalValue);
        tApplicationTotalService.updateSelectiveByPrimaryKey(tApplicationTotal);
        return tApplicationReceiveService.updateSelectiveByPrimaryKey(applicationReceive);
    }

    @Override
    public int deleteFixedAssert(int receiveId, BigDecimal receiveTotalValue) {
        TApplicationReceive tApplicationReceive = tApplicationReceiveService.selectByPrimaryKey(receiveId);
        TApplicationTotal tApplicationTotal = new TApplicationTotal();
        tApplicationTotal.setApplicationId(tApplicationReceive.getApplicationId());
        tApplicationTotal.setReceiveTotalValue(receiveTotalValue);
        tApplicationTotalService.updateSelectiveByPrimaryKey(tApplicationTotal);
        return tApplicationReceiveService.deleteByPrimaryKey(receiveId);
    }
}
