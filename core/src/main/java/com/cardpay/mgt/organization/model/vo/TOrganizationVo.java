package com.cardpay.mgt.organization.model.vo;

import com.cardpay.basic.base.model.GenericEntity;
import com.cardpay.basic.util.treeutil.annotation.TreeChild;
import com.cardpay.basic.util.treeutil.annotation.TreeId;
import com.cardpay.basic.util.treeutil.annotation.TreeParentId;
import com.cardpay.mgt.organization.model.TOrganization;
import com.cardpay.mgt.user.model.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 机构表VO类
 * @author chenkai on 2016/11/23.
 */
@Lazy
@ApiModel(value = "机构表VO类")
public class TOrganizationVo extends GenericEntity<Integer> {
    /**
     * id
     */
    @TreeId
    private Integer id;

    /**
     * 机构名称
     */
    private String orgName;

    /**
     * 机构编号
     */
    private String orgId;

    /**
     * 机构级别(0 法人机构 1 分支机构)
     */
    private Integer orgLevel;

    /**
     * 父机构id
     */
    @TreeParentId
    private Integer orgParentId;

    /**
     * 机构负责人
     */
    private Integer orgDirectorId;

    /**
     * 机构负责人名字
     */
    private String orgDirectorName;

    /**
     * 机构后勤人员id
     */
    private Integer orgLogisticsId;

    /**
     * 创建用户id
     */
    private Integer createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 父机构信息
     */
    private TOrganization parentOrg;

    /**
     * 子机构列表
     */
    @TreeChild
    private List<TOrganizationVo> organizationList;

    /**
     * 后勤信息
     */
    private User user;

    public TOrganization getParentOrg() {
        return parentOrg;
    }

    public void setParentOrg(TOrganization parentOrg) {
        this.parentOrg = parentOrg;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 获取id
     *
     * @return ID - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取机构名称
     *
     * @return ORG_NAME - 机构名称
     */
    public String getOrgName() {
        return orgName;
    }

    /**
     * 设置机构名称
     *
     * @param orgName 机构名称
     */
    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    /**
     * 获取机构编号
     *
     * @return ORG_ID - 机构编号
     */
    public String getOrgId() {
        return orgId;
    }

    /**
     * 设置机构编号
     *
     * @param orgId 机构编号
     */
    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    /**
     * 获取机构级别(0 法人机构 1 分支机构)
     *
     * @return ORG_LEVEL - 机构级别(0 法人机构 1 分支机构)
     */
    public Integer getOrgLevel() {
        return orgLevel;
    }

    /**
     * 设置机构级别(0 法人机构 1 分支机构)
     *
     * @param orgLevel 机构级别(0 法人机构 1 分支机构)
     */
    public void setOrgLevel(Integer orgLevel) {
        this.orgLevel = orgLevel;
    }

    /**
     * 获取父机构id
     *
     * @return ORG_PARENT_ID - 父机构id
     */
    public Integer getOrgParentId() {
        return orgParentId;
    }

    /**
     * 设置父机构id
     *
     * @param orgParentId 父机构id
     */
    public void setOrgParentId(Integer orgParentId) {
        this.orgParentId = orgParentId;
    }

    /**
     * 获取机构负责人
     *
     * @return ORG_DIRECTOR_ID - 机构负责人
     */
    public Integer getOrgDirectorId() {
        return orgDirectorId;
    }

    /**
     * 设置机构负责人
     *
     * @param orgDirectorId 机构负责人
     */
    public void setOrgDirectorId(Integer orgDirectorId) {
        this.orgDirectorId = orgDirectorId;
    }

    /**
     * 获取机构负责人名字
     *
     * @return ORG_DIRECTOR_NAME - 机构负责人名字
     */
    public String getOrgDirectorName() {
        return orgDirectorName;
    }

    /**
     * 设置机构负责人名字
     *
     * @param orgDirectorName 机构负责人名字
     */
    public void setOrgDirectorName(String orgDirectorName) {
        this.orgDirectorName = orgDirectorName;
    }

    /**
     * 获取机构后勤人员id
     *
     * @return ORG_LOGISTICS_ID - 机构后勤人员id
     */
    public Integer getOrgLogisticsId() {
        return orgLogisticsId;
    }

    /**
     * 设置机构后勤人员id
     *
     * @param orgLogisticsId 机构后勤人员id
     */
    public void setOrgLogisticsId(Integer orgLogisticsId) {
        this.orgLogisticsId = orgLogisticsId;
    }

    /**
     * 获取创建用户id
     *
     * @return CREATE_BY - 创建用户id
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建用户id
     *
     * @param createBy 创建用户id
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取创建时间
     *
     * @return CREATE_TIME - 创建时间
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

    public List<TOrganizationVo> getOrganizationList() {
        return organizationList;
    }

    public void setOrganizationList(List<TOrganizationVo> organizationList) {
        this.organizationList = organizationList;
    }

    @Override
    public Integer getPK() {
        return id;
    }
}
