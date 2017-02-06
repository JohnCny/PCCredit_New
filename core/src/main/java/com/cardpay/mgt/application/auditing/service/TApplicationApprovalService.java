package com.cardpay.mgt.application.auditing.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.application.auditing.model.TApplicationApproval;

import java.util.Map;

/**
 * 进件审批
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/13 17:12
 */
public interface TApplicationApprovalService extends BaseService<TApplicationApproval>{

    /**
     * 根据进件id查询审批信息(新增审批)
     * @param applicationId 进件低
     * @return 审批信息
     */
    Map<String, Object> queryApproval(int applicationId);
}
