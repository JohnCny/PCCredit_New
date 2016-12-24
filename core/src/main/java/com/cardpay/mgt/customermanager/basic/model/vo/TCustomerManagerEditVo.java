package com.cardpay.mgt.customermanager.basic.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 客户经理信息编辑页面Vo
 *
 * @author yanweichen
 */
@ApiModel(value="客户经理信息管理")
public class TCustomerManagerEditVo {

    /**
     * 客户经理姓名
     */
    @ApiModelProperty(value="客户经理姓名",required = true)
    private String userId;

    /**
     * 客户经理姓名
     */
    @ApiModelProperty(value="客户经理姓名",required = true)
    private String userCname;

    /**
     * 客户经理级别名称
     */
    @ApiModelProperty(value="客户经理级别名称",required = true)
    private String levelName;

    /**
     * 系统建议级别
     */
    @ApiModelProperty(value="系统建议级别",required = true)
    private String systemLevel;

    /**
     * 是否暂停进件
     */
    @ApiModelProperty(value="是否暂停进件",required = true)
    private Integer status;

    /**
     * 客户经理工号
     */
    @ApiModelProperty(value="客户经理工号",required = true)
    private String employeeNumber;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取客户经理工号
     *
     * @return employeeNumber 客户经理工号
     */
    public String getEmployeeNumber() {
        return employeeNumber;
    }

    /**
     * 设置客户经理工号
     *
     * @param employeeNumber 客户经理工号
     */
    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    /**
     * 获取客户经理姓名
     *
     * @return userCname 客户经理姓名
     */
    public String getUserCname() {
        return userCname;
    }

    /**
     * 设置客户经理姓名
     *
     * @param userCname 客户经理姓名
     */
    public void setUserCname(String userCname) {
        this.userCname = userCname;
    }

    /**
     * 获取客户经理级别名称
     *
     * @return levelName 客户经理级别名称
     */
    public String getLevelName() {
        return levelName;
    }

    /**
     * 设置客户经理级别名称
     *
     * @param levelName 客户经理级别名称
     */
    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    /**
     * 获取是否暂停进件
     *
     * @return ifPause 是否暂停进件
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置是否暂停进件
     *
     * @param status 是否暂停进件
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取系统建议级别
     *
     * @return systemLevel 系统建议级别
     */
    public String getSystemLevel() {
        return systemLevel;
    }

    /**
     * 设置系统建议级别
     *
     * @param systemLevel 系统建议级别
     */
    public void setSystemLevel(String systemLevel) {
        this.systemLevel = systemLevel;
    }

}