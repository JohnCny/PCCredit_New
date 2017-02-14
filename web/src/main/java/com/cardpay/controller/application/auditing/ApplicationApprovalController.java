package com.cardpay.controller.application.auditing;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.application.auditing.model.TApplicationApproval;
import com.cardpay.mgt.application.auditing.service.TApplicationApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 进件审批
 *
 * @author chenkai
 *         createTime 2017-02-2017/2/6 14:29
 */
@RestController
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
     * 根据进件id查询审批信息(签约信息,审批信息,客户信息)
     *
     * @param applicationId 进件id
     * @return 审批信息
     */
    @GetMapping("/{applicationId}")
    public ResultTo queryByAppId(@PathVariable("applicationId") int applicationId) {
        Map<String, Object> map = tApplicationApprovalService.queryApproval(applicationId);
        return new ResultTo().setData(map);
    }

    /**
     * 查询审批分页信息
     * @param request request
     * @return 分页信息
     */
    @RequestMapping("/pageList")
    public DataTablePage pageList(HttpServletRequest request) {
        Example example = new Example(TApplicationApproval.class);
        example.createCriteria().andCondition("approvalPersonId", ShiroKit.getUserId());
        String order = DataTablePage.getOrder(request);
        example.orderBy(order);
        return dataTablePage(example);
    }
}
