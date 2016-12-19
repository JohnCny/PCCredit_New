package com.cardpay.mgt.user.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

/**
 * 权限实体对象
 *
 * @author rankai
 */
@ApiModel("权限实体")
@Table(name = "T_AUTHORITY")
public class Authority extends GenericEntity<Integer> {
    /**
     * 权限id
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select AUTHORITY_SEQ.nextval from dual")
    @ApiModelProperty(value = "权限id", required = true)
    private Integer id;

    /**
     * 权限名称
     */
    @Column(name = "AUTHORITY_NAME")
    @ApiModelProperty(value = "权限名称", allowableValues = "")
    private String authorityName;

    /**
     * 权限描述信息
     */
    @Column(name = "AUTHORITY_DESCRIPTION")
    @ApiModelProperty(value = "权限描述信息", allowableValues = "")
    private String authorityDescription;

    /**
     * 状态描述
     */
    @Column(name = "AUTHORITY_STATUS")
    @ApiModelProperty(value = "状态描述", allowableValues = "")
    private Integer authorityStatus;

    /**
     * 权限中文名称
     */
    @Column(name = "AUTHORITY_NAME_ZH")
    @ApiModelProperty(value = "权限中文名称", allowableValues = "")
    private String authorityNameZh;

    /**
     * 获取权限id
     *
     * @return ID - 权限id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置权限id
     *
     * @param id 权限id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取权限名称
     *
     * @return AUTHORITY_NAME - 权限名称
     */
    public String getAuthorityName() {
        return authorityName;
    }

    /**
     * 设置权限名称
     *
     * @param authorityName 权限名称
     */
    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    /**
     * 获取权限描述信息
     *
     * @return AUTHORITY_DESCRIPTION - 权限描述信息
     */
    public String getAuthorityDescription() {
        return authorityDescription;
    }

    /**
     * 设置权限描述信息
     *
     * @param authorityDescription 权限描述信息
     */
    public void setAuthorityDescription(String authorityDescription) {
        this.authorityDescription = authorityDescription;
    }

    /**
     * 获取状态描述
     *
     * @return AUTHORITY_STATUS - 状态描述
     */
    public Integer getAuthorityStatus() {
        return authorityStatus;
    }

    /**
     * 设置状态描述
     *
     * @param authorityStatus 状态描述
     */
    public void setAuthorityStatus(Integer authorityStatus) {
        this.authorityStatus = authorityStatus;
    }

    /**
     * 获取权限中文名称
     *
     * @return AUTHORITY_NAME_ZH - 权限中文名称
     */
    public String getAuthorityNameZh() {
        return authorityNameZh;
    }

    /**
     * 设置权限中文名称
     *
     * @param authorityNameZh 权限中文名称
     */
    public void setAuthorityNameZh(String authorityNameZh) {
        this.authorityNameZh = authorityNameZh;
    }

    @Override
    public Integer getPK() {
        return this.id;
    }
}