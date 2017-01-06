package com.cardpay.mgt.product.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.product.model.ProductApprove;

import java.util.Map;

/**
 * 产品审批流程服务层接口
 *
 * @author rankai
 *         createTime 2016-12-2016/12/23 14:40
 */
public interface ProductApproveService extends BaseService<ProductApprove> {
    /**
     * 获取新增审批页面所需数据
     *
     * @param productId 产品ID
     * @return 新增审批页面所需数据
     */
    Map<String, Object> getApprove(Integer productId);

    /**
     * 增加产品审批
     *
     * @param productApprove ProductApprove实体对象
     * @param productId      产品ID
     * @return 产品ID
     */
    void addApprove(ProductApprove productApprove, Integer productId);
}
