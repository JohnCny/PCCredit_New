package com.cardpay.mgt.product.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.product.model.TProductOrganization;

import java.util.Map;

/**
 * 产品机构关联Service
 * Created by chenkai on 2016/12/8.
 */
public interface TProductOrganizationService extends BaseService<TProductOrganization>{
    /**
     *  批量插入
     * @param map
     * @return 插入个数
     */
    int batchInsert(Map<String, Object> map);
}
