package com.cardpay.mgt.team.model.vo;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import java.util.Date;

/**
 * 团队所属用户信息
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/24 16:25
 */
public class TUserVo extends GenericEntity<Integer>{
    /**
     * 用户id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;


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
     * 手机号码
     */
    private String phone;

    /**
     * 员工号
     */
    private String employeeNumber;

    /**
     * 团队id
     */
    private Integer teamId;

    /**
     * 所属团队名称
     */
    private String teamName;

    /**
     * 创建时间
     */
    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    @Override
    public Integer getPK() {
        return id;
    }
}
