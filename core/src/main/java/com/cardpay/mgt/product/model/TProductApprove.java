package com.cardpay.mgt.product.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

/**
 * 产品审批管理
 * @author chenkai
 */
@Table(name = "T_PRODUCT_APPROVE")
@ApiModel(value="产品审批管理")
public class TProductApprove extends GenericEntity<Integer> {
    /**
     * 审批节点id
     */
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select PRODUCAPPROVE_SEQ.nextval from dual")
    @ApiModelProperty(value="审批节点id",required = true)
    private Integer id;

    /**
     * 产品id
     */
    @Column(name = "PRODUCT_ID")
    @ApiModelProperty(value="产品id",required = true)
    private String productId;

    /**
     * 节点类型(0 起始节点 1 中间节点 2 结束节点)
     */
    @Column(name = "NODE_TYPE")
    @ApiModelProperty(value="节点类型(0 起始节点 1 中间节点 2 结束节点)",required = true)
    private Integer nodeType;

    /**
     * 节点名称
     */
    @Column(name = "NODE_NAME")
    @ApiModelProperty(value="节点名称",required = true)
    private String nodeName;

    /**
     * 节点前一个节点id(起始节点为-1)
     */
    @Column(name = "PRE_NODE_ID")
    @ApiModelProperty(value="节点前一个节点id(起始节点为-1)",required = true)
    private Integer preNodeId;

    /**
     * 节点后一个节点(结束节点为-1)
     */
    @Column(name = "NEXT_NODE_ID")
    @ApiModelProperty(value="节点后一个节点(结束节点为-1)",required = true)
    private Integer nextNodeId;

    /**
     * 可审批角色(以逗号分隔)
     */
    @Column(name = "APPROVE_ROLES")
    @ApiModelProperty(value="可审批角色(以逗号分隔)",required = true)
    private String approveRoles;

    /**
     * 是否随机分件(0 不随机分件 1 随机分件)
     */
    @Column(name = "IS_RANDOM_DIVISION")
    @ApiModelProperty(value="是否随机分件(0 不随机分件 1 随机分件)",required = true)
    private Integer isRandomDivision;

    /**
     * 是否是审贷会节点(0 不是 1 是)
     */
    @Column(name = "IS_LOAN_MEETING")
    @ApiModelProperty(value="是否是审贷会节点(0 不是 1 是)",required = true)
    private Integer isLoanMeeting;

    /**
     * 是否进行额度判断(0 判断  1 是不判断 )
     */
    @Column(name = "IS_LOAN_LIMIT")
    @ApiModelProperty(value="是否进行额度判断(0 判断  1 是不判断 )",required = true)
    private Integer isLoanLimit;

    /**
     * 审批额度值
     */
    @Column(name = "LOAN_LIMIT")
    @ApiModelProperty(value="审批额度值",required = true)
    private Long loanLimit;

    /**
     * 是否复核节点( 0 不是 1 是)
     */
    @Column(name = "IS_REVIEW_NODE")
    @ApiModelProperty(value="是否复核节点( 0 不是 1 是)",required = true)
    private Integer isReviewNode;

    /**
     * 审贷会通过方式(0 集体通过 1 多数通过)
     */
    @Column(name = "LOAN_MEETING_TYPE")
    @ApiModelProperty(value="审贷会通过方式(0 集体通过 1 多数通过)",required = true)
    private Integer loanMeetingType;

    /**
     * 获取审批节点id
     *
     * @return ID - 审批节点id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置审批节点id
     *
     * @param id 审批节点id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取产品id
     *
     * @return PRODUCT_ID - 产品id
     */
    public String getProductId() {
        return productId;
    }

    /**
     * 设置产品id
     *
     * @param productId 产品id
     */
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * 获取节点类型(0 起始节点 1 中间节点 2 结束节点)
     *
     * @return NODE_TYPE - 节点类型(0 起始节点 1 中间节点 2 结束节点)
     */
    public Integer getNodeType() {
        return nodeType;
    }

    /**
     * 设置节点类型(0 起始节点 1 中间节点 2 结束节点)
     *
     * @param nodeType 节点类型(0 起始节点 1 中间节点 2 结束节点)
     */
    public void setNodeType(Integer nodeType) {
        this.nodeType = nodeType;
    }

    /**
     * 获取节点名称
     *
     * @return NODE_NAME - 节点名称
     */
    public String getNodeName() {
        return nodeName;
    }

    /**
     * 设置节点名称
     *
     * @param nodeName 节点名称
     */
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    /**
     * 获取节点前一个节点id(起始节点为-1)
     *
     * @return PRE_NODE_ID - 节点前一个节点id(起始节点为-1)
     */
    public Integer getPreNodeId() {
        return preNodeId;
    }

    /**
     * 设置节点前一个节点id(起始节点为-1)
     *
     * @param preNodeId 节点前一个节点id(起始节点为-1)
     */
    public void setPreNodeId(Integer preNodeId) {
        this.preNodeId = preNodeId;
    }

    /**
     * 获取节点后一个节点(结束节点为-1)
     *
     * @return NEXT_NODE_ID - 节点后一个节点(结束节点为-1)
     */
    public Integer getNextNodeId() {
        return nextNodeId;
    }

    /**
     * 设置节点后一个节点(结束节点为-1)
     *
     * @param nextNodeId 节点后一个节点(结束节点为-1)
     */
    public void setNextNodeId(Integer nextNodeId) {
        this.nextNodeId = nextNodeId;
    }

    /**
     * 获取可审批角色(以逗号分隔)
     *
     * @return APPROVE_ROLES - 可审批角色(以逗号分隔)
     */
    public String getApproveRoles() {
        return approveRoles;
    }

    /**
     * 设置可审批角色(以逗号分隔)
     *
     * @param approveRoles 可审批角色(以逗号分隔)
     */
    public void setApproveRoles(String approveRoles) {
        this.approveRoles = approveRoles;
    }

    /**
     * 获取是否随机分件(0 不随机分件 1 随机分件)
     *
     * @return IS_RANDOM_DIVISION - 是否随机分件(0 不随机分件 1 随机分件)
     */
    public Integer getIsRandomDivision() {
        return isRandomDivision;
    }

    /**
     * 设置是否随机分件(0 不随机分件 1 随机分件)
     *
     * @param isRandomDivision 是否随机分件(0 不随机分件 1 随机分件)
     */
    public void setIsRandomDivision(Integer isRandomDivision) {
        this.isRandomDivision = isRandomDivision;
    }

    /**
     * 获取是否是审贷会节点(0 不是 1 是)
     *
     * @return IS_LOAN_MEETING - 是否是审贷会节点(0 不是 1 是)
     */
    public Integer getIsLoanMeeting() {
        return isLoanMeeting;
    }

    /**
     * 设置是否是审贷会节点(0 不是 1 是)
     *
     * @param isLoanMeeting 是否是审贷会节点(0 不是 1 是)
     */
    public void setIsLoanMeeting(Integer isLoanMeeting) {
        this.isLoanMeeting = isLoanMeeting;
    }

    /**
     * 获取是否进行额度判断(0 判断  1 是不判断 )
     *
     * @return IS_LOAN_LIMIT - 是否进行额度判断(0 判断  1 是不判断 )
     */
    public Integer getIsLoanLimit() {
        return isLoanLimit;
    }

    /**
     * 设置是否进行额度判断(0 判断  1 是不判断 )
     *
     * @param isLoanLimit 是否进行额度判断(0 判断  1 是不判断 )
     */
    public void setIsLoanLimit(Integer isLoanLimit) {
        this.isLoanLimit = isLoanLimit;
    }

    /**
     * 获取审批额度值
     *
     * @return LOAN_LIMIT - 审批额度值
     */
    public Long getLoanLimit() {
        return loanLimit;
    }

    /**
     * 设置审批额度值
     *
     * @param loanLimit 审批额度值
     */
    public void setLoanLimit(Long loanLimit) {
        this.loanLimit = loanLimit;
    }

    /**
     * 获取是否复核节点( 0 不是 1 是)
     *
     * @return IS_REVIEW_NODE - 是否复核节点( 0 不是 1 是)
     */
    public Integer getIsReviewNode() {
        return isReviewNode;
    }

    /**
     * 设置是否复核节点( 0 不是 1 是)
     *
     * @param isReviewNode 是否复核节点( 0 不是 1 是)
     */
    public void setIsReviewNode(Integer isReviewNode) {
        this.isReviewNode = isReviewNode;
    }

    /**
     * 获取审贷会通过方式(0 集体通过 1 多数通过)
     *
     * @return LOAN_MEETING_TYPE - 审贷会通过方式(0 集体通过 1 多数通过)
     */
    public Integer getLoanMeetingType() {
        return loanMeetingType;
    }

    /**
     * 设置审贷会通过方式(0 集体通过 1 多数通过)
     *
     * @param loanMeetingType 审贷会通过方式(0 集体通过 1 多数通过)
     */
    public void setLoanMeetingType(Integer loanMeetingType) {
        this.loanMeetingType = loanMeetingType;
    }

    @Override
    public Integer getPK() {
        return null;
    }
}