package com.cardpay.mgt.application.basic.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "T_APPLICATION_CONTRACT")
@ApiModel(value="客户签约信息")
public class TApplicationContract extends GenericEntity<Integer>{
    /**
     * 客户签约信息id
     */
    @Id
    @Column(name = "CONTRACT_ID")
    @ApiModelProperty(value="客户签约信息id",required = true)
    private Integer contractId;

    /**
     * 客户名称
     */
    @Column(name = "CUSTOMER_CNAME")
    @ApiModelProperty(value="客户名称",required = true)
    private String customerCname;

    /**
     * 客户证件号码
     */
    @Column(name = "CUSTOMER_CARD_NUMBER")
    @ApiModelProperty(value="客户证件号码",required = true)
    private String customerCardNumber;

    /**
     * 产品名称
     */
    @Column(name = "PRODUCT_NAME")
    @ApiModelProperty(value="产品名称",required = true)
    private String productName;

    /**
     * 审批金额
     */
    @Column(name = "APPROVE_AMOUNT")
    @ApiModelProperty(value="审批金额",required = true)
    private Long approveAmount;

    /**
     * 审批利率
     */
    @Column(name = "APPROVE_RATE")
    @ApiModelProperty(value="审批利率",required = true)
    private BigDecimal approveRate;

    /**
     * 贷款开始时间
     */
    @Column(name = "LOAN_START_TIME")
    @ApiModelProperty(value="贷款开始时间",required = true)
    private Date loanStartTime;

    /**
     * 贷款结束时间
     */
    @Column(name = "LOAN_END_TIME")
    @ApiModelProperty(value="贷款结束时间",required = true)
    private Date loanEndTime;

    /**
     * 合同编号
     */
    @Column(name = "CONTRACT_NUMBER")
    @ApiModelProperty(value="合同编号",required = true)
    private String contractNumber;

    /**
     * 放款账号
     */
    @Column(name = "LOAN_ACCOUNT")
    @ApiModelProperty(value="放款账号",required = true)
    private String loanAccount;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    @ApiModelProperty(value="创建时间",required = true)
    private Date createTime;

    /**
     * 创建人
     */
    @Column(name = "CREATE_BY")
    @ApiModelProperty(value="创建人",required = true)
    private Integer createBy;

    /**
     * 进件id
     */
    @Column(name = "APPLICATION_ID")
    @ApiModelProperty(value="进件id",required = true)
    private Integer applicationId;

    /**
     * 获取客户签约信息id
     *
     * @return CONTRACT_ID - 客户签约信息id
     */
    public Integer getContractId() {
        return contractId;
    }

    /**
     * 设置客户签约信息id
     *
     * @param contractId 客户签约信息id
     */
    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    /**
     * 获取客户名称
     *
     * @return CUSTOMER_CNAME - 客户名称
     */
    public String getCustomerCname() {
        return customerCname;
    }

    /**
     * 设置客户名称
     *
     * @param customerCname 客户名称
     */
    public void setCustomerCname(String customerCname) {
        this.customerCname = customerCname;
    }

    /**
     * 获取客户证件号码
     *
     * @return CUSTOMER_CARD_NUMBER - 客户证件号码
     */
    public String getCustomerCardNumber() {
        return customerCardNumber;
    }

    /**
     * 设置客户证件号码
     *
     * @param customerCardNumber 客户证件号码
     */
    public void setCustomerCardNumber(String customerCardNumber) {
        this.customerCardNumber = customerCardNumber;
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
     * 获取审批金额
     *
     * @return APPROVE_AMOUNT - 审批金额
     */
    public Long getApproveAmount() {
        return approveAmount;
    }

    /**
     * 设置审批金额
     *
     * @param approveAmount 审批金额
     */
    public void setApproveAmount(Long approveAmount) {
        this.approveAmount = approveAmount;
    }

    /**
     * 获取审批利率
     *
     * @return APPROVE_RATE - 审批利率
     */
    public BigDecimal getApproveRate() {
        return approveRate;
    }

    /**
     * 设置审批利率
     *
     * @param approveRate 审批利率
     */
    public void setApproveRate(BigDecimal approveRate) {
        this.approveRate = approveRate;
    }

    /**
     * 获取贷款开始时间
     *
     * @return LOAN_START_TIME - 贷款开始时间
     */
    public Date getLoanStartTime() {
        return loanStartTime;
    }

    /**
     * 设置贷款开始时间
     *
     * @param loanStartTime 贷款开始时间
     */
    public void setLoanStartTime(Date loanStartTime) {
        this.loanStartTime = loanStartTime;
    }

    /**
     * 获取贷款结束时间
     *
     * @return LOAN_END_TIME - 贷款结束时间
     */
    public Date getLoanEndTime() {
        return loanEndTime;
    }

    /**
     * 设置贷款结束时间
     *
     * @param loanEndTime 贷款结束时间
     */
    public void setLoanEndTime(Date loanEndTime) {
        this.loanEndTime = loanEndTime;
    }

    /**
     * 获取合同编号
     *
     * @return CONTRACT_NUMBER - 合同编号
     */
    public String getContractNumber() {
        return contractNumber;
    }

    /**
     * 设置合同编号
     *
     * @param contractNumber 合同编号
     */
    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    /**
     * 获取放款账号
     *
     * @return LOAN_ACCOUNT - 放款账号
     */
    public String getLoanAccount() {
        return loanAccount;
    }

    /**
     * 设置放款账号
     *
     * @param loanAccount 放款账号
     */
    public void setLoanAccount(String loanAccount) {
        this.loanAccount = loanAccount;
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
     * 获取创建人
     *
     * @return CREATE_BY - 创建人
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人
     *
     * @param createBy 创建人
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
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

    @Override
    public Integer getPK() {
        return contractId;
    }
}