package com.cardpay.mgt.user.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * 用户角色关系实体
 *
 * @author rankai
 */
@Table(name = "T_USER_ROLE")
@ApiModel(value = "用户角色关系实体类")
public class UserRole extends GenericEntity<Integer> {
    /**
     * 角色id
     */
    @Column(name = "ROLE_ID")
    @ApiModelProperty(value = "角色id")
    private Integer roleId;

    /**
     * 用户id
     */
    @Column(name = "USER_ID")
    @ApiModelProperty(value = "用户id")
    private Integer userId;

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
     * 获取用户id
     *
     * @return USER_ID - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public Integer getPK() {
        return null;
    }
}