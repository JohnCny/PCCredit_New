package com.cardpay.core.shiro.enums;

/**
 * shrio相关的宏定义
 *
 * @author ramlaio
 */
public enum ShiroEnum {

    SUPER(1),
    ADMIN(2),
    MANAGER(3),
    EXPERT(4);

    private Integer value;

    ShiroEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
