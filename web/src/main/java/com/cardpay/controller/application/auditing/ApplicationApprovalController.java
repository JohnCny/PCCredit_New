package com.cardpay.controller.application.auditing;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.application.auditing.model.TApplicationApproval;
import com.cardpay.mgt.application.auditing.service.TApplicationApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 进件审批表
 *
 * @author chenkai
 *         createTime 2017-02-2017/2/6 14:29
 */
@Controller
@RequestMapping("/api/applicationApproval")
public class ApplicationApprovalController extends BaseController<TApplicationApproval> {
    /**
     * 进件审批Service
     */
    @Autowired
    private TApplicationApprovalService tApplicationApprovalService;

    /**
     * 新增审批
     *
     * @param approval 审批信息
     * @return 数据库变记录
     */
    @PostMapping
    public ResultTo insert(@ModelAttribute TApplicationApproval approval) {
        Integer mark = tApplicationApprovalService.insert(approval);
        return mark != 0 ? new ResultTo().setData(mark) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 根据进件id查询审批信息(新增审批)
     * @param applicationId 进件id
     * @return 审批信息
     */
    @GetMapping("/{applicationId}")
    public ResultTo queryByAppId(@PathVariable int applicationId){
        Map<String, Object> map = tApplicationApprovalService.queryApproval(applicationId);
        return new ResultTo().setData(map);
    }
}
