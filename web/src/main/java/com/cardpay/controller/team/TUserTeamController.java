package com.cardpay.controller.team;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.team.model.TUserTeam;
import com.cardpay.mgt.team.service.TUserTeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 团队用户Controller
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/6 10:58
 */
@RestController
@RequestMapping("/api/userTeam")
public class TUserTeamController extends BaseController<TUserTeam> {
    @Autowired
    private TUserTeamService tUserTeamService;

    /**
     * 更新
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
     * 添加
     *
     * @param teamId  团队id
     * @param userIds 用户id
     * @return 数据库变记录
     */
    @PostMapping
    public ResultTo insert(int teamId, String userIds) {
        int flag = tUserTeamService.batchInsert(teamId, userIds);
        return flag != 0 ? new ResultTo().setData(false) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

}
