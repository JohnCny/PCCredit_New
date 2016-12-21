package com.cardpay.mgt.customer.service;

import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.customer.model.TCustomerTransfer;

import java.util.List;

/**
 * 客户移交类
 * @author yanweichen
 */
public interface CustomerTransferService extends BaseService<TCustomerTransfer>{
    /**
     * 获取移交接收意见状态
     * @return 移交接收意见状态列表
     */
    List<SelectModel> getTransferStatus();
}
