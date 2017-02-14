package com.cardpay.mgt.application.auditing.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.application.auditing.model.TApplicationApprovalReview;
import com.cardpay.mgt.application.auditing.model.vo.TApplicationApprovalReviewVo;

import java.util.List;
import java.util.Map;

/**
 * 审贷会排审表管理
 * @author chenkai
 */
public interface TApplicationApprovalReviewMapper extends BasicMapper<TApplicationApprovalReview> {

    /**
     * 根据指定字段查询审贷会排审信息
     * REVIEW_PERSON_ID和APPLICATION_ID 字段
     * @param map key:要查询的数据库字段名,value 值
     * @return 审贷会信息
     */
    List<TApplicationApprovalReviewVo> queryByKeyValue(Map<Object, Object> map);
}