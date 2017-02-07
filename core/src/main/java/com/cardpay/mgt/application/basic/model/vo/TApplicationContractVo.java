package com.cardpay.mgt.application.basic.model.vo;


import com.cardpay.basic.base.model.GenericEntity;

/**
 * 客户签约信息Vo
 *
 * @author chenkai
 *         createTime 2017-02-2017/2/6 10:45
 */
public class TApplicationContractVo  extends GenericEntity<Integer>{

    /**
     * 进件id
     */
    private Integer applicationId;

    /**
     * 客户签约信息id
     */
    private Integer contractId;

    /**
     * 客户名称
     */
    private String customerCname;

    /**
     * 客户证件号码
     */
    private String customerCardNumber;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 申请金额
     */
    private Long applyAmount;

    /**
     * 进件状态(0 未完成，1 禁入，2 待审核，3 审核通过，4审核不通过)
     */
    private Integer applicationStatus;

    public Integer getContractId() {
        return contractId;
    }

    public void setContractId(Integer contractId) {
        this.contractId = contractId;
    }

    public String getCustomerCname() {
        return customerCname;
    }

    public void setCustomerCname(String customerCname) {
        this.customerCname = customerCname;
    }

    public String getCustomerCardNumber() {
        return customerCardNumber;
    }

    public void setCustomerCardNumber(String customerCardNumber) {
        this.customerCardNumber = customerCardNumber;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }


    public Integer getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(Integer applicationStatus) {
        this.applicationStatus = applicationStatus;
    }


    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public Long getApplyAmount() {
        return applyAmount;
    }

    public void setApplyAmount(Long applyAmount) {
        this.applyAmount = applyAmount;
    }

    @Override
    public Integer getPK() {
        return contractId;
    }
}
