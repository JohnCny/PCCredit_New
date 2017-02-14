package com.cardpay.mgt.application.auditing.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.application.auditing.model.TApplicationApprovalUsers;
import com.cardpay.mgt.user.model.User;

import java.util.List;

/**
 * 审贷会成员
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/13 17:14
 */
public interface TApplicationApprovalUsersService extends BaseService<TApplicationApprovalUsers> {


    List<User> queryByApproval(int userId, int applicationId);
}
