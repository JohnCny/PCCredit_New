package com.cardpay.mgt.riskblack.service;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.riskblack.model.RiskBlackCustomerApprove;
import com.cardpay.mgt.riskblack.model.vo.RiskBlackCustomerApproveVo;

import java.util.List;
import java.util.Map;

/**
 * 风险客户或者黑名单操作审批表服务层接口
 *
 * @author rankai
 *         createTime 2017-01-2017/1/24 9:34
 */
public interface RiskBlackCustomerApproveService extends BaseService<RiskBlackCustomerApprove> {

    /**
     * 获取审批分页列表(反射获取)
     *
     * @param map 参数map
     * @return 审批分页列表
     */
    List<RiskBlackCustomerApproveVo> riskBlackCustomerApprovePageList(Map<String, Object> map);


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
     * @param flag       操作类型(0:拒绝1:同意)
     * @param customerId 客户ID
     * @return 成功或失败
     */
    ResultTo approveResult(Integer customerId, Integer flag);

    /**
     * 根据用户ID获取风险审批信息
     *
     * @param riskBlackApproveId 风险审批ID
     * @return 风险审批信息
     */
    RiskBlackCustomerApproveVo getCustomerApprove(Integer riskBlackApproveId);
}
