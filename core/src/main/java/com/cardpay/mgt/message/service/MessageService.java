package com.cardpay.mgt.message.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.message.model.po.TMessage;

/**
 * 消息服务类
 * @author yanweichen
 */
public interface MessageService extends BaseService<TMessage> {
    /**
     * 查询已读消息数
     * @param userId 用户id
     * @return 已读消息个数
     */
    Integer getReadMessage(Integer userId);

    /**
     * 查询未读消息数
     * @param userId 用户id
     * @return 未读消息个数
     */
    Integer getUnreadMessage(Integer userId);
}
