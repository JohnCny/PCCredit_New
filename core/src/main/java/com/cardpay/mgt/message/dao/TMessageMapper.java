package com.cardpay.mgt.message.dao;

import com.cardpay.mgt.message.model.po.TMessage;
import tk.mybatis.mapper.common.Mapper;

public interface TMessageMapper extends Mapper<TMessage> {
    /**
     * 查询消息数
     * @param userId 用户id
     * @return 已读消息个数
     */
    Integer getMessageByState(Integer userId, Integer msgState);
}