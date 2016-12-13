package com.cardpay.mgt.product.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.product.model.TProductOrganization;
import com.cardpay.mgt.product.model.vo.TProductOrganizationVo;

import java.util.List;
import java.util.Map;

/**
 * 产品机构关联表
 *
 * @author chenkai
 */
public interface TProductOrganizationMapper extends BasicMapper<TProductOrganization> {
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
    List<TProductOrganizationVo> queryProductOrg(int productId);

}