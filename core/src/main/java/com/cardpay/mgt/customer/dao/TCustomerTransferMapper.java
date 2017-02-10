package com.cardpay.mgt.customer.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.customer.model.TCustomerTransfer;
import com.cardpay.mgt.customer.model.vo.TCustomerTransferVo;
import com.cardpay.mgt.customer.model.vo.TCustomerVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 客户移交信息Mapper
 *
 * @author chenkai
 */
public interface TCustomerTransferMapper extends BasicMapper<TCustomerTransfer> {

    /**
     * 查询客户接受列表
     *
     * @param map    移交状态&客户经理id
     * @return 客户接受列表
     */
    List<TCustomerVo> queryTransfer(Map<String, Object> map);

    /**
     * 客户接收
     * @param map 意见记录
     * @return 数据库变条数
     */
    int accept(Map<String, Object> map);

    /**
     * 根据科技经理ID查询移交信息
     * @param customerId 客户经理Id
     * @return 移交记录
     */
    List<TCustomerTransferVo> queryById(@Param("customerId") int customerId);
}