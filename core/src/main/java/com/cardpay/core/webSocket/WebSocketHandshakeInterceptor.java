package com.cardpay.core.webSocket;

import com.cardpay.basic.common.constant.Constant;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.core.shiro.common.ShiroKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * websocket 握手协议实现类
 * @author johnmyiqn
 */
public class WebSocketHandshakeInterceptor extends HttpSessionHandshakeInterceptor {
    @Autowired
    private LogTemplate logger;

    /**
     * 握手协议之前调用函数
     * @param request  request对象
     * @param response response独享
     * @param wsHandler  WebSocketHandler握手对象
     * @param attributes 属性值
     * @return true 为成功，false为失败
     * @throws Exception 握手异常
     */
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        logger.info(WebSocketHandshakeInterceptor.class, "", "websocket before handshake");

        if (request instanceof ServerHttpRequest){
            ServletServerHttpRequest servletRequest = (ServletServerHttpRequest) request;
            HttpSession session = servletRequest.getServletRequest().getSession(false);
            if (session!=null){
                Integer userId = ShiroKit.getUserId();
                if (userId!=null){
                     attributes.put(Constant.WEBSOCKET_USERID, userId);
                }
            }
        }
        return super.beforeHandshake(request, response, wsHandler, attributes);
    }

    /**
     * 握手协议后调用函数
     * @param request   request对象
     * @param response  response对象
     * @param wsHandler WebSocketHandler握手对象
     * @param exception 异常对象
     */
    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
        logger.info(WebSocketHandshakeInterceptor.class, "", "websocket After handshake");
        super.afterHandshake(request, response, wsHandler, exception);
    }
}
