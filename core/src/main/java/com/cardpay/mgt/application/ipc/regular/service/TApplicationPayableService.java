package com.cardpay.mgt.application.ipc.regular.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.application.ipc.regular.model.TApplicationPayable;
import com.cardpay.mgt.application.ipc.regular.model.vo.TApplicationPayableVo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 应付预收Service
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/9 16:53
 */
public interface TApplicationPayableService extends BaseService<TApplicationPayable> {
    /**
     * 添加应付预收表信息更新总计
     * @param applicationPayable 应付预收信息
     * @param payableTotalValue 应付预收总计
     * @return 数据变记录
     */
    int insertPayable(TApplicationPayable applicationPayable, BigDecimal payableTotalValue);

    /**
     * 更新应付预收表更新总计信息
     * @param applicationPayable 应付预收信息
     * @param payableTotalValue 应付预收总计
     * @return 数据变记录
     */
    int updatePayable(TApplicationPayable applicationPayable, BigDecimal payableTotalValue);

    /**
     *  删除应付预收更新总计
     * @param payableId 应付预收id
     * @param payableTotalValue 应付预收总计
     * @return 数据变记录
     */
    int deletePayable(int payableId, BigDecimal payableTotalValue);

    /**
     * 根据进件id查询应付预收表信息
     * @param map 进件id
     * @return 应付预收表信息
     */
    List<TApplicationPayableVo> queryByApplicationId(Map<String, Object> map);

}
