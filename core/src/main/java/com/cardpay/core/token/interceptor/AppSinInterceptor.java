package com.cardpay.core.token.interceptor;

import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.core.token.common.TokenKit;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.Map;

/**
 * AppSin拦截器
 *
 * @author rankai .
 */
public class AppSinInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String apiKeyName = TokenKit.API_KEY_NAME;
        String apiTimeName = TokenKit.API_TIME_NAME;
        String apiKey = request.getParameter(apiKeyName);
        String apiTime = request.getParameter(apiTimeName);
        LogTemplate.info(this.getClass(), "apiKey", apiKey);
        LogTemplate.info(this.getClass(), "apiTime", apiTime);
        TokenKit.outputMessage(response, ResultEnum.PARAM_ERROR);
        if (StringUtils.isEmpty(apiKey) || StringUtils.isEmpty(apiTime)) {
            LogTemplate.info(this.getClass(), "message", "appSin参数为空");
            TokenKit.outputMessage(response, ResultEnum.PARAM_ERROR);
            return Boolean.FALSE;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        long time = simpleDateFormat.parse(apiTime).getTime();
        long nowTime = new Date().getTime();
        if (time - nowTime < 0) {
            LogTemplate.info(this.getClass(), "message", "API请求超时");
            TokenKit.outputMessage(response, ResultEnum.API_TIMEOUT);
            return Boolean.FALSE;
        }
        Enumeration<String> parameterNames = request.getParameterNames();
        Map<String, String> map = new HashedMap();
        while (parameterNames.hasMoreElements()) {
            String mapKey = parameterNames.nextElement();
            if (mapKey.equals(apiKeyName) || mapKey.equals(apiTimeName)) {
                continue;
            }
            map.put(mapKey, request.getParameter(mapKey));
        }
        String appSin = TokenKit.getAppSin(map);
        if (!apiKey.equals(appSin)) {
            LogTemplate.info(this.getClass(), "message", "appSin值不匹配");
            TokenKit.outputMessage(response, ResultEnum.APPSIN_INCOMPATIBLE);
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
