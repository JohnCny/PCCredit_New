package com.cardpay.mgt.customer.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.customer.model.TCustomerIndustry;

import java.util.List;
import java.util.Map;

/**
 * 客户所属行业Mapper
 * @author yanweichen
 */
public interface TCustomerIndustryMapper extends BasicMapper<TCustomerIndustry> {

    /**
     * 批量添加行业信息
     * @param list 行业id,客户id
     * @return 数据库变记录
     */
    int batchInsert(List<TCustomerIndustry> list);
}