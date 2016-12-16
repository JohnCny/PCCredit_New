package com.cardpay.basic.base.controller;

import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.basic.common.propertyeditor.StringEscapeEditor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 基础controller接口，防止xxs攻击
 * @author johnmyiqn
 */
public class BasicController {
    @Autowired
    LogTemplate logger;

    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        /**
         * 自动转换日期类型的字段格式
         */
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
        /**
         * 防止XSS攻击
         */
        binder.registerCustomEditor(String.class, new StringEscapeEditor(true, false));
    }
    /**
     * 获取基于应用程序的url绝对路径
     *
     * @param request HttpServletRequest
     * @param url url地址
     * @return 基于应用程序的url绝对路径
     */
    public final String getAppbaseUrl(HttpServletRequest request, String url) {
        if (request == null) {
            logger.info(BasicController.class,"request获取url绝对路径出现错误,request is null",null);
            return null;
        }
        return request.getContextPath() + (url == null ? "" : url);
    }

}
