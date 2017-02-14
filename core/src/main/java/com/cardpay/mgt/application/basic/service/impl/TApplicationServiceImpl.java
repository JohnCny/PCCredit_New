package com.cardpay.mgt.application.basic.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.application.basic.dao.TApplicationMapper;
import com.cardpay.mgt.application.basic.model.TApplication;
import com.cardpay.mgt.application.basic.model.TApplicationFile;
import com.cardpay.mgt.application.basic.model.TApplicationInvestPicture;
import com.cardpay.mgt.application.basic.model.vo.TApplicationVo;
import com.cardpay.mgt.application.basic.service.TApplicationFileService;
import com.cardpay.mgt.application.basic.service.TApplicationInvestPictureService;
import com.cardpay.mgt.application.basic.service.TApplicationService;
import com.cardpay.mgt.application.enums.ApplicationStatus;
import com.cardpay.mgt.application.ipc.basic.service.ApplicationIPCBasicService;
import com.cardpay.mgt.customermanager.basic.model.TCustomerManager;
import com.cardpay.mgt.customermanager.basic.service.CustomerManagerService;
import com.cardpay.mgt.organization.service.TOrganizationService;
import com.cardpay.mgt.product.model.Product;
import com.cardpay.mgt.product.model.ProductOrganization;
import com.cardpay.mgt.product.service.ProductOrgService;
import com.cardpay.mgt.product.service.ProductService;
import com.cardpay.mgt.team.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.cardpay.mgt.application.enums.ApplicationStatus.APP_UNFINISHED;

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
    @Autowired
    private TOrganizationService tOrganizationService;

    /**
     * 进件调查图
     */
    @Autowired
    private TApplicationInvestPictureService tApplicationInvestPictureService;

    /**
     * 进件相关报告上传
     */
    @Autowired
    private TApplicationFileService tApplicationFileService;

    /**
     * ipc模板
     */
    @Autowired
    private ApplicationIPCBasicService applicationIPCBasicService;

    @Override
    public boolean queryCustomerIfHaveProduct(int customerId, int productId) {
        TApplication tApplication = new TApplication();
        tApplication.setCustomerId(customerId);
        tApplication.setProductId(productId);
        List<TApplication> applicationList = tApplicationDao.select(tApplication);
        return applicationList.size() > 0 ? false : true;
    }

    @Override
    public Map<String, Object> queryProductIfOk(int managerId, int productId) {
        Map<String, Object> map = new HashMap<>();
        Product product = productService.selectByPrimaryKey(productId);
        TCustomerManager tCustomerManager = customerMangerService.selectByUserId(managerId);
        ProductOrganization productOrganization = new ProductOrganization();
        productOrganization.setProductId(productId);
        List<ProductOrganization> productOrganizationList = productOrgService.select(productOrganization);
        for (ProductOrganization organization : productOrganizationList) {
            if (!organization.getOraganizationId().equals(tCustomerManager.getOrganizationId())) {
                map.put("status", false);
                map.put("message", "您所属机构不在此产品准入机构中!!!");
            }
        }
        if (tCustomerManager.getLevelId() > product.getCustomerManagerLevelId()) {
            map.put("status", true);
        } else {
            map.put("status", false);
            map.put("message", "您的级别过低,无法申请此产品.请继续努力!!!");
        }
        return map;
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
        return tOrganizationService.selectIfOrgPrincipal(orgId, userId) ? true : false;
    }

    @Override
    public boolean deleteApplication(int applicationId) {
        TApplication tApplication = tApplicationDao.selectByPrimaryKey(applicationId);
        if (ApplicationStatus.APP_UNFINISHED.getKey().equals(tApplication.getApplicationStatus())) {
            TApplicationInvestPicture tApplicationInvestPicture = new TApplicationInvestPicture();
            tApplicationInvestPicture.setApplicationId(applicationId);
            TApplicationFile applicationFile = new TApplicationFile();
            applicationFile.setApplicationId(applicationId);
            tApplicationDao.deleteByPrimaryKey(applicationId);
            tApplicationInvestPictureService.delete(tApplicationInvestPicture);
            tApplicationFileService.delete(applicationFile);
            return true;
        }
        return false;
    }

    @Override
    public int insertApplication(int productId, int customerId, int userId) {
        boolean flag = queryCustomerIfHaveProduct(customerId, productId);
        if (flag){
            Integer managerId = ShiroKit.getUserId();
            TApplication tApplication = new TApplication();
            tApplication.setCreateTime(new Date());
            tApplication.setProductId(productId);
            tApplication.setCustomerId(customerId);
            tApplication.setCustomerManagerId(managerId);
            tApplication.setApplicationStatus(APP_UNFINISHED.getValue());
            tApplicationDao.insertSelective(tApplication);
            applicationIPCBasicService.initTemplate(tApplication.getId());
            return tApplication.getId();
        }
        return 0;
    }
}
