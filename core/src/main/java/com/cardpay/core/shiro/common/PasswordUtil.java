package com.cardpay.core.shiro.common;

import com.cardpay.mgt.user.model.User;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * 密码工具类,对密码进行加密
 * @author rankai
 */
public class PasswordUtil {

    /**
     * 加密方式
     */
    private static final String HASHA_LGORITHM_NAME = "md5";
    /**
     * 加密次数
     */
    private static final int HASH_ITERATIONS = 1024;
    /**
     * 默认盐值
     */
    private static final String SALT_SOURCE = "qkjr123";

    /**
     * 将传入的字符串的密码加密
     *
     * @param password 密码字符串
     * @return 加密后的字符串
     */
    public static String encryptPassword(String password) {
        ByteSource salt = new Md5Hash(SALT_SOURCE);
        return new SimpleHash(HASHA_LGORITHM_NAME, password, salt, HASH_ITERATIONS).toString();
    }

    /**
     * 将传入的User对象中的密码属性进行加密
     *
     * @param user User对象
     * @return 加密后的字符串
     */
    public static String encryptPassword(User user) {
        ByteSource salt = new Md5Hash(SALT_SOURCE);
        return new SimpleHash(HASHA_LGORITHM_NAME, user.getPassword(), salt, HASH_ITERATIONS).toString();
    }
}
