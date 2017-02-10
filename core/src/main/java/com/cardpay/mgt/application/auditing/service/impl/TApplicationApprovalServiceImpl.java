package com.cardpay.mgt.application.auditing.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.mgt.application.auditing.dao.TApplicationApprovalMapper;
import com.cardpay.mgt.application.auditing.model.TApplicationApproval;
import com.cardpay.mgt.application.auditing.service.TApplicationApprovalService;
import com.cardpay.mgt.application.basic.dao.TApplicationContractMapper;
import com.cardpay.mgt.application.basic.model.TApplication;
import com.cardpay.mgt.application.basic.model.TApplicationContract;
import com.cardpay.mgt.application.basic.service.TApplicationContractService;
import com.cardpay.mgt.application.basic.service.TApplicationService;
import com.cardpay.mgt.customer.model.TCustomerBasic;
import com.cardpay.mgt.customer.service.TCustomerBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 进件审批
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/13 17:16
 */
@Service
public class TApplicationApprovalServiceImpl extends BaseServiceImpl<TApplicationApproval> implements TApplicationApprovalService {
    /**
     * 审批信息
     */
    @Autowired
    private TApplicationApprovalMapper tApplicationApprovalDao;

    /**
     * 签约信息
     */
    @Autowired
    private TApplicationContractService tApplicationContractService;

    /**
     * 客户信息
     */
    @Autowired
    private TCustomerBasicService tCustomerBasicService;

    /**
     * 进件信息
     */
    @Autowired
    private TApplicationService tApplicationService;

    @Override
    public Map<String, Object> queryApproval(int applicationId) {
        //签约信息
        Map<String, Object> map = new HashMap();
        TApplicationContract contract = new TApplicationContract();
        contract.setApplicationId(applicationId);
        TApplicationContract applicationContract = tApplicationContractService.selectOne(contract);
        //审批信息
        TApplicationApproval approval = new TApplicationApproval();
        approval.setApplicationId(applicationId);
        List<TApplicationApproval> applicationApproval = tApplicationApprovalDao.select(approval);
        //客户信息
        TApplication application = tApplicationService.selectByPrimaryKey(applicationId);
        TCustomerBasic customer = tCustomerBasicService.selectByPrimaryKey(application.getCustomerId());
        map.put("customer", customer);
        map.put("contract", applicationContract);
        map.put("approval", applicationApproval);
        return map;
    }
}
