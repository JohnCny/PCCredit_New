package com.cardpay.mgt.product.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.product.model.ProductApprove;

import java.util.List;
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
    Map<String, Object> getApprove(Integer productId, Integer approveId);

    /**
     * 增加产品审批
     *
     * @param productApprove ProductApprove实体对象
     */
    void addApprove(ProductApprove productApprove);

    /**
     * @param productApprove ProductApprove实体对象
     */
    void updateApprove(ProductApprove productApprove);

    /**
     * 根据产品ID获取审批集合
     *
     * @param productId 产品ID
     * @return 审批集合
     */
    List<ProductApprove> selectAllByProductId(Integer productId);

    /**
     * 删除节点
     *
     * @param approveId 审批ID
     * @return 成功或失败
     */
    boolean deleteApprove(Integer approveId);
}
