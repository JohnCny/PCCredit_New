package com.cardpay.mgt.application.auditing.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Table(name = "T_APPLICATION_APPROVE_LIST")
@ApiModel(value="进件审批")
public class TApplicationApproveList extends GenericEntity<Integer> {
    /**
     * 进件已审核列表id
     */
    @Id
    @Column(name = "APPLICATION_APPROVE_LIST_ID")
    @ApiModelProperty(value="进件已审核列表id",required = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select APP_APPROVAL_LIST_SEQ.nextval from dual")
    private Integer applicationApproveListId;

    /**
     * 进件id
     */
    @Column(name = "APPLICATION_ID")
    @ApiModelProperty(value="进件id",required = true)
    private Integer applicationId;

    /**
     * 已经审核节点id
     */
    @Column(name = "PRODUCT_APPROVE_ID")
    @ApiModelProperty(value="已经审核节点id",required = true)
    private Integer productApproveId;

    /**
     * 已审核节点名称
     */
    @Column(name = "PRODUCT_APPROVE_NAME")
    @ApiModelProperty(value="已审核节点名称",required = true)
    private String productApproveName;

    /**
     * 获取进件已审核列表id
     *
     * @return APPLICATION_APPROVE_LIST_ID - 进件已审核列表id
     */
    public Integer getApplicationApproveListId() {
        return applicationApproveListId;
    }

    /**
     * 设置进件已审核列表id
     *
     * @param applicationApproveListId 进件已审核列表id
     */
    public void setApplicationApproveListId(Integer applicationApproveListId) {
        this.applicationApproveListId = applicationApproveListId;
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
     * 获取已经审核节点id
     *
     * @return PRODUCT_APPROVE_ID - 已经审核节点id
     */
    public Integer getProductApproveId() {
        return productApproveId;
    }

    /**
     * 设置已经审核节点id
     *
     * @param productApproveId 已经审核节点id
     */
    public void setProductApproveId(Integer productApproveId) {
        this.productApproveId = productApproveId;
    }

    /**
     * 获取已审核节点名称
     *
     * @return PRODUCT_APPROVE_NAME - 已审核节点名称
     */
    public String getProductApproveName() {
        return productApproveName;
    }

    /**
     * 设置已审核节点名称
     *
     * @param productApproveName 已审核节点名称
     */
    public void setProductApproveName(String productApproveName) {
        this.productApproveName = productApproveName;
    }

    @Override
    public Integer getPK() {
        return applicationApproveListId;
    }
}