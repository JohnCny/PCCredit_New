package com.cardpay.mgt.team.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.mgt.team.dao.TUserTeamMapper;
import com.cardpay.mgt.team.model.TUserTeam;
import com.cardpay.mgt.team.service.TUserTeamService;
import org.apache.commons.collections.map.HashedMap;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Override
    public int batchInsert(int teamId, String userIds) {
        String[] split = userIds.split(",");
        List<Integer> userIdList = new ArrayList<>();
        for (String id : split) {
            int userId = Integer.parseInt(id);
            userIdList.add(userId);
        }
        Map<String, Object> map = new HashedMap();
        map.put("teamId", teamId);
        map.put("userId", userIdList);
        return tUserTeamDao.batchInsert(map);
    }

    @Override
    public List<TUserTeam> queryTeamByAppId(int applicationId) {
        return tUserTeamDao.queryTeamByAppId(applicationId);
    }
}
