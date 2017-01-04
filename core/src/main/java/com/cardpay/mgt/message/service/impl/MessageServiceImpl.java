package com.cardpay.mgt.message.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.mgt.message.dao.TMessageMapper;
import com.cardpay.mgt.message.model.TMessage;
import com.cardpay.mgt.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.WebSocketSession;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.cardpay.core.webSocket.SystemWebSocketHandler.sendMessageToUser;
import static com.cardpay.core.webSocket.SystemWebSocketHandler.sendMessageToUsers;
import static com.cardpay.core.webSocket.SystemWebSocketHandler.webSocketSessions;
import static com.cardpay.mgt.message.service.impl.MessageStatus.*;

enum MessageStatus {
    /**
     * 不广播
     */
    BROADCAST_NO(0),
    /**
     * 广播
     */
    BROADCAST_YES(1),
    /**
     * 已读
     */
    MSG_STATE_READ(1),
    /**
     * 未读
     */
    MSG_STATE(0);
    /**
     * 获取value值
     */
    private int value;

    MessageStatus(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

/**
 * 消息服务实现类
 *
 * @author yanweichen
 */
@Service
public class MessageServiceImpl extends BaseServiceImpl<TMessage> implements MessageService {
    @Autowired
    private TMessageMapper tMessageDao;

    @Override
    public Integer getReadMessage(Integer userId, Integer mark) {
        return tMessageDao.getMessageByState(userId, mark);
    }

    @Override
    public int sendMessage(String title, String content, int userId, int type, int level) {
        TMessage tMessage = new TMessage();
        tMessage.setMsgTitle(title);
        tMessage.setMsgContent(content);
        tMessage.setMsgType(type);
        tMessage.setMsgLevel(level);
        tMessage.setMsgState(MSG_STATE.getValue());
        tMessage.setUserId(userId);
        tMessage.setCreateTime(new Date());
        tMessage.setIsBroadcast(BROADCAST_NO.getValue());
        tMessageDao.insertSelective(tMessage);
        String jsonMessage = messageJsonToString(tMessage.getId(), title, content, BROADCAST_NO.getValue());
        sendMessageToUser(userId, jsonMessage);
        return tMessage.getId();
    }

    @Override
    public void sendMessageAll(String title, String content, int type, int level) {
        List<TMessage> list = new ArrayList<>();
        for (Map.Entry<Integer, WebSocketSession> entity : webSocketSessions.entrySet()) {
            Integer id = entity.getKey();
            TMessage tMessage = new TMessage();
            tMessage.setMsgTitle(title);
            tMessage.setMsgContent(content);
            tMessage.setMsgType(type);
            tMessage.setMsgLevel(level);
            tMessage.setMsgState(MSG_STATE.getValue());
            tMessage.setUserId(id);
            tMessage.setCreateTime(new Date());
            tMessage.setIsBroadcast(BROADCAST_YES.getValue());
            list.add(tMessage);
        }
        tMessageDao.batchInsert(list);
        String jsonMessage = messageJsonToString(0, title, content, BROADCAST_YES.getValue());
        sendMessageToUsers(jsonMessage);
    }

    /**
     * 消息Json拼装
     *
     * @param messageId   消息ID
     * @param title       消息头
     * @param content     消息体
     * @param isBroadcast 是否为推送消息
     * @return 消息String类型
     */
    private String messageJsonToString(Integer messageId, String title, String content, int isBroadcast) {
        JSONObject jsonMessage = new JSONObject();
        jsonMessage.put("messageId", messageId);
        jsonMessage.put("messageTitle", title);
        jsonMessage.put("messageContent", content);
        jsonMessage.put("isBroadcast", isBroadcast);
        return jsonMessage.toJSONString();
    }

    @Override
    public int setMessageIfRead(int messageId) {
        TMessage tMessage = new TMessage();
        tMessage.setId(messageId);
        tMessage.setMsgState(MSG_STATE_READ.getValue());
        return tMessageDao.updateByPrimaryKeySelective(tMessage);
    }

    @Override
    public List<TMessage> queryBroadcastMessage(int userId) {
        TMessage tMessage = new TMessage();
        tMessage.setUserId(userId);
        tMessage.setIsBroadcast(BROADCAST_YES.getValue());
        return tMessageDao.selectAll();
    }


}
