package com.cardpay.mgt.team.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Table(name = "T_USER_TEAM")
@ApiModel(value="用户团队表")
public class TUserTeam extends GenericEntity<Integer> {

    /**
     * 团队id
     */
    @Column(name = "TEAM_ID")
    @ApiModelProperty(value="团队id",required = true)
    private Integer teamId;

    /**
     * 用户id
     */
    @Column(name = "USER_ID")
    @ApiModelProperty(value="用户id",required = true)
    private Integer userId;


    /**
     * 获取团队id
     *
     * @return TEAM_ID - 团队id
     */
    public Integer getTeamId() {
        return teamId;
    }

    /**
     * 设置团队id
     *
     * @param teamId 团队id
     */
    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    /**
     * 获取用户id
     *
     * @return USER_ID - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public Integer getPK() {
        return null;
    }
}