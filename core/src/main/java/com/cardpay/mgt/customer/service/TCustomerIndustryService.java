package com.cardpay.mgt.customer.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.customer.model.TCustomerIndustry;

import java.util.List;

/**
 * 客户所属行业Service类
 *
 * @author chenkai 2016/12/19 10:43
 */
public interface TCustomerIndustryService extends BaseService<TCustomerIndustry> {

    /**
     * 批量添加行业信息
     * @param list 行业id,客户id
     * @return 数据库变记录
     */
    int batchInsert(List<TCustomerIndustry> list);
}
