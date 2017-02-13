package com.cardpay.controller.application.auditing;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.application.auditing.model.TApplicationApprovalReview;
import com.cardpay.mgt.application.auditing.model.vo.TApplicationApprovalReviewVo;
import com.cardpay.mgt.application.auditing.service.TApplicationApprovalReviewService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 审贷会排审
 *
 * @author chenkai
 *         createTime 2017-02-2017/2/8 11:03
 */
@RestController
@RequestMapping("/api/applicationApprovalReview")
public class ApplicationApprovalReviewController extends BaseController<TApplicationApprovalReview> {
    /**
     * 审贷会排审
     */
    @Autowired
    private TApplicationApprovalReviewService tApplicationApprovalReviewService;

    /**
     * 分页查询审贷会排审
     *
     * @return 分页信息
     */
    @RequestMapping("/pageList")
    public DataTablePage queryAll() {
        Map<String, Object> map = new HashMap<>();
        map.put("key", "REVIEW_PERSON_ID");
        map.put("value", ShiroKit.getUserId());
        return dataTablePage("queryByKeyAndValue", map);
    }

    /**
     * 按进件id查询审贷会排审信息
     *
     * @param applicationId 进件id
     * @return 审贷会排审信息
     */
    @GetMapping("/{applicationId}")
    public ResultTo getByAppId(@PathVariable int applicationId) {
        Map<Object, Object> map = new HashMap<>();
        map.put("key", "APPLICATION_ID");
        map.put("value", applicationId);
        List<TApplicationApprovalReviewVo> approvalReviewVos = tApplicationApprovalReviewService.queryByKeyAndValue(map);
        return new ResultTo().setData(approvalReviewVos);
    }

    /**
     * 新增排审信息
     *
     * @param review 审贷会排审
     * @return 数据库变记录
     */
    @PostMapping
    public ResultTo insert(@ModelAttribute TApplicationApprovalReview review) {
        Integer mark = tApplicationApprovalReviewService.insert(review);
        return mark != 0 ? new ResultTo().setData(mark) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 更新排审信息
     *
     * @param review 审贷会排审
     * @return 数据库变记录
     */
    @PutMapping
    public ResultTo update(@ModelAttribute TApplicationApprovalReview review) {
        Integer mark = tApplicationApprovalReviewService.updateSelectiveByPrimaryKey(review);
        return mark != 0 ? new ResultTo().setData(mark) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }
}
