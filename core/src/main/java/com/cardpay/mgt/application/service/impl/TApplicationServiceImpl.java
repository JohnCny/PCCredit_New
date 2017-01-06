package com.cardpay.mgt.application.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.mgt.application.dao.TApplicationMapper;
import com.cardpay.mgt.application.model.TApplication;
import com.cardpay.mgt.application.model.vo.TApplicationVo;
import com.cardpay.mgt.application.service.TApplicationService;
import com.cardpay.mgt.customermanager.basic.model.TCustomerManager;
import com.cardpay.mgt.customermanager.basic.service.CustomerManagerService;
import com.cardpay.mgt.product.model.Product;
import com.cardpay.mgt.product.model.ProductOrganization;
import com.cardpay.mgt.product.service.ProductOrganizationService;
import com.cardpay.mgt.product.service.ProductService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    private ProductOrganizationService productOrganizationService;

    /**
     * 产品Service
     */
    @Autowired
    private ProductService productService;

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
        List<ProductOrganization> productOrganizationList = productOrganizationService.select(productOrganization);
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
    public List<TApplicationVo> queryByManagerId(int managerId) {
        return tApplicationDao.queryByManagerId(managerId);
    }

    @Override
    public TApplicationVo queryByApplication(int applicationId) {
        return tApplicationDao.queryByApplication(applicationId);
    }
}
