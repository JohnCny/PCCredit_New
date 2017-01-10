package com.cardpay.mgt.application.regular.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.application.regular.model.TApplicationReceive;

import java.math.BigDecimal;

/**
 * 应收预付表Service
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/9 16:45
 */
public interface TApplicationReceiveService extends BaseService<TApplicationReceive> {
    /**
     * 添加应收预付表信息更新总计
     * @param applicationReceive 应收预付信息
     * @param receiveTotalValue 应收预付总计
     * @return 数据变记录
     */
    int insertFixedAssert(TApplicationReceive applicationReceive, BigDecimal receiveTotalValue);

    /**
     * 更新应收预付表更新总计信息
     * @param applicationReceive 应收预付信息
     * @param receiveTotalValue 应收预付总计
     * @return 数据变记录
     */
    int updateFixedAssert(TApplicationReceive applicationReceive, BigDecimal receiveTotalValue);

    /**
     *  删除应收预付更新总计
     * @param receiveId 应收预付id
     * @param receiveTotalValue 应收预付总计
     * @return 数据变记录
     */
    int deleteFixedAssert(int receiveId, BigDecimal receiveTotalValue);
}
