package com.cardpay.mgt.industry.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.industry.model.TIndustry;

/**
 * 行业信息类
 * @author yanweichen
 */
public interface IndustryService extends BaseService<TIndustry> {
    /**
     * 获取行业信息
     * @return 行业信息列表
     */
    Object getIndustryInfo();
}
