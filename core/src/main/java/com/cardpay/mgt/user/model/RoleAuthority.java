package com.cardpay.mgt.user.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Table(name = "T_ROLE_AUTHORITY")
@ApiModel(value = "角色于权限关系实体")
public class RoleAuthority extends GenericEntity<Integer> {
    /**
     * 角色id
     */
    @Column(name = "ROLE_ID")
    @ApiModelProperty(value = "角色id")
    private Integer roleId;

    /**
     * 权限id
     */
    @Column(name = "AUTHORITY_ID")
    @ApiModelProperty(value = "权限id")
    private Integer authorityId;

    /**
     * 获取角色id
     *
     * @return ROLE_ID - 角色id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 设置角色id
     *
     * @param roleId 角色id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

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

    @Override
    public Integer getPK() {
        return null;
    }
}