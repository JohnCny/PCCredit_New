package com.cardpay.mgt.application.regular.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.mgt.application.regular.model.TApplicationPayable;
import com.cardpay.mgt.application.regular.model.TApplicationTotal;
import com.cardpay.mgt.application.regular.model.vo.TApplicationPayableVo;
import com.cardpay.mgt.application.regular.service.TApplicationPayableService;
import com.cardpay.mgt.application.regular.service.TApplicationTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 应付预收表Service实现类
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/9 16:54
 */
@Service
public class TApplicationPayableServiceImpl extends BaseServiceImpl<TApplicationPayable> implements TApplicationPayableService {
    @Autowired
    private TApplicationPayableService tApplicationPayableService;

    /**
     * 总计表
     */
    @Autowired
    private TApplicationTotalService tApplicationTotalService;

    @Override
    public int insertFixedAssert(TApplicationPayable applicationPayable, BigDecimal payableTotalValue) {
        TApplicationTotal tApplicationTotal = new TApplicationTotal();
        tApplicationTotal.setApplicationId(applicationPayable.getApplicationId());
        tApplicationTotal.setPayableTotalValue(payableTotalValue);
        tApplicationTotalService.updateSelectiveByPrimaryKey(tApplicationTotal);
        return tApplicationPayableService.insert(applicationPayable);
    }

    @Override
    public int updateFixedAssert(TApplicationPayable applicationPayable, BigDecimal payableTotalValue) {
        TApplicationTotal tApplicationTotal = new TApplicationTotal();
        tApplicationTotal.setApplicationId(applicationPayable.getApplicationId());
        tApplicationTotal.setPayableTotalValue(payableTotalValue);
        tApplicationTotalService.updateSelectiveByPrimaryKey(tApplicationTotal);
        return tApplicationPayableService.updateSelectiveByPrimaryKey(applicationPayable);
    }

    @Override
    public int deleteFixedAssert(int payableId, BigDecimal payableTotalValue) {
        TApplicationPayable tApplicationPayable = tApplicationPayableService.selectByPrimaryKey(payableId);
        TApplicationTotal tApplicationTotal = new TApplicationTotal();
        tApplicationTotal.setApplicationId(tApplicationPayable.getApplicationId());
        tApplicationTotal.setPayableTotalValue(payableTotalValue);
        tApplicationTotalService.updateSelectiveByPrimaryKey(tApplicationTotal);
        return tApplicationPayableService.deleteByPrimaryKey(payableId);
    }

    @Override
    public List<TApplicationPayableVo> queryByApplicationId(Map<String, Object> map) {
        return tApplicationPayableService.queryByApplicationId(map);
    }
}
