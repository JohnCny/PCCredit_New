package com.cardpay.mgt.application.basic.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.application.basic.model.TApplication;
import com.cardpay.mgt.application.basic.model.vo.TApplicationVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 进件基本信息表Mapper
 */
public interface TApplicationMapper extends BasicMapper<TApplication> {
    /**
     * 按客户经理Id查询进件信息
     * @param map 客户经理Id
     * @return 进件Vo列表
     */
    List<TApplicationVo> queryByManagerId(Map<String, Object> map);

    /**
     * 按进件Id查询进件信息
     * @param applicationId 进件id
     * @return 进件Vo类
     */
    TApplicationVo queryByApplication(@Param("applicationId") int applicationId);
}