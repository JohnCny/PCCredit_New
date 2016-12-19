package com.cardpay.basic.util;

import javax.servlet.http.HttpServletRequest;

/**
 * ajax工具类
 * @author johnmyiqn
 */
public class AjaxUtil {

    public static Boolean isAjax(HttpServletRequest request){
        Boolean result = Boolean.TRUE;
         /*判断是否ajax请求*/
        if (!(request.getHeader("accept").indexOf("application/json") > -1
                || (request.getHeader("X-Requested-With") != null
                && request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1))) {
            result = Boolean.FALSE;
        }
        return result;
    }
}
