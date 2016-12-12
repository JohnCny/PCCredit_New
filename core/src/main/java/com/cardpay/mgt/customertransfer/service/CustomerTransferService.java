package com.cardpay.mgt.customertransfer.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.customertransfer.model.po.TCustomerTransfer;

/**
 * 客户移交类
 * @author wangpeng
 */
public interface CustomerTransferService extends BaseService<TCustomerTransfer>{
    /**
     * 获取移交接收意见状态
     * @return 移交接收意见状态列表
     */
    Object getTransferStatus();
}
