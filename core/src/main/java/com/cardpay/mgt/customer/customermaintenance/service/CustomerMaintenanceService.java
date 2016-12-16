package com.cardpay.mgt.customer.customermaintenance.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.customer.customermaintenance.model.po.TCustomerMaintenance;

/**
 * 客户维护服务类
 * @author wangpeng
 */
public interface CustomerMaintenanceService extends BaseService<TCustomerMaintenance>{
    /**
     * 获取维护类型
     * @return 维护类型列表
     */
    Object getMaintenanceType();
}
