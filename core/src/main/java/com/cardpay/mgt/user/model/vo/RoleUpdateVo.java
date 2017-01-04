package com.cardpay.mgt.user.model.vo;

/**
 * Role更新前所需的权限数据VO
 *
 * @author rankai .
 */
public class RoleUpdateVo {

    private Integer authorityId;

    private String authorityNameZh;

    private Integer operationId;

    private String operationNameZh;

    public Integer getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(Integer authorityId) {
        this.authorityId = authorityId;
    }

    public String getAuthorityNameZh() {
        return authorityNameZh;
    }

    public void setAuthorityNameZh(String authorityNameZh) {
        this.authorityNameZh = authorityNameZh;
    }

    public Integer getOperationId() {
        return operationId;
    }

    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }

    public String getOperationNameZh() {
        return operationNameZh;
    }

    public void setOperationNameZh(String operationNameZh) {
        this.operationNameZh = operationNameZh;
    }
}
