package com.cardpay.mgt.customermanager.model.po;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.persistence.*;

@Table(name = "T_CUSTOMER_MANAGER")
@ApiModel(value="客户经理信息管理")
public class TCustomerManager extends GenericEntity<Long> {
    /**
     * 客户经理id(需要生成规则生成)
     */
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select CUSTOMER_MANAGER_SEQ.nextval from dual")
    @ApiModelProperty(value="客户经理id(需要生成规则生成)",required = true)
    private Long id;

    /**
     * 用户id
     */
    @Column(name = "T_U_ID")
    @ApiModelProperty(value="用户id",required = true)
    private Integer tUId;

    /**
     * id
     */
    @Column(name = "T_O_ID")
    @ApiModelProperty(value="id",required = true)
    private Integer tOId;

    /**
     * 客户经理姓名
     */
    @Column(name = "CNAME")
    @ApiModelProperty(value="客户经理姓名",required = true)
    private String cname;

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
    public Long getId() {
        return id;
    }

    /**
     * 设置客户经理id(需要生成规则生成)
     *
     * @param id 客户经理id(需要生成规则生成)
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return T_U_ID - 用户id
     */
    public Integer gettUId() {
        return tUId;
    }

    /**
     * 设置用户id
     *
     * @param tUId 用户id
     */
    public void settUId(Integer tUId) {
        this.tUId = tUId;
    }

    /**
     * 获取id
     *
     * @return T_O_ID - id
     */
    public Integer gettOId() {
        return tOId;
    }

    /**
     * 设置id
     *
     * @param tOId id
     */
    public void settOId(Integer tOId) {
        this.tOId = tOId;
    }

    /**
     * 获取客户经理姓名
     *
     * @return CNAME - 客户经理姓名
     */
    public String getCname() {
        return cname;
    }

    /**
     * 设置客户经理姓名
     *
     * @param cname 客户经理姓名
     */
    public void setCname(String cname) {
        this.cname = cname;
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
    public Long getPK() {
        return id;
    }
}