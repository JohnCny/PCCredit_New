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
    @Id
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
     * 用户姓名
     */
    @Column(name = "USER_CNAME")
    @ApiModelProperty(value = "用户姓名", required = true)
    private String userCname;

    /**
     * 用户性别
     */
    @Column(name = "SEX")
    @ApiModelProperty(value = "用户性别", required = true)
    private Short sex;

    /**
     * 创建人
     */
    @Column(name = "CREATE_BY")
    @ApiModelProperty(value = "创建人", required = true)
    private Integer createBy;

    /**
     * 用户年龄
     */
    @Column(name = "AGE")
    @ApiModelProperty(value = "用户年龄", required = true)
    private Short age;

    /**
     * 手机号码
     */
    @Column(name = "PHONE")
    @ApiModelProperty(value = "手机号码", required = true)
    private String phone;

    /**
     * 身份证号
     */
    @Column(name = "ID_CARD_NUMBER")
    @ApiModelProperty(value = "身份证号", required = true)
    private String idCardNumber;

    /**
     * 员工号
     */
    @Column(name = "EMPLOYEE_NUMBER")
    @ApiModelProperty(value = "员工号", required = true)
    private String employeeNumber;

    /**
     * 用户类型
     */
    @Column(name = "USER_TYPE")
    @ApiModelProperty(value = "用户类型", required = true)
    private Integer userType;

    /**
     * 修改人
     */
    @Column(name = "MODIFY_BY")
    @ApiModelProperty(value = "修改人", required = true)
    private Integer modifyBy;

    /**
     * 修改时间
     */
    @Column(name = "MODIFY_TIME")
    @ApiModelProperty(value = "修改时间", required = true)
    private Date modifyTime;

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
     * 获取用户类型
     *
     * @return userType - 用户类型
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     * 设置用户类型
     *
     * @param userType 用户类型
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
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

    /**
     * 获取用户姓名
     *
     * @return USER_CNAME - 用户姓名
     */
    public String getUserCname() {
        return userCname;
    }

    /**
     * 设置用户姓名
     *
     * @param userCname 用户姓名
     */
    public void setUserCname(String userCname) {
        this.userCname = userCname;
    }

    /**
     * 获取用户性别
     *
     * @return SEX - 用户性别
     */
    public Short getSex() {
        return sex;
    }

    /**
     * 设置用户性别
     *
     * @param sex 用户性别
     */
    public void setSex(Short sex) {
        this.sex = sex;
    }

    /**
     * 获取创建人
     *
     * @return CREATE_BY - 创建人
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * 设置创建人
     *
     * @param createBy 创建人
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * 获取用户年龄
     *
     * @return AGE - 用户年龄
     */
    public Short getAge() {
        return age;
    }

    /**
     * 设置用户年龄
     *
     * @param age 用户年龄
     */
    public void setAge(Short age) {
        this.age = age;
    }

    /**
     * 获取手机号码
     *
     * @return PHONE - 手机号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号码
     *
     * @param phone 手机号码
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取身份证号
     *
     * @return ID_CARD_NUMBER - 身份证号
     */
    public String getIdCardNumber() {
        return idCardNumber;
    }

    /**
     * 设置身份证号
     *
     * @param idCardNumber 身份证号
     */
    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    /**
     * 获取员工号
     *
     * @return EMPLOYEE_NUMBER - 员工号
     */
    public String getEmployeeNumber() {
        return employeeNumber;
    }

    /**
     * 设置员工号
     *
     * @param employeeNumber 员工号
     */
    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    /**
     * 获取修改人
     *
     * @return MODIFY_BY - 修改人
     */
    public Integer getModifyBy() {
        return modifyBy;
    }

    /**
     * 设置修改人
     *
     * @param modifyBy 修改人
     */
    public void setModifyBy(Integer modifyBy) {
        this.modifyBy = modifyBy;
    }

    /**
     * 获取修改时间
     *
     * @return MODIFY_TIME - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
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
        private String userCname;
        private Short sex;
        private Integer createBy;
        private Short age;
        private String phone;
        private String idCardNumber;
        private String employeeNumber;
        private Integer modifyBy;
        private Date modifyTime;

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

        public UserBuilder withUserCname(String userCname) {
            this.userCname = userCname;
            return this;
        }

        public UserBuilder withSex(Short sex) {
            this.sex = sex;
            return this;
        }

        public UserBuilder withCreateBy(Integer createBy) {
            this.createBy = createBy;
            return this;
        }

        public UserBuilder withAge(Short age) {
            this.age = age;
            return this;
        }

        public UserBuilder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder withIdCardNumber(String idCardNumber) {
            this.idCardNumber = idCardNumber;
            return this;
        }

        public UserBuilder withEmployeeNumber(String employeeNumber) {
            this.employeeNumber = employeeNumber;
            return this;
        }

        public UserBuilder withModifyBy(Integer modifyBy) {
            this.modifyBy = modifyBy;
            return this;
        }

        public UserBuilder withModifyTime(Date modifyTime) {
            this.modifyTime = modifyTime;
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
            user.setUserCname(userCname);
            user.setSex(sex);
            user.setCreateBy(createBy);
            user.setAge(age);
            user.setPhone(phone);
            user.setIdCardNumber(idCardNumber);
            user.setEmployeeNumber(employeeNumber);
            user.setModifyBy(modifyBy);
            user.setModifyTime(modifyTime);
            return user;
        }
    }
}