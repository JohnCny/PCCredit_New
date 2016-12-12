package com.cardpay.mgt.customerbasic.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.customerbasic.model.po.TCustomerBasic;

import java.util.List;

/**
 * 客户基本信息服务类
 * @author wangpeng
 */
public interface CustomerBasicService extends BaseService<TCustomerBasic> {
    /**
     * 获取证件类型
     * @return 证件类型列表
     */
    Object getCert();

    /**
     * 获取文化程度
     * @return 文化程度列表
     */
    Object getEducationDegree();

    /**
     * 获取婚姻状况
     * @return 婚姻状况列表
     */
    Object getMarriageStatus();

    /**
     * 获取客户状态
     * @return 客户状态列表
     */
    Object getCustomerStatus();

    /**
     * 获取潜在客户列表
     * @param customerManagerId 客户经理id
     * @return 潜在客户列表
     */
    List<TCustomerBasic> getProspectiveCustomers(Integer customerManagerId);
}
