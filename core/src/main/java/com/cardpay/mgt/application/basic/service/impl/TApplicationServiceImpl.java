package com.cardpay.mgt.application.basic.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.application.basic.dao.TApplicationMapper;
import com.cardpay.mgt.application.basic.model.TApplication;
import com.cardpay.mgt.application.basic.model.vo.TApplicationVo;
import com.cardpay.mgt.application.basic.service.TApplicationService;
import com.cardpay.mgt.customermanager.basic.model.TCustomerManager;
import com.cardpay.mgt.customermanager.basic.service.CustomerManagerService;
import com.cardpay.mgt.organization.model.TOrganization;
import com.cardpay.mgt.organization.service.TOrganizationService;
import com.cardpay.mgt.product.model.Product;
import com.cardpay.mgt.product.model.ProductOrganization;
import com.cardpay.mgt.product.service.ProductOrgService;
import com.cardpay.mgt.product.service.ProductService;
import com.cardpay.mgt.team.service.TeamService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 进件基本信息Service实现类
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/5 15:31
 */
@Service
public class TApplicationServiceImpl extends BaseServiceImpl<TApplication> implements TApplicationService {
    /**
     * 进件mapper
     */
    @Autowired
    private TApplicationMapper tApplicationDao;

    /**
     * 客户经理基本信息Service
     */
    @Autowired
    private CustomerManagerService customerMangerService;

    /**
     * 产品准入机构关联表
     */
    @Autowired
    private ProductOrgService productOrgService;

    /**
     * 产品Service
     */
    @Autowired
    private ProductService productService;

    /**
     * 团队service
     */
    @Autowired
    private TeamService teamService;

    /**
     * 机构service
     */
    private TOrganizationService tOrganizationService;

    @Override
    public boolean queryCustomerIfHaveProduct(int customerId, int productId) {
        TApplication tApplication = new TApplication();
        tApplication.setCustomerId(customerId);
        tApplication.setProductId(productId);
        List<TApplication> applicationList = tApplicationDao.select(tApplication);
        return applicationList.size() > 0 ? true : false;
    }

    @Override
    public boolean queryProductIfOk(int managerId, int productId) {
        Product product = productService.selectByPrimaryKey(productId);
        TCustomerManager tCustomerManager = customerMangerService.selectByUserId(managerId);
        ProductOrganization productOrganization = new ProductOrganization();
        productOrganization.setProductId(productId);
        List<ProductOrganization> productOrganizationList = productOrgService.select(productOrganization);
        for (ProductOrganization organization : productOrganizationList) {
            if (!organization.getOraganizationId().equals(tCustomerManager.getOrganizationId())) {
                return false;
            }
        }
        if (tCustomerManager.getLevelId() > product.getCustomerManagerLevelId()) {
            return true;
        }
        return false;
    }

    @Override
    public List<TApplicationVo> queryByManagerId(Map<String, Object> map) {
        return tApplicationDao.queryByManagerId(map);
    }

    @Override
    public TApplicationVo queryByApplication(int applicationId) {
        return tApplicationDao.queryByApplication(applicationId);
    }

    @Override
    public List<TApplicationVo> queryAppByOrgId(Map<String, Object> map) {
        return tApplicationDao.queryAppByOrgId(map);
    }

    @Override
    public List<TApplicationVo> queryAppByTeamId(Map<String, Object> map) {
        return tApplicationDao.queryAppByTeamId(map);
    }

    @Override
    public boolean userIfTeamBoss(int teamId, int userId) {
        if (teamService.selectIfTeamPrincipal(userId, teamId)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean userIfOrgBoss(int orgId, int userId) {
        if (tOrganizationService.selectIfOrgPrincipal(orgId, userId)) {
            return true;
        }
        return false;
    }
}
