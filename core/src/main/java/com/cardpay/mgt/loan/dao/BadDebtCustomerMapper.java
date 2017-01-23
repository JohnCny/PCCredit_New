package com.cardpay.mgt.loan.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.loan.model.BadDebtCustomer;
import com.cardpay.mgt.loan.model.vo.BadDebtCustomerVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

public interface BadDebtCustomerMapper extends BasicMapper<BadDebtCustomer> {

    /**
     * 反射调用(不良客户分页列表)
     *
     * @param map 参数Map
     */
    List<BadDebtCustomerVo> badDebtCustomerPageList(Map<String, Object> map);
}