package com.cardpay.mgt.organization.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.organization.model.TOrganization;
import com.cardpay.mgt.organization.model.vo.TOrganizationVo;
import com.cardpay.mgt.organization.model.vo.TreeOrgVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 机构service层
 * @author chenkai on 2016/11/24.
 */
public interface TOrganizationService extends BaseService<TOrganization> {
    /**
     *  递归查询机构层级信息
     * @param parentId 父级id
     * @param levels 查询的层级数量
     * @return 机构层级信息
     */
    List<TOrganizationVo> queryOrganization(int parentId, int levels);

    /**
     *  递归删除机构信息
     * @param organizationId 机构id
     * @return 1成功, 0失败
     */
    int deleteOrganization( int organizationId);

    /**
     * 查询所有机构信息
     * @param map 父id
     * @return 机构信息
     */
    List<TOrganizationVo> queryAll(Map<String, Object> map);

    /**
     *  查询此用户所负责的机构信息
     * @param userId 用户id
     * @return 机构列表
     */
    List<TOrganization>queryIfOrgPrincipal(int userId);

    /**
     * 查询此用户是否是此机构的负责人
     * @param directorId 负责人id
     * @param orgId 机构id
     * @return true/false
     */
    boolean selectIfOrgPrincipal(int directorId, int orgId);

    /**
     * 根据机构id 获得顶级机构id
     *
     * @param orgId 机构id
     * @return topId
     */
    Integer getTopOrgId(Integer orgId);

}
