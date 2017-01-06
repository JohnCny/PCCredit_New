package com.cardpay.mgt.team.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.team.model.Team;
import com.cardpay.mgt.team.model.vo.TeamVo;
import com.cardpay.mgt.team.model.vo.UserTeamVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 团队表Mapper
 */
public interface TeamMapper extends BasicMapper<Team> {

    /**
     * 按id查询团队下的用用户
     * @return 信息列表
     */
    List<UserTeamVo> queryTeam(@Param("teamId") Integer teamId);

    /**
     * 查询团队层级信息
     * @return
     */
    List<TeamVo> queryAll();
}