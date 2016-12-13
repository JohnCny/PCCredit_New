package com.cardpay.mgt.customer.customermanagerday.model.po;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.persistence.*;

@Table(name = "T_CUSTOMER_MANAGER_DAY")
@ApiModel(value="客户经理日报数据管理")
public class TCustomerManagerDay extends GenericEntity<Integer> {
    /**
     * 客户经理id(需要生成规则生成)
     */
    @Column(name = "CUS_ID")
    @ApiModelProperty(value="客户经理id(需要生成规则生成)",required = true)
    private Long cusId;

    /**
     * 客户经理日报id
     */
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select CUSTOMER_MANAGER_DAY_SEQ.nextval from dual")
    @ApiModelProperty(value="客户经理日报id",required = true)
    private Integer id;

    /**
     * 客户经理id
     */
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
     * 新增或者拜访客户数
     */
    @Column(name = "CREATE_TIME")
    @ApiModelProperty(value="新增或者拜访客户数",required = true)
    private Date createTime;

    /**
     * 客户维护数
     */
    @Column(name = "VISIT_NEW_NUMBER")
    @ApiModelProperty(value="客户维护数",required = true)
    private Integer visitNewNumber;

    /**
     * 新申请贷款数
     */
    @Column(name = "MAINTENANCE_NUMBER")
    @ApiModelProperty(value="新申请贷款数",required = true)
    private Integer maintenanceNumber;

    /**
     * 贷前调查书
     */
    @Column(name = "LOAN_NEW_NUMBER")
    @ApiModelProperty(value="贷前调查书",required = true)
    private Integer loanNewNumber;

    @Column(name = "PRELOAN_NUMBER")
    @ApiModelProperty(value="null",required = true)
    private Integer preloanNumber;

    /**
     * 获取客户经理id(需要生成规则生成)
     *
     * @return CUS_ID - 客户经理id(需要生成规则生成)
     */
    public Long getCusId() {
        return cusId;
    }

    /**
     * 设置客户经理id(需要生成规则生成)
     *
     * @param cusId 客户经理id(需要生成规则生成)
     */
    public void setCusId(Long cusId) {
        this.cusId = cusId;
    }

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
     * 获取新增或者拜访客户数
     *
     * @return CREATE_TIME - 新增或者拜访客户数
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置新增或者拜访客户数
     *
     * @param createTime 新增或者拜访客户数
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取客户维护数
     *
     * @return VISIT_NEW_NUMBER - 客户维护数
     */
    public Integer getVisitNewNumber() {
        return visitNewNumber;
    }

    /**
     * 设置客户维护数
     *
     * @param visitNewNumber 客户维护数
     */
    public void setVisitNewNumber(Integer visitNewNumber) {
        this.visitNewNumber = visitNewNumber;
    }

    /**
     * 获取新申请贷款数
     *
     * @return MAINTENANCE_NUMBER - 新申请贷款数
     */
    public Integer getMaintenanceNumber() {
        return maintenanceNumber;
    }

    /**
     * 设置新申请贷款数
     *
     * @param maintenanceNumber 新申请贷款数
     */
    public void setMaintenanceNumber(Integer maintenanceNumber) {
        this.maintenanceNumber = maintenanceNumber;
    }

    /**
     * 获取贷前调查书
     *
     * @return LOAN_NEW_NUMBER - 贷前调查书
     */
    public Integer getLoanNewNumber() {
        return loanNewNumber;
    }

    /**
     * 设置贷前调查书
     *
     * @param loanNewNumber 贷前调查书
     */
    public void setLoanNewNumber(Integer loanNewNumber) {
        this.loanNewNumber = loanNewNumber;
    }

    /**
     * @return PRELOAN_NUMBER
     */
    public Integer getPreloanNumber() {
        return preloanNumber;
    }

    /**
     * @param preloanNumber
     */
    public void setPreloanNumber(Integer preloanNumber) {
        this.preloanNumber = preloanNumber;
    }

    @Override
    public Integer getPK() {
        return id;
    }
}