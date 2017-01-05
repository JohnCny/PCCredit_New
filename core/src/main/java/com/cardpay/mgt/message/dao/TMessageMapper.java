package com.cardpay.mgt.message.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.message.model.TMessage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 消息管理mapper
 * @author johnmyiqn
 */
public interface TMessageMapper extends BasicMapper<TMessage> {
    /**
     * 查询消息数
     * @param userId 用户id
     * @param msgState 消息状态
     * @return 已读消息个数
     */
    Integer getMessageByState(@Param("userId") Integer userId, @Param("msgState") Integer msgState);

    /**
     * 批量添加消息信息
     * @param list 消息信息集合
     * @return 数据库变更记录
     */
    int batchInsert(List<TMessage> list);
}