package com.cardpay.mgt.application.ipc.regular.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.application.ipc.regular.model.TApplicationReceive;
import com.cardpay.mgt.application.ipc.regular.model.vo.TApplicationReceiveVo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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
    int insertReceive(TApplicationReceive applicationReceive, BigDecimal receiveTotalValue);

    /**
     * 更新应收预付表更新总计信息
     * @param applicationReceive 应收预付信息
     * @param receiveTotalValue 应收预付总计
     * @return 数据变记录
     */
    int updateReceive(TApplicationReceive applicationReceive, BigDecimal receiveTotalValue);

    /**
     *  删除应收预付更新总计
     * @param receiveId 应收预付id
     * @param receiveTotalValue 应收预付总计
     * @return 数据变记录
     */
    int deleteReceive(int receiveId, BigDecimal receiveTotalValue);

    /**
     * 根据进件id查询应收预付表信息
     * @param map 进件id
     * @return 应收预付表信息
     */
    List<TApplicationReceiveVo> queryByApplicationId(Map<String, Object> map);
}
