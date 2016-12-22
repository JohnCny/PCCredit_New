package com.cardpay.mgt.customer.service;

import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.customer.model.TCustomerTransfer;
import com.cardpay.mgt.customer.model.vo.TCustomerVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 客户移交类
 * @author wangpeng
 */
public interface TCustomerTransferService extends BaseService<TCustomerTransfer>{
    /**
     * 获取移交接收意见状态
     * @return 移交接收意见状态列表
     */
    List<SelectModel> getTransferStatus();


    /**
     * 查询客户接受列表
     *
     * @param status    移交状态
     * @param managerId 客户经理id
     * @return 客户接受列表
     */
    List<TCustomerVo> queryTransfer(@Param("status") int status, @Param("managerId") int managerId);
}
