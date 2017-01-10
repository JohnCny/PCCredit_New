package com.cardpay.mgt.user.enums;

/**
 * 用户状态枚举
 *
 * @author yanwe
 * createTime 2016-12-2016/12/29 9:36
 */
public enum UserStatus {

    NORMAL(0,"正常"),
    LOCK(1,"锁定"),
    NON_ACTIVATED(3,"待激活");

    private Integer status;
    private String statusName;

    UserStatus(Integer status, String statusName) {
        this.status = status;
        this.statusName = statusName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public static UserStatus getStatusNameByStatus(Integer status) {
        switch (status) {
            case 0:
                return NORMAL;
            case 1:
                return LOCK;
            case 3:
                return NON_ACTIVATED;
            default:
                break;
        }
        return null;
    }
}
