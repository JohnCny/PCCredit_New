package com.cardpay.mgt.param.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.param.model.po.TBusinessParam;


/**
 * 业务参数服务类
 * @author wangpeng
 */
public interface ParamService extends BaseService<TBusinessParam> {
    /**
     * 根据消息名称获取消息实体
     * @param name 消息名
     * @return 消息实体
     */
    TBusinessParam getByName(String name);
}
