package com.cardpay.mgt.team.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.team.model.Team;
import com.cardpay.mgt.team.model.vo.OrganizationTeamVo;
import com.cardpay.mgt.team.model.vo.TeamVo;
import com.cardpay.mgt.team.model.vo.UserTeamVo;
import com.cardpay.mgt.user.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 团队表Mapper
 */
public interface TeamMapper extends BasicMapper<Team> {

    /**
     * 按id查询团队下的用用户
     * @return 信息列表
     */
    List<UserTeamVo> queryTeam(@Param("teamId") int teamId, @Param("organizationId") int organizationId);

    /**
     * 查询团队层级信息
     * @return
     */
    List<TeamVo> queryAll(Map<String, Object> map);

    /**
     * 递归删除团队信息
     * @param teamId
     * @return
     */
    int deleteTeam(@Param("teamId") Integer teamId);

    /**
     * 查询团队是否有子团队
     * @param teamId
     * @return
     */
    int querySubsidiary(@Param("teamId") Integer teamId);

    /**
     * 查询此用户是否是此团队的负责人
     * @param principalId 负责人id
     * @param teamId 机构id
     * @return 数量
     */
    int selectIfTeamPrincipal(@Param("principalId")int principalId,@Param("teamId") int teamId);

    /**
     * 按团队id查询子团队
     * @param teamId 团队id
     * @return 子团队
     */
    List<Team>querySonTeamById(@Param("teamId") int teamId);

    /**
     * 查询所有机构团队信息
     * @return 机构团队信息
     */
    List<OrganizationTeamVo> queryOrganization();

    /**
     * 按团队所属用户信息系
     * @param map 参数
     * @return 用户信息
     */
    List<User> queryTeamInUser(Map<String, Object> map);

    /**
     * 查询新增团队成员信息
     * @param orgId 团队id
     * @return 成员信息
     */
    List<User> queryNewTeamMember(@Param("orgId") int orgId);
}