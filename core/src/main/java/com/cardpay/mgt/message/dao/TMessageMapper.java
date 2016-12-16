package com.cardpay.mgt.message.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.message.model.po.TMessage;
import org.apache.ibatis.annotations.Param;

/**
 * 消息管理mapper
 * @author johnmyiqn
 */
public interface TMessageMapper extends BasicMapper<TMessage> {
    /**
     * 查询消息数
     * @param userId 用户id
     * @return 已读消息个数
     */
    Integer getMessageByState(@Param("userId") Integer userId, @Param("msgState") Integer msgState);
}