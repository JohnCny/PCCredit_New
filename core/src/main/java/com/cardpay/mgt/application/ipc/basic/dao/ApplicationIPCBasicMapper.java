package com.cardpay.mgt.application.ipc.basic.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.application.ipc.normal.model.TTemplateGroup;
import com.cardpay.mgt.application.ipc.normal.model.vo.TemplateGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 进件IPC财务报表基础操作Mapper
 *
 * @author yanwe
 *         createTime 2017-01-2017/1/6 9:30
 */
public interface ApplicationIPCBasicMapper extends BasicMapper<TTemplateGroup>{

    /**
     * 初始化进件模版
     *
     * @param applicationId 进件Id
     * @param templateId 模版Id
     * @return 影响数量
     */
    Integer initNormalTemplate(Integer applicationId, Integer templateId);

    /**
     * 根据模板和进件id查询树
     *
     * @param applicationId 进件Id
     * @param templateId 模板Id
     * @return 模板树
     */
    List<TemplateGroup> selectGroupEntrance(@Param("applicationId") Integer applicationId, @Param("templateId") Integer templateId);
}
