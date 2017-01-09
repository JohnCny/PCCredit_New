package com.cardpay.mgt.application.balancecross.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Table(name = "T_TEMPLATE_GROUP")
@ApiModel(value="null")
public class TTemplateGroup {
    /**
     * 模板组id
     */
    @Id
    @Column(name = "GROUP_ID")
    @ApiModelProperty(value="模板组id",required = true)
    private Integer groupId;

    /**
     * 模板名称
     */
    @Column(name = "GROUP_NAME")
    @ApiModelProperty(value="模板名称",required = true)
    private String groupName;

    /**
     * 模板组父id
     */
    @Column(name = "GROUP_PARENT_ID")
    @ApiModelProperty(value="模板组父id",required = true)
    private Integer groupParentId;

    /**
     * 模板组描述
     */
    @Column(name = "GROUP_DESCRIPTION")
    @ApiModelProperty(value="模板组描述",required = true)
    private String groupDescription;

    /**
     * 是否是菜单项
     */
    @Column(name = "IS_GROUP_MENU")
    @ApiModelProperty(value="是否是菜单项",required = true)
    private Integer isGroupMenu;

    /**
     * 获取模板组id
     *
     * @return GROUP_ID - 模板组id
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * 设置模板组id
     *
     * @param groupId 模板组id
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    /**
     * 获取模板名称
     *
     * @return GROUP_NAME - 模板名称
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     * 设置模板名称
     *
     * @param groupName 模板名称
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     * 获取模板组父id
     *
     * @return GROUP_PARENT_ID - 模板组父id
     */
    public Integer getGroupParentId() {
        return groupParentId;
    }

    /**
     * 设置模板组父id
     *
     * @param groupParentId 模板组父id
     */
    public void setGroupParentId(Integer groupParentId) {
        this.groupParentId = groupParentId;
    }

    /**
     * 获取模板组描述
     *
     * @return GROUP_DESCRIPTION - 模板组描述
     */
    public String getGroupDescription() {
        return groupDescription;
    }

    /**
     * 设置模板组描述
     *
     * @param groupDescription 模板组描述
     */
    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    /**
     * 获取是否是菜单项
     *
     * @return IS_GROUP_MENU - 是否是菜单项
     */
    public Integer getIsGroupMenu() {
        return isGroupMenu;
    }

    /**
     * 设置是否是菜单项
     *
     * @param isGroupMenu 是否是菜单项
     */
    public void setIsGroupMenu(Integer isGroupMenu) {
        this.isGroupMenu = isGroupMenu;
    }
}