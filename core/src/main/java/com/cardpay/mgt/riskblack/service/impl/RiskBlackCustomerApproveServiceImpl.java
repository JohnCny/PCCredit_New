package com.cardpay.mgt.riskblack.service.impl;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.customer.dao.TCustomerBasicMapper;
import com.cardpay.mgt.riskblack.dao.RiskBlackCustomerApproveMapper;
import com.cardpay.mgt.riskblack.dao.RiskCustomerMapper;
import com.cardpay.mgt.riskblack.model.RiskBlackCustomerApprove;
import com.cardpay.mgt.riskblack.model.RiskCustomer;
import com.cardpay.mgt.riskblack.service.RiskBlackCustomerApproveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 风险客户或者黑名单操作审批表服务层实现
 *
 * @author rankai
 *         createTime 2017-01-2017/1/24 9:34
 */
@Service
public class RiskBlackCustomerApproveServiceImpl extends BaseServiceImpl<RiskBlackCustomerApprove> implements RiskBlackCustomerApproveService {

    @Autowired
    private RiskBlackCustomerApproveMapper riskBlackCustomerApproveMapper;

    @Autowired
    private RiskCustomerMapper riskCustomerMapper;

    @Autowired
    private TCustomerBasicMapper customerBasicMapper;

    @Override
    public ResultTo approve(RiskBlackCustomerApprove riskBlackCustomerApprove, Integer riskCustomerId) {
        Integer type = riskBlackCustomerApprove.getRiskBlackOperationType();
        LogTemplate.debug(this.getClass(), "type", type);
        if (type != 1 || type != 2 || type != 0) {
            return new ResultTo(ResultEnum.OPERATION_FAILED);
        }
        RiskCustomer riskCustomer = riskCustomerMapper.selectByPrimaryKey(riskCustomerId);
        if (riskCustomer == null) {
            return new ResultTo(ResultEnum.OPERATION_FAILED);
        }
        riskBlackCustomerApprove.setCustomerType(riskCustomer.getCustomerType());
        riskBlackCustomerApprove.setRiskBlackCustomerId(riskCustomer.getCustomerId());
        riskBlackCustomerApprove.setRiskBlackApproveStatus(0);
        riskBlackCustomerApprove.setCreateTime(new Date());
        riskBlackCustomerApprove.setCreateBy(ShiroKit.getUserId());
        riskBlackCustomerApproveMapper.insertSelective(riskBlackCustomerApprove);
        return new ResultTo();
    }

    @Override
    public ResultTo approveResult(RiskBlackCustomerApprove riskBlackCustomerApprove) {




        return null;
    }
}
