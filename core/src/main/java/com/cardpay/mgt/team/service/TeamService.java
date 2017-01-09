package com.cardpay.mgt.team.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.team.model.Team;
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
     * @param map 参数
     * @return 团队层级信息
     */
    List<TeamVo> queryAll(Map<String, Integer> map);

    /**
     * 按id查询团队下的用用户
     * @return 信息列表
     */
    List<UserTeamVo> queryTeam(Integer teamId);

    /**
     * 递归删除团队信息
     * @param teamId
     * @return
     */
    int deleteTeam(Integer teamId);

}
