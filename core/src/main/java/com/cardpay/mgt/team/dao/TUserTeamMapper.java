package com.cardpay.mgt.team.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.team.model.TUserTeam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 用户团队关联表
 * @author chenkai
 */
public interface TUserTeamMapper extends BasicMapper<TUserTeam> {

    /**
     * 批量添加团队,成员关联信息
     * @param map 用户,团队id
     * @return 数据库变记录
     */
    int batchInsert (Map<String, Object> map);

    /**
     * 批量更新团队,成员信息
     * @param map 用户,团队id
     * @return 数据库变记录
     */
    int batchUpdate(Map<String, Object> map);

    /**
     * 按用户id查询关联团队id
     * @param userId 用户id
     * @return 团队id
     */
    List<TUserTeam> queryByUserId(@Param("userId") int userId);

    /**
     * 按进件Id查询所属团队信息
     * @param applicationId 进件id
     * @return 用户团队信息
     */
    List<TUserTeam> queryTeamByAppId(@Param("applicationId") int applicationId);

    /**
     * 批量删除团队成员信息
     * @param map 参数
     * @return 成员信息
     */
    int bathDelete(Map<String, Object> map);
}