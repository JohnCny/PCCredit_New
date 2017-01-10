package com.cardpay.mgt.team.model.vo;

import com.cardpay.basic.base.model.GenericEntity;
import com.cardpay.basic.util.treeutil.annotation.TreeChild;
import com.cardpay.basic.util.treeutil.annotation.TreeId;
import com.cardpay.basic.util.treeutil.annotation.TreeParentId;
import com.cardpay.mgt.team.model.TUserTeam;
import com.cardpay.mgt.user.model.User;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import java.util.Date;
import java.util.List;

/**
 * 团队Vo类
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/6 9:38
 */
public class TeamVo extends GenericEntity<Integer> {

    /**
     * 团队id
     */
    @TreeId
    private Integer teamId;

    /**
     * 团队名称
     */
    private String teamName;

    /**
     * 团队描述
     */
    private String teamDescription;

    /**
     * 团队负责人id
     */
    private Integer teamLeaderId;

    /**
     * 团队负责人姓名
     */
    private String teamLeaderCname;

    /**
     * 父团队id(顶级默认为0)
     */
    @TreeParentId
    private Integer teamParentId;

    /**
     * 创建人id
     */
    private Integer createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 是否机构类团队
     */
    private Short isMenuType;

    /**
     * 子团队信息
     */
    @TreeChild
    private List<TeamVo> teamList;

    /**
     *客户机构关联信息
     */
    private List<UserTeamVo> userTeamList;

    public List<UserTeamVo> getUserTeamList() {
        return userTeamList;
    }

    public void setUserTeamList(List<UserTeamVo> userTeamList) {
        this.userTeamList = userTeamList;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamDescription() {
        return teamDescription;
    }

    public void setTeamDescription(String teamDescription) {
        this.teamDescription = teamDescription;
    }

    public Integer getTeamLeaderId() {
        return teamLeaderId;
    }

    public void setTeamLeaderId(Integer teamLeaderId) {
        this.teamLeaderId = teamLeaderId;
    }

    public String getTeamLeaderCname() {
        return teamLeaderCname;
    }

    public void setTeamLeaderCname(String teamLeaderCname) {
        this.teamLeaderCname = teamLeaderCname;
    }

    public Integer getTeamParentId() {
        return teamParentId;
    }

    public void setTeamParentId(Integer teamParentId) {
        this.teamParentId = teamParentId;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Short getIsMenuType() {
        return isMenuType;
    }

    public void setIsMenuType(Short isMenuType) {
        this.isMenuType = isMenuType;
    }

    public List<TeamVo> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<TeamVo> teamList) {
        this.teamList = teamList;
    }

    @Override
    public Integer getPK() {
        return teamId;
    }
}
