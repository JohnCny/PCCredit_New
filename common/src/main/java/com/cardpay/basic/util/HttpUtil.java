package com.cardpay.basic.util;

import com.cardpay.basic.common.log.LogTemplate;
import javax.servlet.http.HttpServletRequest;

/**
 * 获取IP地址
 * @author johnmyiqn
 */
public class HttpUtil {

    /**
     * 获取客户端IP地址.<br>
     * 支持多级反向代理
     *
     * @param request HttpServletRequest
     * @return 客户端真实IP地址
     */
    public static String getRemoteAddr(final HttpServletRequest request) {
        try{
            String remoteAddr = request.getHeader("X-Forwarded-For");
            // 如果通过多级反向代理，X-Forwarded-For的值不止一个，而是一串用逗号分隔的IP值，此时取X-Forwarded-For中第一个非unknown的有效IP字符串
            if (isEffective(remoteAddr) && (remoteAddr.indexOf(",") > -1)) {
                String[] array = remoteAddr.split(",");
                for (String element : array) {
                    if (isEffective(element)) {
                        remoteAddr = element;
                        break;
                    }
                }
            }
            if (!isEffective(remoteAddr)) {
                remoteAddr = request.getHeader("X-Real-IP");
            }
            if (!isEffective(remoteAddr)) {
                remoteAddr = request.getRemoteAddr();

            }
            return remoteAddr;
        }catch(Exception e){
            LogTemplate.error(HttpUtil.class, e, "get romote ip error,error message:{}", e.getMessage());
            return "";
        }
    }

    /**
     * 获取客户端源端口
     * @param request  HttpServletRequest
     * @return   客户端真实端口号
     */
    public static Long getRemotePort(final HttpServletRequest request){
        try{
            String port = request.getHeader("remote-port");
            //字符串不为空
            if(port!=null) {
                try{
                    return Long.parseLong(port);
                }catch(NumberFormatException ex){
                    LogTemplate.error(HttpUtil.class, ex, "convert port to long error , port:{}", port);
                    return 0l;
                }
            }else{
                return 0l;
            }
        }catch(Exception e){
            LogTemplate.error(HttpUtil.class, e, "get romote port error,error message:{}", e.getMessage());
            return 0l;
        }
    }

    /**
     * 远程地址是否有效.
     *
     * @param remoteAddr 远程地址
     * @return true代表远程地址有效，false代表远程地址无效
     */
    private static boolean isEffective(final String remoteAddr) {
        boolean isEffective = false;
        if ((null != remoteAddr) && (!"".equals(remoteAddr.trim()))
                && (!"unknown".equalsIgnoreCase(remoteAddr.trim()))) {
            isEffective = true;
        }
        return isEffective;
    }

    /**
     * 获取用户真实IP地址，不使用request.getRemoteAddr();的原因是有可能用户使用了代理软件方式避免真实IP地址,
     *
     * 可是，如果通过了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP值，究竟哪个才是真正的用户端的真实IP呢？
     * 答案是取X-Forwarded-For中第一个非unknown的有效IP字符串。
     *
     * 如：X-Forwarded-For：192.168.1.110, 192.168.1.120, 192.168.1.130,
     * 192.168.1.100
     *
     * 用户真实IP为： 192.168.1.110
     *
     * @param request  HttpServletRequest
     * @return 客户端真实IP地址
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}