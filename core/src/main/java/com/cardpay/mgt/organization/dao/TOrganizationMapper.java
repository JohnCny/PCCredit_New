package com.cardpay.mgt.organization.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.organization.model.TOrganization;
import com.cardpay.mgt.organization.model.vo.TOrganizationVo;
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
     * 递归删除机构信息
     *
     * @param id 机构id
     * @return 1成功, 0失败
     */
    int deleteOrganization(@Param("id") int id);

    /**
     * 查询所有机构信息
     * @return 机构信息
     */
    List<TOrganizationVo> queryAll();

    /**
     * 查询所有机构信息
     * @param map 参数
     * @return 机构信息
     */
    List<TOrganization> selectOrganization(Map<String, Object> map);

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

    /**
     * 按机构id查询机构及子机构信息
     * @param orgId 机构id
     * @return 机构信息
     */
     List<TOrganizationVo> queryOrgChildren(@Param("orgId") int orgId);

    /**
     * 按id查询机构信息
     * @param orgId 机构id
     * @return 机构信息
     */
     TOrganizationVo queryByOrgId(@Param("orgId") int orgId);

}