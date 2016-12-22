package com.cardpay.mgt.customermanager.basic.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.customermanager.basic.model.TCustomerManager;
import com.cardpay.mgt.customermanager.basic.model.vo.TCustomerManagerListVo;

import java.util.List;
import java.util.Map;

/**
 * 客户经理管理类
 * @author yanweichen
 */
public interface CustomerManagerService extends BaseService<TCustomerManager> {

    /**
     * 客户经理管理列表
     *
     * @param map 参数列表
     * @return 客户经理管理列表
     */
    List<TCustomerManagerListVo> selectListVo(Map<String,Object> map);
}
