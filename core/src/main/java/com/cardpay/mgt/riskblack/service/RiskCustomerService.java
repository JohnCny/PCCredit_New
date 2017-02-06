package com.cardpay.mgt.riskblack.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.riskblack.model.RiskCustomer;
import com.cardpay.mgt.riskblack.model.vo.RiskCustomerVo;

import java.util.List;
import java.util.Map;

/**
 * 风险客户列表服务层接口
 *
 * @author rankai
 *         createTime 2017-01-2017/1/24 11:08
 */
public interface RiskCustomerService extends BaseService<RiskCustomer> {

    /**
     * 获取风险客户或者黑名单操作审批表分页数据
     *
     * @return 风险客户或者黑名单操作审批表分页数据
     */
    List<RiskCustomerVo> riskCustomerPageList(Map<String, Object> map);
}
