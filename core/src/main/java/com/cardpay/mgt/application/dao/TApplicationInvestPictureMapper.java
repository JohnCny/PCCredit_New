package com.cardpay.mgt.application.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.application.model.TApplicationInvestPicture;
import org.apache.ibatis.annotations.Param;

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
}