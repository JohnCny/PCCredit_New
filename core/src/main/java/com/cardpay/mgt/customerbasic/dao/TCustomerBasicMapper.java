package com.cardpay.mgt.customerbasic.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.customerbasic.model.po.TCustomerBasic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TCustomerBasicMapper extends BasicMapper<TCustomerBasic> {

    /**
     * 获取潜在客户列表
     * @param customerManagerId 客户经理id
     * @return 潜在客户列表
     */
    List<TCustomerBasic> getProspectiveCustomers(@Param("customerManagerId") Integer customerManagerId);
}