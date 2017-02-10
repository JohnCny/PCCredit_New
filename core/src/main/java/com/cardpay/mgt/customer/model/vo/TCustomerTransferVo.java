package com.cardpay.mgt.customer.model.vo;

import com.cardpay.basic.base.model.GenericEntity;
import com.cardpay.mgt.customer.model.TCustomerBasic;
import com.cardpay.mgt.user.model.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.context.annotation.Lazy;

import javax.persistence.Column;
import java.util.Date;

/**
 * 客户移交Vo
 * @author chenkai 2016/12/22 10:24
 */
@Lazy
@ApiModel(value = "客户移交Vo")
public class TCustomerTransferVo extends GenericEntity<String> {
    /**
     * 客户id
     */
    @ApiModelProperty(value = "客户id", required = true)
    private String id;
    /**
     * 客户名称
     */
    @ApiModelProperty(value = "客户名称", required = true)
    private String name;

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

    /**
     * 客户信息
     */
    private TCustomerBasic customer;

    /**
     * 移交时间
     */
    @ApiModelProperty(value="移交时间",required = true)
    private Date transferTime;

    /**
     * 原有客户经理id
     */
    @ApiModelProperty(value="原有客户经理id",required = true)
    private Integer originCustomerManager;

    /**
     * 现有客户经理id
     */
    @ApiModelProperty(value="现有客户经理id",required = true)
    private Integer nowCustomerManager;

    /**
     * 原客户经理信息
     */
    private User oldManager;

    /**
     * 移交后客户经理信息
     */
    private User newManager;

    public TCustomerBasic getCustomer() {
        return customer;
    }

    public void setCustomer(TCustomerBasic customer) {
        this.customer = customer;
    }

    public String getTransferReason() {
        return transferReason;
    }

    public void setTransferReason(String transferReason) {
        this.transferReason = transferReason;
    }

    public Integer getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(Integer transferStatus) {
        this.transferStatus = transferStatus;
    }

    public Date getTransferTime() {
        return transferTime;
    }

    public void setTransferTime(Date transferTime) {
        this.transferTime = transferTime;
    }

    public Integer getOriginCustomerManager() {
        return originCustomerManager;
    }

    public void setOriginCustomerManager(Integer originCustomerManager) {
        this.originCustomerManager = originCustomerManager;
    }

    public Integer getNowCustomerManager() {
        return nowCustomerManager;
    }

    public void setNowCustomerManager(Integer nowCustomerManager) {
        this.nowCustomerManager = nowCustomerManager;
    }

    public User getOldManager() {
        return oldManager;
    }

    public void setOldManager(User oldManager) {
        this.oldManager = oldManager;
    }

    public User getNewManager() {
        return newManager;
    }

    public void setNewManager(User newManager) {
        this.newManager = newManager;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getPK() {
        return id;
    }
}
