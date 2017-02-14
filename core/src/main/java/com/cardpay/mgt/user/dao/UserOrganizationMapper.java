package com.cardpay.mgt.user.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.team.model.TUserTeam;
import com.cardpay.mgt.user.model.UserOrganization;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * 用户机构关联Dao层接口
 *
 * @author rankai
 *         createTime 2016-12-2016/12/23 14:40
 */
public interface UserOrganizationMapper extends BasicMapper<UserOrganization> {

    /**
     * 查询此机构是否含有用户
     * @param organizationId 机构id
     * @return 用户数量
     */
    int queryUserOrg(@Param("organizationId") int organizationId);

    /**
     * 按用户id查询关联机构信息
     * @param userId 用户id
     * @return 关联信息
     */
    List<UserOrganization>queryByUserId(@Param("userId") int userId);

    /**
     * 按进件Id查询所属机构信息
     * @param applicationId 进件id
     * @return 用户机构信息
     */
    List<UserOrganization> queryOrgByAppId(@Param("applicationId") int applicationId);
}