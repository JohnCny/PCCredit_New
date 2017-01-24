package com.cardpay.mgt.loan.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "T_CUSTOMER_COLLECTION")
@ApiModel(value = "客户催收")
public class CustomerCollection {
    /**
     * 客户催收id
     */
    @Id
    @Column(name = "COLLECTION_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select CUSTOMER_BASIC_SEQ.nextval from dual")
    @ApiModelProperty(value = "客户催收id", required = true)
    private Integer collectionId;

    /**
     * 不良客户信息表id
     */
    @Column(name = "BAD_CUSTOMER_ID")
    @ApiModelProperty(value = "不良客户信息表id", required = true)
    private Integer badCustomerId;

    /**
     * 催收方式(0 电话， 1 上门  2 其他 )
     */
    @Column(name = "COLLECTION_TYPE")
    @ApiModelProperty(value = "催收方式(0 电话， 1 上门  2 其他 )", required = true)
    private Short collectionType;

    /**
     * 催收结果(0 成功 1 失败 2 待定 3 其他)
     */
    @Column(name = "COLLECTION_RESULT")
    @ApiModelProperty(value = "催收结果(0 成功 1 失败 2 待定 3 其他)", required = true)
    private Short collectionResult;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 创建人
     */
    @Column(name = "CREATE_BY")
    private Integer createBy;

    /**
     * 获取客户催收id
     *
     * @return COLLECTION_ID - 客户催收id
     */
    public Integer getCollectionId() {
        return collectionId;
    }

    /**
     * 设置客户催收id
     *
     * @param collectionId 客户催收id
     */
    public void setCollectionId(Integer collectionId) {
        this.collectionId = collectionId;
    }

    /**
     * 获取不良客户信息表id
     *
     * @return BAD_CUSTOMER_ID - 不良客户信息表id
     */
    public Integer getBadCustomerId() {
        return badCustomerId;
    }

    /**
     * 设置不良客户信息表id
     *
     * @param badCustomerId 不良客户信息表id
     */
    public void setBadCustomerId(Integer badCustomerId) {
        this.badCustomerId = badCustomerId;
    }

    /**
     * 获取催收方式(0 电话， 1 上门  2 其他 )
     *
     * @return COLLECTION_TYPE - 催收方式(0 电话， 1 上门  2 其他 )
     */
    public Short getCollectionType() {
        return collectionType;
    }

    /**
     * 设置催收方式(0 电话， 1 上门  2 其他 )
     *
     * @param collectionType 催收方式(0 电话， 1 上门  2 其他 )
     */
    public void setCollectionType(Short collectionType) {
        this.collectionType = collectionType;
    }

    /**
     * 获取催收结果(0 成功 1 失败 2 待定 3 其他)
     *
     * @return COLLECTION_RESULT - 催收结果(0 成功 1 失败 2 待定 3 其他)
     */
    public Short getCollectionResult() {
        return collectionResult;
    }

    /**
     * 设置催收结果(0 成功 1 失败 2 待定 3 其他)
     *
     * @param collectionResult 催收结果(0 成功 1 失败 2 待定 3 其他)
     */
    public void setCollectionResult(Short collectionResult) {
        this.collectionResult = collectionResult;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }
}