package com.cardpay.mgt.process.service.impl;

import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.mgt.application.auditing.model.TApplicationApprovalReview;
import com.cardpay.mgt.application.basic.dao.TApplicationMapper;
import com.cardpay.mgt.application.basic.model.TApplication;
import com.cardpay.mgt.application.enums.ApplicationStatus;
import com.cardpay.mgt.customer.dao.TCustomerBasicMapper;
import com.cardpay.mgt.customer.dao.TCustomerIndustryMapper;
import com.cardpay.mgt.customer.model.TCustomerBasic;
import com.cardpay.mgt.customer.model.TCustomerIndustry;
import com.cardpay.mgt.customermanager.basic.dao.TCustomerManagerMapper;
import com.cardpay.mgt.process.core.ReturnData;
import com.cardpay.mgt.process.dao.AppApproveMapper;
import com.cardpay.mgt.process.dao.AppApproveUserMapper;
import com.cardpay.mgt.process.model.AppApprove;
import com.cardpay.mgt.process.model.AppApproveUser;
import com.cardpay.mgt.process.service.ProcessService;
import com.cardpay.mgt.product.dao.ProductApproveMapper;
import com.cardpay.mgt.product.dao.ProductMapper;
import com.cardpay.mgt.product.model.Product;
import com.cardpay.mgt.product.model.ProductApprove;
import com.cardpay.mgt.user.dao.UserMapper;
import com.cardpay.mgt.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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
    private ProductApproveMapper productApproveMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TCustomerIndustryMapper customerIndustryMapper;

    @Autowired
    private AppApproveUserMapper appApproveUserMapper;

    @Autowired
    private AppApproveMapper appApproveMapper;


    @Override
    public ReturnData applicationApproval(Integer applicationId) {
        LogTemplate.debug(this.getClass(), "applicationId", applicationId);
        TApplication application = applicationMapper.selectByPrimaryKey(applicationId);
        if (application == null) {
            LogTemplate.debug(this.getClass(), "message", "进件为空");
        }
        ReturnData returnData = access(application);
        if (!returnData.isPass()) {
            return returnData;
        }
        return null;
    }

    /**
     * 插入审批
     *
     * @param appApproveOneId appApproveOneId
     * @param flag            是否为
     */
    @Override
    public ReturnData addAppApproveUser(Integer appApproveOneId) {
        LogTemplate.debug(this.getClass(), "appApproveOneId", appApproveOneId);
        AppApprove appApprove = appApproveMapper.selectByPrimaryKey(appApproveOneId);
        if (appApprove.getIsReview() == 1 && appApprove.getStatus() == 1) { //复核节点
            List<User> approveUser = getApproveUser(appApprove);
            AppApproveUser appApproveUser = new AppApproveUser();
            appApproveUser.setUserId(approveUser.get(0).getId());
            appApproveUser.setCreateTime(new Date());
            appApproveUser.setAppApproveId(appApproveOneId);
            appApproveUser.setIsReview(1);
            appApproveUserMapper.insertSelective(appApproveUser);
            appApprove.setStatus(2);
            appApproveMapper.updateByPrimaryKeySelective(appApprove);
        } else if (appApprove.getIsReview() == 0 || (appApprove.getIsReview() == 1 && appApprove.getStatus() == 2)) {
            if (appApprove.getIsEnd() == 1) {
                TApplication application = applicationMapper.selectByPrimaryKey(appApprove.getAppId());
                application.setApplicationStatus(ApplicationStatus.APP_ADOPT.getValue());
                applicationMapper.updateByPrimaryKeySelective(application);
                appApprove.setStatus(3);
                appApproveMapper.updateByPrimaryKeySelective(appApprove);
            } else if (appApprove.getIsEnd() == 0) {
                AppApprove appApproveOne = new AppApprove();
                appApproveOne.setAppId(appApprove.getAppId());
                appApproveOne.setSort(appApprove.getAppId() + 1);
                AppApprove appApproveNext = appApproveMapper.selectOne(appApproveOne);
                List<User> approveUser = getApproveUser(appApproveNext);
                if (appApproveNext.getLoanMeetingType() == 0) {//非审贷会
                    AppApproveUser appApproveUser = new AppApproveUser();
                    appApproveUser.setUserId(approveUser.get(0).getId());
                    appApproveUser.setCreateTime(new Date());
                    appApproveUser.setAppApproveId(appApproveOneId);
                    appApproveUser.setIsReview(0);
                    appApproveUserMapper.insertSelective(appApproveUser);
                    appApprove.setStatus(1);
                    appApproveMapper.updateByPrimaryKeySelective(appApprove);
                } else if (appApproveNext.getLoanMeetingType() == 1) { //审贷会
                    TApplicationApprovalReview applicationApprovalReview = new TApplicationApprovalReview();


                    appApprove.setStatus(1);
                    appApproveMapper.updateByPrimaryKeySelective(appApprove);
                }
            }
        }
        return new ReturnData(Boolean.TRUE);
    }

    @Override
    public void updateAppApprove(Integer appId) {
        AppApprove appApprove = new AppApprove();
        appApprove.setAppId(appId);
        List<AppApprove> appApproves = appApproveMapper.select(appApprove);
        for (AppApprove appApproveOne : appApproves) {
            appApprove.setStatus(2);
            appApproveMapper.updateByPrimaryKeySelective(appApproveOne);
        }
    }


    /**
     * 进件准入判断
     *
     * @param application 进件对象
     * @return ReturnData
     */
    private ReturnData access(TApplication application) {
        Integer productId = application.getProductId();
        Integer customerId = application.getCustomerId();
        TCustomerBasic customerBasic = customerBasicMapper.selectByPrimaryKey(customerId);
        Product product = productMapper.selectByPrimaryKey(productId);
        if (customerBasic == null || product == null) {
            LogTemplate.debug(this.getClass(), "message", "进件中的客户信息或产品信息异常");
            return null;
        }

        //户籍
        if (product.getProductHouseholdLevelLimit() != null && customerBasic.getAddressType() != null) {
            if (product.getProductHouseholdLevelLimit() != 2) {
                LogTemplate.debug(this.getClass(), "addressType", customerBasic.getAddressType());
                if (product.getProductHouseholdLevelLimit() != customerBasic.getAddressType()) {
                    return new ReturnData().setMessage("客户户籍未达到准入标准");
                }
            }
        } else {
            LogTemplate.debug(this.getClass(), "message", "进件中用户或产品户籍信息异常");
            return null;
        }

        //婚姻状况
        LogTemplate.debug(this.getClass(), "marriageStatus", customerBasic.getMarriageStatus());
        if (product.getProductMarriageLimit() != null && customerBasic.getMarriageStatus() != null) {
            if (product.getProductMarriageLimit() == 0) { //未婚
                if (customerBasic.getMarriageStatus() == 1) {
                    return new ReturnData().setMessage("客户婚姻状态未达到准入标准");
                }
            } else { //已婚
                if (customerBasic.getMarriageStatus() == 0 || customerBasic.getMarriageStatus() == 2) {
                    return new ReturnData().setMessage("客户婚姻状态未达到准入标准");
                }
            }
        } else {
            LogTemplate.debug(this.getClass(), "message", "进件中用户或产品婚姻状态信息异常");
            return null;
        }


        //年龄区间
        User user = userMapper.selectByPrimaryKey(customerBasic.getUserId());
        if (user != null && user.getAge() != null && product.getProductAgeMinLimit() != null && product.getProductAgeMaxLimit() != null) {
            LogTemplate.debug(this.getClass(), "age", user.getAge());
            if (product.getProductAgeMinLimit() > user.getAge() || product.getProductAgeMaxLimit() < user.getAge()) {
                return new ReturnData().setMessage("客户年龄未达到准入标准");
            }
        } else {
            LogTemplate.debug(this.getClass(), "message", "进件中用户或产品年龄信息异常");
            return null;
        }

        //征信信息
        String productCreditLevelLimit = product.getProductCreditLevelLimit();
        String[] productCreditLevelLimits = productCreditLevelLimit.split(",");


        //非准入行业
        String productIndustryLimit = product.getProductIndustryLimit();
        LogTemplate.debug(this.getClass(), "IndustryLimit", productIndustryLimit);
        if (productIndustryLimit != null) {
            String[] productIndustryLimits = productIndustryLimit.split(",");
            TCustomerIndustry customerIndustry = new TCustomerIndustry();
            customerIndustry.setCustomerId(application.getCustomerId());
            List<TCustomerIndustry> customerIndustries = customerIndustryMapper.select(customerIndustry);
            if (customerIndustries != null) {
                for (int i = 0; productIndustryLimits.length > i; i++) {
                    for (int j = 0; customerIndustries.size() > j; j++) {
                        if (productIndustryLimits[i].equals(customerIndustries.get(j).getIndustryId())) {
                            return new ReturnData().setMessage("客户行业未达到准入标准");
                        }
                    }
                }
            } else {
                LogTemplate.debug(this.getClass(), "message", "进件中客户准入行业异常");
                return null;
            }
        } else {
            LogTemplate.debug(this.getClass(), "message", "进件中产品非准入行业异常");
            return null;
        }
        return new ReturnData(Boolean.TRUE);
    }

    private ReturnData approval(TApplication application) {
        ProductApprove productApprove = new ProductApprove();
        productApprove.setProductId(application.getProductId());
        List<ProductApprove> productApproves = productApproveMapper.select(productApprove);
        if (productApproves == null || productApproves.size() == 0) {
            LogTemplate.debug(this.getClass(), "message", "获取产品审批流程信息异常");
            return null;
        }

        //获取审批顺序链
        List<ProductApprove> productApproveLink = getProductApproveLink(productApproves);
        if (productApproveLink == null) {
            LogTemplate.debug(this.getClass(), "message", "获取的产品审批流程信息中没有起始节点");
            return null;
        }

        //插入审批顺序链
        for (int i = 0; productApproveLink.size() > 0; i++) {
            if ((productApproveLink.get(i).getIsLoanLimit() == 1) && (productApproveLink.get(i).getLoanLimit() >=
                    application.getApplyAmount().longValue())) {
                ProductApprove productApproveOne = productApproveLink.get(i);
                AppApprove appApprove = AppApprove.AppApproveBuilder.get()
                        .withAppId(application.getId())
                        .withProductApproveId(productApproveOne.getId())
                        .withSort(i + 1)
                        .withCreateTime(new Date())
                        .withIsReview(productApproveOne.getIsReviewNode())
                        .withApproveRoles(productApproveOne.getApproveRoles())
                        .withIsRandomDivision(productApproveOne.getIsRandomDivision())
                        .withIsLoanLimit(productApproveOne.getIsLoanLimit())
                        .withLoanLimit(productApproveOne.getLoanLimit())
                        .withLoanMeetingType(productApproveOne.getLoanMeetingType())
                        .build();
                if (i == 0) {
                    appApprove.setStatus(1);//审批中
                } else {
                    appApprove.setStatus(0);//待审批
                }
                if (i == productApproveLink.size() - 1) {
                    appApprove.setIsEnd(1);
                }
                appApproveMapper.insertSelective(appApprove);
                if (i == 0) {
                    List<User> approveUser = getApproveUser(appApprove);
                    AppApproveUser appApproveUser = new AppApproveUser();
                    appApproveUser.setUserId(approveUser.get(0).getId());
                    appApproveUser.setCreateTime(new Date());
                    appApproveUser.setAppApproveId(appApprove.getId());
                    appApproveUser.setIsReview(0);
                    appApproveUserMapper.insertSelective(appApproveUser);
                }
            }
        }
        return new ReturnData(Boolean.TRUE);
    }

    /**
     * 获取审批顺序链
     *
     * @param productApproves 审批流程集合
     * @return 审批顺序链
     */
    private List<ProductApprove> getProductApproveLink(List<ProductApprove> productApproves) {
        List<ProductApprove> productApprovesCopy = productApproves;
        List<ProductApprove> productApproveLink = new LinkedList<>();
        while (true) {
            if (productApproveLink.size() == 0) {
                for (int i = 0; productApproves.size() > i; i++) {
                    if (productApproves.get(i).getPreNodeId() == -1) {
                        productApproveLink.add(productApproves.get(i));
                        productApprovesCopy.remove(productApproves.get(i));
                        break;
                    }
                }
            }
            if (productApproveLink.size() == 0) {
                return null;
            }
            Integer preNodeId = productApproveLink.get(productApproveLink.size()).getPreNodeId();
            for (int i = 0; productApprovesCopy.size() > i; i++) {
                if (productApprovesCopy.get(i).getId() == preNodeId) {
                    productApproveLink.add(productApprovesCopy.get(i));
                    productApprovesCopy.remove(productApprovesCopy.get(i));
                    break;
                }
            }
            if (productApproveLink.size() == productApproves.size()) {
                break;
            }
        }
        return productApproveLink;
    }

    /**
     * 筛选审批用户
     *
     * @param appApprove 审批节点信息
     * @return 筛选出的审批用户
     */
    private List<User> getApproveUser(AppApprove appApprove) {
        String approveRoles = appApprove.getApproveRoles();
        String[] roleIds = approveRoles.split(",");
        List<User> users = userMapper.selectUserByRoleIds(roleIds);
        List<User> userList = new ArrayList<>();
        if (users != null && appApprove.getIsLoanLimit() == 0) {
            for (User user : users) {
                if (200 >= appApprove.getLoanLimit()) {
                    userList.add(user);
                }
            }
        }
        if (appApprove.getLoanMeetingType() != 1) { //审贷会
            List<Integer> AppApproveUserVos = appApproveUserMapper.selectOrderUser(users);
            List<User> usersLinked = new LinkedList<>();
            List<User> usersLinkedOne = new LinkedList<>();
            for (User user : userList) {
                boolean flag = Boolean.TRUE;
                for (Integer userId : AppApproveUserVos) {
                    if (userId == user.getId()) {
                        flag = Boolean.FALSE;
                        usersLinkedOne.add(user);
                        break;
                    }
                }
                if (flag) {
                    usersLinked.add(user);
                }
            }
            usersLinked.addAll(usersLinkedOne);
            return usersLinked;
        }
        return userList;
    }
}
