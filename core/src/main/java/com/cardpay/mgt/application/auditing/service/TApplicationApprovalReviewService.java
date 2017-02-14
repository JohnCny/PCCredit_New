package com.cardpay.mgt.application.auditing.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.application.auditing.model.TApplicationApprovalReview;
import com.cardpay.mgt.application.auditing.model.vo.TApplicationApprovalReviewVo;

import java.util.List;
import java.util.Map;

/**
 * 审贷会排审表管理
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/13 17:13
 */
public interface TApplicationApprovalReviewService extends BaseService<TApplicationApprovalReview>{
    /**
     * key:要查询的数据库字段名,value 值
     * REVIEW_PERSON_ID和APPLICATION_ID 字段
     * @param map 参数
     * @return 审贷会信息
     */
    List<TApplicationApprovalReviewVo> queryByKeyAndValue(Map<Object, Object> map);

    /**
     * 新增审贷会成员信息
     * @param review 审贷会信息
     * @param userIds 用户id逗号分隔
     * @return 数据库变记录
     */
    int insertReview(TApplicationApprovalReview review, String userIds);
}
