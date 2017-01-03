package com.cardpay.mgt.customer.service;

import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.customer.model.TCustomerBasic;
import com.cardpay.mgt.customer.model.vo.TCustomerVo;
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
     * 获取客户状态
     * @return 客户状态列表
     */
    List<SelectModel> getCustomerStatus();

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
    boolean isIdCardExist(long idCard);

    /**
     * 查询客户经理所属客户
     * @param managerId managerId
     * @return 客户id, 客户名称
     */
    List<TCustomerTransferVo> queryCustomer(@Param("managerId") int managerId);

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
}
