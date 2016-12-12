package com.cardpay.mgt.customermanagerlevel.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.customermanagerlevel.model.po.TCustomerManagerLevel;

/**
 * 客户经理级别类
 * @author wangpeng
 */
public interface CustomerManagerLevelService extends BaseService<TCustomerManagerLevel> {
    /**
     * 获取客户经理级别
     * @return 客户经理级别列表
     */
    Object getCustomerManagerLevel();
}
