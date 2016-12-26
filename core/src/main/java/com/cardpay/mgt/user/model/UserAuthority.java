package com.cardpay.mgt.user.model;

/**
 * 用户拥有的资源
 *
 * @author rankai .
 */
public class UserAuthority {
    /**
     * 权限名
     */
    private String authorityName;
    /**
     * 资源名
     */
    private String resoucreName;
    /**
     * 操作名
     */
    private String operationName;

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    public String getResoucreName() {
        return resoucreName;
    }

    public void setResoucreName(String resoucreName) {
        this.resoucreName = resoucreName;
    }

    public String getOperationName() {
        return operationName;
    }

    public void setOperationName(String operationName) {
        this.operationName = operationName;
    }
}
