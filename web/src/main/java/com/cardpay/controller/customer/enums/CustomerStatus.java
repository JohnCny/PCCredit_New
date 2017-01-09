package com.cardpay.controller.customer.enums;

/**
 * 客户状态
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/9 9:15
 */
public enum CustomerStatus {
    ORDINARY("正常",0),
    HIGH_RISK("高风险", 1),
    BLACKLIST("黑名单",2),
    FORBIDDEN("禁用", 3);

    private int value;
    private String key;

    CustomerStatus(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
