package com.cardpay.mgt.user.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.mgt.user.dao.UserOrganizationMapper;
import com.cardpay.mgt.user.model.UserOrganization;
import com.cardpay.mgt.user.service.UserOrganizationService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户机构关联接口实现
 *
 * @author rankai
 *         createTime 2016-12-2016/12/23 14:40
 */
@Service
public class UserOrganizationServiceImpl extends BaseServiceImpl<UserOrganization> implements UserOrganizationService {
    @Autowired
    private UserOrganizationMapper userOrganizationDao;

    @Override
    public int queryUserOrg(int organizationId) {
        return userOrganizationDao.queryUserOrg(organizationId);
    }

    @Override
    public List<UserOrganization> queryOrgByAppId(int applicationId) {
        return userOrganizationDao.queryOrgByAppId(applicationId);
    }
}
