package com.cardpay.mgt.customermanager.basic.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.persistence.*;

/**
 * 客户经理信息实体类
 * @author yanweichen
 */
@Table(name = "T_CUSTOMER_MANAGER")
@ApiModel(value="客户经理信息管理")
public class TCustomerManager extends GenericEntity<Integer> {

    /**
     * 客户经理id(需要生成规则生成)
     */
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select CUSTOMER_MANAGER_SEQ.nextval from dual")
    @ApiModelProperty(value="客户经理id(需要生成规则生成)",required = true)
    private Integer id;

    /**
     * 客户经理姓名
     */
    @Column(name = "C_NAME")
    @ApiModelProperty(value="客户经理姓名",required = true)
    private String cName;

    /**
     * 客户经理级别id
     */
    @Column(name = "LEVEL_ID")
    @ApiModelProperty(value="客户经理级别id",required = true)
    private Integer levelId;

    /**
     * 客户经理身份证号
     */
    @Column(name = "CARD_NUMBER")
    @ApiModelProperty(value="客户经理身份证号",required = true)
    private String cardNumber;

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
     * 创建人id
     */
    @Column(name = "CREATE_BY")
    @ApiModelProperty(value="创建人id",required = true)
    private Integer createBy;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    @ApiModelProperty(value="创建时间",required = true)
    private Date createTime;

    /**
     * 修改人id
     */
    @Column(name = "MODIFY_BY")
    @ApiModelProperty(value="修改人id",required = true)
    private Integer modifyBy;

    /**
     * 修改时间
     */
    @Column(name = "MODIFY_TIME")
    @ApiModelProperty(value="修改时间",required = true)
    private Date modifyTime;

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
     * 获取客户经理姓名
     *
     * @return CNAME - 客户经理姓名
     */
    public String getcName() {
        return cName;
    }

    /**
     * 设置客户经理姓名
     *
     * @param cName 客户经理姓名
     */
    public void setcName(String cName) {
        this.cName = cName;
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
     * 获取客户经理身份证号
     *
     * @return CARD_NUMBER - 客户经理身份证号
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * 设置客户经理身份证号
     *
     * @param cardNumber 客户经理身份证号
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
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

    /**
     * 获取创建人id
     *
     * @return CREATE_BY - 创建人id
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人id
     *
     * @param createBy 创建人id
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
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
     * 获取修改人id
     *
     * @return MODIFY_BY - 修改人id
     */
    public Integer getModifyBy() {
        return modifyBy;
    }

    /**
     * 设置修改人id
     *
     * @param modifyBy 修改人id
     */
    public void setModifyBy(Integer modifyBy) {
        this.modifyBy = modifyBy;
    }

    /**
     * 获取修改时间
     *
     * @return MODIFY_TIME - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public Integer getPK() {
        return id;
    }
}