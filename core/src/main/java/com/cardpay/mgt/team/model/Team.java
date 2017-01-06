package com.cardpay.mgt.team.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.persistence.*;

@Table(name = "T_TEAM")
@ApiModel(value="团队表")
public class Team extends GenericEntity<Integer>{
    /**
     * 团队id
     */
    @Id
    @Column(name = "team_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select TEAM_SEQ.nextval from dual")
    @ApiModelProperty(value="团队id",required = true)
    private Integer teamId;

    /**
     * 团队名称
     */
    @Column(name = "team_name")
    @ApiModelProperty(value="团队名称",required = true)
    private String teamName;

    /**
     * 团队描述
     */
    @Column(name = "team_description")
    @ApiModelProperty(value="团队描述",required = true)
    private String teamDescription;

    /**
     * 团队负责人id
     */
    @Column(name = "team_leader_id")
    @ApiModelProperty(value="团队负责人id",required = true)
    private Integer teamLeaderId;

    /**
     * 团队负责人姓名
     */
    @Column(name = "team_leader_cname")
    @ApiModelProperty(value="团队负责人姓名",required = true)
    private String teamLeaderCname;

    /**
     * 父团队id(顶级默认为0)
     */
    @Column(name = "team_parent_id")
    @ApiModelProperty(value="父团队id(顶级默认为0)",required = true)
    private Integer teamParentId;

    /**
     * 创建人id
     */
    @Column(name = "create_by")
    @ApiModelProperty(value="创建人id",required = true)
    private Integer createBy;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @ApiModelProperty(value="创建时间",required = true)
    private Date createTime;

    /**
     * 是否机构类团队
     */
    @Column(name = "is_menu_type")
    @ApiModelProperty(value="是否机构类团队",required = true)
    private Short isMenuType;

    /**
     * 获取团队id
     *
     * @return team_id - 团队id
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
     * 获取团队名称
     *
     * @return team_name - 团队名称
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * 设置团队名称
     *
     * @param teamName 团队名称
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * 获取团队描述
     *
     * @return team_description - 团队描述
     */
    public String getTeamDescription() {
        return teamDescription;
    }

    /**
     * 设置团队描述
     *
     * @param teamDescription 团队描述
     */
    public void setTeamDescription(String teamDescription) {
        this.teamDescription = teamDescription;
    }

    /**
     * 获取团队负责人id
     *
     * @return team_leader_id - 团队负责人id
     */
    public Integer getTeamLeaderId() {
        return teamLeaderId;
    }

    /**
     * 设置团队负责人id
     *
     * @param teamLeaderId 团队负责人id
     */
    public void setTeamLeaderId(Integer teamLeaderId) {
        this.teamLeaderId = teamLeaderId;
    }

    /**
     * 获取团队负责人姓名
     *
     * @return team_leader_cname - 团队负责人姓名
     */
    public String getTeamLeaderCname() {
        return teamLeaderCname;
    }

    /**
     * 设置团队负责人姓名
     *
     * @param teamLeaderCname 团队负责人姓名
     */
    public void setTeamLeaderCname(String teamLeaderCname) {
        this.teamLeaderCname = teamLeaderCname;
    }

    /**
     * 获取父团队id(顶级默认为0)
     *
     * @return team_parent_id - 父团队id(顶级默认为0)
     */
    public Integer getTeamParentId() {
        return teamParentId;
    }

    /**
     * 设置父团队id(顶级默认为0)
     *
     * @param teamParentId 父团队id(顶级默认为0)
     */
    public void setTeamParentId(Integer teamParentId) {
        this.teamParentId = teamParentId;
    }

    /**
     * 获取创建人id
     *
     * @return create_by - 创建人id
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人id
     *
     * @param createBy 创建人id
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取是否机构类团队
     *
     * @return is_menu_type - 是否机构类团队
     */
    public Short getIsMenuType() {
        return isMenuType;
    }

    /**
     * 设置是否机构类团队
     *
     * @param isMenuType 是否机构类团队
     */
    public void setIsMenuType(Short isMenuType) {
        this.isMenuType = isMenuType;
    }

    @Override
    public Integer getPK() {
        return teamId;
    }
}