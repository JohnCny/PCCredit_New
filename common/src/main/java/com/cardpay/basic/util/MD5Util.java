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
     * MD5加码 生成32位md5码
     *
     * @param password 要加密的字符串
     * @return 加密后的字符串
     */
    public static String md5Code(String password) {
        MessageDigest md5 = null;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
        char[] charArray = password.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        for (int i = 0; i < charArray.length; i++)
            byteArray[i] = (byte) charArray[i];
        byte[] md5Bytes = md5.digest(byteArray);
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16)
                hexValue.append("0");
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();

    }

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

    public static String md5CodeByShiro(String password, String salt) {
        return md5Code(new Md5Hash(md5Code(password), salt).toString());
    }

    // 测试主函数
    public static void main(String args[]) {
        String s = "123456";
        System.out.println("原始：" + s);
        System.out.println("MD5后：" + md5Code(s));
        System.out.println("加密的：" + convertMD5(s));
        System.out.println("解密的：" + convertMD5(convertMD5(s)));
        System.out.println("Commons加密的：" + md5CodeByCommons(s, "kawins"));
        System.out.println("Shiro加密的：" + md5CodeByCommons(s, "kawins"));
    }
}