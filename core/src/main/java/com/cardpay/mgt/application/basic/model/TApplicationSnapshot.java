package com.cardpay.mgt.application.basic.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.persistence.*;

@Table(name = "T_APPLICATION_SNAPSHOT")
@ApiModel(value="进件快照表")
public class TApplicationSnapshot extends GenericEntity<Integer>{
    /**
     * 进件快照id
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select APPLICATION_SNAPSHOT_SEQ.nextval from dual")
    @ApiModelProperty(value="进件快照id",required = true)
    private Integer id;

    /**
     * 进件id
     */
    @Column(name = "APPLICATION_ID")
    @ApiModelProperty(value="进件id",required = true)
    private Integer applicationId;

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
     * 申请时间
     */
    @Column(name = "CREATE_TIME")
    @ApiModelProperty(value="申请时间",required = true)
    private Date createTime;

    /**
     * 进件所属客户经理id
     */
    @Column(name = "CUSTOMER_MANAGER_ID")
    @ApiModelProperty(value="进件所属客户经理id",required = true)
    private Integer customerManagerId;

    /**
     * 进件快照信息(采用json方式，将客户信息，进件信息，产品信息，客户经理信息按照json格式保存)
     */
    @Column(name = "T_APPLICATION_SNAPSHOT")
    @ApiModelProperty(value="进件快照信息(采用json方式，将客户信息，进件信息，产品信息，客户经理信息按照json格式保存)",required = true)
    private String tApplicationSnapshot;

    /**
     * 获取进件快照id
     *
     * @return ID - 进件快照id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置进件快照id
     *
     * @param id 进件快照id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取进件id
     *
     * @return APPLICATION_ID - 进件id
     */
    public Integer getApplicationId() {
        return applicationId;
    }

    /**
     * 设置进件id
     *
     * @param applicationId 进件id
     */
    public void setApplicationId(Integer applicationId) {
        this.applicationId = applicationId;
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
     * 获取申请时间
     *
     * @return CREATE_TIME - 申请时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置申请时间
     *
     * @param createTime 申请时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取进件所属客户经理id
     *
     * @return CUSTOMER_MANAGER_ID - 进件所属客户经理id
     */
    public Integer getCustomerManagerId() {
        return customerManagerId;
    }

    /**
     * 设置进件所属客户经理id
     *
     * @param customerManagerId 进件所属客户经理id
     */
    public void setCustomerManagerId(Integer customerManagerId) {
        this.customerManagerId = customerManagerId;
    }

    /**
     * 获取进件快照信息(采用json方式，将客户信息，进件信息，产品信息，客户经理信息按照json格式保存)
     *
     * @return T_APPLICATION_SNAPSHOT - 进件快照信息(采用json方式，将客户信息，进件信息，产品信息，客户经理信息按照json格式保存)
     */
    public String gettApplicationSnapshot() {
        return tApplicationSnapshot;
    }

    /**
     * 设置进件快照信息(采用json方式，将客户信息，进件信息，产品信息，客户经理信息按照json格式保存)
     *
     * @param tApplicationSnapshot 进件快照信息(采用json方式，将客户信息，进件信息，产品信息，客户经理信息按照json格式保存)
     */
    public void settApplicationSnapshot(String tApplicationSnapshot) {
        this.tApplicationSnapshot = tApplicationSnapshot;
    }

    @Override
    public Integer getPK() {
        return id;
    }
}