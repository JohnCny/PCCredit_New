package com.cardpay.mgt.organization.dao;

import com.cardpay.mgt.organization.model.TOrganization;
import com.cardpay.mgt.organization.model.TOrganizationVo;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 机构mapper接口
 * @author chenkai
 */
public interface TOrganizationMapper extends Mapper<TOrganization> {
    /**
     * 创建机构表临时视图
     * @param id 父级id
     * @param levels 显示层级数量
     */
    void createOrganizationView (int id, int levels);

    /**
     *  递归查询机构层级信息
     * @param id 父级id
     * @return 机构层级信息
     */
    List<TOrganizationVo> queryOrganization(int id);
}