package com.cardpay.mgt.application.balancecross.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.application.balancecross.model.TTemplateGroup;
import com.cardpay.mgt.application.balancecross.model.vo.BalanceCrossGroup;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TTemplateGroupMapper1 extends BasicMapper<TTemplateGroup> {

    /**
     * 根据模板和进件id查询树
     *
     * @param applicationId 进件Id
     * @param templateId 模板Id
     * @return 模板树
     */
    List<BalanceCrossGroup> selectBalanceCross(@Param("applicationId") Integer applicationId,@Param("templateId") Integer templateId);
}