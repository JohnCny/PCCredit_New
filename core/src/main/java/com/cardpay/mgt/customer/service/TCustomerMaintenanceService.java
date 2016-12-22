package com.cardpay.mgt.customer.service;

import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.customer.model.TCustomerBasic;
import com.cardpay.mgt.customer.model.TCustomerMaintenance;
import com.cardpay.mgt.customer.model.vo.TCustomerMaintenanceVo;

import java.util.List;

/**
 * 客户维护服务类
 * @author yanweichen
 */
public interface TCustomerMaintenanceService extends BaseService<TCustomerMaintenance>{
    /**
     * 获取维护类型
     * @return 维护类型列表
     */
    List<SelectModel> getMaintenanceType();

    /**
     * 按条件查询客户维护信息
     * @param tCustomerBasic 客户基本信息
     * @return 客户列表
     */
    List<TCustomerMaintenanceVo> queryCustomerByCondition(TCustomerBasic tCustomerBasic);
}
