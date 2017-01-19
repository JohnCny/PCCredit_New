package com.cardpay.controller.team;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.team.model.TUserTeam;
import com.cardpay.mgt.team.service.TUserTeamService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 团队用户Controller
 *
 * @author chenkai
 */
@RestController
@RequestMapping("/api/userTeam")
public class TUserTeamController extends BaseController<TUserTeam> {
    @Autowired
    private TUserTeamService tUserTeamService;

    /**
     * 更新团队成员信息
     *
     * @param tUserTeam 用户团队表
     * @return 数据库变记录
     */
    @PutMapping
    public ResultTo update(TUserTeam tUserTeam) {
        Integer flag = tUserTeamService.updateSelectiveByPrimaryKey(tUserTeam);
        return flag != 0 ? new ResultTo().setData(false) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 添加团队成员信息
     *
     * @param teamId  团队id
     * @param userIds 用户id(,分割)
     * @return 数据库变记录
     */
    @PostMapping
    public ResultTo insert(int teamId, String userIds) {
        int flag = tUserTeamService.batchInsert(teamId, userIds);
        return flag != 0 ? new ResultTo().setData(false) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 删除团队成员信息
     * @param teamId 团队id
     * @param userIds 用户id(,分割)
     * @return 数据库变记录
     */
    @DeleteMapping
    public ResultTo delete(int teamId, String userIds){
        Map<String, Object> map = new HashMap<>();
        map.put("teamId", teamId);
        map.put("userIds", userIds);
        int bathDelete = tUserTeamService.bathDelete(map);
        return bathDelete!=0? new ResultTo().setData(bathDelete): new ResultTo(ResultEnum.SERVICE_ERROR);
    }

}
