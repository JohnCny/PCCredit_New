package com.cardpay.controller.team;

import com.alibaba.fastjson.JSONArray;
import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.team.model.TUserTeam;
import com.cardpay.mgt.team.model.Team;
import com.cardpay.mgt.team.model.vo.TeamVo;
import com.cardpay.mgt.team.model.vo.UserTeamVo;
import com.cardpay.mgt.team.service.TUserTeamService;
import com.cardpay.mgt.team.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 团队Controller
 *
 * @author chenkai
 */
@RestController
@RequestMapping("/api/team")
public class TeamController extends BaseController<Team> {
    @Autowired
    private TeamService teamService;

    /**
     * 团队成员关联Service
     */
    @Autowired
    private TUserTeamService tUserTeamService;

    /**
     * 查询团队层级信息
     *
     * @param topId 层级Id
     * @return 团队层级信息
     */
    private List<TeamVo> queryAllTeam(int topId) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("topId", topId);
        List<TeamVo> teamVoList = teamService.queryAll(map);
        return teamVoList;
    }

    /**
     * 查询团队信息（包含成员信息）
     *
     * @param topId
     * @return
     */
    @GetMapping
    public ResultTo queryAll(@RequestParam(defaultValue = "0") int topId) {
        List<TeamVo> teamVoList = queryAllTeam(topId);
        for (TeamVo teamVo : teamVoList) {
            List<UserTeamVo> userTeamVos = teamService.queryTeam(teamVo.getTeamId());
            teamVo.setUserTeamList(userTeamVos);
            List<TeamVo> teamList = teamVo.getTeamList();
            for (TeamVo team : teamList) {
                List<UserTeamVo> userTeamVoList = teamService.queryTeam(team.getTeamId());
                team.setUserTeamList(userTeamVoList);
            }
        }
        return new ResultTo().setData(teamVoList);
    }

    /**
     * 查询团队信息（不包含成员信息）
     *
     * @param topId
     * @return
     */
    @GetMapping("/all")
    public ResultTo queryTeam(@RequestParam(defaultValue = "0") int topId) {
        List<TeamVo> teamVoList = queryAllTeam(topId);
        return new ResultTo().setData(teamVoList);
    }

    /**
     * 新增团队信息（默认新增团队为顶级团队）
     *
     * @param team 团队信息
     * @return 团队Id
     */
    @PostMapping
    public ResultTo insertTeam(@ModelAttribute Team team) {
        Integer userId = ShiroKit.getUserId();
        team.setCreateBy(userId);
        team.setCreateTime(new Date());
        team.setTeamParentId(0);
        Integer flag = teamService.insertSelective(team);
        return flag != 0 ? new ResultTo().setData(team.getTeamId()) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 拖拽更新团队信息
     *
     * @param team 团队信息
     * @return 数据库变记录
     */
    @PutMapping("/move")
    public ResultTo updateTeam(@RequestBody String team) {
        List<Team> teamList = JSONArray.parseArray(team, Team.class);
        int flag = 0;
        for (Team teamBean : teamList) {
            flag = teamService.updateSelectiveByPrimaryKey(teamBean);
            TUserTeam tUserTeam = new TUserTeam();
            tUserTeam.setTeamId(teamBean.getTeamId());
            tUserTeamService.updateSelectiveByPrimaryKey(tUserTeam);
            flag++;
        }
        return flag != 0 ? new ResultTo().setData(flag) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 更新团队信息
     *
     * @param team 团队信息
     * @return 数据库变记录
     */
    @PutMapping
    public ResultTo updateById(@ModelAttribute Team team) {
        Integer flag = teamService.updateSelectiveByPrimaryKey(team);
        return flag != 0 ? new ResultTo().setData(flag) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 删除团队
     *
     * @param teamId 团队id
     * @return 数据库变记录
     */
    @DeleteMapping("/{id}")
    public ResultTo delete(@PathVariable("id") int teamId) {
        int flag = teamService.deleteTeam(teamId);
        return flag != 0 ? new ResultTo().setData(flag) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 查询子团队信息
     *
     * @param teamId 团队id
     * @return 团队信息
     */
    @GetMapping("/{id}")
    public ResultTo querySonTeam(@PathVariable("id") int teamId) {
        List<Team> teamList = teamService.querySonTeamById(teamId);
        return new ResultTo().setData(teamList);
    }

    /**
     * 查询此用户负责的团队信息
     *
     * @return 团队信息
     */
    @GetMapping("/principalTeam")
    public ResultTo bossTeam() {
        List<Team> teamList = teamService.queryIfTeamPrincipal(ShiroKit.getUserId());
        return new ResultTo().setData(teamList);
    }

}
