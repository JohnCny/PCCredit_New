package com.cardpay.basic.common.interceptor.captcha;

import com.alibaba.fastjson.JSON;
import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.redis.RedisClient;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用于验证码的拦截器
 *
 * @author rankai .
 */
public class CaptchaInterceptor implements HandlerInterceptor {
    /**
     * 前端form表单中验证码input中的name属性的值
     */
    private static final String CAPTCHA_NAME = "captcha";
    /**
     * 验证码生成时,产生的cookie的key值
     */
    public static final String CAPTCHA_COOKIE_KEY = "captcha_cookie";

    @Autowired
    private RedisClient redisClient;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("++++++++++++++++++++++++++++++++++++++++++");

        String captchaValue = request.getParameter(CAPTCHA_NAME);
        if (StringUtils.isBlank(captchaValue)) {
            outputMessage(response, new ResultTo(ResultEnum.CAPTCHA_NULL.getValue()));
            return Boolean.FALSE;
        }
        Cookie[] cookies = request.getCookies();
        String key = "";
        for (Cookie cookie : cookies) {
            if (CAPTCHA_COOKIE_KEY.equals(cookie.getName())) {
                key = cookie.getValue();
                break;
            }
        }
//        Object object = redisClient.get(key);
        Object object = "1234";

        if (object == null) {
            outputMessage(response, new ResultTo(ResultEnum.CAPTCHA_TIMEOUT.getValue()));
            return Boolean.FALSE;
        }
        if (!captchaValue.equals(object.toString())) {
            outputMessage(response, new ResultTo(ResultEnum.CAPTCHA_ERROR.getValue()));
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("++++++++++++++++++postHandle++++++++++++++++++++++++");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("+++++++++++++++++++++afterCompletion+++++++++++++++++++++");
    }

    private void outputMessage(HttpServletResponse response, ResultTo resultTo) {
        String json = JSON.toJSONString(resultTo);
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
}
