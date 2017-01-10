package com.cardpay.mgt.application.regular.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.mgt.application.regular.dao.TApplicationFixedAssertMapper;
import com.cardpay.mgt.application.regular.model.TApplicationFixedAssert;
import com.cardpay.mgt.application.regular.model.TApplicationTotal;
import com.cardpay.mgt.application.regular.model.vo.TApplicationFixedAssertVo;
import com.cardpay.mgt.application.regular.service.TApplicationFixedAssertService;
import com.cardpay.mgt.application.regular.service.TApplicationTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 固定资产清单表ServiceImpl
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/9 15:37
 */
@Service
public class TApplicationFixedAssertServiceImpl extends BaseServiceImpl<TApplicationFixedAssert> implements TApplicationFixedAssertService {
    /**
     * 固定资产
     */
    @Autowired
    private TApplicationFixedAssertMapper tApplicationFixedAssertDao;
    /**
     * 总计表
     */
    @Autowired
    private TApplicationTotalService tApplicationTotalService;

    @Override
    @Transactional
    public int insertFixedAssert(TApplicationFixedAssert tApplicationFixedAssert, BigDecimal fixedAssertTotalValue, BigDecimal fixedAssertDepreciateValue) {
        TApplicationTotal tApplicationTotal = new TApplicationTotal();
        tApplicationTotal.setApplicationId(tApplicationFixedAssert.getApplicationId());
        tApplicationTotal.setFixedAssertTotalValue(fixedAssertTotalValue);
        tApplicationTotal.setFixedAssertDepreciateValue(fixedAssertDepreciateValue);
        tApplicationTotalService.updateSelectiveByPrimaryKey(tApplicationTotal);
        return tApplicationFixedAssertDao.insert(tApplicationFixedAssert);
    }

    @Override
    @Transactional
    public int updateFixedAssert(TApplicationFixedAssert tApplicationFixedAssert, BigDecimal fixedAssertTotalValue, BigDecimal fixedAssertDepreciateValue) {
        TApplicationTotal tApplicationTotal = new TApplicationTotal();
        tApplicationTotal.setApplicationId(tApplicationFixedAssert.getApplicationId());
        tApplicationTotal.setFixedAssertTotalValue(fixedAssertTotalValue);
        tApplicationTotal.setFixedAssertDepreciateValue(fixedAssertDepreciateValue);
        tApplicationTotalService.updateSelectiveByPrimaryKey(tApplicationTotal);
        return tApplicationFixedAssertDao.updateByPrimaryKeySelective(tApplicationFixedAssert);
    }

    @Override
    @Transactional
    public int deleteFixedAssert(int fixedAssertTotalId, BigDecimal fixedAssertTotalValue, BigDecimal fixedAssertDepreciateValue) {
        TApplicationFixedAssert tApplicationFixedAssert = tApplicationFixedAssertDao.selectByPrimaryKey(fixedAssertTotalId);
        TApplicationTotal tApplicationTotal = new TApplicationTotal();
        tApplicationTotal.setApplicationId(tApplicationFixedAssert.getApplicationId());
        tApplicationTotal.setFixedAssertTotalValue(fixedAssertTotalValue);
        tApplicationTotal.setFixedAssertDepreciateValue(fixedAssertDepreciateValue);
        tApplicationTotalService.updateSelectiveByPrimaryKey(tApplicationTotal);
        return tApplicationFixedAssertDao.deleteByPrimaryKey(fixedAssertTotalId);
    }

    @Override
    public List<TApplicationFixedAssertVo> queryByApplicationId(Map<String, Object> map) {
        return tApplicationFixedAssertDao.queryByApplicationId(map);
    }


}
