package com.cardpay.mgt.customermanager.basic.model.vo;

import com.cardpay.mgt.user.model.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 客户经理信息BaseVo
 *
 * @author yanweichen
 */
@ApiModel(value="客户经理信息管理")
public class TCustomerManagerBaseVo {

    /**
     * 客户经理用户基本信息
     */
    @ApiModelProperty(value="客户经理用户基本信息",required = true)
    private User user;

    /**
     * 客户经理Id
     */
    @ApiModelProperty(value="客户经理Id",required = true)
    private Integer managerId;

    /**
     * 客户经理级别id
     */
    @ApiModelProperty(value="客户经理级别id",required = true)
    private Integer levelId;

    /**
     * 客户经理级别
     */
    @ApiModelProperty(value="客户经理级别",required = true)
    private Integer levelName;

    /**
     * 客户经理所属机构id
     */
    @ApiModelProperty(value="客户经理所属机构id",required = true)
    private Integer organizationId;

    /**
     * 客户经理所属机构名称
     */
    @ApiModelProperty(value="客户经理所属机构名称",required = true)
    private Integer orgName;

    /**
     * 客户经理状态
     */
    @ApiModelProperty(value="客户经理状态",required = true)
    private Integer status;

    /**
     * 获取客户经理用户基本信息
     *
     * @return user - 客户经理用户基本信息
     */
    public User getUser() {
        return user;
    }

    /**
     * 设置客户经理用户基本信息
     *
     * @param user 客户经理用户基本信息
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * 获取客户经理Id
     *
     * @return managerId - 客户经理id
     */
    public Integer getManagerId() {
        return managerId;
    }

    /**
     * 设置客户经理id
     *
     * @param managerId 客户经理id
     */
    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    /**
     * 获取客户经理级别名称
     *
     * @return ID - 客户经理级别名称
     */
    public Integer getLevelName() {
        return levelName;
    }

    /**
     * 设置客户经理级别名称
     *
     * @param levelName 客户经理级别名称
     */
    public void setLevelName(Integer levelName) {
        this.levelName = levelName;
    }

    /**
     * 获取客户经理状态
     *
     * @return ID - 客户经理状态
     */
    public Integer getOrgName() {
        return orgName;
    }

    /**
     * 设置客户经理机构名称
     *
     * @param orgName 客户经理机构名称
     */
    public void setOrgName(Integer orgName) {
        this.orgName = orgName;
    }

    /**
     * 获取客户经理状态
     *
     * @return ID - 客户经理状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置客户经理状态
     *
     * @param status 客户经理状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取客户经理级别id
     *
     * @return LEVEL_ID - 客户经理级别id
     */
    public Integer getLevelId() {
        return levelId;
    }

    /**
     * 设置客户经理级别id
     *
     * @param levelId 客户经理级别id
     */
    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    /**
     * 获取客户经理所属机构
     *
     * @return ORGANIZATION_ID - 客户经理所属机构
     */
    public Integer getOrganizationId() {
        return organizationId;
    }

    /**
     * 设置客户经理所属机构
     *
     * @param organizationId 客户经理所属机构
     */
    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

}