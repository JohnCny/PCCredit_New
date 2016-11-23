package com.cardpay.core.shrio.util;

import com.cardpay.basic.util.MD5Util;
import com.cardpay.core.shrio.enums.ShrioEnum;
import org.apache.shiro.crypto.hash.Md5Hash;

/**
 * 密码工具类,对密码进行加密
 *
 * @author rankai
 */
public class PasswordUtil {
    /**
     * 将传入的字符串的密码加密
     *
     * @param password 密码字符串
     * @return 加密后的字符串
     */
    public static String encryptPassword(String password) {
        return MD5Util.md5Code(new Md5Hash(MD5Util.md5Code(password), ShrioEnum.SALT).toString());
    }
}
