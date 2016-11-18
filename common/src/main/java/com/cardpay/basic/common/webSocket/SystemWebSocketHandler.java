package com.cardpay.basic.common.webSocket;

import com.cardpay.basic.common.constant.Constant;
import com.cardpay.basic.common.log.LogBase;
import org.slf4j.Logger;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * WebSocket消息发送处理对象
 * Created by chenkai on 2016/11/17.
 */
public class SystemWebSocketHandler extends TextWebSocketHandler {
    private static final Logger logger;

    private static final List<WebSocketSession> users;

    private static final Map<Integer, WebSocketSession> webSocketSessions;

    static {
        logger= LogBase.get();
        users = new ArrayList<>();
        webSocketSessions = new HashMap<>();
    }

    /**
     * 客户端建立连接
     * @param session  session
     * @throws Exception 异常信息
     */
    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        if (logger.isDebugEnabled()){
            logger.debug("connect to the websocket success......");
        }
        //将客户信息添加到session,用于在线发送信息
        users.add(session);

        Integer userId = null;
        try {
            // userId = ShiroKit.getUser().getId();
            userId = (Integer) session.getAttributes().get(Constant.WEBSOCKET_USERID);
        }catch (Exception e) {
            e.printStackTrace();
            logger.info(e.getMessage());
        }
        webSocketSessions.put(userId, session);//用户上线
    }

    /**
     * 接受客户端信息
     * @param session session
     * @param message 信息
     * @throws Exception
     */
    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage message)
            throws Exception {
        session.sendMessage(new TextMessage(message.getPayload().toString()));
        logger.info(message.getPayload().toString());
    }

    /**
     * 连接异常
     * @param session session
     * @param exception 异常信息
     * @throws Exception 异常信息
     */
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        if (logger.isDebugEnabled()){
            logger.debug("websocket connect closed......");
        }
        logger.info(exception.getMessage());
        users.remove(session);
    }

    /**
     * 关闭连接
     * @param session session
     * @param closeStatus 关闭状态
     * @throws Exception 异常信息
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus) throws Exception {
        if (logger.isDebugEnabled()){
            logger.debug("websocket connect closed......");
        }
        users.remove(session);
    }

    /**
     * 给所有在线用户发消息
     * @param message 消息
     */
    public void sendMessageToUsers(String message) {
        users.forEach(user->{
                if(user.isOpen()){
                    try {
                        user.sendMessage(new TextMessage(message));
                        if (logger.isDebugEnabled()){
                            logger.debug("message send success......");
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        logger.info(e.getMessage());
                    }
                }
        });

    }

    /**
     * 给指定的用户发消息
     * @param userId 用户id
     * @param message 消息
     */
    public void sendMessageToUser(Integer userId, String message) {
            WebSocketSession session = webSocketSessions.get(userId);
        if (session.isOpen()){
            try {
                session.sendMessage(new TextMessage(message));
                if (logger.isDebugEnabled()){
                    logger.debug("message send success........");
                }
            } catch (IOException e) {
                e.printStackTrace();
                logger.info(e.getMessage());
            }
        }
    }

}
