package com.cardpay.mgt.loan.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import javax.persistence.*;

@Table(name = "T_POST_LOAN_MONITOR")
@ApiModel(value = "贷后监控")
public class PostLoanMonitor {
    /**
     * 贷后监控id
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select 你的序列名.nextval from dual")
    @ApiModelProperty(value = "贷后监控id", required = true)
    private BigDecimal id;

    /**
     * 贷后监控客户id
     */
    @Column(name = "CUSTOMER_ID")
    @ApiModelProperty(value = "贷后监控客户id", required = true)
    private Integer customerId;

    /**
     * 贷后监控客户名称
     */
    @Column(name = "CUSTOMER_NAME")
    @ApiModelProperty(value = "贷后监控客户名称", required = true)
    private String customerName;

    /**
     * 贷后监控客户证件号码
     */
    @Column(name = "CUSTOMER_CARD_NUM")
    @ApiModelProperty(value = "贷后监控客户证件号码", required = true)
    private String customerCardNum;

    /**
     * 产品名称
     */
    @Column(name = "PRODUCT_NAME")
    @ApiModelProperty(value = "产品名称", required = true)
    private String productName;

    /**
     * 申请额度
     */
    @Column(name = "APPLY_AMOUNT")
    @ApiModelProperty(value = "申请额度", required = true)
    private BigDecimal applyAmount;

    /**
     * 贷后监控方式
     */
    @Column(name = "T_POST_LOAN_MONITOR_TYPE")
    @ApiModelProperty(value = "贷后监控方式", required = true)
    private Short tPostLoanMonitorType;

    /**
     * 贷后监控任务状态
     */
    @Column(name = "TASK_STATUS")
    @ApiModelProperty(value = "贷后监控任务状态", required = true)
    private Short taskStatus;

    /**
     * 进件id
     */
    @Column(name = "APPLICATION_ID")
    @ApiModelProperty(value = "进件id", required = true)
    private Integer applicationId;

    /**
     * 产品名称
     */
    @Column(name = "PRODUCT_ID")
    @ApiModelProperty(value = "产品名称", required = true)
    private Integer productId;

    /**
     * 机构ID
     */
    @Column(name = "ORG_ID")
    private Integer orgId;

    /**
     * 其他
     */
    @Column(name = "OTHER")
    private String other;


    /**
     * 获取贷后监控id
     *
     * @return ID - 贷后监控id
     */
    public BigDecimal getId() {
        return id;
    }

    /**
     * 设置贷后监控id
     *
     * @param id 贷后监控id
     */
    public void setId(BigDecimal id) {
        this.id = id;
    }

    /**
     * 获取贷后监控客户id
     *
     * @return CUSTOMER_ID - 贷后监控客户id
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * 设置贷后监控客户id
     *
     * @param customerId 贷后监控客户id
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * 获取贷后监控客户名称
     *
     * @return CUSTOMER_NAME - 贷后监控客户名称
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * 设置贷后监控客户名称
     *
     * @param customerName 贷后监控客户名称
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * 获取贷后监控客户证件号码
     *
     * @return CUSTOMER_CARD_NUM - 贷后监控客户证件号码
     */
    public String getCustomerCardNum() {
        return customerCardNum;
    }

    /**
     * 设置贷后监控客户证件号码
     *
     * @param customerCardNum 贷后监控客户证件号码
     */
    public void setCustomerCardNum(String customerCardNum) {
        this.customerCardNum = customerCardNum;
    }

    /**
     * 获取产品名称
     *
     * @return PRODUCT_NAME - 产品名称
     */
    public String getProductName() {
        return productName;
    }

    /**
     * 设置产品名称
     *
     * @param productName 产品名称
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * 获取申请额度
     *
     * @return APPLY_AMOUNT - 申请额度
     */
    public BigDecimal getApplyAmount() {
        return applyAmount;
    }

    /**
     * 设置申请额度
     *
     * @param applyAmount 申请额度
     */
    public void setApplyAmount(BigDecimal applyAmount) {
        this.applyAmount = applyAmount;
    }

    /**
     * 获取贷后监控方式
     *
     * @return T_POST_LOAN_MONITOR_TYPE - 贷后监控方式
     */
    public Short gettPostLoanMonitorType() {
        return tPostLoanMonitorType;
    }

    /**
     * 设置贷后监控方式
     *
     * @param tPostLoanMonitorType 贷后监控方式
     */
    public void settPostLoanMonitorType(Short tPostLoanMonitorType) {
        this.tPostLoanMonitorType = tPostLoanMonitorType;
    }

    /**
     * 获取贷后监控任务状态
     *
     * @return TASK_STATUS - 贷后监控任务状态
     */
    public Short getTaskStatus() {
        return taskStatus;
    }

    /**
     * 设置贷后监控任务状态
     *
     * @param taskStatus 贷后监控任务状态
     */
    public void setTaskStatus(Short taskStatus) {
        this.taskStatus = taskStatus;
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

    /**
     * 获取产品名称
     *
     * @return PRODUCT_ID - 产品名称
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置产品名称
     *
     * @param productId 产品名称
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }
}