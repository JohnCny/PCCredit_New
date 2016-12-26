package com.cardpay.core.rabbitmq;

/**
 * rabbit消息实体
 * @author johnmyiqn
 */

public class RabbitMqMessage {
    /**
     * 消息级别
     */
    private Integer msgRank;
    /**
     * 消息类型
     */
    private Integer msgType;
    /**
     * Json string对象(客户端根据需要解析数据)
     */
    private String message;
    /**
     * Json string对象(客户端根据需要解析数据)
     */
    private String messageTitle;
    /**
     * 消息ID
     */
    private Long id;
    /**
     * 发送给用户user_id
     */
    private Integer userId;
    /**
     * 发送范围(0为发给全部用户，1位发送给指定用户)
     */
    private Integer limit;

    /**
     * 消息队列
     */
    public RabbitMqMessage() {
        this.msgRank = 0;
        this.msgType = 0;
        this.message = "";
        this.id = (long) -1;
        this.userId = -1;
        this.limit = 0;
    }

    public Integer getMsgRank() {
        return msgRank;
    }

    public void setMsgRank(Integer msgRank) {
        this.msgRank = msgRank;
    }

    public Integer getMsgType() {
        return msgType;
    }

    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "RabbitMqMessage{" +
                "msgRank=" + msgRank +
                ", msgType=" + msgType +
                ", message='" + message + '\'' +
                ", messageTitle='" + messageTitle + '\'' +
                ", id=" + id +
                ", userId=" + userId +
                ", limit=" + limit +
                '}';
    }
}
