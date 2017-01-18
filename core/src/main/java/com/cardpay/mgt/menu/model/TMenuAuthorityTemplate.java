package com.cardpay.mgt.menu.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Table(name = "T_MENU_AUTHORITY_TEMPLATE")
@ApiModel(value="菜单权限模板表")
public class TMenuAuthorityTemplate {
    /**
     * 权限id
     */
    @Column(name = "AUTHORITY_ID")
    @ApiModelProperty(value="权限id",required = true)
    private Integer authorityId;

    /**
     * 菜单模板id
     */
    @Column(name = "MENU_TEMPLATE_ID")
    @ApiModelProperty(value="菜单模板id",required = true)
    private Integer menuTemplateId;

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
     * 获取菜单模板id
     *
     * @return MENU_TEMPLATE_ID - 菜单模板id
     */
    public Integer getMenuTemplateId() {
        return menuTemplateId;
    }

    /**
     * 设置菜单模板id
     *
     * @param menuTemplateId 菜单模板id
     */
    public void setMenuTemplateId(Integer menuTemplateId) {
        this.menuTemplateId = menuTemplateId;
    }
}