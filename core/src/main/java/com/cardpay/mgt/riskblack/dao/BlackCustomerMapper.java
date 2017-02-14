package com.cardpay.mgt.riskblack.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.riskblack.model.BlackCustomer;
import com.cardpay.mgt.riskblack.model.vo.BlackCustomerVo;

import java.util.List;
import java.util.Map;

public interface BlackCustomerMapper extends BasicMapper<BlackCustomer> {

    /**
     * 获取黑名单分页数据
     *
     * @param map 参数map
     * @return 黑名单分页数据
     */
    List<BlackCustomerVo> blackCustomerPageList(Map<String, Object> map);
}