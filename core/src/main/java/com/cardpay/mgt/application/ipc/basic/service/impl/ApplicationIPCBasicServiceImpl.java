package com.cardpay.mgt.application.ipc.basic.service.impl;

import com.cardpay.basic.util.treeutil.TreeUtil;
import com.cardpay.mgt.application.enums.TemplateTypeEnum;
import com.cardpay.mgt.application.ipc.basic.dao.ApplicationIPCBasicMapper;
import com.cardpay.mgt.application.ipc.basic.model.IPCMenu;
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
    public Object selectGroupEntrance(Integer applicationId, Integer templateId,Integer templateType) {
        switch (TemplateTypeEnum.getTemplateTypeEnumById(templateType)){
            case NORMAL:
                List<TemplateGroup> normalTemplateGroups =
                        applicationIPCBasicMapper.selectGroupEntrance(applicationId, templateId);
                return normalTemplateGroups;
            case CASHFLOW_PROFIT:
                return null;
            default:
                break;
        }
        throw new IllegalArgumentException("模板类型错误");
    }

    @Override
    public List<IPCMenu> selectIPCMenu(Integer applicationId) {
        TreeUtil<IPCMenu> treeUtil = new TreeUtil<>("menuOrder",TreeUtil.ASC);
        List<IPCMenu> ipcMenus = applicationIPCBasicMapper.selectIPCMenu(applicationId);
        List<IPCMenu> resultMenu = treeUtil.getChildNodesByParentId(ipcMenus, 0);
        return resultMenu;
    }
}
