package com.cardpay.mgt.team.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.mgt.organization.service.TOrganizationService;
import com.cardpay.mgt.team.dao.TUserTeamMapper;
import com.cardpay.mgt.team.dao.TeamMapper;
import com.cardpay.mgt.team.model.TUserTeam;
import com.cardpay.mgt.team.model.Team;
import com.cardpay.mgt.team.model.vo.OrganizationTeamVo;
import com.cardpay.mgt.team.model.vo.TeamVo;
import com.cardpay.mgt.team.model.vo.UserTeamVo;
import com.cardpay.mgt.team.service.TeamService;
import com.cardpay.mgt.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 团队表ServiceImpl
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/6 9:30
 */
@Service
public class TeamServiceImpl extends BaseServiceImpl<Team> implements TeamService {
    @Autowired
    private TeamMapper teamDao;

    @Autowired
    private TUserTeamMapper tUserTeamDao;

    @Autowired
    private TOrganizationService tOrganizationService;

    @Override
    public List<TeamVo> queryAll(Map<String, Object> map, int organizationId) {
        Integer topOrgId = tOrganizationService.getTopOrgId(organizationId);
        map.put("organizationId", topOrgId);
        List<TeamVo> teamVos = teamDao.queryAll(map);
        return teamVos;
    }

    @Override
    public List<UserTeamVo> queryTeam(int teamId, int organizationId) {
        Integer topOrgId = tOrganizationService.getTopOrgId(organizationId);
        return teamDao.queryTeam(teamId, topOrgId);
    }

    @Override
    @Transactional
    public Map<String, Object> deleteTeam(Integer teamId, int organizationId) {
        Map<String, Object> map = new HashMap<>();
        List<UserTeamVo> userTeamVos = teamDao.queryTeam(teamId, organizationId);
        int count = teamDao.querySubsidiary(teamId);
        if (count == 0 || userTeamVos.size() > 0) {
            map.put("message", "该团队下有成员无法进行删除操作!");
            map.put("count", 0);
        } else {
            map.put("message", "删除成功");
            map.put("count", teamDao.deleteTeam(teamId));
        }
        return map;
    }

    @Override
    public List<Team> queryIfTeamPrincipal(int userId) {
        List<Team> teamList = new ArrayList<>();
        //查询此用户属于那些团队
        List<TUserTeam> tUserTeams = tUserTeamDao.queryByUserId(userId);
        for (TUserTeam userTeam : tUserTeams) {
            Team team = new Team();
            team.setTeamId(userTeam.getTeamId());
            Team oneTeam = teamDao.selectOne(team);
            //查询是否为此团队负责人
            int flag = teamDao.selectIfTeamPrincipal(oneTeam.getTeamLeaderId(), userId);
            if (flag > 0) {
                teamList.add(oneTeam);
            }
        }
        return teamList;
    }

    @Override
    public List<Team> querySonTeamById(int teamId) {
        return teamDao.querySonTeamById(teamId);
    }

    @Override
    public boolean selectIfTeamPrincipal(int userId, int teamId) {
        int mark = teamDao.selectIfTeamPrincipal(userId, teamId);
        return mark > 0 ? true : false;
    }

    @Override
    public List<OrganizationTeamVo> queryOrganization() {
        return teamDao.queryOrganization();
    }

    @Override
    public List<User> queryTeamInUser(Map<String, Object> map) {
        return teamDao.queryTeamInUser(map);
    }

    @Override
    public List<User> queryNewTeamMember(int orgId, int teamId) {
        return teamDao.queryNewTeamMember(orgId, teamId);
    }
}
