package com.cardpay.mgt.index.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.index.model.IndexOrgApplicationInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 首页进件信息Mapper
 *
 * @author yanwe
 *         createTime 2017-02-2017/2/7 16:15
 */
public interface IndexOrgApplicationMapper extends BasicMapper<IndexOrgApplicationInfo> {

    /**
     * 查询指定机构下所有进件统计信息
     *
     * @param topOrgId 顶级机构id
     * @return 该机构下所有进件统计信息
     */
    List<IndexOrgApplicationInfo> selectOrgApplicationInfo(@Param("topOrgId") Integer topOrgId);
}
