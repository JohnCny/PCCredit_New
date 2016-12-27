package com.cardpay.mgt.user.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Table(name = "T_USER_ORGANIZATION")
@ApiModel(value = "用户机构关联")
public class UserOrganization extends GenericEntity<Integer> {
    /**
     * 用户ID
     */
    @Column(name = "USER_ID")
    @ApiModelProperty(value = "用户ID", required = true)
    private Integer userId;

    /**
     * 机构ID
     */
    @Column(name = "ORGANIZATION_ID")
    @ApiModelProperty(value = "机构ID", required = true)
    private Integer organizationId;

    /**
     * @return USER_ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return ORGANIZATION_ID
     */
    public Integer getOrganizationId() {
        return organizationId;
    }

    /**
     * @param organizationId
     */
    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    @Override
    public Integer getPK() {
        return null;
    }
}