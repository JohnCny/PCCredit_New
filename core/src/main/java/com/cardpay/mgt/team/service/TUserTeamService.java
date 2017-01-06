package com.cardpay.mgt.team.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.team.model.TUserTeam;

import java.util.Map;

/**
 * 用户团队关联表
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/6 10:39
 */
public interface TUserTeamService extends BaseService<TUserTeam> {
    /**
     * 批量添加团队,成员关联信息
     * @param teamId 团队Id
     * @param userIds 成员id
     * @return 数据库变记录
     */
    int batchInsert (int teamId, String userIds);

}
