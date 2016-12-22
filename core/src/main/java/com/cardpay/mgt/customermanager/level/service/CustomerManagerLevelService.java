package com.cardpay.mgt.customermanager.level.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.customermanager.level.model.TCustomerManagerLevel;

/**
 * 客户经理级别类
 * @author yanweichen
 */
public interface CustomerManagerLevelService extends BaseService<TCustomerManagerLevel> {
    /**
     * 获取客户经理级别
     * @return 客户经理级别列表
     */
    Object getCustomerManagerLevel();
}
