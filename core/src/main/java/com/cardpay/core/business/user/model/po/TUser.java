package com.cardpay.core.business.user.model.po;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.persistence.*;

/**
 * 用户信息
 * @author wangpeng
 */
@Table(name = "T_USER")
public class TUser  extends GenericEntity<Integer> {
    /**
     * 用户id
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名", required = true)
    @Column(name = "USERNAME")
    private String username;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码", required = true)
    @Column(name = "PASSWORD")
    private String password;

    /**
     * 最后登录时间
     */
    @ApiModelProperty(value = "最后登录时间", required = true)
    @Column(name = "LAST_LOGIN_TIME")
    private Date lastLoginTime;

    /**
     * 电子邮件地址
     */
    @ApiModelProperty(value = "电子邮件地址", required = true)
    @Column(name = "EMAIL")
    private String email;

    /**
     * 联系电话
     */
    @ApiModelProperty(value = "联系电话", required = true)
    @Column(name = "TEL")
    private String tel;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间", required = true)
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 用户状态(0 正常，1 锁定，3 待激活) 
     */
    @ApiModelProperty(value = "用户状态", required = true)
    @Column(name = "STATUS")
    private Integer status;

    @Override
    public Integer getPK() {
        return id;
    }

    /**
     * 获取用户id
     *
     * @return ID - 业务参数id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置用户id
     *
     * @param id 业务参数id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return USERNAME - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取密码
     *
     * @return PASSWORD - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取最后登录时间
     *
     * @return LAST_LOGIN_TIME - 最后登录时间
     */
    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    /**
     * 设置最后登录时间
     *
     * @param lastLoginTime 最后登录时间
     */
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    /**
     * 获取电子邮件地址
     *
     * @return EMAIL - 电子邮件地址
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置电子邮件地址
     *
     * @param email 电子邮件地址
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取联系电话
     *
     * @return TEL - 联系电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置联系电话
     *
     * @param tel 联系电话
     */
    public void setTel(String tel) {
        this.tel = tel;
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
     * 获取用户状态(0 正常，1 锁定，3 待激活) 
     *
     * @return STATUS - 用户状态(0 正常，1 锁定，3 待激活) 
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置用户状态(0 正常，1 锁定，3 待激活) 
     *
     * @param status 用户状态(0 正常，1 锁定，3 待激活) 
     */
    public void setStatus(Integer status) {
        this.status = status;
    }
}