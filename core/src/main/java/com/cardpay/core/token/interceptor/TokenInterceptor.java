package com.cardpay.basic.token.interceptor;

import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.token.common.TokenFactory;
import com.cardpay.basic.token.common.TokenKit;
import com.cardpay.mgt.user.model.User;
import com.cardpay.mgt.user.model.UserToken;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * Token拦截器
 *
 * @author rankai
 */
public class TokenInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getParameter(TokenKit.TOKEN_KEY_NAME);
        TokenFactory tokenFactory = TokenFactory.get();
        Object tokenObject = tokenFactory.getRedisClient().get(token);
        UserToken selectOne = null;
        if (tokenObject == null) {
            UserToken userToken = new UserToken();
            userToken.setToken(token);
            selectOne = tokenFactory.getUserTokenService().selectOne(userToken);
            if (selectOne == null) {
                TokenKit.outputMessage(response, ResultEnum.NO_LOGIN);
                return Boolean.FALSE;
            }
            long expirationTime = selectOne.getExpirationTime().getTime();
            long nowTime = new Date().getTime();
            if (expirationTime - nowTime < 0) {
                TokenKit.outputMessage(response, ResultEnum.LOGIN_TIMEOUT);
                return Boolean.FALSE;
            }
        }
        HttpSession session = request.getSession();
        if (session.getAttribute(TokenKit.USER_SESSION_KEY) == null) {
            if (selectOne == null) {
                UserToken userToken = new UserToken();
                userToken.setToken(token);
                selectOne = tokenFactory.getUserTokenService().selectOne(userToken);
            }
            User user = tokenFactory.getUserService().selectByPrimaryKey(selectOne.getUserId());
            session.setAttribute(TokenKit.USER_SESSION_KEY, user);
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
