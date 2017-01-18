package com.cardpay.mgt.team.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.team.model.Team;
import com.cardpay.mgt.team.model.vo.OrganizationTeamVo;
import com.cardpay.mgt.team.model.vo.TeamVo;
import com.cardpay.mgt.team.model.vo.UserTeamVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 团队表Service
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/6 9:28
 */
public interface TeamService extends BaseService<Team> {

    /**
     * 查询所有团队信息
     * @param map 参数信息
     * @param organizationId 机构id
     * @return 团队信息
     */
    List<TeamVo> queryAll(Map<String, Object> map, int organizationId);

    /**
     * 按id查询团队下的用用户
     * @param teamId  团队id
     * @param organizationId 机构id
     * @return 机构信息
     */
    List<UserTeamVo> queryTeam(int teamId, int organizationId);

    /**
     * 递归删除团队信息
     * @param teamId 团队id
     * @param organizationId 机构id
     * @return 数据库变记录
     */
    int deleteTeam(Integer teamId, int organizationId);

    /**
     * 查询此用户负责的团队信息
     * @param userId 用户id
     * @return 负责机构信信息
     */
    List<Team> queryIfTeamPrincipal(int userId);

    /**
     * 按团队id查询子团队
     * @param teamId 团队id
     * @return 子团队
     */
    List<Team>querySonTeamById(int teamId);

    /**
     * 查询此用户是否是此团队的负责人
     * @param userId 负责人id
     * @param teamId 机构id
     * @return 数量
     */
    boolean selectIfTeamPrincipal(int userId, int teamId);

    /**
     * 查询所有机构团队信息
     * @return 机构团队信息
     */
    List<OrganizationTeamVo> queryOrganization();

}
