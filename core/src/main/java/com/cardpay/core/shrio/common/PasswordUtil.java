package com.cardpay.core.shrio.common;

import com.cardpay.basic.util.MD5Util;
import com.cardpay.core.shrio.enums.ShrioEnum;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * 密码工具类,对密码进行加密
 *
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
     * 将传入的字符串的密码加密
     *
     * @param password 密码字符串
     * @return 加密后的字符串
     */
    public static String encryptPassword(String password, String saltSource) {
        ByteSource salt = new Md5Hash(saltSource);
        return new SimpleHash(HASHA_LGORITHM_NAME, password, salt, HASH_ITERATIONS).toString();
    }
}
