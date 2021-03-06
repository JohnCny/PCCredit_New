package com.cardpay.mgt.application.ipc.regular.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.application.ipc.regular.model.TApplicationFixedAssert;
import com.cardpay.mgt.application.ipc.regular.model.vo.TApplicationFixedAssertVo;

import java.util.List;
import java.util.Map;

/**
 * 固定资产清单表Mapper
 *
 * @author chenkai
 */
public interface TApplicationFixedAssertMapper extends BasicMapper<TApplicationFixedAssert> {

    /**
     * 根据进件id查询固定资产信息
     * @param map 进件id
     * @return 固定资产信息
     */
    List<TApplicationFixedAssertVo> queryByApplicationId(Map<String, Object> map);
}