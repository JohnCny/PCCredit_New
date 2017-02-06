package com.cardpay.mgt.customer.service;

import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.customer.model.TCustomerBasic;
import com.cardpay.mgt.customer.model.vo.TCustomerTransferVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 客户基本信息服务类
 * @author yanweichen
 */
public interface TCustomerBasicService extends BaseService<TCustomerBasic> {
    /**
     * 获取证件类型
     * @return 证件类型列表
     */
    List<SelectModel> getCert();

    /**
     * 获取文化程度
     * @return 文化程度列表
     */
    List<SelectModel> getEducationDegree();

    /**
     * 获取婚姻状况
     * @return 婚姻状况列表
     */
    List<SelectModel> getMarriageStatus();

    /**
     * 获取客户状态 分页
     * @return 客户状态列表
     */
    List<SelectModel> getCustomerStatus();

    /**
     * 判断身份证号码是否已经存在
     * @param idCard 身份证号码
     * @param organizationId 机构id
     * @return 是否存在(true:存在, false:不存在)
     */
    boolean isIdCardExist(String idCard, Integer organizationId);

    /**
     * 查询客户经理所属客户
     * @param managerId managerId
     * @param customerType 客户类型
     * @return 客户id, 客户名称
     */
    List<TCustomerTransferVo> queryCustomer(@Param("managerId") int managerId, int customerType);

    /**
     * 更新客户状态
     * @param map 状态信息,客户id
     * @return 数据库变记录
     */
    int updateStatus(Map map);

    /**
     * 按条件查询客户信息
     * @param map 查询参数
     * @return 客户列表
     */
    List<TCustomerBasic> queryCustomerByCondition(Map<String, Object> map);

    /**
     * 查询无进件记录的客户信息 分页
     * @param map 客户经理id
     * @return 可删除的客户列表
     */
    List<TCustomerBasic> selectDelete(Map<String, Object> map);

    /**
     * 删除客户信息
     * @param customerId 客户id
     * @return 数据库变记录
     */
    Integer deleteCustomer(int customerId);

    /**
     * 获取客户经理id
     * @param userId
     * @return
     */
    Integer getManagerId(int userId);

    /**
     * 客户信息验重
     * @param tCustomerBasic 客户信息
     * @return true/false
     */
    boolean validate(TCustomerBasic tCustomerBasic);
}
