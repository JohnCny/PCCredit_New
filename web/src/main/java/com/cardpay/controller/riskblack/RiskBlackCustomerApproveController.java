package com.cardpay.controller.riskblack;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.riskblack.model.RiskBlackCustomerApprove;
import com.cardpay.mgt.riskblack.service.RiskBlackCustomerApproveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 风险客户操作controller
 *
 * @author rankai
 *         createTime 2017-01-2017/1/24 9:38
 */
@RestController
@RequestMapping("/riskBlackCustomerApprove")
public class RiskBlackCustomerApproveController extends BaseController<RiskBlackCustomerApprove> {

    @Autowired
    private RiskBlackCustomerApproveService riskBlackCustomerApproveService;

    /**
     * 申请转出风险名单或转入黑名单
     *
     * @param riskBlackCustomerApprove RiskBlackCustomerApprove
     * @param riskCustomerId           风险客户ID
     * @return 成功或失败
     */
    @PutMapping(value = "/approve", params = "riskCustomerId")
    public ResultTo approve(RiskBlackCustomerApprove riskBlackCustomerApprove, @RequestParam("riskCustomerId") Integer riskCustomerId) {
        return riskBlackCustomerApproveService.approve(riskBlackCustomerApprove, riskCustomerId);
    }


    /**
     * 审批操作
     *
     * @param riskBlackCustomerApprove RiskBlackCustomerApprove
     * @return 成功或失败
     */
    @PutMapping
    public ResultTo approveResult(RiskBlackCustomerApprove riskBlackCustomerApprove) {
        return riskBlackCustomerApproveService.approveResult(riskBlackCustomerApprove);
    }
}
