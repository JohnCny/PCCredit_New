package com.cardpay.mgt.application.enums;

/**
 * 进件状态枚举类
 *
 * @author chenkai
 */
public enum ApplicationStatus {
    /**
     * 未完成
     */
    APP_UNFINISHED("未完成", 0),
    /**
     * 禁入
     */
    APP_PROHIBITION("禁入", 1),
    /**
     * 待审核
     */
    APP_PENDING("待审核", 2),
    /**
     * 审核通过
     */
    APP_ADOPT("审核通过", 3),
    /**
     * 审核未通过
     */
    APP_REJECT("审核未通过", 4),

    /**
     * 已放贷
     */
    APP_LENDING("已放贷", 5);

    private int value;
    private String key;

    ApplicationStatus(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }
}
