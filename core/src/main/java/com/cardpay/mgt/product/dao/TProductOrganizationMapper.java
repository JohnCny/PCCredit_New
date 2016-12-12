package com.cardpay.mgt.product.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.product.model.TProductOrganization;

import java.util.Map;

/**
 * 产品机构关联表
 * @author chenkai
 */
public interface TProductOrganizationMapper extends BasicMapper<TProductOrganization> {

    /**
     *  批量插入
     * @param map
     * @return 插入个数
     */
    int batchInsert(Map<String, Object> map);

}