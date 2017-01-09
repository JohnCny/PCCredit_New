package com.cardpay.mgt.product.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.product.model.ProductOrganization;
import com.cardpay.mgt.product.model.vo.ProductOrganizationVo;

import java.util.List;
import java.util.Map;

/**
 * 产品机构关联表Dao层接口
 *
 * @author rankai
 *         createTime 2016-12-2016/12/23 14:40
 */
public interface ProductOrgMapper extends BasicMapper<ProductOrganization> {

    /**
     * 批量删除
     *
     * @param map
     * @return 插入个数
     */
    int bathDeleteOrg(Map<String, Object> map);

    /**
     * 查询产品相关机构信息
     *
     * @param productId 产品ID
     * @return 查询产品相关机构信息Po类
     */
    List<ProductOrganizationVo> queryProductOrg(int productId);

    /**
     * 批量插入产品机构
     *
     * @param productId  产品ID
     * @param productIds 机构ID数组
     */
    void batchInsertOrg(Integer productId, String[] productIds);
}