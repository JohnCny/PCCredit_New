package com.cardpay.mgt.customermanager.daily.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.persistence.*;

@Table(name = "T_CUSTOMER_MANAGER_DAY")
@ApiModel(value="客户经理日报数据管理")
public class TCustomerManagerDay {
    /**
     * 客户经理日报id
     */
    @Column(name = "ID")
    @ApiModelProperty(value="客户经理日报id",required = true)
    private Integer id;

    /**
     * 客户经理id
     */
    @Id
    @Column(name = "CUSTOMER_MANAGER_ID")
    @ApiModelProperty(value="客户经理id",required = true)
    private Integer customerManagerId;

    /**
     * 日报时间(yyyy-mm-dd)
     */
    @Column(name = "DAILY_TIME")
    @ApiModelProperty(value="日报时间(yyyy-mm-dd)",required = true)
    private Date dailyTime;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    @ApiModelProperty(value="创建时间",required = true)
    private Date createTime;

    /**
     * 拜访/新增客户数
     */
    @Column(name = "VISIT_NEW_NUMBER")
    @ApiModelProperty(value="拜访/新增客户数",required = true)
    private Integer visitNewNumber;

    /**
     * 客户维护数
     */
    @Column(name = "MAINTENANCE_NUMBER")
    @ApiModelProperty(value="客户维护数",required = true)
    private Integer maintenanceNumber;

    /**
     * 新申请贷款数
     */
    @Column(name = "LOAN_NEW_NUMBER")
    @ApiModelProperty(value="新申请贷款数",required = true)
    private Integer loanNewNumber;

    /**
     * 贷前调查数
     */
    @Column(name = "PRE_LOAN_NUMBER")
    @ApiModelProperty(value="贷前调查数",required = true)
    private Integer preLoanNumber;

    /**
     * 贷后调查数
     */
    @Column(name = "POST_LOAN_NUMBER")
    @ApiModelProperty(value="贷后调查数",required = true)
    private Integer postLoanNumber;

    /**
     * 获取客户经理日报id
     *
     * @return ID - 客户经理日报id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置客户经理日报id
     *
     * @param id 客户经理日报id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取客户经理id
     *
     * @return CUSTOMER_MANAGER_ID - 客户经理id
     */
    public Integer getCustomerManagerId() {
        return customerManagerId;
    }

    /**
     * 设置客户经理id
     *
     * @param customerManagerId 客户经理id
     */
    public void setCustomerManagerId(Integer customerManagerId) {
        this.customerManagerId = customerManagerId;
    }

    /**
     * 获取日报时间(yyyy-mm-dd)
     *
     * @return DAILY_TIME - 日报时间(yyyy-mm-dd)
     */
    public Date getDailyTime() {
        return dailyTime;
    }

    /**
     * 设置日报时间(yyyy-mm-dd)
     *
     * @param dailyTime 日报时间(yyyy-mm-dd)
     */
    public void setDailyTime(Date dailyTime) {
        this.dailyTime = dailyTime;
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
     * 获取拜访/新增客户数
     *
     * @return VISIT_NEW_NUMBER - 拜访/新增客户数
     */
    public Integer getVisitNewNumber() {
        return visitNewNumber;
    }

    /**
     * 设置拜访/新增客户数
     *
     * @param visitNewNumber 拜访/新增客户数
     */
    public void setVisitNewNumber(Integer visitNewNumber) {
        this.visitNewNumber = visitNewNumber;
    }

    /**
     * 获取客户维护数
     *
     * @return MAINTENANCE_NUMBER - 客户维护数
     */
    public Integer getMaintenanceNumber() {
        return maintenanceNumber;
    }

    /**
     * 设置客户维护数
     *
     * @param maintenanceNumber 客户维护数
     */
    public void setMaintenanceNumber(Integer maintenanceNumber) {
        this.maintenanceNumber = maintenanceNumber;
    }

    /**
     * 获取新申请贷款数
     *
     * @return LOAN_NEW_NUMBER - 新申请贷款数
     */
    public Integer getLoanNewNumber() {
        return loanNewNumber;
    }

    /**
     * 设置新申请贷款数
     *
     * @param loanNewNumber 新申请贷款数
     */
    public void setLoanNewNumber(Integer loanNewNumber) {
        this.loanNewNumber = loanNewNumber;
    }

    /**
     * 获取贷前调查数
     *
     * @return PRE_LOAN_NUMBER - 贷前调查数
     */
    public Integer getPreLoanNumber() {
        return preLoanNumber;
    }

    /**
     * 设置贷前调查数
     *
     * @param preLoanNumber 贷前调查数
     */
    public void setPreLoanNumber(Integer preLoanNumber) {
        this.preLoanNumber = preLoanNumber;
    }


    /**
     * 获取贷后调查数
     *
     * @return POST_LOAN_NUMBER - 贷前调查数
     */
    public Integer getPostLoanNumber() {
        return postLoanNumber;
    }

    /**
     * 设置贷后调查数
     *
     * @param postLoanNumber 贷后调查数
     */
    public void setPostLoanNumber(Integer postLoanNumber) {
        this.postLoanNumber = postLoanNumber;
    }
}