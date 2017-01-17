package com.cardpay.mgt.team.model.vo;


import com.cardpay.basic.base.model.GenericEntity;
import com.cardpay.mgt.team.model.Team;

import java.util.List;

/**
 * 机构团队信息
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/17 10:13
 */
public class OrganizationTeamVo extends GenericEntity<Integer> {
    /**
     * 团队id
     */
    private Integer teamId;

    /**
     * 团队名称
     */
    private String teamName;

    /**
     * 父团队id(顶级默认为0)
     */
    private Integer teamParentId;

    /**
     * 团队所属机构id
     */
    private Integer organizationId;

    //----------机构--------------

    /**
     * 机构id
     */
    private Integer orgId;

    /**
     * 机构名称
     */
    private String orgName;

    /**
     * 机构级别(0 法人机构 1 分支机构)
     */
    private Integer orgLevel;

    /**
     * 父机构id
     */
    private Integer orgParentId;

    /**
     * 机构list
     */
    private List<OrganizationTeamVo> orgList;

    /**
     * 团队List
     */
    private List<Team> teamList;

    /**
     * 机构下的团队List
     */
    private List<OrganizationTeamVo> orgTeamList;


    public List<OrganizationTeamVo> getOrgTeamList() {
        return orgTeamList;
    }

    public void setOrgTeamList(List<OrganizationTeamVo> orgTeamList) {
        this.orgTeamList = orgTeamList;
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

    public Integer getTeamParentId() {
        return teamParentId;
    }

    public void setTeamParentId(Integer teamParentId) {
        this.teamParentId = teamParentId;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Integer getOrgLevel() {
        return orgLevel;
    }

    public void setOrgLevel(Integer orgLevel) {
        this.orgLevel = orgLevel;
    }

    public Integer getOrgParentId() {
        return orgParentId;
    }

    public void setOrgParentId(Integer orgParentId) {
        this.orgParentId = orgParentId;
    }

    public List<OrganizationTeamVo> getOrgList() {
        return orgList;
    }

    public void setOrgList(List<OrganizationTeamVo> orgList) {
        this.orgList = orgList;
    }

    public List<Team> getTeamList() {
        return teamList;
    }

    public void setTeamList(List<Team> teamList) {
        this.teamList = teamList;
    }

    @Override
    public Integer getPK() {
        return teamId;
    }
}
