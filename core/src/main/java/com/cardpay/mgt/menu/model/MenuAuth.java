package com.cardpay.mgt.menu.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 菜单权限
 * @author yanwe
 */
@ApiModel(value = "菜单权限")
public class MenuAuth {

    /**
     * 权限Id
     */
    @ApiModelProperty(value = "权限Id", required = true)
    private Integer authId;

    /**
     * 权限类型
     */
    @ApiModelProperty(value = "权限类型", required = true)
    private String authType;

    /**
     * 是否拥有权限
     */
    @ApiModelProperty(value = "是否拥有权限", required = true)
    private boolean isHaveAuth;

    public Integer getAuthId() {
        return authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    public String getAuthType() {
        return authType;
    }

    public void setAuthType(String authType) {
        this.authType = authType;
    }

    public boolean isHaveAuth() {
        return isHaveAuth;
    }

    public void setHaveAuth(boolean haveAuth) {
        isHaveAuth = haveAuth;
    }
}
