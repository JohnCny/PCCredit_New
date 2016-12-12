package com.cardpay.mgt.customermanagerlevel.model.po;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "T_CUSTOMER_MANAGER_LEVEL")
@ApiModel(value="客户经理级别信息管理")
public class TCustomerManagerLevel extends GenericEntity<Integer> {
    /**
     * 级别id
     */
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select CUSTOMER_MANAGER_LEVEL_SEQ.nextval from dual")
    @ApiModelProperty(value="级别id",required = true)
    private Integer id;

    /**
     * 级别名称
     */
    @Column(name = "LEVEL_NAME")
    @ApiModelProperty(value="级别名称",required = true)
    private String levelName;

    /**
     * 级别对应额度（需不同于之前定义级别）
     */
    @Column(name = "LEVEL_CREDIT")
    @ApiModelProperty(value="级别对应额度（需不同于之前定义级别）",required = true)
    private BigDecimal levelCredit;

    /**
     * 级别逾期容忍率（超过将无法进件，只计算本人）
     */
    @Column(name = "OVERDUE_TOLERATE_RATE")
    @ApiModelProperty(value="级别逾期容忍率（超过将无法进件，只计算本人）",required = true)
    private BigDecimal overdueTolerateRate;

    /**
     * 级别不良容忍率（超过将无法进件，只计算本人）
     */
    @Column(name = "BADLOAN_TOLERATE_RATE")
    @ApiModelProperty(value="级别不良容忍率（超过将无法进件，只计算本人）",required = true)
    private BigDecimal badloanTolerateRate;

    /**
     * 级别贷后监控容忍量（超过将无法进件，只计算本人）
     */
    @Column(name = "POSTLOAN_MONITOR_TOLERATE_NUM")
    @ApiModelProperty(value="级别贷后监控容忍量（超过将无法进件，只计算本人）",required = true)
    private Integer postloanMonitorTolerateNum;

    /**
     * 级别贷款最小额度（计算本人及所管辖机构）
     */
    @Column(name = "LOAN_LIMIT_MIN")
    @ApiModelProperty(value="级别贷款最小额度（计算本人及所管辖机构）",required = true)
    private BigDecimal loanLimitMin;

    /**
     * 级别贷款最小笔数（计算本人及所管辖机构）
     */
    @Column(name = "LOAN_NUMBER_MIN")
    @ApiModelProperty(value="级别贷款最小笔数（计算本人及所管辖机构）",required = true)
    private Integer loanNumberMin;

    /**
     * 级别最小逾期率（计算本人及所管辖机构）
     */
    @Column(name = "OVERDUE_RATE_MIN")
    @ApiModelProperty(value="级别最小逾期率（计算本人及所管辖机构）",required = true)
    private BigDecimal overdueRateMin;

    /**
     * 级别最小不良率（计算本人及所管辖机构）
     */
    @Column(name = "BADLOAN_RATE_MIN")
    @ApiModelProperty(value="级别最小不良率（计算本人及所管辖机构）",required = true)
    private BigDecimal badloanRateMin;

    /**
     * 创建人id
     */
    @Column(name = "CREATE_BY")
    @ApiModelProperty(value="创建人id",required = true)
    private Integer createBy;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    @ApiModelProperty(value="创建时间",required = true)
    private Date createTime;

    /**
     * 修改人id
     */
    @Column(name = "MODIFY_BY")
    @ApiModelProperty(value="修改人id",required = true)
    private Integer modifyBy;

    /**
     * 修改时间
     */
    @Column(name = "MODIFY_TIME")
    @ApiModelProperty(value="修改时间",required = true)
    private Date modifyTime;

    /**
     * 获取级别id
     *
     * @return ID - 级别id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置级别id
     *
     * @param id 级别id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取级别名称
     *
     * @return LEVEL_NAME - 级别名称
     */
    public String getLevelName() {
        return levelName;
    }

    /**
     * 设置级别名称
     *
     * @param levelName 级别名称
     */
    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    /**
     * 获取级别对应额度（需不同于之前定义级别）
     *
     * @return LEVEL_CREDIT - 级别对应额度（需不同于之前定义级别）
     */
    public BigDecimal getLevelCredit() {
        return levelCredit;
    }

    /**
     * 设置级别对应额度（需不同于之前定义级别）
     *
     * @param levelCredit 级别对应额度（需不同于之前定义级别）
     */
    public void setLevelCredit(BigDecimal levelCredit) {
        this.levelCredit = levelCredit;
    }

    /**
     * 获取级别逾期容忍率（超过将无法进件，只计算本人）
     *
     * @return OVERDUE_TOLERATE_RATE - 级别逾期容忍率（超过将无法进件，只计算本人）
     */
    public BigDecimal getOverdueTolerateRate() {
        return overdueTolerateRate;
    }

    /**
     * 设置级别逾期容忍率（超过将无法进件，只计算本人）
     *
     * @param overdueTolerateRate 级别逾期容忍率（超过将无法进件，只计算本人）
     */
    public void setOverdueTolerateRate(BigDecimal overdueTolerateRate) {
        this.overdueTolerateRate = overdueTolerateRate;
    }

    /**
     * 获取级别不良容忍率（超过将无法进件，只计算本人）
     *
     * @return BADLOAN_TOLERATE_RATE - 级别不良容忍率（超过将无法进件，只计算本人）
     */
    public BigDecimal getBadloanTolerateRate() {
        return badloanTolerateRate;
    }

    /**
     * 设置级别不良容忍率（超过将无法进件，只计算本人）
     *
     * @param badloanTolerateRate 级别不良容忍率（超过将无法进件，只计算本人）
     */
    public void setBadloanTolerateRate(BigDecimal badloanTolerateRate) {
        this.badloanTolerateRate = badloanTolerateRate;
    }

    /**
     * 获取级别贷后监控容忍量（超过将无法进件，只计算本人）
     *
     * @return POSTLOAN_MONITOR_TOLERATE_NUM - 级别贷后监控容忍量（超过将无法进件，只计算本人）
     */
    public Integer getPostloanMonitorTolerateNum() {
        return postloanMonitorTolerateNum;
    }

    /**
     * 设置级别贷后监控容忍量（超过将无法进件，只计算本人）
     *
     * @param postloanMonitorTolerateNum 级别贷后监控容忍量（超过将无法进件，只计算本人）
     */
    public void setPostloanMonitorTolerateNum(Integer postloanMonitorTolerateNum) {
        this.postloanMonitorTolerateNum = postloanMonitorTolerateNum;
    }

    /**
     * 获取级别贷款最小额度（计算本人及所管辖机构）
     *
     * @return LOAN_LIMIT_MIN - 级别贷款最小额度（计算本人及所管辖机构）
     */
    public BigDecimal getLoanLimitMin() {
        return loanLimitMin;
    }

    /**
     * 设置级别贷款最小额度（计算本人及所管辖机构）
     *
     * @param loanLimitMin 级别贷款最小额度（计算本人及所管辖机构）
     */
    public void setLoanLimitMin(BigDecimal loanLimitMin) {
        this.loanLimitMin = loanLimitMin;
    }

    /**
     * 获取级别贷款最小笔数（计算本人及所管辖机构）
     *
     * @return LOAN_NUMBER_MIN - 级别贷款最小笔数（计算本人及所管辖机构）
     */
    public Integer getLoanNumberMin() {
        return loanNumberMin;
    }

    /**
     * 设置级别贷款最小笔数（计算本人及所管辖机构）
     *
     * @param loanNumberMin 级别贷款最小笔数（计算本人及所管辖机构）
     */
    public void setLoanNumberMin(Integer loanNumberMin) {
        this.loanNumberMin = loanNumberMin;
    }

    /**
     * 获取级别最小逾期率（计算本人及所管辖机构）
     *
     * @return OVERDUE_RATE_MIN - 级别最小逾期率（计算本人及所管辖机构）
     */
    public BigDecimal getOverdueRateMin() {
        return overdueRateMin;
    }

    /**
     * 设置级别最小逾期率（计算本人及所管辖机构）
     *
     * @param overdueRateMin 级别最小逾期率（计算本人及所管辖机构）
     */
    public void setOverdueRateMin(BigDecimal overdueRateMin) {
        this.overdueRateMin = overdueRateMin;
    }

    /**
     * 获取级别最小不良率（计算本人及所管辖机构）
     *
     * @return BADLOAN_RATE_MIN - 级别最小不良率（计算本人及所管辖机构）
     */
    public BigDecimal getBadloanRateMin() {
        return badloanRateMin;
    }

    /**
     * 设置级别最小不良率（计算本人及所管辖机构）
     *
     * @param badloanRateMin 级别最小不良率（计算本人及所管辖机构）
     */
    public void setBadloanRateMin(BigDecimal badloanRateMin) {
        this.badloanRateMin = badloanRateMin;
    }

    /**
     * 获取创建人id
     *
     * @return CREATE_BY - 创建人id
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人id
     *
     * @param createBy 创建人id
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
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
     * 获取修改人id
     *
     * @return MODIFY_BY - 修改人id
     */
    public Integer getModifyBy() {
        return modifyBy;
    }

    /**
     * 设置修改人id
     *
     * @param modifyBy 修改人id
     */
    public void setModifyBy(Integer modifyBy) {
        this.modifyBy = modifyBy;
    }

    /**
     * 获取修改时间
     *
     * @return MODIFY_TIME - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public Integer getPK() {
        return id;
    }
}