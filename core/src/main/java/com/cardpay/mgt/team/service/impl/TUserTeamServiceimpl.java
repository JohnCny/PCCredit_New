package com.cardpay.mgt.team.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.mgt.team.dao.TUserTeamMapper;
import com.cardpay.mgt.team.model.TUserTeam;
import com.cardpay.mgt.team.model.Team;
import com.cardpay.mgt.team.service.TUserTeamService;
import com.cardpay.mgt.team.service.TeamService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户团队关联表Service
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/6 10:39
 */
@Service
public class TUserTeamServiceimpl extends BaseServiceImpl<TUserTeam> implements TUserTeamService {
    @Autowired
    private TUserTeamMapper tUserTeamDao;

    @Autowired
    private TeamService teamService;

    @Override
    @Transactional
    public int batchInsert(int teamId, String userIds) {
        String[] split = userIds.split(",");
        List<Integer> userIdList = new ArrayList<>();
        for (String id : split) {
            int userId = Integer.parseInt(id);
            userIdList.add(userId);
        }
        Map<String, Object> map = new HashedMap();
        map.put("teamId", teamId);
        map.put("userIds", userIdList);
        return tUserTeamDao.batchInsert(map);
    }

    @Override
    public List<TUserTeam> queryTeamByAppId(int applicationId) {
        return tUserTeamDao.queryTeamByAppId(applicationId);
    }

    @Override
    @Transactional
    public Map<String, Object> bathDelete(int teamId, String userIds) {
        Map<String, Object> map = new HashMap<>();
        map.put("teamId", teamId);
        List<Integer> list = new ArrayList<>();
        String[] split = userIds.split(",");
        for (String userId : split) {
            int id = Integer.parseInt(userId);
            list.add(id);
        }
        //团队负责人不能删除
        Team team = teamService.selectByPrimaryKey(teamId);
        list.remove(team.getTeamLeaderId());
        Map<String, Object> markMap = new HashMap<>();
        if (list.isEmpty()) {
            markMap.put("message", "团队负责人无法删除");
            markMap.put("mark", 6000);
        } else {
            map.put("userIds", list);
            markMap.put("message", "删除成功");
            markMap.put("mark", 6001);
            tUserTeamDao.bathDelete(map);

        }
        return markMap;
    }

}
