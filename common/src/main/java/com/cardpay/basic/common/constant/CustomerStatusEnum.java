package com.cardpay.basic.common.constant;

/**
 * ${DESCRIPTION}
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/13 15:12
 */
public enum CustomerStatusEnum {
    /**
     * 正常
     */
    ORDINARY("正常", 0),
    /**
     * 高风险用户
     */
    HIGH_RISK("高风险用户", 1),
    /**
     * 黑名单用户
     */
    BLACKLIST("黑名单用户", 2),
    /**
     * 高风险转黑名单审核
     */
    BLACKLIST_TO_HIGH_RISK("高风险转黑名单审核", 3),
    /**
     * 黑名单转出
     */
    BLACKLIST_OUT("黑名单转出", 4),
    /**
     * 禁用客户
     */
    FORBIDDEN("禁用客户", 5),
    /**
     * 客户移交中
     */
    TRANSFER("客户移交中", 6);
    private int value;
    private String key;

    CustomerStatusEnum(String key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
