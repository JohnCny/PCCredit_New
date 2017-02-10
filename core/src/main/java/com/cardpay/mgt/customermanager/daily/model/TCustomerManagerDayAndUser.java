package com.cardpay.mgt.customermanager.daily.model;

import com.cardpay.mgt.user.model.User;

/**
 * 客户经理日报和客户经理信息
 *
 * @author yanwe
 *         createTime 2017-02-2017/2/10 14:04
 */
public class TCustomerManagerDayAndUser {

    /**
     * id
     */
    private Integer id;
    /**
     * 客户经理日报信息
     */
    private TCustomerManagerDay customerManagerDay;

    /**
     * 客户经理用户信息
     */
    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TCustomerManagerDay getCustomerManagerDay() {
        return customerManagerDay;
    }

    public void setCustomerManagerDay(TCustomerManagerDay customerManagerDay) {
        this.customerManagerDay = customerManagerDay;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
