package com.cardpay.mgt.loan.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.loan.model.BadDebtCustomer;
import com.cardpay.mgt.loan.model.vo.BadDebtCustomerVo;

import java.util.List;
import java.util.Map;

/**
 * 不良客户服务层接口
 *
 * @author rankai
 *         createTime 2017-01-2017/1/22 17:58
 */
public interface BadDebtCustomerService extends BaseService<BadDebtCustomer> {

    /**
     * 反射调用(不良客户分页列表)
     *
     * @param map 参数Map
     */
    List<BadDebtCustomerVo> badDebtCustomerPageList(Map<String, Object> map);
}
