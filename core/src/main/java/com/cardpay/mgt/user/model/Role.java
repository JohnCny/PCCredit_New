package com.cardpay.mgt.user.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.persistence.*;

/**
 * 角色实体
 *
 * @author rankai
 */
@Table(name = "T_ROLE")
@ApiModel(value = "角色实体")
public class Role {
    /**
     * 角色id
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select ROLE_SEQ.nextval from dual")
    @ApiModelProperty(value = "角色id", required = true)
    private Integer id;

    /**
     * 角色名称
     */
    @Column(name = "ROLE_NAME")
    @ApiModelProperty(value = "角色名称", allowableValues = "")
    private String roleName;

    /**
     * 角色描述
     */
    @Column(name = "ROLE_DESCRIPTION")
    @ApiModelProperty(value = "角色描述", allowableValues = "")
    private String roleDescription;

    /**
     * 角色状态(0 正常，1 停用)
     */
    @Column(name = "ROLE_STATUS")
    @ApiModelProperty(value = "角色状态", allowableValues = "", notes = "(0 正常，1 停用)")
    private Integer roleStatus;

    /**
     * 角色中文名称
     */
    @Column(name = "ROLE_NAME_ZH")
    @ApiModelProperty(value = "角色中文名称", allowableValues = "")
    private String roleNameZh;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    @ApiModelProperty(value = "创建时间", allowableValues = "")
    private Date createTime;

    /**
     * 修改时间
     */
    @Column(name = "CREATE_BY")
    @ApiModelProperty(value = "修改时间", allowableValues = "")
    private Integer createBy;

    /**
     * 获取id
     *
     * @return ID - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取角色名称
     *
     * @return ROLE_NAME - 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    /**
     * 获取角色描述
     *
     * @return ROLE_DESCRIPTION - 角色描述
     */
    public String getRoleDescription() {
        return roleDescription;
    }

    /**
     * 设置角色描述
     *
     * @param roleDescription 角色描述
     */
    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    /**
     * 获取角色状态(0 正常，1 停用)
     *
     * @return ROLE_STATUS - 角色状态(0 正常，1 停用)
     */
    public Integer getRoleStatus() {
        return roleStatus;
    }

    /**
     * 设置角色状态(0 正常，1 停用)
     *
     * @param roleStatus 角色状态(0 正常，1 停用)
     */
    public void setRoleStatus(Integer roleStatus) {
        this.roleStatus = roleStatus;
    }

    /**
     * 获取角色中文名称
     *
     * @return ROLE_NAME_ZH - 角色中文名称
     */
    public String getRoleNameZh() {
        return roleNameZh;
    }

    /**
     * 设置角色中文名称
     *
     * @param roleNameZh 角色中文名称
     */
    public void setRoleNameZh(String roleNameZh) {
        this.roleNameZh = roleNameZh;
    }

    /**
     * 获取创建时间
     *
     * @return CREATE_TIME - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取修改时间
     *
     * @return CREATE_BY - 修改时间
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * 设置修改时间
     *
     * @param createBy 修改时间
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }


    public static final class RoleBuilder {
        private Integer id;
        private String roleName;
        private String roleDescription;
        private Integer roleStatus;
        private String roleNameZh;
        private Date createTime;
        private Integer createBy;

        private RoleBuilder() {
        }

        public static RoleBuilder get() {
            return new RoleBuilder();
        }

        public RoleBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public RoleBuilder withRoleName(String roleName) {
            this.roleName = roleName;
            return this;
        }

        public RoleBuilder withRoleDescription(String roleDescription) {
            this.roleDescription = roleDescription;
            return this;
        }

        public RoleBuilder withRoleStatus(Integer roleStatus) {
            this.roleStatus = roleStatus;
            return this;
        }

        public RoleBuilder withRoleNameZh(String roleNameZh) {
            this.roleNameZh = roleNameZh;
            return this;
        }

        public RoleBuilder withCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public RoleBuilder withCreateBy(Integer createBy) {
            this.createBy = createBy;
            return this;
        }

        public Role build() {
            Role role = new Role();
            role.setId(id);
            role.setRoleName(roleName);
            role.setRoleDescription(roleDescription);
            role.setRoleStatus(roleStatus);
            role.setRoleNameZh(roleNameZh);
            role.setCreateTime(createTime);
            role.setCreateBy(createBy);
            return role;
        }
    }
}