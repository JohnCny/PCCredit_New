package com.cardpay.basic.util;

import org.apache.shiro.crypto.hash.Md5Hash;

import java.security.MessageDigest;

/**
 * MD5工具
 *
 * @author rankai
 */
public class MD5Util {

    /**
     * 加密解密算法 执行一次加密，两次解密
     *
     * @param password 要加密的字符串
     * @return 加密后的字符串
     */
    public static String convertMD5(String password) {
        char[] a = password.toCharArray();
        for (int i = 0; i < a.length; i++) {
            a[i] = (char) (a[i] ^ 't');
        }
        String s = new String(a);
        return s;
    }

    public static String md5CodeByCommons(String password, String salt) {
        //return Md5Crypt.apr1Crypt(password, salt);
        return null;
    }

    // 测试主函数
    public static void main(String args[]) {
        String s = "123456";
        System.out.println("原始：" + s);
        System.out.println("加密的：" + convertMD5(s));
        System.out.println("解密的：" + convertMD5(convertMD5(s)));
        System.out.println("Commons加密的：" + md5CodeByCommons(s, "kawins"));
        System.out.println("Shiro加密的：" + md5CodeByCommons(s, "kawins"));
    }
}