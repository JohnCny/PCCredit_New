package com.cardpay.mgt.organization.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.organization.model.TOrganization;
import com.cardpay.mgt.organization.model.vo.TOrganizationVo;
import com.cardpay.mgt.organization.model.vo.TreeOrgVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 机构mapper接口
 *
 * @author chenkai
 */
public interface TOrganizationMapper extends BasicMapper<TOrganization> {
    /**
     * 动态创建机构表临时视图
     *
     * @param id     父级id
     * @param levels 显示层级数量
     */
    void createOrganizationView(@Param("id") int id, @Param("levels") int levels);

    /**
     * 递归查询机构层级信息
     *
     * @param id 父级id
     * @return 机构层级信息
     */
    List<TOrganizationVo> queryOrganization(@Param("id") int id);

    /**
     * 递归删除机构信息
     *
     * @param id 机构id
     * @return 1成功, 0失败
     */
    int deleteOrganization(@Param("id") int id);

    /**
     * 查询所有机构信息
     *
     * @return TOrganizationVo类
     */
    List<TOrganizationVo> queryAll();

    /**
     * 查询此机构是否有子机构
     * @param organizationId 机构id
     * @return 资机构数量
     */
    int querySubsidiary(@Param("organizationId") int organizationId);

    /**
     * 查询此用户是否是此机构的负责人
     * @param directorId 负责人id
     * @param orgId 机构id
     * @return 是否为负责人
     */
    int selectIfOrgPrincipal(@Param("directorId")int directorId,@Param("orgId") int orgId);

}