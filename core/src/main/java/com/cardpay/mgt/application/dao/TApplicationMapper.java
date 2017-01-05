package com.cardpay.mgt.application.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.application.model.TApplication;
import com.cardpay.mgt.application.model.vo.TApplicationVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 进件基本信息表Mapper
 */
public interface TApplicationMapper extends BasicMapper<TApplication> {
    /**
     * 按客户经理Id查询进件信息
     * @param managerId 客户经理Id
     * @return 进件Vo列表
     */
    List<TApplicationVo> queryByManagerId(@Param("managerId") int managerId);

    /**
     * 按进件Id查询进件信息
     * @param applicationId 进件id
     * @return 进件Vo类
     */
    TApplicationVo queryByApplication(@Param("applicationId") int applicationId);
}