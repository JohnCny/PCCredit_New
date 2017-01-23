package com.cardpay.mgt.application.basic.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.application.basic.model.TApplicationInvestPicture;
import com.cardpay.mgt.application.basic.model.vo.TApplicationInvestPictureVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 调查图片表Mapper
 * @author chenkai
 */
public interface TApplicationInvestPictureMapper extends BasicMapper<TApplicationInvestPicture> {
    /**
     * 统计进件表中图片上传个数
     * @param applicationId 进件id
     * @return 个数
     */
    int queryApplicationFileNext(@Param("applicationId") int applicationId);

    /**
     * 统计产品表中图片上传个数
     * @param applicationId 进件id
     * @return 个数
     */
    int queryProductFileNext(@Param("applicationId") int applicationId);

    /**
     *  查询产品调查图片
     * @param map 产品id
     * @return 产品调查图片信息
     */
    List<TApplicationInvestPictureVo>queryByProduct (Map<String, Object> map);
}