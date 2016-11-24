package com.cardpay.mgt.organization.dao;

import com.cardpay.mgt.organization.model.TOrganization;
import tk.mybatis.mapper.common.Mapper;

/**
 * 机构mapper接口
 * @author chenkai
 */
public interface TOrganizationMapper extends Mapper<TOrganization> {
    /**
     * 创建机构表临时视图
     * @param id 父级id
     * @param level 创建层级
     */
    void createView (int id, int level);
}