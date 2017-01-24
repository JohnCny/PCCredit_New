package com.cardpay.mgt.riskblack.service;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.riskblack.model.RiskBlackCustomerApprove;

/**
 * 风险客户或者黑名单操作审批表服务层接口
 *
 * @author rankai
 *         createTime 2017-01-2017/1/24 9:34
 */
public interface RiskBlackCustomerApproveService extends BaseService<RiskBlackCustomerApprove> {
    /**
     * 申请转出风险名单或转入黑名单
     *
     * @param riskBlackCustomerApprove RiskBlackCustomerApprove
     * @param riskCustomerId           风险客户ID
     * @return 成功或失败
     */
    ResultTo approve(RiskBlackCustomerApprove riskBlackCustomerApprove, Integer riskCustomerId);

    /**
     * 审批操作
     *
     * @param riskBlackCustomerApprove RiskBlackCustomerApprove
     * @return 成功或失败
     */
    ResultTo approveResult(RiskBlackCustomerApprove riskBlackCustomerApprove);
}
