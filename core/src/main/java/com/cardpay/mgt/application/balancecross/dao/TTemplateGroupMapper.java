package com.cardpay.mgt.application.balancecross.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.application.balancecross.model.TTemplateGroup;
import com.cardpay.mgt.application.balancecross.model.vo.BalanceCrossGroup;

import java.util.List;

public interface TTemplateGroupMapper extends BasicMapper<TTemplateGroup> {

    /**
     * 根据模板和进件id查询树
     *
     * @param applicationId 进件Id
     * @param templateId 模板Id
     * @return 模板树
     */
    List<BalanceCrossGroup> selectBalanceCross(Integer applicationId,Integer templateId);
}