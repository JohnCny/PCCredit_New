package com.cardpay.mgt.application.basic.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.application.basic.model.TApplicationContract;
import com.cardpay.mgt.application.basic.model.vo.TApplicationContractVo;

import java.util.List;
import java.util.Map;

/**
 * 客户签约信息Mapper
 * @author chenkai
 */
public interface TApplicationContractMapper extends BasicMapper<TApplicationContract> {

    /**
     * 查询客户签约信息
     * @param map 参数
     * @return 签约信息
     */
    List<TApplicationContractVo> queryAll(Map<String, Object> map);
}