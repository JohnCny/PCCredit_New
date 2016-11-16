package com.cardpay.basic.base.controller;

import com.cardpay.basic.common.propertyeditor.StringEscapeEditor;
import com.cardpay.basic.util.DozerUtil;
import com.cardpay.basic.util.LogUtil;
import org.slf4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.awt.SystemColor.info;

/**
 * Created by johnmyiqn on 2016/11/10.
 */
public class BasicController {
    protected static final Logger logger = LogUtil.get();

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
            return null;
        }
        return request.getContextPath() + (url == null ? "" : url);
    }

}
