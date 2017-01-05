package com.cardpay.mgt.application.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "T_APPLICATION")
@ApiModel(value="进件信息管理表")
public class TApplication extends GenericEntity<Integer> {
    /**
     * 进件id
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select 你的序列名.nextval from dual")
    @ApiModelProperty(value="进件id",required = true)
    private Integer id;

    /**
     * 客户id
     */
    @Column(name = "customer_id")
    @ApiModelProperty(value="客户id",required = true)
    private Integer customerId;

    /**
     * 产品id
     */
    @Column(name = "product_id")
    @ApiModelProperty(value="产品id",required = true)
    private Integer productId;

    /**
     * 进件退回原因
     */
    @Column(name = "repulse_reason")
    @ApiModelProperty(value="进件退回原因",required = true)
    private String repulseReason;

    /**
     * 进件状态(0 未完成，1 禁入，2 待审核，3 审核通过，4审核不通过)
     */
    @Column(name = "application_status")
    @ApiModelProperty(value="进件状态(0 未完成，1 禁入，2 待审核，3 审核通过，4审核不通过)",required = true)
    private Integer applicationStatus;

    /**
     * 进件申请金额
     */
    @Column(name = "apply_amount")
    @ApiModelProperty(value="进件申请金额",required = true)
    private BigDecimal applyAmount;

    /**
     * 进件审批金额
     */
    @Column(name = "approve_amount")
    @ApiModelProperty(value="进件审批金额",required = true)
    private BigDecimal approveAmount;

    /**
     * 进件申请原因
     */
    @Column(name = "apply_reason")
    @ApiModelProperty(value="进件申请原因",required = true)
    private String applyReason;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    @ApiModelProperty(value="创建时间",required = true)
    private Date createTime;

    /**
     * 客户经理id
     */
    @Column(name = "customer_manager_id")
    @ApiModelProperty(value="客户经理id",required = true)
    private Integer customerManagerId;

    /**
     * 获取进件id
     *
     * @return id - 进件id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置进件id
     *
     * @param id 进件id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取客户id
     *
     * @return customer_id - 客户id
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * 设置客户id
     *
     * @param customerId 客户id
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * 获取产品id
     *
     * @return product_id - 产品id
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * 设置产品id
     *
     * @param productId 产品id
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    /**
     * 获取进件退回原因
     *
     * @return repulse_reason - 进件退回原因
     */
    public String getRepulseReason() {
        return repulseReason;
    }

    /**
     * 设置进件退回原因
     *
     * @param repulseReason 进件退回原因
     */
    public void setRepulseReason(String repulseReason) {
        this.repulseReason = repulseReason;
    }

    /**
     * 获取进件状态(0 未完成，1 禁入，2 待审核，3 审核通过，4审核不通过)
     *
     * @return application_status - 进件状态(0 未完成，1 禁入，2 待审核，3 审核通过，4审核不通过)
     */
    public Integer getApplicationStatus() {
        return applicationStatus;
    }

    /**
     * 设置进件状态(0 未完成，1 禁入，2 待审核，3 审核通过，4审核不通过)
     *
     * @param applicationStatus 进件状态(0 未完成，1 禁入，2 待审核，3 审核通过，4审核不通过)
     */
    public void setApplicationStatus(Integer applicationStatus) {
        this.applicationStatus = applicationStatus;
    }

    /**
     * 获取进件申请金额
     *
     * @return apply_amount - 进件申请金额
     */
    public BigDecimal getApplyAmount() {
        return applyAmount;
    }

    /**
     * 设置进件申请金额
     *
     * @param applyAmount 进件申请金额
     */
    public void setApplyAmount(BigDecimal applyAmount) {
        this.applyAmount = applyAmount;
    }

    /**
     * 获取进件审批金额
     *
     * @return approve_amount - 进件审批金额
     */
    public BigDecimal getApproveAmount() {
        return approveAmount;
    }

    /**
     * 设置进件审批金额
     *
     * @param approveAmount 进件审批金额
     */
    public void setApproveAmount(BigDecimal approveAmount) {
        this.approveAmount = approveAmount;
    }

    /**
     * 获取进件申请原因
     *
     * @return apply_reason - 进件申请原因
     */
    public String getApplyReason() {
        return applyReason;
    }

    /**
     * 设置进件申请原因
     *
     * @param applyReason 进件申请原因
     */
    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    /**
     * 获取创建时间
     *
     * @return create_time - 创建时间
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
     * 获取客户经理id
     *
     * @return customer_manager_id - 客户经理id
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

    @Override
    public Integer getPK() {
        return id;
    }
}