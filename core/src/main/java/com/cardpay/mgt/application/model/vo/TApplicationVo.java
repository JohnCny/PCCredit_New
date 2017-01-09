package com.cardpay.mgt.application.model.vo;

import com.cardpay.basic.base.model.GenericEntity;
import com.cardpay.mgt.customer.model.TCustomerBasic;
import com.cardpay.mgt.product.model.Product;

import java.math.BigDecimal;

/**
 * 进件Vo类
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/5 17:11
 */
public class TApplicationVo extends GenericEntity<Integer> {
    /**
     * 进件id
     */
    private Integer id;

    /**
     * 客户id
     */
    private Integer customerId;

    /**
     * 产品id
     */
    private Integer productId;


    /**
     * 进件申请金额
     */
    private BigDecimal applyAmount;

    /**
     * 进件状态(0 未完成，1 禁入，2 待审核，3 审核通过，4审核不通过)
     */
    private Short applicationStatus;

    /**
     * 进件申请原因
     */
    private String applyReason;

    /**
     * 进件审批金额
     */
    private BigDecimal approveAmount;

    /**
     * 客户经理id
     */
    private Integer customerManagerId;

    /**
     * 产品信息
     */
    private Product product;

    /**
     * 客户信息
     */
    private TCustomerBasic customer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCustomerManagerId() {
        return customerManagerId;
    }

    public void setCustomerManagerId(Integer customerManagerId) {
        this.customerManagerId = customerManagerId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public TCustomerBasic getCustomer() {
        return customer;
    }

    public void setCustomer(TCustomerBasic customer) {
        this.customer = customer;
    }

    public BigDecimal getApplyAmount() {
        return applyAmount;
    }

    public void setApplyAmount(BigDecimal applyAmount) {
        this.applyAmount = applyAmount;
    }

    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    public BigDecimal getApproveAmount() {
        return approveAmount;
    }

    public void setApproveAmount(BigDecimal approveAmount) {
        this.approveAmount = approveAmount;
    }

    public Short getApplicationStatus() {
        return applicationStatus;
    }

    public void setApplicationStatus(Short applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    @Override
    public Integer getPK() {
        return id;
    }
}
