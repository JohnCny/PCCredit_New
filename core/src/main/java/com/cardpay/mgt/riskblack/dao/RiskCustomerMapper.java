package com.cardpay.mgt.riskblack.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.riskblack.model.RiskCustomer;
import com.cardpay.mgt.riskblack.model.vo.RiskCustomerVo;

import java.util.List;
import java.util.Map;

public interface RiskCustomerMapper extends BasicMapper<RiskCustomer> {

    /**
     * 获取风险客户或者黑名单操作审批表分页数据
     *
     * @return 风险客户或者黑名单操作审批表分页数据
     */
    List<RiskCustomerVo> riskCustomerPageList(Map<String, Object> map);
}