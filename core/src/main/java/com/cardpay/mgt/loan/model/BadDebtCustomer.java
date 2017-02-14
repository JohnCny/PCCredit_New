package com.cardpay.mgt.loan.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Table(name = "T_BAD_DEBT_CUSTOMER")
@ApiModel(value = "不良客户列表")
public class BadDebtCustomer {
    /**
     * 不良客户列表id
     */
    @Id
    @Column(name = "COLLECTION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select BAD_DEBT_CUSTOMER_SEQ.nextval from dual")
    @ApiModelProperty(value = "不良客户列表id", required = true)
    private Integer collectionId;

    /**
     * 不良客户id
     */
    @Column(name = "BAD_CUSTOMER_ID")
    @ApiModelProperty(value = "不良客户id", required = true)
    private Integer badCustomerId;

    /**
     * 不良客户证件号码
     */
    @Column(name = "BAD_CUSTOMER_CARD_NUM")
    @ApiModelProperty(value = "不良客户证件号码", required = true)
    private String badCustomerCardNum;


    /**
     * 逾期或者不良金额
     */
    @Column(name = "BAD_DEBT_AMOUNT")
    @ApiModelProperty(value = "逾期或者不良金额", required = true)
    private BigDecimal badDebtAmount;


    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    @ApiModelProperty(value = "创建时间", required = true)
    private Date createTime;

    /**
     * 进件id
     */
    @Column(name = "APPLICATION_ID")
    @ApiModelProperty(value = "进件id", required = true)
    private Integer applicationId;

    /**
     * 客户类型(0 个人用户 1 企业用户)
     */
    @Column(name = "CUATOMER_TYPE")
    private Integer cuatomerType;

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
     * 获取不良客户id
     *
     * @return BAD_CUSTOMER_ID - 不良客户id
     */
    public Integer getBadCustomerId() {
        return badCustomerId;
    }

    /**
     * 设置不良客户id
     *
     * @param badCustomerId 不良客户id
     */
    public void setBadCustomerId(Integer badCustomerId) {
        this.badCustomerId = badCustomerId;
    }

    /**
     * 获取不良客户证件号码
     *
     * @return BAD_CUSTOMER_CARD_NUM - 不良客户证件号码
     */
    public String getBadCustomerCardNum() {
        return badCustomerCardNum;
    }

    /**
     * 设置不良客户证件号码
     *
     * @param badCustomerCardNum 不良客户证件号码
     */
    public void setBadCustomerCardNum(String badCustomerCardNum) {
        this.badCustomerCardNum = badCustomerCardNum;
    }

    /**
     * 获取逾期或者不良金额
     *
     * @return BAD_DEBT_AMOUNT - 逾期或者不良金额
     */
    public BigDecimal getBadDebtAmount() {
        return badDebtAmount;
    }

    /**
     * 设置逾期或者不良金额
     *
     * @param badDebtAmount 逾期或者不良金额
     */
    public void setBadDebtAmount(BigDecimal badDebtAmount) {
        this.badDebtAmount = badDebtAmount;
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
     * 获取进件id
     *
     * @return APPLICATION_ID - 进件id
     */
    public Integer getApplicationId() {
        return applicationId;
    }

    /**
     * 设置进件id
     *
     * @param applicationId 进件id
     */
    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Integer getCuatomerType() {
        return cuatomerType;
    }

    public void setCuatomerType(Integer cuatomerType) {
        this.cuatomerType = cuatomerType;
    }
}