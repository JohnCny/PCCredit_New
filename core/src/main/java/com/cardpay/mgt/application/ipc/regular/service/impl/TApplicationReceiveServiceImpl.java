package com.cardpay.mgt.application.ipc.regular.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.mgt.application.ipc.regular.dao.TApplicationReceiveMapper;
import com.cardpay.mgt.application.ipc.regular.model.TApplicationReceive;
import com.cardpay.mgt.application.ipc.regular.model.TApplicationTotal;
import com.cardpay.mgt.application.ipc.regular.model.vo.TApplicationReceiveVo;
import com.cardpay.mgt.application.ipc.regular.service.TApplicationReceiveService;
import com.cardpay.mgt.application.ipc.regular.service.TApplicationTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 应收预付表Service实现类
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/9 16:49
 */
@Service
public class TApplicationReceiveServiceImpl extends BaseServiceImpl<TApplicationReceive> implements TApplicationReceiveService {
    @Autowired
    private TApplicationReceiveMapper tApplicationReceiveDao;
    /**
     * 总计表
     */
    @Autowired
    private TApplicationTotalService tApplicationTotalService;


    @Override
    public int insertReceive(TApplicationReceive applicationReceive, BigDecimal receiveTotalValue) {
        TApplicationTotal tApplicationTotal = new TApplicationTotal();
        tApplicationTotal.setApplicationId(applicationReceive.getApplicationId());
        tApplicationTotal.setReceiveTotalValue(receiveTotalValue);
        tApplicationTotalService.updateSelectiveByPrimaryKey(tApplicationTotal);
        return tApplicationReceiveDao.insert(applicationReceive);
    }

    @Override
    public int updateReceive(TApplicationReceive applicationReceive, BigDecimal receiveTotalValue) {
        TApplicationTotal tApplicationTotal = new TApplicationTotal();
        tApplicationTotal.setApplicationId(applicationReceive.getApplicationId());
        tApplicationTotal.setReceiveTotalValue(receiveTotalValue);
        tApplicationTotalService.updateSelectiveByPrimaryKey(tApplicationTotal);
        return tApplicationReceiveDao.updateByPrimaryKeySelective(applicationReceive);
    }

    @Override
    public int deleteReceive(int receiveId, BigDecimal receiveTotalValue) {
        TApplicationReceive tApplicationReceive = tApplicationReceiveDao.selectByPrimaryKey(receiveId);
        TApplicationTotal tApplicationTotal = new TApplicationTotal();
        tApplicationTotal.setApplicationId(tApplicationReceive.getApplicationId());
        tApplicationTotal.setReceiveTotalValue(receiveTotalValue);
        tApplicationTotalService.updateSelectiveByPrimaryKey(tApplicationTotal);
        return tApplicationReceiveDao.deleteByPrimaryKey(receiveId);
    }

    @Override
    public List<TApplicationReceiveVo> queryByApplicationId(Map<String, Object> map) {
        return tApplicationReceiveDao.queryByApplicationId(map);
    }
}
