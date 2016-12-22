package com.cardpay.mgt.customer.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.customer.model.TCustomerTransfer;
import com.cardpay.mgt.customer.model.vo.TCustomerVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 客户移交信息Mapper
 *
 * @author chenkai
 */
public interface TCustomerTransferMapper extends BasicMapper<TCustomerTransfer> {

    /**
     * 查询客户接受列表
     *
     * @param status    移交状态
     * @param managerId 客户经理id
     * @return 客户接受列表
     */
    List<TCustomerVo> queryTransfer(@Param("status") int status, @Param("managerId") int managerId);

}