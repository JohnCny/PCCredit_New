package com.cardpay.mgt.team.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.team.model.TUserTeam;

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
}