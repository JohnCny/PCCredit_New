package com.cardpay.mgt.riskblack.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.mgt.riskblack.dao.RiskCustomerMapper;
import com.cardpay.mgt.riskblack.model.RiskCustomer;
import com.cardpay.mgt.riskblack.model.vo.RiskCustomerVo;
import com.cardpay.mgt.riskblack.service.RiskCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 风险客户列表服务层实现
 *
 * @author rankai
 *         createTime 2017-01-2017/1/24 11:08
 */
@Service
public class RiskCustomerServiceImpl extends BaseServiceImpl<RiskCustomer> implements RiskCustomerService {

    @Autowired
    private RiskCustomerMapper riskCustomerMapper;

    @Override
    public List<RiskCustomerVo> riskCustomerPageList(Map<String, Object> map) {
        return riskCustomerMapper.riskCustomerPageList(map);
    }
}
