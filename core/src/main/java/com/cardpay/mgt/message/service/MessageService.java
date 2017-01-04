package com.cardpay.mgt.message.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.message.model.TMessage;

import java.util.List;

/**
 * 消息服务类
 * @author yanweichen
 */
public interface MessageService extends BaseService<TMessage> {
    /**
     * 查询已读/未读消息数
     * @param userId 用户id
     * @param mark 已读/未读
     * @return 已读消息个数
     */
    Integer getReadMessage(Integer userId, Integer mark);

    /**
     * 给指定用户发送消息
     * @param title 消息标题
     * @param content 消息内容
     * @param userId 消息所属用户id
     * @param type 消息类型(0 业务消息，1 非业务消息)
     * @param level 消息级别(0 正常消息，2 警告消息，3 错误消息)
     * @return 消息id
     */
    int sendMessage(String title, String content, int userId, int type, int level);

    /**
     * 给所有用户推送消息
     * @param title
     * @param content
     * @param type
     * @param level
     */
    void sendMessageAll(String title, String content, int type, int level);

    /**
     * 设置消息已读
     * @param messageId 消息ID
     * @return 数据库变记录
     */
    int setMessageIfRead(int messageId);

    /**
     * 查询指定用户广播消息
     * @param userId 用户id
     * @return 广播消息
     */
    List<TMessage> queryBroadcastMessage(int userId);
}
