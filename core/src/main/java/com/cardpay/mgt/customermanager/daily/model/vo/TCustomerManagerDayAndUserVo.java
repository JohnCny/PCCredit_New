package com.cardpay.mgt.customermanager.daily.model.vo;

import java.util.Date;

public class TCustomerManagerDayAndUserVo {

    /**
     * 客户经理id
     */
    private Integer customerManagerId;

    /**
     * 日报时间(yyyy-mm-dd)
     */
    private Date dailyTime;

    /**
     * 用户姓名
     */
    private String userCname;

    /**
     * 员工号
     */
    private String employeeNumber;

    public String getUserCname() {
        return userCname;
    }

    public void setUserCname(String userCname) {
        this.userCname = userCname;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    /**
     * 获取客户经理id
     *
     * @return CUSTOMER_MANAGER_ID - 客户经理id
     */
    public Integer getCustomerManagerId() {
        return customerManagerId;
    }

    /**
     * 设置客户经理id
     *
     * @param customerManagerId 客户经理id
     */
    public void setCustomerManagerId(Integer customerManagerId) {
        this.customerManagerId = customerManagerId;
    }

    /**
     * 获取日报时间(yyyy-mm-dd)
     *
     * @return DAILY_TIME - 日报时间(yyyy-mm-dd)
     */
    public Date getDailyTime() {
        return dailyTime;
    }

    /**
     * 设置日报时间(yyyy-mm-dd)
     *
     * @param dailyTime 日报时间(yyyy-mm-dd)
     */
    public void setDailyTime(Date dailyTime) {
        this.dailyTime = dailyTime;
    }

}