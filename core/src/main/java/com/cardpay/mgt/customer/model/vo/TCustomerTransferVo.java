package com.cardpay.mgt.customer.model.vo;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;

/**
 * @author chenkai 2016/12/20 16:24
 */
public class TCustomerTransferVo extends GenericEntity<Integer> {

    /**
     * 客户id
     */
    @ApiModelProperty(value="客户id",required = true)
    private Integer customerId;

    /**
     * 证件号码
     */
    @ApiModelProperty(value="证件号码",required = true)
    private String certificateNumber;

    /**
     * 客户姓名
     */
    @ApiModelProperty(value="客户姓名",required = true)
    private String cname;

    /**
     * 移交原因
     */
    @ApiModelProperty(value="移交原因",required = true)
    private String transferReason;

    /**
     * 意见状态(0 带接收人确认  1 接收人确认  2 接收人拒绝)
     */
    @ApiModelProperty(value="意见状态(0 带接收人确认  1 接收人确认  2 接收人拒绝)",required = true)
    private Integer transferStatus;


    public Integer getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(Integer transferStatus) {
        this.transferStatus = transferStatus;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCertificateNumber() {
        return certificateNumber;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getTransferReason() {
        return transferReason;
    }

    public void setTransferReason(String transferReason) {
        this.transferReason = transferReason;
    }

    @Override
    public Integer getPK() {
        return null;
    }
}
