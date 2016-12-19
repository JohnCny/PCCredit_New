package com.cardpay.mgt.param.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.param.model.po.TBusinessParam;


/**
 * 业务参数
 * @author wangpeng
 */
public interface TBusinessParamMapper extends BasicMapper<TBusinessParam> {
    /**
     * 根据消息名称获取消息实体
     * @param name 消息名
     * @return 消息实体
     */
    TBusinessParam getByName(String name);
}