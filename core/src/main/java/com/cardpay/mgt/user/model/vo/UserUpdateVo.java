package com.cardpay.mgt.user.model.vo;

/**
 * 用户更新vo
 *
 * @author rankai
 *         createTime 2017-01-2017/1/3 17:24
 */
public class UserUpdateVo {
    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户拥有的角色ID
     */
    private Integer roleId;

    /**
     * 用户所在机构ID
     */
    private Integer orgId;

    /**
     * 用户所在机构名称
     */
    private String orgName;
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 电子邮件地址
     */
    private String email;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * 用户状态(0 正常，1 锁定，3 待激活)
     */
    private Integer status;

    /**
     * 用户姓名
     */
    private String userCname;

    /**
     * 用户性别(0:男1:女)
     */
    private Short sex;

    /**
     * 用户年龄
     */
    private Short age;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 身份证号
     */
    private String idCardNumber;

    /**
     * 员工号
     */
    private String employeeNumber;

    /**
     * 用户类型
     */
    private Integer userType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getOrgId() {
        return orgId;
    }

    public void setOrgId(Integer orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserCname() {
        return userCname;
    }

    public void setUserCname(String userCname) {
        this.userCname = userCname;
    }

    public Short getSex() {
        return sex;
    }

    public void setSex(Short sex) {
        this.sex = sex;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }
}
