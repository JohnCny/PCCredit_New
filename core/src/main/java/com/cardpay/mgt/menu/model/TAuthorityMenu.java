package com.cardpay.mgt.menu.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Table(name = "T_AUTHORITY_MENU")
@ApiModel(value="权限菜单表")
public class TAuthorityMenu {
    /**
     * 权限id
     */
    @Column(name = "AUTHORITY_ID")
    @ApiModelProperty(value="权限id",required = true)
    private Integer authorityId;

    /**
     * 菜单id
     */
    @Column(name = "MENU_ID")
    @ApiModelProperty(value="菜单id",required = true)
    private Integer menuId;

    /**
     * 获取权限id
     *
     * @return AUTHORITY_ID - 权限id
     */
    public Integer getAuthorityId() {
        return authorityId;
    }

    /**
     * 设置权限id
     *
     * @param authorityId 权限id
     */
    public void setAuthorityId(Integer authorityId) {
        this.authorityId = authorityId;
    }

    /**
     * 获取菜单id
     *
     * @return MENU_ID - 菜单id
     */
    public Integer getMenuId() {
        return menuId;
    }

    /**
     * 设置菜单id
     *
     * @param menuId 菜单id
     */
    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }
}