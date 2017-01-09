package com.cardpay.mgt.application.basic.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.application.balancecross.model.TTemplateGroup;

/**
 * 进件IPC财务报表基础操作Mapper
 *
 * @author yanwe
 *         createTime 2017-01-2017/1/6 9:30
 */
public interface ApplicationIPCBasicMapper extends BasicMapper<TTemplateGroup> {

    /**
     * 初始化进件模版
     *
     * @param applicationId 进件Id
     * @param templateId 模版Id
     * @return 影响数量
     */
    Integer initBalanceCrossTemplate(Integer applicationId,Integer templateId);
}
