package com.cardpay.mgt.user.model;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.persistence.*;

/**
 * 用户实体
 */
@ApiModel(value = "用户实体")
@Table(name = "T_USER")
public class User extends GenericEntity<Integer> {
    /**
     * 用户id
     */
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "select USER_SEQ.nextval from dual")
    @ApiModelProperty(value = "用户id", required = true)
    private Integer id;

    /**
     * 用户名
     */
    @Column(name = "USERNAME")
    @ApiModelProperty(value = "用户名", allowableValues = "")
    private String username;

    /**
     * 密码
     */
    @Column(name = "PASSWORD")
    @ApiModelProperty(value = "密码", allowableValues = "")
    private String password;

    /**
     * 最后登录时间
     */
    @Column(name = "LAST_LOGIN_TIME")
    @ApiModelProperty(value = "最后登录时间", allowableValues = "")
    private Date lastLoginTime;

    /**
     * 电子邮件地址
     */
    @Column(name = "EMAIL")
    @ApiModelProperty(value = "电子邮件地址", allowableValues = "")
    private String email;

    /**
     * 联系电话
     */
    @Column(name = "TEL")
    @ApiModelProperty(value = "联系电话", allowableValues = "")
    private String tel;

    /**
     * 创建时间
     */
    @Column(name = "CREATE_TIME")
    @ApiModelProperty(value = "创建时间", allowableValues = "")
    private Date createTime;

    /**
     * 用户状态(0 正常，1 锁定，3 待激活)
     */
    @Column(name = "STATUS")
    @ApiModelProperty(value = "用户状态", notes = "(0 正常，1 锁定，3 待激活)", allowableValues = "")
    private Integer status;

    /**
     * 获取用户id
     *
     * @return ID - 用户id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置用户id
     *
     * @param id 用户id
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

    @Override
    public Integer getPK() {
        return this.id;
    }


    public static final class UserBuilder {
        private Integer id;
        private String username;
        private String password;
        private Date lastLoginTime;
        private String email;
        private String tel;
        private Date createTime;
        private Integer status;

        private UserBuilder() {
        }

        public static UserBuilder get() {
            return new UserBuilder();
        }

        public UserBuilder withId(Integer id) {
            this.id = id;
            return this;
        }

        public UserBuilder withUsername(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder withPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder withLastLoginTime(Date lastLoginTime) {
            this.lastLoginTime = lastLoginTime;
            return this;
        }

        public UserBuilder withEmail(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder withTel(String tel) {
            this.tel = tel;
            return this;
        }

        public UserBuilder withCreateTime(Date createTime) {
            this.createTime = createTime;
            return this;
        }

        public UserBuilder withStatus(Integer status) {
            this.status = status;
            return this;
        }

        public User build() {
            User user = new User();
            user.setId(id);
            user.setUsername(username);
            user.setPassword(password);
            user.setLastLoginTime(lastLoginTime);
            user.setEmail(email);
            user.setTel(tel);
            user.setCreateTime(createTime);
            user.setStatus(status);
            return user;
        }
    }
}