package com.cardpay.mgt.menu.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 菜单权限展示
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
    //为了适应前段插件显示修改为menuNameZh,实际为menuNameZh
    private String menuNameZh;

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

    public String getMenuNameZh() {
        return menuNameZh;
    }

    public void setMenuNameZh(String menuNameZh) {
        this.menuNameZh = menuNameZh;
    }

    public boolean isHaveAuth() {
        return isHaveAuth;
    }

    public void setHaveAuth(boolean haveAuth) {
        isHaveAuth = haveAuth;
    }
}
