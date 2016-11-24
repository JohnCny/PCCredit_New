package com.cardpay.core.business.message.dao;

import com.cardpay.basic.base.mapper.BaseMapper;
import com.cardpay.core.business.message.model.po.TMessage;

public interface TMessageMapper extends BaseMapper<TMessage> {
    /**
     * 查询消息数
     * @param userId 用户id
     * @return 已读消息个数
     */
    Integer getMessageByState(Integer userId, Integer msgState);
}