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
    public ResultTo approve(RiskBlackCustomerApprove riskBlackCustomerApprove, Integer customerId) {
        Integer type = riskBlackCustomerApprove.getRiskBlackOperationType();
        LogTemplate.debug(this.getClass(), "type", type);
        if (type == 1 || type == 2 || type == 0) {
            TCustomerBasic tCustomerBasic = customerBasicMapper.selectByPrimaryKey(customerId);
            if (tCustomerBasic == null) {
                return new ResultTo(ResultEnum.OPERATION_FAILED);
            }
            switch (type) {
                case 0: //0 转入黑名单
                    tCustomerBasic.setCustomerStatus(3);
                    break;
                case 1: //1 转出黑名单
                    tCustomerBasic.setCustomerStatus(4);
                    BlackCustomer blackCustomer = new BlackCustomer();
                    blackCustomer.settBlackCustomerId(tCustomerBasic.getId());
                    BlackCustomer blackCustomerOne = blackCustomerMapper.selectOne(blackCustomer);
                    blackCustomerOne.settBlackCustomerStatus(1);
                    blackCustomerMapper.updateByPrimaryKeySelective(blackCustomerOne);
                    break;
                case 2: //2 转出风险名单
                    tCustomerBasic.setCustomerStatus(7);
                    break;
                default:
                    break;
            }
            customerBasicMapper.updateByPrimaryKeySelective(tCustomerBasic);
            riskBlackCustomerApprove.setCustomerType(tCustomerBasic.getCustomerType());
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
        riskBlackCustomerApprove.setRiskBlackApproveStatus(0);
        RiskBlackCustomerApprove riskBlackCustomerApproveOne = riskBlackCustomerApproveMapper
                .selectOne(riskBlackCustomerApprove);
        if (riskBlackCustomerApproveOne.getRiskBlackApproveStatus() != 0) {
            LogTemplate.debug(this.getClass(), "message", "该条信息已审批过");
            return new ResultTo(ResultEnum.PARAM_ERROR);
        }
        Integer type = riskBlackCustomerApproveOne.getRiskBlackOperationType();
        TCustomerBasic customerBasic = customerBasicMapper.selectByPrimaryKey(customerId);
        if (customerBasic == null) {
            return new ResultTo(ResultEnum.OPERATION_FAILED);
        }
        switch (flag) {
            case 0: //拒绝
                riskBlackCustomerApproveOne.setRiskBlackApproveStatus(2);
                riskBlackCustomerApproveMapper.updateByPrimaryKeySelective(riskBlackCustomerApproveOne);
                if (type == 0) {

                }
                if (type == 1) {
                    BlackCustomer blackCustomer = new BlackCustomer();
                    blackCustomer.settBlackCustomerId(customerId);
                    blackCustomer.settBlackCustomerStatus(1);
                    BlackCustomer blackCustomerOne = blackCustomerMapper.selectOne(blackCustomer);
                    blackCustomerOne.settBlackCustomerStatus(0);
                    blackCustomerMapper.updateByPrimaryKeySelective(blackCustomerOne);
                }
                if (type == 2) {

                }
                customerBasic.setCustomerStatus(0);
                customerBasicMapper.updateByPrimaryKeySelective(customerBasic);
                break;
            case 1: //同意

                riskBlackCustomerApproveOne.setRiskBlackApproveStatus(1);
                if (type == 0) {//转入黑名单
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
