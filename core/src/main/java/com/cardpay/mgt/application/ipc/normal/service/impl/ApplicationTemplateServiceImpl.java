package com.cardpay.mgt.application.ipc.normal.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.mgt.application.enums.TemplateTypeEnum;
import com.cardpay.mgt.application.ipc.normal.dao.TApplicationTemplateMapper;
import com.cardpay.mgt.application.ipc.normal.model.TApplicationTemplate;
import com.cardpay.mgt.application.ipc.normal.service.ApplicationTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * IPC模板Service实现类
 *
 * @author yanwe
 *         createTime 2017-01-2017/1/20 11:21
 */
@Service
public class ApplicationTemplateServiceImpl extends BaseServiceImpl<TApplicationTemplate> implements ApplicationTemplateService {

    @Autowired
    private TApplicationTemplateMapper applicationTemplateMapper;

    @Override
    public List<TApplicationTemplate> getApplicationFromList() {
        return getApplicationTemplateByType(TemplateTypeEnum.APPLICATION_FROM);
    }

    @Override
    public List<TApplicationTemplate> getApplicationTemplateByType(TemplateTypeEnum templateTypeEnum) {
        TApplicationTemplate applicationTemplate = new TApplicationTemplate();
        applicationTemplate.setTemplateType(templateTypeEnum.getTemplateType());
        List<TApplicationTemplate> applicationTemplateList = applicationTemplateMapper.select(applicationTemplate);
        return applicationTemplateList;
    }
}
