package com.cardpay.mgt.customermanager.basic.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.persistence.*;

/**
 * 客户经理信息实体类
 *
 * @author yanweichen
 */
@Table(name = "T_CUSTOMER_MANAGER")
@ApiModel(value="客户经理信息管理")
public class TCustomerManager extends GenericEntity<Integer> {

    /**
     * 客户经理id
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select CUSTOMER_MANAGER_SEQ.nextval from dual")
    @ApiModelProperty(value="客户经理id",required = true)
    private Integer id;

    /**
     * 客户经理级别id
     */
    @Column(name = "LEVEL_ID")
    @ApiModelProperty(value="客户经理级别id",required = true)
    private Integer levelId;

    /**
     * 客户经理所属机构
     */
    @Column(name = "ORGANIZATION_ID")
    @ApiModelProperty(value="客户经理所属机构",required = true)
    private Integer organizationId;

    /**
     * 客户经理用户id
     */
    @Column(name = "USER_ID")
    @ApiModelProperty(value="客户经理用户id",required = true)
    private Integer userId;

    /**
     * 客户经理状态
     */
    @Column(name = "STATUS")
    @ApiModelProperty(value="客户经理状态",required = true)
    private Integer status;

    /**
     * 获取客户经理状态
     *
     * @return ID - 客户经理状态
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置客户经理状态
     *
     * @param status 客户经理状态
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取客户经理id(需要生成规则生成)
     *
     * @return ID - 客户经理id(需要生成规则生成)
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置客户经理id(需要生成规则生成)
     *
     * @param id 客户经理id(需要生成规则生成)
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取客户经理级别id
     *
     * @return LEVEL_ID - 客户经理级别id
     */
    public Integer getLevelId() {
        return levelId;
    }

    /**
     * 设置客户经理级别id
     *
     * @param levelId 客户经理级别id
     */
    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    /**
     * 获取客户经理所属机构
     *
     * @return ORGANIZATION_ID - 客户经理所属机构
     */
    public Integer getOrganizationId() {
        return organizationId;
    }

    /**
     * 设置客户经理所属机构
     *
     * @param organizationId 客户经理所属机构
     */
    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    /**
     * 获取客户经理用户id
     *
     * @return USER_ID - 客户经理用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置客户经理用户id
     *
     * @param userId 客户经理用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public Integer getPK() {
        return id;
    }
}