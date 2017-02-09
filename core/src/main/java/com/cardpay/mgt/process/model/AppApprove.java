package com.cardpay.mgt.process.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.persistence.*;

@Table(name = "T_APP_APPROVE")
@ApiModel(value = "null")
public class AppApprove extends GenericEntity<Integer> {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select 你的序列名.nextval from dual")
    @ApiModelProperty(value = "null", required = true)
    private Integer id;

    @Column(name = "APP_ID")
    @ApiModelProperty(value = "null", required = true)
    private Integer appId;

    @Column(name = "PRODUCT_APPROVE_ID")
    @ApiModelProperty(value = "null", required = true)
    private Integer productApproveId;

    @Column(name = "SORT")
    @ApiModelProperty(value = "null", required = true)
    private Integer sort;

    /**
     * 审批状态 0 待进行 1正在进行 2已完成
     */
    @Column(name = "STATUS")
    @ApiModelProperty(value = "审批状态 0 待进行 1正在进行 2已完成", required = true)
    private Integer status;

    @Column(name = "CREATE_TIME")
    @ApiModelProperty(value = "null", required = true)
    private Date createTime;

    @Column(name = "COMPLETE_TIME")
    @ApiModelProperty(value = "null", required = true)
    private Date completeTime;

    /**
     * @return ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return APP_ID
     */
    public Integer getAppId() {
        return appId;
    }

    /**
     * @param appId
     */
    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    /**
     * @return PRODUCT_APPROVE_ID
     */
    public Integer getProductApproveId() {
        return productApproveId;
    }

    /**
     * @param productApproveId
     */
    public void setProductApproveId(Integer productApproveId) {
        this.productApproveId = productApproveId;
    }

    /**
     * @return SORT
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * @param sort
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取审批状态 0 待进行 1正在进行 2已完成
     *
     * @return STATUS - 审批状态 0 待进行 1正在进行 2已完成
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置审批状态 0 待进行 1正在进行 2已完成
     *
     * @param status 审批状态 0 待进行 1正在进行 2已完成
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * @return CREATE_TIME
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * @return COMPLETE_TIME
     */
    public Date getCompleteTime() {
        return completeTime;
    }

    /**
     * @param completeTime
     */
    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }

    @Override
    public Integer getPK() {
        return id;
    }
}