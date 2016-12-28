package com.cardpay.mgt.user.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * 权限资源关系实体
 *
 * @author rankai
 */
@Table(name = "T_AUTHORITY_RESOURCES")
@ApiModel(value = "权限资源关系实体")
public class AuthorityResources extends GenericEntity<Integer> {

    /**
     * 权限id
     */
    @Column(name = "AUTHORITY_ID")
    @ApiModelProperty(value = "权限id")
    private Integer authorityId;

    /**
     * 资源id
     */
    @Column(name = "RESOURCE_ID")
    @ApiModelProperty(value = "资源id")
    private Integer resourceId;

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
     * 获取资源id
     *
     * @return RESOURCE_ID - 资源id
     */
    public Integer getResourceId() {
        return resourceId;
    }

    /**
     * 设置资源id
     *
     * @param resourceId 资源id
     */
    public void setResourceId(Integer resourceId) {
        this.resourceId = resourceId;
    }

    @Override
    public Integer getPK() {
        return null;
    }
}