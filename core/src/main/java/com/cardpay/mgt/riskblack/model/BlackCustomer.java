package com.cardpay.mgt.riskblack.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.persistence.*;

@Table(name = "T_BLACK_CUSTOMER")
@ApiModel(value = "黑名单客户管理")
public class BlackCustomer {
    /**
     * 黑名单客户列表id
     */
    @Id
    @Column(name = "BLACK_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select BLACK_CUSTOMER_SEQ.nextval from dual")
    @ApiModelProperty(value = "黑名单客户列表id", required = true)
    private Integer blackId;

    /**
     * 黑名单客户id
     */
    @Column(name = "T_BLACK_CUSTOMER_ID")
    @ApiModelProperty(value = "黑名单客户id", required = true)
    private Integer tBlackCustomerId;

    /**
     * 黑名单进入原因
     */
    @Column(name = "BLACK_REASON")
    @ApiModelProperty(value = "黑名单进入原因", required = true)
    private String blackReason;

    /**
     * 黑名单客户状态(0 正常 1 转出审核中)
     */
    @Column(name = "T_BLACK_CUSTOMER_STATUS")
    @ApiModelProperty(value = "黑名单客户状态(0 正常 1 转出审核中)", required = true)
    private Integer tBlackCustomerStatus;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

    /**
     * 操作人
     */
    @Column(name = "CREATE_BY")
    @ApiModelProperty(value = "操作人", required = true)
    private Integer createBy;

    /**
     * 黑名单客户所属客户经理id
     */
    @Column(name = "CUSTOMER_MANAGER_ID")
    @ApiModelProperty(value = "黑名单客户所属客户经理id", required = true)
    private Integer customerManagerId;


    /**
     * 获取黑名单客户列表id
     *
     * @return BLACK_ID - 黑名单客户列表id
     */
    public Integer getBlackId() {
        return blackId;
    }

    /**
     * 设置黑名单客户列表id
     *
     * @param blackId 黑名单客户列表id
     */
    public void setBlackId(Integer blackId) {
        this.blackId = blackId;
    }

    /**
     * 获取黑名单客户id
     *
     * @return T_BLACK_CUSTOMER_ID - 黑名单客户id
     */
    public Integer gettBlackCustomerId() {
        return tBlackCustomerId;
    }

    /**
     * 设置黑名单客户id
     *
     * @param tBlackCustomerId 黑名单客户id
     */
    public void settBlackCustomerId(Integer tBlackCustomerId) {
        this.tBlackCustomerId = tBlackCustomerId;
    }

    /**
     * 获取黑名单进入原因
     *
     * @return BLACK_REASON - 黑名单进入原因
     */
    public String getBlackReason() {
        return blackReason;
    }

    /**
     * 设置黑名单进入原因
     *
     * @param blackReason 黑名单进入原因
     */
    public void setBlackReason(String blackReason) {
        this.blackReason = blackReason;
    }

    /**
     * 获取黑名单客户状态(0 正常 1 转出审核中)
     *
     * @return T_BLACK_CUSTOMER_STATUS - 黑名单客户状态(0 正常 1 转出审核中)
     */
    public Integer gettBlackCustomerStatus() {
        return tBlackCustomerStatus;
    }

    /**
     * 设置黑名单客户状态(0 正常 1 转出审核中)
     *
     * @param tBlackCustomerStatus 黑名单客户状态(0 正常 1 转出审核中)
     */
    public void settBlackCustomerStatus(Integer tBlackCustomerStatus) {
        this.tBlackCustomerStatus = tBlackCustomerStatus;
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
     * 获取操作人
     *
     * @return CREATE_BY - 操作人
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * 设置操作人
     *
     * @param createBy 操作人
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取黑名单客户所属客户经理id
     *
     * @return CUSTOMER_MANAGER_ID - 黑名单客户所属客户经理id
     */
    public Integer getCustomerManagerId() {
        return customerManagerId;
    }

    /**
     * 设置黑名单客户所属客户经理id
     *
     * @param customerManagerId 黑名单客户所属客户经理id
     */
    public void setCustomerManagerId(Integer customerManagerId) {
        this.customerManagerId = customerManagerId;
    }
}