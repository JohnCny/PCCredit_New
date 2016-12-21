package com.cardpay.mgt.customer.service;

import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.basic.base.service.BaseService;
import com.cardpay.basic.common.interceptor.mapper.ReturnMapParam;
import com.cardpay.mgt.customer.model.TCustomerBasic;

import java.util.List;
import java.util.Map;

/**
 * 客户基本信息服务类
 * @author wangpeng
 */
public interface TCustomerBasicService extends BaseService<TCustomerBasic> {
    /**
     * 获取下拉框
     * @return 下拉框
     */
    Map<String, SelectModel> getDropDownList();

    /**
     * 获取潜在客户列表
     * @param customerManagerId 客户经理id
     * @return 潜在客户列表
     */
    List<TCustomerBasic> getProspectiveCustomers(Integer customerManagerId);

    /**
     * 判断身份证号码是否已经存在
     * @param idCard 身份证号码
     * @return 是否存在(true:存在, false:不存在)
     */
    boolean isIdCardExist(int idCard);

    /**
     * 查询客户经理所属客户
     * @param mapParam managerId
     * @return 客户id, 客户名称
     */
    Map<Integer, String> queryCustomer(ReturnMapParam mapParam);

    /**
     * 更新客户状态
     * @param map 状态信息,客户id
     * @return 数据库变记录
     */
    int updateStatus(Map map);

}
