package com.cardpay.mgt.process.impl;

import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.mgt.application.basic.dao.TApplicationMapper;
import com.cardpay.mgt.application.basic.model.TApplication;
import com.cardpay.mgt.customer.dao.TCustomerBasicMapper;
import com.cardpay.mgt.customer.model.TCustomerBasic;
import com.cardpay.mgt.customermanager.basic.dao.TCustomerManagerMapper;
import com.cardpay.mgt.process.ProcessService;
import com.cardpay.mgt.process.core.ReturnData;
import com.cardpay.mgt.product.dao.ProductApproveMapper;
import com.cardpay.mgt.product.dao.ProductMapper;
import com.cardpay.mgt.product.model.Product;
import com.cardpay.mgt.product.model.ProductApprove;
import com.cardpay.mgt.product.service.ProductService;
import com.cardpay.mgt.user.dao.UserMapper;
import com.cardpay.mgt.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 进件流程服务层实现
 *
 * @author rankai
 *         createTime 2017-02-2017/2/6 9:49
 */
@Service
public class ProcessServiceImpl implements ProcessService {

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private TApplicationMapper applicationMapper;

    @Autowired
    private TCustomerBasicMapper customerBasicMapper;

    @Autowired
    private TCustomerManagerMapper customerManagerMapper;

    @Autowired
    private ProductApproveMapper productApproveMapper;

    @Autowired
    private UserMapper userMapper;


    @Override
    public ReturnData applicationApproval(Integer applicationId) {
        TApplication application = applicationMapper.selectByPrimaryKey(applicationId);
        ReturnData returnData = threshoud(application);
        if (!returnData.isPass()) {
            return returnData;
        }
        return null;
    }


    private ReturnData threshoud(TApplication application) {
        Integer productId = application.getProductId();
        Integer customerId = application.getCustomerId();
        TCustomerBasic customerBasic = customerBasicMapper.selectByPrimaryKey(customerId);
        Product product = productMapper.selectByPrimaryKey(productId);
        //户籍
        if (product.getProductHouseholdLevelLimit() != 2) {
            LogTemplate.debug(this.getClass(), "addressType", customerBasic.getAddressType());
            if (product.getProductHouseholdLevelLimit() != customerBasic.getAddressType()) {
                return new ReturnData().setMessage("客户户籍未达到准入标准");
            }
        }
        //婚姻状况
        LogTemplate.debug(this.getClass(), "marriageStatus", customerBasic.getMarriageStatus());
        if (product.getProductMarriageLimit() == 0) { //未婚
            if (customerBasic.getMarriageStatus() == 1) {
                return new ReturnData().setMessage("客户婚姻状态未达到准入标准");
            }
        } else { //已婚
            if (customerBasic.getMarriageStatus() == 0 || customerBasic.getMarriageStatus() == 2) {
                return new ReturnData().setMessage("客户婚姻状态未达到准入标准");
            }
        }

        //年龄区间
        User user = userMapper.selectByPrimaryKey(customerBasic.getUserId());
        LogTemplate.debug(this.getClass(), "age", user.getAge());
        if (product.getProductAgeMinLimit() > user.getAge() || product.getProductAgeMaxLimit() < user.getAge()) {
            return new ReturnData().setMessage("客户年龄未达到准入标准");
        }

        //征信信息
        String productCreditLevelLimit = product.getProductCreditLevelLimit();
        String[] productCreditLevelLimits = productCreditLevelLimit.split(",");


        //非准入行业
        String productIndustryLimit = product.getProductIndustryLimit();
        String[] productIndustryLimits = productIndustryLimit.split(",");


        return null;
    }
}
