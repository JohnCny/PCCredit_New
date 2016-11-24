package com.cardpay.mgt.message.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.common.constant.ConstantMessage;
import com.cardpay.mgt.message.dao.TMessageMapper;
import com.cardpay.mgt.message.model.po.TMessage;
import com.cardpay.mgt.message.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 消息服务实现类
 * @author wangpeng
 */
public class MessageServiceImpl extends BaseServiceImpl<TMessage> implements MessageService{
    @Autowired
    private TMessageMapper tMessageDao;

    /**
     * 查询已读消息数
     * @param userId 用户id
     * @return 已读消息个数
     */
    @Override
    public Integer getReadMessage(Integer userId){
        return tMessageDao.getMessageByState(userId, ConstantMessage.MSG_READ);
    }

    /**
     * 查询未读消息数
     * @param userId 用户id
     * @return 未读消息个数
     */
    @Override
    public Integer getUnreadMessage(Integer userId){
        return tMessageDao.getMessageByState(userId, ConstantMessage.MSG_UNREAD);
    }
}
