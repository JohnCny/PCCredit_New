package com.cardpay.mgt.application.ipc.normal.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.application.ipc.normal.model.TTemplateGroup;
import com.cardpay.mgt.application.ipc.normal.model.vo.TemplateGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 一般进件模板Mapper
 *
 * @author yanwe
 *         createTime 2017-01-2017/1/12 9:53
 */
public interface NormalTemplateMapper extends BasicMapper<TTemplateGroup>{
    /**
     * 根据模板和进件id查询树
     *
     * @param applicationId 进件Id
     * @param templateId 模板Id
     * @return 模板树
     */
    List<TemplateGroup> selectGroupEntrance(@Param("applicationId") Integer applicationId, @Param("templateId") Integer templateId);
}
