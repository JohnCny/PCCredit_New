package com.cardpay.mgt.application.ipc.regular.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.application.ipc.regular.model.TApplicationFixedAssert;
import com.cardpay.mgt.application.ipc.regular.model.vo.TApplicationFixedAssertVo;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 固定资产清单表Service
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/9 15:32
 */
public interface TApplicationFixedAssertService extends BaseService<TApplicationFixedAssert>{

    /**
     * 添加固定资产表信息更新总计
     * @param tApplicationFixedAssert 固定资产信息
     * @param fixedAssertTotalValue 总价值
     * @param fixedAssertDepreciateValue 折旧后价值
     * @return 数据变记录
     */
    int insertFixedAssert(TApplicationFixedAssert tApplicationFixedAssert, BigDecimal fixedAssertTotalValue, BigDecimal fixedAssertDepreciateValue);

    /**
     * 更新固定资产表更新总计信息
     * @param tApplicationFixedAssert 固定资产信息
     * @param fixedAssertTotalValue 总价值
     * @param fixedAssertDepreciateValue 折旧后价值
     * @return 数据变记录
     */
    int updateFixedAssert(TApplicationFixedAssert tApplicationFixedAssert, BigDecimal fixedAssertTotalValue, BigDecimal fixedAssertDepreciateValue);

    /**
     *  删除固定资产更新总计
     * @param fixedAssertTotalId 固定资产id
     * @param fixedAssertTotalValue 总价值
     * @param fixedAssertDepreciateValue 折旧后价值
     * @return 数据变记录
     */
    int deleteFixedAssert(int fixedAssertTotalId, BigDecimal fixedAssertTotalValue, BigDecimal fixedAssertDepreciateValue);

    /**
     * 根据进件id查询固定资产信息
     * @param map 进件id
     * @return 固定资产信息
     */
    List<TApplicationFixedAssertVo> queryByApplicationId(Map<String, Object> map);
}
