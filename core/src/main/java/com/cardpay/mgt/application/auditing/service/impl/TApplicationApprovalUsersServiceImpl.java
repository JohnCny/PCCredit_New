package com.cardpay.mgt.application.auditing.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.mgt.application.auditing.model.TApplicationApprovalUsers;
import com.cardpay.mgt.application.auditing.service.TApplicationApprovalUsersService;
import com.cardpay.mgt.application.basic.model.TApplication;
import com.cardpay.mgt.application.basic.service.TApplicationService;
import com.cardpay.mgt.customermanager.basic.model.TCustomerManager;
import com.cardpay.mgt.customermanager.basic.service.CustomerManagerService;
import com.cardpay.mgt.customermanager.level.model.TCustomerManagerLevel;
import com.cardpay.mgt.customermanager.level.service.CustomerManagerLevelService;
import com.cardpay.mgt.organization.service.TOrganizationService;
import com.cardpay.mgt.user.model.User;
import com.cardpay.mgt.user.model.UserOrganization;
import com.cardpay.mgt.user.service.UserOrganizationService;
import com.cardpay.mgt.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 审贷会成员
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/13 17:17
 */
@Service
public class TApplicationApprovalUsersServiceImpl extends BaseServiceImpl<TApplicationApprovalUsers> implements TApplicationApprovalUsersService {
    @Autowired
    private CustomerManagerService customerManagerService;

    @Autowired
    private CustomerManagerLevelService customerManagerLevelService;

    @Autowired
    private TApplicationService tApplicationService;

    @Autowired
    private UserOrganizationService userOrganizationService;

    @Autowired
    private UserService userService;

    @Override
    public List<User> queryByApproval(int orgId, int applicationId) {
        List<User> list = new ArrayList<>();
        UserOrganization userOrganization = new UserOrganization();
        userOrganization.setOrganizationId(orgId);
        List<UserOrganization> userOrganizationList = userOrganizationService.select(userOrganization);
        for (UserOrganization organization : userOrganizationList) {
            Integer userId = organization.getUserId();
            TCustomerManager customerManager = customerManagerService.selectByUserId(userId);
            if (customerManager != null) {
                TCustomerManagerLevel managerLevel = customerManagerLevelService.selectByPrimaryKey(customerManager.getLevelId());
                TApplication application = tApplicationService.selectByPrimaryKey(applicationId);
                if (application != null) {
                    if (application.getApplyAmount().compareTo(managerLevel.getLevelCredit()) == -1) {
                        User user = userService.selectByPrimaryKey(userId);
                        list.add(user);
                    }
                }
            }
        }
        return list;
    }
}
