package com.cardpay.basic.token.common;

import com.alibaba.fastjson.JSON;
import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.context.ContextProperty;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.mgt.user.model.User;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import java.util.UUID;

/**
 * token工具类
 *
 * @author rankai
 */
public class TokenKit {

    /**
     * User对象在session的key
     */
    public static final String USER_SESSION_KEY = "userSession";
    /**
     * 登陆过期时间(单位:秒)
     */
    public static final int LOGIN_TIMEOUT_TIME = 7 * 24 * 60 * 60;
    /**
     * token的名称
     */
    public static final String TOKEN_KEY_NAME = "token";
    /**
     * apiKey的名称
     */
    public static final String API_KEY_NAME = "apiKey";
    /**
     * apiTime的名称
     */
    public static final String API_TIME_NAME = "apiTime";
    /**
     * APP_KEY值
     */
    private static final String APP_SALT;

    static {
        String property = (String) ContextProperty.getContextProperty("app_key");
        APP_SALT = property == null ? "qkjr420" : property;
    }

    /**
     * 获取getAppSin
     *
     * @param map request中的参数map
     * @return 加密后的AppSin
     */
    public static String getAppSin(Map<String, String> map) {
        return encryption(mapToString(sortMapByKey(map)), APP_SALT, 3);
    }

    /**
     * 字符串MD5加密
     *
     * @param string 要加密的字符串
     * @param salt   盐值
     * @param count  循环次数(最多64次)
     * @return 加密后的字符串
     */
    public static String encryption(String string, String salt, int count) {
        for (int i = 0; i < (count > 64 ? 64 : count); i++) {
            string = md5Code(string);
            salt = md5Code(salt);
        }
        String reverseString = new StringBuffer(salt).reverse().toString();
        char[] stringCharArray = string.toCharArray();
        char[] reverseStringCharArray = reverseString.toCharArray();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < stringCharArray.length; i++) {
            stringBuffer.append(stringCharArray[i]).append(reverseStringCharArray[i]);
        }
        return stringBuffer.toString();
    }

    /**
     * 生成tokenKey
     *
     * @return 返回UUID值
     */
    public static String generatorUUID() {
        return String.valueOf(UUID.randomUUID());
    }

    /**
     * 获取session中保存的User信息
     *
     * @return Session中保存的User信息
     */
    public static User getUser() {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Object attribute = request.getSession().getAttribute(USER_SESSION_KEY);
        return attribute == null ? null : (User) attribute;
    }

    /**
     * 获取session中保存的UserId信息
     *
     * @return Session中保存的UserId信息
     */
    public static Integer getUserId() {
        User user = getUser();
        return user == null ? null : user.getId();
    }

    /**
     * response方法
     *
     * @param response   HttpServletResponse
     * @param resultEnum ResultEnum
     */
    public static void outputMessage(HttpServletResponse response, ResultEnum resultEnum) {
        String json = JSON.toJSONString(new ResultTo(resultEnum));
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/json");
        ServletOutputStream servletOutputStream;
        try {
            servletOutputStream = response.getOutputStream();
            servletOutputStream.write(json.getBytes("utf-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param map
     * @return
     */
    private static String mapToString(Map<String, String> map) {
        StringBuffer stringBuffer = new StringBuffer();
        int i = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (i != 0) {
                stringBuffer.append("&");
            }
            stringBuffer.append(entry.getKey()).append("=").append(entry.getValue());
            i++;
        }
        return stringBuffer.toString();
    }

    /**
     * 使用 Map按key进行排序
     *
     * @param map Map
     * @return 排序后的Map
     */
    private static Map<String, String> sortMapByKey(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        Map<String, String> sortMap = new TreeMap<>(new MapKeyComparator());
        sortMap.putAll(map);
        return sortMap;
    }

    /**
     * MD5加码 生成32位md5码
     *
     * @param password 要加密的字符串
     * @return 加密后的字符串
     */
    private static String md5Code(String password) {
        MessageDigest md5;
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

}

class MapKeyComparator implements Comparator<String>, Serializable {

    private static final long serialVersionUID = -6125210754527958613L;

    @Override
    public int compare(String str1, String str2) {
        return str1.compareTo(str2);
    }
}

