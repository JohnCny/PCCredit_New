package com.cardpay.mgt.application.auditing.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.mgt.application.auditing.dao.TApplicationApprovalReviewMapper;
import com.cardpay.mgt.application.auditing.model.TApplicationApprovalReview;
import com.cardpay.mgt.application.auditing.model.vo.TApplicationApprovalReviewVo;
import com.cardpay.mgt.application.auditing.service.TApplicationApprovalReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 审贷会排审表管理
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/13 17:15
 */

@Service
public class TApplicationApprovalReviewServiceImpl extends BaseServiceImpl<TApplicationApprovalReview>
        implements TApplicationApprovalReviewService {
    @Autowired
    private TApplicationApprovalReviewMapper tApplicationApprovalReviewDao;


    @Override
    public List<TApplicationApprovalReviewVo> queryByKeyAndValue(Map<Object, Object> map) {
        return tApplicationApprovalReviewDao.queryByKeyValue(map);
    }
}
