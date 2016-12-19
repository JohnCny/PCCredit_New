package com.cardpay.mgt.product.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.product.model.TProductOrganization;
import com.cardpay.mgt.product.model.vo.TProductOrganizationVo;

import java.util.List;
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
    int batchInsertOrg(Map<String, Object> map);

    /**
     *  批量删除
     * @param map
     * @return 插入个数
     */
    int bathDeleteOrg(Map<String, Object> map);

    /**
     * 查询产品相关机构信息
     * @param productId 产品id
     * @param topId 顶级id
     * @return ProductOrganizationPo
     */
    List<TProductOrganizationVo> queryProductOrg(int productId, int topId);
}
