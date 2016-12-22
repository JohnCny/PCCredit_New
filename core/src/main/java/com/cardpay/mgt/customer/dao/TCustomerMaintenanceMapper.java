package com.cardpay.mgt.customer.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.customer.model.TCustomerBasic;
import com.cardpay.mgt.customer.model.TCustomerMaintenance;
import com.cardpay.mgt.customer.model.vo.TCustomerMaintenanceVo;

import java.util.List;

/**
 * 客户维护Mapper
 * @author yanweichen
 */
public interface TCustomerMaintenanceMapper extends BasicMapper<TCustomerMaintenance> {
    /**
     * 按条件查询客户维护信息
     * @param tCustomerBasic 客户基本信息
     * @return 客户列表
     */
    List<TCustomerMaintenanceVo> queryCustomerByCondition(TCustomerBasic tCustomerBasic);
}