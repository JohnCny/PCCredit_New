package com.cardpay.mgt.loan.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.mgt.loan.dao.BadDebtCustomerMapper;
import com.cardpay.mgt.loan.model.BadDebtCustomer;
import com.cardpay.mgt.loan.model.vo.BadDebtCustomerVo;
import com.cardpay.mgt.loan.service.BadDebtCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 不良客户服务层实现
 *
 * @author rankai
 *         createTime 2017-01-2017/1/22 18:01
 */
@Service
public class BadDebtCustomerServiceImpl extends BaseServiceImpl<BadDebtCustomer> implements BadDebtCustomerService {

    @Autowired
    private BadDebtCustomerMapper badDebtCustomerMapper;

    @Override
    public List<BadDebtCustomerVo> badDebtCustomerPageList(Map<String, Object> map) {
        return badDebtCustomerMapper.badDebtCustomerPageList(map);
    }
}
