package com.cardpay.mgt.user.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "T_USER_TOKEN")
@ApiModel(value="用户token表")
public class TUserToken {
    /**
     * id
     */
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select 你的序列名.nextval from dual")
    @ApiModelProperty(value="id",required = true)
    private Integer id;

    /**
     * 用户id
     */
    @Column(name = "USER_ID")
    @ApiModelProperty(value="用户id",required = true)
    private String userId;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    @ApiModelProperty(value="创建时间",required = true)
    private Date createTime;

    /**
     * 过期时间
     */
    @Column(name = "EXPIRATION_TIME")
    @ApiModelProperty(value="过期时间",required = true)
    private Date expirationTime;

    /**
     * token值
     */
    @Column(name = "TOKEN")
    @ApiModelProperty(value="token值",required = true)
    private String token;

    /**
     * 获取id
     *
     * @return ID - id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return USER_ID - 用户id
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(String userId) {
        this.userId = userId;
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
     * 获取过期时间
     *
     * @return EXPIRATION_TIME - 过期时间
     */
    public Date getExpirationTime() {
        return expirationTime;
    }

    /**
     * 设置过期时间
     *
     * @param expirationTime 过期时间
     */
    public void setExpirationTime(Date expirationTime) {
        this.expirationTime = expirationTime;
    }

    /**
     * 获取token值
     *
     * @return TOKEN - token值
     */
    public String getToken() {
        return token;
    }

    /**
     * 设置token值
     *
     * @param token token值
     */
    public void setToken(String token) {
        this.token = token;
    }
}