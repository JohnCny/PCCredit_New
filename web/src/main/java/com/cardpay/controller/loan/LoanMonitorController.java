package com.cardpay.controller.loan;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.loan.model.PostLoanMonitor;
import com.cardpay.mgt.loan.service.PostLoanMonitorService;
import jdk.nashorn.internal.ir.ReturnNode;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.Map;

/**
 * 贷后监控规则控制层
 *
 * @author rankai
 *         createTime 2017-01-2017/1/22 9:52
 */
@RestController
@RequestMapping("/api/loanMonitor")
public class LoanMonitorController extends BaseController<PostLoanMonitor> {


    @Autowired
    private PostLoanMonitorService postLoanMonitorService;

    /**
     * 获得增加贷后监控列表
     *
     * @return 增加贷后监控列表
     */
    @PostMapping("/add/pageList")
    public DataTablePage addPageList() {
        Map<String, Object> map = new HashMap<>();
        map.put("managerId", ShiroKit.getUserId());
        return dataTablePage("loanMonitorAddPageList", map);
    }


    /**
     * 获取维护分页列表
     *
     * @return 维护列表
     */
    @PostMapping("/pageList")
    public DataTablePage pageList() {
        Example example = new Example(PostLoanMonitor.class);
        example.createCriteria().andEqualTo("orgId", ShiroKit.getOrgId());
        return dataTablePage(example);
    }


    /**
     * 增加贷后监控
     *
     * @param applicationId 进件ID
     * @return 成功或失败
     */
    @RequestMapping("/{applicationId}")
    public ResultTo add(@PathVariable("applicationId") Integer applicationId) {
        return postLoanMonitorService.addLoan(applicationId);
    }

    /**
     * 增加监控
     *
     * @param postLoanMonitor PostLoanMonitor
     * @return 成功或失败
     */
    @PutMapping
    public ResultTo update(PostLoanMonitor postLoanMonitor) {
        if (postLoanMonitor.getTaskStatus() != null || postLoanMonitor.gettPostLoanMonitorType() == null) {
            return new ResultTo(ResultEnum.PARAM_ERROR);
        }
        PostLoanMonitor newPostLoanMonitor = new PostLoanMonitor();
        newPostLoanMonitor.setId(postLoanMonitor.getId());
        newPostLoanMonitor.setTaskStatus(postLoanMonitor.getTaskStatus());
        newPostLoanMonitor.settPostLoanMonitorType(postLoanMonitor.gettPostLoanMonitorType());
        postLoanMonitorService.updateSelectiveByPrimaryKey(newPostLoanMonitor);
        return new ResultTo();
    }
}
