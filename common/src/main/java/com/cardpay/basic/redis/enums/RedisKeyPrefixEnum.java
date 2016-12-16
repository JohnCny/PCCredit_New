package com.cardpay.basic.redis.enums;

/**
 * redis前缀,用模块化存储
 * @author rankai
 */

public enum RedisKeyPrefixEnum {
	/**
	 * 客户模块
	 */
	COMMON ("cardpay_"),
	/**
	 * 用户模块
	 */
	USER ("user_"),
	/**
	 * 产品模块
	 */
	PRODUCT ("product_"),
	/**
	 * 其他模块
	 */
	OTHER ("other_"),
	/**
	 * 消金模块
	 */
	CFS ("cfs_"),

	ROLE_MENU ("roleMenu_");

	private final String prefix;
	   
	RedisKeyPrefixEnum(String prefix) {
	     this.prefix = prefix;
	}
	
	public String getKeyPrefix() {
	     return prefix;
	}
}
