package com.cardpay.mgt.loan.service.impl;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.util.DateTimeUtil;
import com.cardpay.mgt.application.basic.dao.TApplicationMapper;
import com.cardpay.mgt.application.basic.model.TApplication;
import com.cardpay.mgt.application.basic.service.TApplicationService;
import com.cardpay.mgt.application.enums.ApplicationStatus;
import com.cardpay.mgt.customer.dao.TCustomerBasicMapper;
import com.cardpay.mgt.customer.model.TCustomerBasic;
import com.cardpay.mgt.customer.service.TCustomerBasicService;
import com.cardpay.mgt.loan.dao.PostLoanMonitorMapper;
import com.cardpay.mgt.loan.model.PostLoanMonitor;
import com.cardpay.mgt.loan.model.vo.AddLoanVo;
import com.cardpay.mgt.loan.service.PostLoanMonitorService;
import com.cardpay.mgt.product.dao.ProductMapper;
import com.cardpay.mgt.product.model.Product;
import com.cardpay.mgt.product.model.ProductLoanMonitorRules;
import com.cardpay.mgt.product.service.ProductLoanService;
import com.cardpay.mgt.product.service.ProductService;
import javafx.application.Application;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.SimpleDateFormat;
import java.util.*;

import static com.cardpay.basic.util.DateTimeUtil.dateSubtraction;

/**
 * 贷后监控服务层实现
 *
 * @author rankai
 *         createTime 2017-01-2017/1/22 14:51
 */
@Service
public class PostLoanMonitorServiceImpl extends BaseServiceImpl<PostLoanMonitor> implements PostLoanMonitorService {

    @Autowired
    private PostLoanMonitorMapper postLoanMonitorMapper;

    @Autowired
    private TApplicationMapper applicationMapper;

    @Autowired
    private TCustomerBasicMapper customerBasicMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private TApplicationService applicationService;

    @Autowired
    private ProductLoanService productLoanService;

    /**
     * 客户信息
     */
    @Autowired
    private TCustomerBasicService customerBasicService;

    @Override
    public List<AddLoanVo> loanMonitorAddPageList(Map<String, Object> map) {
        return postLoanMonitorMapper.loanMonitorAddPageList(map);
    }

    @Override
    public ResultTo addLoan(Integer applicationId) {
        TApplication application = applicationMapper.selectByPrimaryKey(applicationId);
        if (application == null) {
            return new ResultTo(ResultEnum.OPERATION_FAILED);
        }
        TCustomerBasic customerBasic = customerBasicMapper.selectByPrimaryKey(application.getCustomerId());
        Product product = productMapper.selectByPrimaryKey(application.getProductId());
        if (product == null || customerBasic == null) {
            return new ResultTo(ResultEnum.OPERATION_FAILED);
        }
        PostLoanMonitor postLoanMonitor = new PostLoanMonitor();
        postLoanMonitor.setApplicationId(applicationId);

        int count = postLoanMonitorMapper.insertSelective(postLoanMonitor);
        if (count > 0) {
            return new ResultTo();
        }
        return new ResultTo(ResultEnum.OPERATION_FAILED);
    }

    @Override
    public List<AddLoanVo> loanMonitorPageList(Map<String, Object> map) {
        return postLoanMonitorMapper.loanMonitorPageList(map);
    }

    @Override
    public void scanLoanByApplication() {
        TApplication application = new TApplication();
        application.setApplicationStatus(ApplicationStatus.APP_LENDING.getValue());
        List<TApplication> applicationList = applicationService.select(application);
        for (TApplication tApplication : applicationList) {
            Integer productId = tApplication.getProductId();
            ProductLoanMonitorRules productLoanMonitorRules = new ProductLoanMonitorRules();
            productLoanMonitorRules.setProductId(productId);
            TCustomerBasic customerBasic = customerBasicService.selectByPrimaryKey(tApplication.getCustomerId());
            List<ProductLoanMonitorRules> loanMonitorRules = productLoanService.select(productLoanMonitorRules);
            for (ProductLoanMonitorRules loanMonitorRule : loanMonitorRules) { //获取进件中产品监控规则
                Date beginTime = tApplication.getLoanTime();
                Date nowTime = new Date();
                Map<String, Object> intervalMap = dateSubtraction(beginTime, nowTime);
                Integer month = (Integer) intervalMap.get("month");
                Integer day = (Integer) intervalMap.get("day");

                PostLoanMonitor postLoanMonitor = new PostLoanMonitor();
                postLoanMonitor.setApplicationId(tApplication.getId());
                postLoanMonitor.setCustomerType(customerBasic.getCustomerType());
                List<PostLoanMonitor> monitors = postLoanMonitorMapper.select(postLoanMonitor);
                switch (loanMonitorRule.getMonitorTimeFirst()) {
                    case 0://一周内
                        if (day != null && day <= 7) {
                            if (monitors.isEmpty()) {
                                postLoanMonitorMapper.insertSelective(postLoanMonitor);
                            }
                            break;
                        }
                    case 1://半月
                        if (day != null && day <= 15) {
                            if (monitors.isEmpty()) {
                                postLoanMonitorMapper.insertSelective(postLoanMonitor);
                            }
                            break;
                        }
                    case 2: //一月内
                        if (month != null && month <= 1) {
                            if (monitors.isEmpty()) {
                                postLoanMonitorMapper.insertSelective(postLoanMonitor);
                            }
                            break;
                        }
                    default:
                        break;
                }
            }
        }
    }

}
