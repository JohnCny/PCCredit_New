package com.cardpay.mgt.user.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Table(name = "T_AUTHORITY_OPERATION")
@ApiModel(value = "权限于资源操作关系的实体")
public class AuthorityOperation extends GenericEntity<Integer> {

    /**
     * 权限id
     */
    @Column(name = "AUTHORITY_ID")
    @ApiModelProperty(value = "权限id")
    private Short authorityId;

    /**
     * 操作id
     */
    @Column(name = "OPERATION_ID")
    @ApiModelProperty(value = "操作id")
    private Short operationId;

    /**
     * 获取权限id
     *
     * @return AUTHORITY_ID - 权限id
     */
    public Short getAuthorityId() {
        return authorityId;
    }

    /**
     * 设置权限id
     *
     * @param authorityId 权限id
     */
    public void setAuthorityId(Short authorityId) {
        this.authorityId = authorityId;
    }

    /**
     * 获取操作id
     *
     * @return OPERATION_ID - 操作id
     */
    public Short getOperationId() {
        return operationId;
    }

    /**
     * 设置操作id
     *
     * @param operationId 操作id
     */
    public void setOperationId(Short operationId) {
        this.operationId = operationId;
    }

    @Override
    public Integer getPK() {
        return null;
    }
}