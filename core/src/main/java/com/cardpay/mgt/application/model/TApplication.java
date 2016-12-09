package com.cardpay.mgt.application.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.persistence.*;

/**
 * 进件表
 * @author chenkai
 */
@Table(name = "T_APPLICATION")
@ApiModel(value="进件信息管理表")
public class TApplication extends GenericEntity<Integer> {
    /**
     * 进件id
     */
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select APPLICATION_SEQ.nextval from dual")
    @ApiModelProperty(value="进件id",required = true)
    private Integer id;

    /**
     * 客户id
     */
    @Column(name = "CUSTOMER_ID")
    @ApiModelProperty(value="客户id",required = true)
    private Integer customerId;

    /**
     * 产品id
     */
    @Column(name = "PRODUCT_ID")
    @ApiModelProperty(value="产品id",required = true)
    private Integer productId;

    /**
     * 客户经理id
     */
    @Column(name = "CUSTOMER_MANAGER_ID")
    @ApiModelProperty(value="客户经理id",required = true)
    private Integer customerManagerId;

    /**
     * 进件状态(0 未完成，1 禁入，2 待审核，3 审核通过，4审核不通过)
     */
    @Column(name = "APPLICATION_STATUS")
    @ApiModelProperty(value="进件状态(0 未完成，1 禁入，2 待审核，3 审核通过，4审核不通过)",required = true)
    private Integer applicationStatus;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    @ApiModelProperty(value="创建时间",required = true)
    private Date createTime;

    /**
     * 获取进件id
     *
     * @return ID - 进件id
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
     * @return CUSTOMER_ID - 客户id
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
     * @return PRODUCT_ID - 产品id
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
     * 获取进件状态(0 未完成，1 禁入，2 待审核，3 审核通过，4审核不通过)
     *
     * @return APPLICATION_STATUS - 进件状态(0 未完成，1 禁入，2 待审核，3 审核通过，4审核不通过)
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

    @Override
    public Integer getPK() {
        return null;
    }
}