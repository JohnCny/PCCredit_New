package com.cardpay.mgt.application.regular.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.application.regular.model.TApplicationReceive;
import com.cardpay.mgt.application.regular.model.vo.TApplicationReceiveVo;

import java.util.List;
import java.util.Map;

/**
 * 应收预付表
 * @author chenkai
 */
public interface TApplicationReceiveMapper extends BasicMapper<TApplicationReceive> {
    /**
     * 根据进件id查询应收预付表
     * @param map 进件id
     * @return 应收预付表
     */
    List<TApplicationReceiveVo> queryByApplicationId(Map<String, Object> map);
}