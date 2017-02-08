package com.cardpay.mgt.riskblack.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.persistence.*;

@Table(name = "T_RISK_CUSTOMER")
@ApiModel(value = "风险客户名单管理")
public class RiskCustomer {
    /**
     * 不良客户列表id
     */
    @Id
    @Column(name = "COLLECTION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select RISK_CUSTOMER_SEQ.nextval from dual")
    @ApiModelProperty(value = "不良客户列表id", required = true)
    private Integer collectionId;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

    /**
     * 进入不良客户原因
     */
    @Column(name = "BAD_REASON")
    @ApiModelProperty(value = "进入不良客户原因", required = true)
    private String badReason;

    /**
     * 不良客户所属客户经理id
     */
    @Column(name = "CUSTOMER_MANAGER_ID")
    @ApiModelProperty(value = "不良客户所属客户经理id", required = true)
    private Integer customerManagerId;

    /**
     * 客户id
     */
    @Column(name = "CUSTOMER_ID")
    @ApiModelProperty(value = "客户id", required = true)
    private Integer customerId;

    /**
     * 客户类型(0 个人用户 1 企业用户)
     */
    @Column(name = "CUSTOMER_TYPE")
    @ApiModelProperty(value = "客户类型(0 个人用户 1 企业用户)", required = true)
    private Integer customerType;

    /**
     * 获取不良客户列表id
     *
     * @return COLLECTION_ID - 不良客户列表id
     */
    public Integer getCollectionId() {
        return collectionId;
    }

    /**
     * 设置不良客户列表id
     *
     * @param collectionId 不良客户列表id
     */
    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
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
     * 获取进入不良客户原因
     *
     * @return BAD_REASON - 进入不良客户原因
     */
    public String getBadReason() {
        return badReason;
    }

    /**
     * 设置进入不良客户原因
     *
     * @param badReason 进入不良客户原因
     */
    public void setBadReason(String badReason) {
        this.badReason = badReason;
    }

    /**
     * 获取不良客户所属客户经理id
     *
     * @return CUSTOMER_MANAGER_ID - 不良客户所属客户经理id
     */
    public Integer getCustomerManagerId() {
        return customerManagerId;
    }

    /**
     * 设置不良客户所属客户经理id
     *
     * @param customerManagerId 不良客户所属客户经理id
     */
    public void setCustomerManagerId(Integer customerManagerId) {
        this.customerManagerId = customerManagerId;
    }

    /**
     * 获取客户id
     *
     * @return CUSTOMER_ID - 客户id
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * 设置客户id
     *
     * @param customerId 客户id
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * 获取客户类型(0 个人用户 1 企业用户)
     *
     * @return CUSTOMER_TYPE - 客户类型(0 个人用户 1 企业用户)
     */
    public Integer getCustomerType() {
        return customerType;
    }

    /**
     * 设置客户类型(0 个人用户 1 企业用户)
     *
     * @param customerType 客户类型(0 个人用户 1 企业用户)
     */
    public void setCustomerType(Integer customerType) {
        this.customerType = customerType;
    }
}