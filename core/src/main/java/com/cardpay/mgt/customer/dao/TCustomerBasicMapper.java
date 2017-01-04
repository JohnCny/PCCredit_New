package com.cardpay.mgt.customer.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.customer.model.TCustomerBasic;
import com.cardpay.mgt.customer.model.vo.TCustomerTransferVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 客户基本信息Mapper
 * @author chenkai
 */
public interface TCustomerBasicMapper extends BasicMapper<TCustomerBasic> {

    /**
     * 判断身份证号码是否已经存在
     * @param idCard 身份证号码
     * @return 是否存在(大于0 存在, 等于0 不存在)
     */
    Integer isIdCardExist(@Param("idCard") long idCard);

    /**
     * 查询客户经理所属客户
     * @param managerId 客户经理Id
     * @return 客户id, 客户名称
     */
    List<TCustomerTransferVo> queryCustomer(@Param("managerId") int managerId);

    /**
     * 更新客户状态
     * @param map 状态信息,客户id
     * @return 数据库变记录
     */
    int updateStatus(Map<String, Object> map);

    /**
     * 按条件查询客户信息
     * @param map 客户基本信息
     * @return 客户列表
     */
    List<TCustomerBasic> queryCustomerByCondition(Map<String, Object> map);

    /**
     * 查询无进件记录的客户信息
     * @param map 客户经理id
     * @return 可删除的客户列表
     */
    List<TCustomerBasic> selectDelete(Map<String, Object> map);
}