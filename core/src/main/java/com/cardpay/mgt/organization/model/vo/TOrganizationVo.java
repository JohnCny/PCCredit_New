package com.cardpay.mgt.organization.model.vo;

import com.cardpay.basic.base.model.GenericEntity;
import com.cardpay.basic.util.treeutil.annotation.TreeChild;
import com.cardpay.basic.util.treeutil.annotation.TreeId;
import com.cardpay.basic.util.treeutil.annotation.TreeParentId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * 机构表VO类
 * Created by chenkai on 2016/11/23.
 */
@ApiModel(value = "机构表VO类")
public class TOrganizationVo extends GenericEntity<Integer> {
    /**
     * id
     */
    @Id
    @TreeId
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select ORGANIZATION_SEQ.nextval from dual")
    @ApiModelProperty(value = "机构Id", required = true)
    private Integer id;

    /**
     * 机构名称
     */
    @Column(name = "ORG_NAME")
    @ApiModelProperty(value = "机构名称", required = true)
    private String orgName;

    /**
     * 机构编号
     */
    @Column(name = "ORG_ID")
    @ApiModelProperty(value = "机构编号", required = true)
    private String orgId;

    /**
     * 机构级别(0 法人机构 1 分支机构)
     */
    @Column(name = "ORG_LEVEL")
    @ApiModelProperty(value = "机构级别(0 法人机构 1 分支机构)", required = true)
    private Integer orgLevel;

    /**
     * 父机构id
     */
    @Column(name = "ORG_PARENT_ID")
    @ApiModelProperty(value = "父机构id", required = true)
    @TreeParentId
    private Integer orgParentId;

    /**
     * 机构负责人
     */
    @Column(name = "ORG_DIRECTOR_ID")
    @ApiModelProperty(value = "机构负责人", required = true)
    private Integer orgDirectorId;

    /**
     * 机构负责人名字
     */
    @Column(name = "ORG_DIRECTOR_NAME")
    @ApiModelProperty(value = "机构负责人名字", required = true)
    private String orgDirectorName;

    /**
     * 机构后勤人员id
     */
    @Column(name = "ORG_LOGISTICS_ID")
    @ApiModelProperty(value = "机构后勤人员id", required = true)
    private Integer orgLogisticsId;

    /**
     * 创建用户id
     */
    @Column(name = "CREATE_BY")
    @ApiModelProperty(value = "创建用户id", required = true)
    private Integer createBy;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

    /**
     * 子机构列表
     */
    @ApiModelProperty(value = "子机构列表", required = true)
    @Transient
    @TreeChild
    private List<TOrganizationVo> organizationList;

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
