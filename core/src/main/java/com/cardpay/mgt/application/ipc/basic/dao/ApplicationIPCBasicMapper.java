package com.cardpay.mgt.application.ipc.basic.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.application.ipc.basic.model.IPCMenu;
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
     * @param templateType 模版类型
     * @return 影响数量
     */
    Integer initNormalTemplate(@Param("applicationId") Integer applicationId,@Param("templateType") Integer templateType);


    /**
     * 查询该进件的模板类型
     * @param applicationId 进件id
     * @return
     */
    List<Integer> selectTemplateTypeByApplicationId(@Param("applicationId") Integer applicationId);

    /**
     * IPC 菜单
     *
     * @param applicationId 进件Id
     * @return 菜单
     */
    List<IPCMenu> selectIPCMenu(@Param("applicationId") Integer applicationId);
}
