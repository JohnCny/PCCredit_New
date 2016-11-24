package com.cardpay.core.business.message.model.po;

import com.cardpay.basic.base.model.GenericEntity;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import javax.persistence.*;

/**
 * 消息
 * @author wangpeng
 */
@Table(name = "T_MESSAGE")
public class TMessage extends GenericEntity<Integer>{
    /**
     * 消息id
     */
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 消息标题
     */
    @ApiModelProperty(value = "消息标题", required = true)
    @Column(name = "MSG_TITLE")
    private String msgTitle;

    /**
     * 消息内容
     */
    @ApiModelProperty(value = "消息内容", required = true)
    @Column(name = "MSG_CONTENT")
    private String msgContent;

    /**
     * 消息类型(0 业务消息，1 非业务消息)
     */
    @ApiModelProperty(value = "消息类型", required = true)
    @Column(name = "MSG_TYPE")
    private Integer msgType;

    /**
     * 消息级别(0 正常消息，2 警告消息，3 错误消息)
     */
    @ApiModelProperty(value = "消息级别", required = true)
    @Column(name = "MSG_LEVEL")
    private Integer msgLevel;

    /**
     * 消息状态(0 未读，1 已读)
     */
    @ApiModelProperty(value = "消息状态", required = true)
    @Column(name = "MSG_STATE")
    private Integer msgState;

    /**
     * 消息所属用户id
     */
    @ApiModelProperty(value = "消息所属用户id", required = true)
    @Column(name = "USER_ID")
    private Integer userId;

    /**
     * 消息发送时间
     */
    @ApiModelProperty(value = "消息发送时间", required = true)
    @Column(name = "CREATE_TIME")
    private Date createTime;

    /**
     * 是否是广播消息(0 不是，1 是)
     */
    @ApiModelProperty(value = "是否是广播消息", required = true)
    @Column(name = "IS_BROADCAST")
    private Integer isBroadcast;

    /**
     * 获取消息id
     *
     * @return ID - 消息id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置消息id
     *
     * @param id 消息id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取消息标题
     *
     * @return MSG_TITLE - 消息标题
     */
    public String getMsgTitle() {
        return msgTitle;
    }

    /**
     * 设置消息标题
     *
     * @param msgTitle 消息标题
     */
    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle;
    }

    /**
     * 获取消息内容
     *
     * @return MSG_CONTENT - 消息内容
     */
    public String getMsgContent() {
        return msgContent;
    }

    /**
     * 设置消息内容
     *
     * @param msgContent 消息内容
     */
    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent;
    }

    /**
     * 获取消息类型(0 业务消息，1 非业务消息)
     *
     * @return MSG_TYPE - 消息类型(0 业务消息，1 非业务消息)
     */
    public Integer getMsgType() {
        return msgType;
    }

    /**
     * 设置消息类型(0 业务消息，1 非业务消息)
     *
     * @param msgType 消息类型(0 业务消息，1 非业务消息)
     */
    public void setMsgType(Integer msgType) {
        this.msgType = msgType;
    }

    /**
     * 获取消息级别(0 正常消息，2 警告消息，3 错误消息)
     *
     * @return MSG_LEVEL - 消息级别(0 正常消息，2 警告消息，3 错误消息)
     */
    public Integer getMsgLevel() {
        return msgLevel;
    }

    /**
     * 设置消息级别(0 正常消息，2 警告消息，3 错误消息)
     *
     * @param msgLevel 消息级别(0 正常消息，2 警告消息，3 错误消息)
     */
    public void setMsgLevel(Integer msgLevel) {
        this.msgLevel = msgLevel;
    }

    /**
     * 获取消息状态(0 未读，1 已读)
     *
     * @return MSG_STATE - 消息状态(0 未读，1 已读)
     */
    public Integer getMsgState() {
        return msgState;
    }

    /**
     * 设置消息状态(0 未读，1 已读)
     *
     * @param msgState 消息状态(0 未读，1 已读)
     */
    public void setMsgState(Integer msgState) {
        this.msgState = msgState;
    }

    /**
     * 获取消息所属用户id
     *
     * @return USER_ID - 消息所属用户id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 设置消息所属用户id
     *
     * @param userId 消息所属用户id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 获取消息发送时间
     *
     * @return CREATE_TIME - 消息发送时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置消息发送时间
     *
     * @param createTime 消息发送时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取是否是广播消息(0 不是，1 是)
     *
     * @return IS_BROADCAST - 是否是广播消息(0 不是，1 是)
     */
    public Integer getIsBroadcast() {
        return isBroadcast;
    }

    /**
     * 设置是否是广播消息(0 不是，1 是)
     *
     * @param isBroadcast 是否是广播消息(0 不是，1 是)
     */
    public void setIsBroadcast(Integer isBroadcast) {
        this.isBroadcast = isBroadcast;
    }

    @Override
    public Integer getPK() {
        return id;
    }
}