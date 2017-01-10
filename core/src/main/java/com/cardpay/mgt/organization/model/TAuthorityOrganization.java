package com.cardpay.mgt.organization.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
@Lazy
@ApiModel(value = "权限机构关联表")
@Table(name = "T_AUTHORITY_ORGANIZATION")
public class TAuthorityOrganization extends GenericEntity<Integer>{
    /**
     * 权限id
     */
    @Column(name = "AUTHORITY_ID")
    @ApiModelProperty(value = "权限id", required = true)
    private Integer authorityId;

    /**
     * 机构id
     */
    @Column(name = "ORGANIZATION_ID")
    @ApiModelProperty(value = "菜单id", required = true)
    private Integer organizationId;

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
     * @return ORGANIZATION_ID - 菜单id
     */
    public Integer getOrganizationId() {
        return organizationId;
    }

    /**
     * 设置菜单id
     *
     * @param organizationId 菜单id
     */
    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    @Override
    public Integer getPK() {
        return null;
    }
}