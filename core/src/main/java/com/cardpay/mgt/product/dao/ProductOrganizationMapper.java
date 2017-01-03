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
public interface ProductOrganizationMapper extends BasicMapper<ProductOrganization> {
    /**
     * 批量插入
     *
     * @param map
     * @return 插入个数
     */
    int batchInsertOrg(Map<String, Object> map);

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
     * @param productId
     * @return 查询产品相关机构信息Po类
     */
    List<ProductOrganizationVo> queryProductOrg(int productId);

}