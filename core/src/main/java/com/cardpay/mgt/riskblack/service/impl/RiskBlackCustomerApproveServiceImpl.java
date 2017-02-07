package com.cardpay.mgt.riskblack.service.impl;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.customer.dao.TCustomerBasicMapper;
import com.cardpay.mgt.customer.model.TCustomerBasic;
import com.cardpay.mgt.riskblack.dao.BlackCustomerMapper;
import com.cardpay.mgt.riskblack.dao.RiskBlackCustomerApproveMapper;
import com.cardpay.mgt.riskblack.dao.RiskCustomerMapper;
import com.cardpay.mgt.riskblack.model.BlackCustomer;
import com.cardpay.mgt.riskblack.model.RiskBlackCustomerApprove;
import com.cardpay.mgt.riskblack.model.RiskCustomer;
import com.cardpay.mgt.riskblack.model.vo.RiskBlackCustomerApproveVo;
import com.cardpay.mgt.riskblack.service.RiskBlackCustomerApproveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Autowired
    private BlackCustomerMapper blackCustomerMapper;

    @Override
    public List<RiskBlackCustomerApproveVo> riskBlackCustomerApprovePageList(Map<String, Object> map) {
        return riskBlackCustomerApproveMapper.riskBlackCustomerApprovePageList(map);
    }

    @Override
    public ResultTo approve(RiskBlackCustomerApprove riskBlackCustomerApprove, Integer riskCustomerId) {
        Integer type = riskBlackCustomerApprove.getRiskBlackOperationType();
        LogTemplate.debug(this.getClass(), "type", type);
        if (type == 1 || type == 2 || type == 0) {
            RiskCustomer riskCustomer = riskCustomerMapper.selectByPrimaryKey(riskCustomerId);
            TCustomerBasic tCustomerBasic = customerBasicMapper.selectByPrimaryKey(riskCustomer.getCustomerId());
            if (riskCustomer == null) {
                return new ResultTo(ResultEnum.OPERATION_FAILED);
            }
            switch (type) {
                case 1: //0 转入黑名单
                    tCustomerBasic.setCustomerStatus(3);
                    break;
                case 2://1 转出黑名单
                    tCustomerBasic.setCustomerStatus(4);
                    break;
                default:
                    customerBasicMapper.updateByPrimaryKeySelective(tCustomerBasic);
                    break;
            }
            riskBlackCustomerApprove.setCustomerType(riskCustomer.getCustomerType());
            riskBlackCustomerApprove.setRiskBlackCustomerId(tCustomerBasic.getId());
            riskBlackCustomerApprove.setRiskBlackApproveStatus(0);
            riskBlackCustomerApprove.setCreateTime(new Date());
            riskBlackCustomerApprove.setCreateBy(ShiroKit.getUserId());
            riskBlackCustomerApproveMapper.insertSelective(riskBlackCustomerApprove);
            return new ResultTo();
        }
        return new ResultTo(ResultEnum.PARAM_ERROR);
    }

    @Override
    public ResultTo approveResult(Integer customerId, Integer flag) {
        RiskBlackCustomerApprove riskBlackCustomerApprove = new RiskBlackCustomerApprove();
        riskBlackCustomerApprove.setRiskBlackCustomerId(customerId);
        RiskBlackCustomerApprove riskBlackCustomerApproveOne = riskBlackCustomerApproveMapper
                .selectOne(riskBlackCustomerApprove);
        switch (flag) {
            case 0: //拒绝
                riskBlackCustomerApproveMapper.delete(riskBlackCustomerApproveOne);
                break;
            case 1: //同意
                Integer type = riskBlackCustomerApproveOne.getRiskBlackOperationType();
                if (type == 0) {//转入黑名单
                    TCustomerBasic customerBasic = customerBasicMapper.selectByPrimaryKey(customerId);
                    BlackCustomer blackCustomer = new BlackCustomer();
                    blackCustomer.setCreateBy(ShiroKit.getUserId());
                    blackCustomer.setCreateTime(new Date());
                    blackCustomer.settBlackCustomerStatus(0);
                    blackCustomer.setCustomerManagerId(customerBasic.getCustomerManagerId());
                    blackCustomer.setBlackReason(riskBlackCustomerApproveOne.getRiskBlackTransforReason());
                    blackCustomer.settBlackCustomerId(customerId);
                    blackCustomerMapper.insertSelective(blackCustomer);
                    customerBasic.setCustomerStatus(2);
                    customerBasicMapper.updateByPrimaryKeySelective(customerBasic);
                    RiskCustomer riskCustomer = new RiskCustomer();
                    riskCustomer.setCustomerId(customerId);
                    riskCustomerMapper.delete(riskCustomer);
                }
                if (type == 1) {//转出黑名单
                    TCustomerBasic customerBasic = new TCustomerBasic();
                    customerBasic.setId(riskBlackCustomerApproveOne.getRiskBlackCustomerId());
                    customerBasic.setCustomerStatus(1);
                    customerBasicMapper.updateByPrimaryKeySelective(customerBasic);
                    BlackCustomer blackCustomer = new BlackCustomer();
                    blackCustomer.settBlackCustomerId(customerId);
                    blackCustomerMapper.delete(blackCustomer);
                }
                if (type == 2) {//转出风险名单
                    RiskCustomer riskCustomer = new RiskCustomer();
                    riskBlackCustomerApproveOne.setRiskBlackApproveStatus(1);
                    riskCustomer.setCustomerId(riskBlackCustomerApproveOne.getRiskBlackCustomerId());
                    riskCustomerMapper.delete(riskCustomer);
                }
                break;
            default:
                return new ResultTo(ResultEnum.OPERATION_FAILED);
        }
        riskBlackCustomerApproveOne.setApproveBy(ShiroKit.getUserId());
        riskBlackCustomerApproveOne.setApproveTime(new Date());
        riskBlackCustomerApproveOne.setRiskBlackApproveStatus(1);
        riskBlackCustomerApproveMapper.updateByPrimaryKeySelective(riskBlackCustomerApproveOne);
        return new ResultTo();
    }

    @Override
    public RiskBlackCustomerApproveVo getCustomerApprove(Integer riskBlackApproveId) {
        Map<String, Object> map = new HashMap();
        map.put("riskBlackApproveId", riskBlackApproveId);
        map.put("orgId", ShiroKit.getOrgId());
        return riskBlackCustomerApproveMapper.getCustomerApprove(map);
    }
}
