package com.cardpay.mgt.application.ipc.universal.model.vo;

import java.util.List;

public class TemplateGroup {

    /**
     * 进件Id
     */
    private Integer applicationId;

    /**
     * 模板组id
     */
    private Integer groupId;

    /**
     * 模板名称
     */
    private String groupName;

    /**
     * 模板组父id
     */
    private Integer groupParentId;

    /**
     * 模板组描述
     */
    private String groupDescription;

    /**
     * 是否是菜单项
     */
    private Integer isGroupMenu;

    /**
     * 进件菜单url
     */
    private String groupMenuUrl;

    /**
     * children
     */
    private List<TemplateGroup> groups;

    /**
     * vars
     */
    private List<TemplateVar> vars;

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public List<TemplateGroup> getGroups() {
        return groups;
    }

    public void setGroups(List<TemplateGroup> groups) {
        this.groups = groups;
    }

    public List<TemplateVar> getVars() {
        return vars;
    }

    public void setVars(List<TemplateVar> vars) {
        this.vars = vars;
    }

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

    /**
     * 获取进件菜单url
     *
     * @return GROUP_MENU_URL - 进件菜单url
     */
    public String getGroupMenuUrl() {
        return groupMenuUrl;
    }

    /**
     * 设置进件菜单url
     *
     * @param groupMenuUrl 进件菜单url
     */
    public void setGroupMenuUrl(String groupMenuUrl) {
        this.groupMenuUrl = groupMenuUrl;
    }
}