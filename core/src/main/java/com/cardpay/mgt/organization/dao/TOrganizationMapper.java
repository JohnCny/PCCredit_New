package com.cardpay.mgt.organization.dao;

import com.cardpay.mgt.organization.model.TOrganization;
import com.cardpay.mgt.organization.model.TOrganizationVo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 机构mapper接口
 * @author chenkai
 */
public interface TOrganizationMapper extends Mapper<TOrganization> {
    /**
     * 动态创建机构表临时视图
     * @param id 父级id
     * @param levels 显示层级数量
     */
    void createOrganizationView (@Param("id")int id, @Param("levels")int levels);

    /**
     *  递归查询机构层级信息
     * @param id 父级id
     * @return 机构层级信息
     */
    List<TOrganizationVo> queryOrganization(@Param("id")int id);

    /**
     * 更新此机构所属层级信息
     * @param id 机构id
     * @param parentId 父机构id
     * @return 1成功, 0失败
     */
    int updateOrganization(@Param("id")int id,@Param("parentId")int parentId);

    /**
     *  递归删除机构信息
     * @param id 机构id
     * @return 1成功, 0失败
     */
    int deleteOrganization(@Param("id") int id);
}