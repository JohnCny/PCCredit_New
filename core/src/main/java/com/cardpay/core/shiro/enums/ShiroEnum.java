package com.cardpay.core.shiro.enums;

/**
 * shrio相关的宏定义
 *
 * @author rankai
 */
public enum ShiroEnum {

    SUPER(1),
    ADMIN(2),
    MANAGER(3),
    EXPERT(4),
    /**
     * 团队负责人
     */
    TEAM_CHARGE(5);

    private Integer value;

    ShiroEnum(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public static ShiroEnum getEnumById(Integer value) {
        switch (value) {
            case 1:
                return SUPER;
            case 2:
                return ADMIN;
            case 3:
                return MANAGER;
            case 4:
                return EXPERT;
            case 5:
                return TEAM_CHARGE;
            default:
                break;
        }
        throw new IllegalArgumentException("未找到对应角色枚举");
    }
}
