package com.cardpay.basic.common.webSocket;

import com.cardpay.basic.common.log.LogTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
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
@Component
public class SystemWebSocketHandler extends TextWebSocketHandler {
    @Autowired
    private static LogTemplate logger;

    private static final List<WebSocketSession> users;

    private static final Map<Integer, WebSocketSession> webSocketSessions;

    static {
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
        logger.debug(SystemWebSocketHandler.class, "客户端建立连接","connect to the websocket success......");
        //将客户信息添加到session,用于在线发送信息
        users.add(session);

        Integer userId = null;
        try {
            // userId = ShiroKit.getUser().getId();
            //userId = (Integer) session.getAttributes().get(Constant.WEBSOCKET_USERID);
        }catch (Exception e) {
            e.printStackTrace();
            logger.info(SystemWebSocketHandler.class, "异常原因", e.getMessage());
        }
        webSocketSessions.put(1, session);//用户上线
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
        logger.info(SystemWebSocketHandler.class, "消息内容", message.getPayload().toString());
    }

    /**
     * 连接异常
     * @param session session
     * @param exception 异常信息
     * @throws Exception 异常信息
     */
    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        logger.debug(SystemWebSocketHandler.class, "客户端连接异常","websocket connect closed.....");
        logger.info(SystemWebSocketHandler.class, "异常原因", exception.getMessage());
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
        logger.debug(SystemWebSocketHandler.class, "客户端连接关闭","websocket connect closed.....");
        logger.info(SystemWebSocketHandler.class, "关闭状态", closeStatus.toString());
        users.remove(session);
    }

    /**
     * 给所有在线用户推送消息
     * @param message 消息内容
     */
    public static void sendMessageToUsers(String message) {
        users.forEach(user->{
            if(user.isOpen()){
                try {
                    user.sendMessage(new TextMessage(message));
                    logger.debug(SystemWebSocketHandler.class, "给所有在线用户发消息","message send success......");
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.info(SystemWebSocketHandler.class, "失败原因", e.getMessage());
                }
            }
        });

    }

    /**
     * 给指定的用户推送消息
     * @param userId 用户id
     * @param message 消息内容
     */
    public static void sendMessageToUser(Integer userId, String message) {
        WebSocketSession session = webSocketSessions.get(userId);
        if (session.isOpen()){
            try {
                session.sendMessage(new TextMessage(message));
                    logger.debug(SystemWebSocketHandler.class, "给指定的用户发消息","message send success......");
            } catch (IOException e) {
                e.printStackTrace();
                logger.info(SystemWebSocketHandler.class, "失败原因", e.getMessage());
            }
        }
    }

}
