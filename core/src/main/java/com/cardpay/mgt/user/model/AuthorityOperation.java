package com.cardpay.mgt.user.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.models.auth.In;

import javax.persistence.*;

/**
 * 权限资源操作关系实体
 *
 * @author rankai
 */
@Table(name = "T_AUTHORITY_OPERATION")
@ApiModel(value = "权限于资源操作关系的实体")
public class AuthorityOperation extends GenericEntity<Integer> {

    /**
     * 权限id
     */
    @Column(name = "AUTHORITY_ID")
    @ApiModelProperty(value = "权限id")
    private Integer authorityId;

    /**
     * 操作id
     */
    @Column(name = "OPERATION_ID")
    @ApiModelProperty(value = "操作id")
    private Integer operationId;

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
     * 获取操作id
     *
     * @return OPERATION_ID - 操作id
     */
    public Integer getOperationId() {
        return operationId;
    }

    /**
     * 设置操作id
     *
     * @param operationId 操作id
     */
    public void setOperationId(Integer operationId) {
        this.operationId = operationId;
    }

    @Override
    public Integer getPK() {
        return null;
    }
}