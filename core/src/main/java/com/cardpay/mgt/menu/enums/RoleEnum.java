package com.cardpay.mgt.menu.enums;

/**
 * 角色ID枚举
 */
public enum RoleEnum {

    ADMIN("admin", 2),
    MANAGER("manager", 3);

    RoleEnum(String roleName, Integer roleId) {
        this.roleName = roleName;
        this.roleId = roleId;
    }

    private String roleName;
    private Integer roleId;

    public String getRoleName() {
        return roleName;
    }

    private void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public static RoleEnum getValueById(Integer id) {
        switch (id) {
            case 2:
                return ADMIN;
            case 3:
                return MANAGER;
            default:
                break;
        }
        return null;
    }
}