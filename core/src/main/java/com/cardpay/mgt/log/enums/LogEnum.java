package com.cardpay.mgt.log.enums;

/**
 * 日志枚举类
 *
 * @author rankai
 *         createTime 2016-12-2016/12/27 13:53
 */
public enum LogEnum {
    UNKNOWN_ACCOUNT(1),
    USER_PWD_ERROR(2),
    LOCKED_ACCOUNT(3),
    DISABLED_ACCOUNT(4),
    SUCCESS(5);

    private int value; // 自定义数据域，private为了封装

    LogEnum(int val) {
        this.value = val;
    }

    /**
     * 获取对应的值
     *
     * @return 对应值value
     */
    public int getValue() {
        return value;
    }
}
