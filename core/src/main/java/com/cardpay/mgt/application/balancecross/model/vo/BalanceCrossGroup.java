package com.cardpay.mgt.application.balancecross.model.vo;

import java.util.List;

/**
 * 资产负债和交叉检验类型group
 *
 * @author yanwe
 *         createTime 2017-01-2017/1/6 14:06
 */
public class BalanceCrossGroup {

    /**
     * 进件id
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
     * childGroup
     */
    private List<BalanceCrossGroup> balanceCrossChildren;

    /**
     * var
     */
    private List<BalanceCrossVar> balanceCrossVars;

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getGroupParentId() {
        return groupParentId;
    }

    public void setGroupParentId(Integer groupParentId) {
        this.groupParentId = groupParentId;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    public Integer getIsGroupMenu() {
        return isGroupMenu;
    }

    public void setIsGroupMenu(Integer isGroupMenu) {
        this.isGroupMenu = isGroupMenu;
    }

    public List<BalanceCrossGroup> getBalanceCrossChildren() {
        return balanceCrossChildren;
    }

    public void setBalanceCrossChildren(List<BalanceCrossGroup> balanceCrossChildren) {
        this.balanceCrossChildren = balanceCrossChildren;
    }

    public List<BalanceCrossVar> getBalanceCrossVars() {
        return balanceCrossVars;
    }

    public void setBalanceCrossVars(List<BalanceCrossVar> balanceCrossVars) {
        this.balanceCrossVars = balanceCrossVars;
    }
}
