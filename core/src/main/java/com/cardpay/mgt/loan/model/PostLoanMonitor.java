package com.cardpay.mgt.loan.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;

@Table(name = "T_POST_LOAN_MONITOR")
@ApiModel(value = "贷后监控")
public class PostLoanMonitor {
    /**
     * 贷后监控id
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select POST_LOAN_MONITOR_SEQ.nextval from dual")
    @ApiModelProperty(value = "贷后监控id", required = true)
    private Integer id;


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
     * 其他
     */
    @Column(name = "OTHER")
    private String other;

    /**
     * 客户类型(0:个人1:企业)
     */
    @Column(name = "CUSTOMER_TYPE")
    private Integer customerType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Short gettPostLoanMonitorType() {
        return tPostLoanMonitorType;
    }

    public void settPostLoanMonitorType(Short tPostLoanMonitorType) {
        this.tPostLoanMonitorType = tPostLoanMonitorType;
    }

    public Short getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Short taskStatus) {
        this.taskStatus = taskStatus;
    }

    public Integer getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public Integer getCustomerType() {
        return customerType;
    }

    public void setCustomerType(Integer customerType) {
        this.customerType = customerType;
    }
}