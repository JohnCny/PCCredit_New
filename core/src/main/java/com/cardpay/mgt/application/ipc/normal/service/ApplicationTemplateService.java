package com.cardpay.mgt.application.ipc.normal.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.application.enums.TemplateTypeEnum;
import com.cardpay.mgt.application.ipc.normal.model.TApplicationTemplate;

import java.util.List;

/**
 * IPC模板Service
 *
 * @author yanwe
 *         createTime 2017-01-2017/1/20 11:20
 */
public interface ApplicationTemplateService extends BaseService<TApplicationTemplate> {

    /**
     * 获得申请表模板列表
     *
     * @return 申请表模板
     */
    List<TApplicationTemplate> getApplicationFromList();

    /**
     * 根据IPC模板类型获取模板
     *
     * @param templateTypeEnum IPC模板类型
     * @return 模板列表
     */
    List<TApplicationTemplate> getApplicationTemplateByType(TemplateTypeEnum templateTypeEnum);
}
