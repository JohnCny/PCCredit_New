package com.cardpay.mgt.customer.customerbasic.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.customer.customerbasic.model.po.TCustomerBasic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TCustomerBasicMapper extends BasicMapper<TCustomerBasic> {

    /**
     * 获取潜在客户列表
     * @param customerManagerId 客户经理id
     * @return 潜在客户列表
     */
    List<TCustomerBasic> getProspectiveCustomers(@Param("customerManagerId") Integer customerManagerId);

    /**
     * 判断身份证号码是否已经存在
     * @param idCard 身份证号码
     * @return 是否存在(>0:存在, =0:不存在)
     */
    Integer isIdCardExist(@Param("idCard")String idCard);
}