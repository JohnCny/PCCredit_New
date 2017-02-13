package com.cardpay.controller.application.auditing;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.application.auditing.model.TApplicationApprovalUsers;
import com.cardpay.mgt.application.auditing.service.TApplicationApprovalUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 审贷会成员表
 *
 * @author chenkai
 *         createTime 2017-02-2017/2/13 9:56
 */
@RestController
@RequestMapping("/api/ApplicationApprovalUsers")
public class ApplicationApprovalUsersController extends BaseController<TApplicationApprovalUsers> {

    @Autowired
    private TApplicationApprovalUsersService approvalUsersService;

    /**
     * 查询审贷会成员信息
     *
     * @return 审贷会成员信息
     */
    @GetMapping
    public ResultTo queryAll() {
        List<TApplicationApprovalUsers> approvalUsers = approvalUsersService.selectAll();
        return new ResultTo().setData(approvalUsers);
    }
}
