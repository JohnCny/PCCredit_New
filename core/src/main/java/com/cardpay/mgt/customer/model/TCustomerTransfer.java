package com.cardpay.mgt.customer.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.context.annotation.Lazy;

import java.util.Date;
import javax.persistence.*;

/**
 * 客户移交信息实体类
 * @author yanweichen
 */
@Lazy
@Table(name = "T_CUSTOMER_TRANSFER")
@ApiModel(value="客户移交记录")
public class TCustomerTransfer extends GenericEntity<Integer>{
    /**
     * 客户id
     */
    @Id
    @Column(name = "ID")
    @ApiModelProperty(value="客户id(需要生成规则生成)",required = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select CUSTOMER_TRANSFER_SEQ.nextval from dual")
    private Integer id;

    /**
     * 原有客户经理id
     */
    @Column(name = "ORIGIN_CUSTOMER_MANAGER")
    @ApiModelProperty(value="原有客户经理id",required = true)
    private Integer originCustomerManager;

    /**
     * 现有客户经理id
     */
    @Column(name = "NOW_CUSTOMER_MANAGER")
    @ApiModelProperty(value="现有客户经理id",required = true)
    private Integer nowCustomerManager;

    /**
     * 移交原因
     */
    @Column(name = "TRANSFER_REASON")
    @ApiModelProperty(value="移交原因",required = true)
    private String transferReason;

    /**
     * 意见状态(0 带接收人确认  1 接收人确认  2 接收人拒绝)
     */
    @Column(name = "TRANSFER_STATUS")
    @ApiModelProperty(value="意见状态(0 带接收人确认  1 接收人确认  2 接收人拒绝)",required = true)
    private Integer transferStatus;

    /**
     * 移交时间
     */
    @Column(name = "TRANSFER_TIME")
    @ApiModelProperty(value="移交时间",required = true)
    private Date transferTime;
    /**
     * 客户类型
     */
    @Column(name = "CUSTOMER_TYPE")
    private Integer customerType;
    /**
     * 客户id
     */
    @Column(name = "CUSTOMER_ID")
    private int customerId;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public Integer getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Integer customerType) {
        this.customerType = customerType;
    }

    /**
     * 获取id
     *
     * @return ID - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }


    /**
     * 获取原有客户经理id
     *
     * @return ORIGIN_CUSTOMER_MANAGER - 原有客户经理id
     */
    public Integer getOriginCustomerManager() {
        return originCustomerManager;
    }

    /**
     * 设置原有客户经理id
     *
     * @param originCustomerManager 原有客户经理id
     */
    public void setOriginCustomerManager(Integer originCustomerManager) {
        this.originCustomerManager = originCustomerManager;
    }

    /**
     * 获取现有客户经理id
     *
     * @return NOW_CUSTOMER_MANAGER - 现有客户经理id
     */
    public Integer getNowCustomerManager() {
        return nowCustomerManager;
    }

    /**
     * 设置现有客户经理id
     *
     * @param nowCustomerManager 现有客户经理id
     */
    public void setNowCustomerManager(Integer nowCustomerManager) {
        this.nowCustomerManager = nowCustomerManager;
    }

    /**
     * 获取移交原因
     *
     * @return TRANSFER_REASON - 移交原因
     */
    public String getTransferReason() {
        return transferReason;
    }

    /**
     * 设置移交原因
     *
     * @param transferReason 移交原因
     */
    public void setTransferReason(String transferReason) {
        this.transferReason = transferReason;
    }

    /**
     * 获取意见状态(0 带接收人确认  1 接收人确认  2 接收人拒绝)
     *
     * @return TRANSFER_STATUS - 意见状态(0 带接收人确认  1 接收人确认  2 接收人拒绝)
     */
    public Integer getTransferStatus() {
        return transferStatus;
    }

    /**
     * 设置意见状态(0 带接收人确认  1 接收人确认  2 接收人拒绝)
     *
     * @param transferStatus 意见状态(0 带接收人确认  1 接收人确认  2 接收人拒绝)
     */
    public void setTransferStatus(Integer transferStatus) {
        this.transferStatus = transferStatus;
    }

    /**
     * 获取移交时间
     *
     * @return TRANSFER_TIME - 移交时间
     */
    public Date getTransferTime() {
        return transferTime;
    }

    /**
     * 设置移交时间
     *
     * @param transferTime 移交时间
     */
    public void setTransferTime(Date transferTime) {
        this.transferTime = transferTime;
    }

    @Override
    public Integer getPK() {
        return id;
    }
}