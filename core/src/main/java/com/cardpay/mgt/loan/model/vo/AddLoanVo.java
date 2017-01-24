package com.cardpay.mgt.loan.model.vo;

import java.math.BigDecimal;

/**
 * 新增贷后实体VO
 *
 * @author rankai
 *         createTime 2017-01-2017/1/22 15:48
 */
public class AddLoanVo {

    /**
     * 进件ID
     */
    private Integer id;

    /**
     * 客户名
     */
    private String customerName;
    /**
     * 产品名称
     */
    private String productName;
    /**
     * 客户身份证号码
     */
    private String customerCardId;

    /**
     * 申请金额
     */
    private BigDecimal applyAmount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCustomerCardId() {
        return customerCardId;
    }

    public void setCustomerCardId(String customerCardId) {
        this.customerCardId = customerCardId;
    }

    public BigDecimal getApplyAmount() {
        return applyAmount;
    }

    public void setApplyAmount(BigDecimal applyAmount) {
        this.applyAmount = applyAmount;
    }
}
