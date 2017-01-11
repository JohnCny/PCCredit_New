package com.cardpay.mgt.application.ipc.basic.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.mgt.application.ipc.basic.dao.ApplicationIPCBasicMapper;
import com.cardpay.mgt.application.ipc.basic.service.ApplicationIPCBasicService;
import com.cardpay.mgt.application.ipc.normal.model.vo.TemplateGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 进件IPC基础操作Service实现类
 *
 * @author yanwe
 *         createTime 2017-01-2017/1/11 14:42
 */
@Service
public class ApplicationIPCBasicServiceImpl implements ApplicationIPCBasicService{

    @Autowired
    private ApplicationIPCBasicMapper applicationIPCBasicMapper;

    @Override
    public Integer initNormalTemplate(Integer applicationId, Integer templateId) {
        return applicationIPCBasicMapper.initNormalTemplate(applicationId,templateId);
    }

    @Override
    public List<TemplateGroup> selectGroupEntrance(Integer applicationId, Integer templateId) {
        return applicationIPCBasicMapper.selectGroupEntrance(applicationId,templateId);
    }
}
