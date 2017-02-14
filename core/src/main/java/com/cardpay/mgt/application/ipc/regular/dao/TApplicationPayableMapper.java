package com.cardpay.mgt.application.ipc.regular.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.application.ipc.regular.model.TApplicationPayable;
import com.cardpay.mgt.application.ipc.regular.model.vo.TApplicationPayableVo;

import java.util.List;
import java.util.Map;

/**
 * 应付预收表
 * @author chenkai
 */
public interface TApplicationPayableMapper extends BasicMapper<TApplicationPayable> {
    /**
     * 根据进件id查询应付预收表信息
     * @param map 进件id
     * @return 应付预收表信息
     */
    List<TApplicationPayableVo> queryByApplicationId(Map<String, Object> map);
}