package com.cardpay.mgt.manager.customermanagerweekly.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.persistence.*;

/**
 * 客户经理周报信息实体类
 * @author yanweichen
 */
@Table(name = "T_CUSTOMER_MANAGER_WEEKLY")
@ApiModel(value="客户经理周报数据管理")
public class TCustomerManagerWeekly extends GenericEntity<Integer> {
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
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select CUSTOMER_MANAGER_WEEKLY_SEQ.nextval from dual")
    @ApiModelProperty(value="客户经理周报id",required = true)
    private Integer id;

    /**
     * 客户经理id
     */
    @Column(name = "CUSTOMER_MANAGER_ID")
    @ApiModelProperty(value="客户经理id",required = true)
    private Integer customerManagerId;

    /**
     * 周报开始时间(yyyy-mm-dd)
     */
    @Column(name = "WEEKLY_START_TIME")
    @ApiModelProperty(value="周报开始时间(yyyy-mm-dd)",required = true)
    @OrderBy("DESC")
    private Date weeklyStartTime;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    @ApiModelProperty(value="创建时间",required = true)
    private Date createTime;

    /**
     * 新增或者拜访客户数
     */
    @Column(name = "VISIT_NEW_NUMBER")
    @ApiModelProperty(value="新增或者拜访客户数",required = true)
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
    @Column(name = "PRELOAN_NUMBER")
    @ApiModelProperty(value="贷前调查数",required = true)
    private Integer preloanNumber;

    /**
     * 周报开始时间(yyyy-mm-dd)
     */
    @Column(name = "WEEKLY_END_TIME")
    @ApiModelProperty(value="周报开始时间(yyyy-mm-dd)",required = true)
    private Date weeklyEndTime;

    /**
     * 第几周周报
     */
    @Column(name = "WEEKLY_ORDER")
    @ApiModelProperty(value="第几周周报",required = true)
    private Integer weeklyOrder;

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
     * 获取周报开始时间(yyyy-mm-dd)
     *
     * @return WEEKLY_START_TIME - 周报开始时间(yyyy-mm-dd)
     */
    public Date getWeeklyStartTime() {
        return weeklyStartTime;
    }

    /**
     * 设置周报开始时间(yyyy-mm-dd)
     *
     * @param weeklyStartTime 周报开始时间(yyyy-mm-dd)
     */
    public void setWeeklyStartTime(Date weeklyStartTime) {
        this.weeklyStartTime = weeklyStartTime;
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
     * 获取新增或者拜访客户数
     *
     * @return VISIT_NEW_NUMBER - 新增或者拜访客户数
     */
    public Integer getVisitNewNumber() {
        return visitNewNumber;
    }

    /**
     * 设置新增或者拜访客户数
     *
     * @param visitNewNumber 新增或者拜访客户数
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
     * @return PRELOAN_NUMBER - 贷前调查数
     */
    public Integer getPreloanNumber() {
        return preloanNumber;
    }

    /**
     * 设置贷前调查数
     *
     * @param preloanNumber 贷前调查数
     */
    public void setPreloanNumber(Integer preloanNumber) {
        this.preloanNumber = preloanNumber;
    }

    /**
     * 获取周报开始时间(yyyy-mm-dd)
     *
     * @return WEEKLY_END_TIME - 周报开始时间(yyyy-mm-dd)
     */
    public Date getWeeklyEndTime() {
        return weeklyEndTime;
    }

    /**
     * 设置周报开始时间(yyyy-mm-dd)
     *
     * @param weeklyEndTime 周报开始时间(yyyy-mm-dd)
     */
    public void setWeeklyEndTime(Date weeklyEndTime) {
        this.weeklyEndTime = weeklyEndTime;
    }

    /**
     * 获取第几周周报
     *
     * @return WEEKLY_ORDER - 第几周周报
     */
    public Integer getWeeklyOrder() {
        return weeklyOrder;
    }

    /**
     * 设置第几周周报
     *
     * @param weeklyOrder 第几周周报
     */
    public void setWeeklyOrder(Integer weeklyOrder) {
        this.weeklyOrder = weeklyOrder;
    }

    @Override
    public Integer getPK() {
        return id;
    }
}