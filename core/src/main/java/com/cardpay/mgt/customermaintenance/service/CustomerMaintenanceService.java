package com.cardpay.mgt.customermaintenance.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.customermaintenance.model.po.TCustomerMaintenance;

/**
 * 客户维护类
 * @author wangpeng
 */
public interface CustomerMaintenanceService extends BaseService<TCustomerMaintenance>{
    /**
     * 获取维护类型
     * @return 维护类型列表
     */
    Object getMaintenanceType();
}
