package com.cardpay.mgt.application.ipc.basic.service;

import com.cardpay.mgt.application.exception.NoSuchApplicationTemplateError;
import com.cardpay.mgt.application.ipc.basic.model.IPCMenu;

import java.util.List;

/**
 * 进件IPC基础操作Service
 *
 * @author yanwe
 *         createTime 2017-01-2017/1/11 14:40
 */
public interface ApplicationIPCBasicService{

    /**
     * 初始化进件模版
     *
     * @param applicationId 进件Id
     * @return 影响数量
     */
    Integer initTemplate(Integer applicationId);

    /**
     * 根据模板和进件id查询树
     *
     * @param applicationId 进件Id
     * @param templateId 模板Id
     * @return 模板树
     */
    Object selectGroupEntrance(Integer applicationId, Integer templateId) throws NoSuchApplicationTemplateError;

    /**
     * IPC 菜单
     *
     * @param applicationId 进件Id
     * @return 菜单
     */
    List<IPCMenu> selectIPCMenu(Integer applicationId);
}
