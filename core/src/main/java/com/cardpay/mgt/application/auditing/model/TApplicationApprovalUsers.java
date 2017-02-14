package com.cardpay.mgt.application.auditing.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@Table(name = "T_APPLICATION_APPROVAL_USERS")
@ApiModel(value="审贷会成员")
public class TApplicationApprovalUsers extends GenericEntity<Integer>{
    /**
     * 审贷会成员id
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select APP_APPROVAL_USERS_SEQ.nextval from dual")
    @ApiModelProperty(value="审贷会成员id",required = true)
    private Integer id;

    /**
     * 审贷会id
     */
    @Column(name = "REVIEW_ID")
    @ApiModelProperty(value="审贷会id",required = true)
    private Integer reviewId;

    /**
     * 进件id
     */
    @Column(name = "APPLICATION_ID")
    @ApiModelProperty(value="进件id",required = true)
    private Integer applicationId;

    /**
     * 用户id
     */
    @Column(name = "USER_ID")
    @ApiModelProperty(value="用户id",required = true)
    private Integer userId;

    /**
     * 用户姓名
     */
    @Column(name = "USER_NAME")
    @ApiModelProperty(value="用户姓名",required = true)
    private String userName;

    /**
     * 获取审贷会成员id
     *
     * @return ID - 审贷会成员id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置审贷会成员id
     *
     * @param id 审贷会成员id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取审贷会id
     *
     * @return REVIEW_ID - 审贷会id
     */
    public Integer getReviewId() {
        return reviewId;
    }

    /**
     * 设置审贷会id
     *
     * @param reviewId 审贷会id
     */
    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
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
     * 获取用户id
     *
     * @return USER_ID - 用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取用户姓名
     *
     * @return USER_NAME - 用户姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户姓名
     *
     * @param userName 用户姓名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public Integer getPK() {
        return id;
    }
}