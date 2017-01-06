package com.cardpay.mgt.team.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.util.treeutil.TreeUtil;
import com.cardpay.mgt.team.dao.TeamMapper;
import com.cardpay.mgt.team.model.Team;
import com.cardpay.mgt.team.model.vo.TeamVo;
import com.cardpay.mgt.team.model.vo.UserTeamVo;
import com.cardpay.mgt.team.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public List<TeamVo> queryAll(Map<String, Integer> map) {
        TreeUtil<TeamVo> tree = new TreeUtil<>();
        return tree.getChildNodesByParentId(teamDao.queryAll(), map.get("topId"));
    }

    @Override
    public List<UserTeamVo> queryTeam(Integer teamId) {
        return teamDao.queryTeam(teamId);
    }
}
