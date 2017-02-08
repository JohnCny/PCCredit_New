package com.cardpay.controller.riskblack;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.riskblack.model.RiskBlackCustomerApprove;
import com.cardpay.mgt.riskblack.model.vo.RiskBlackCustomerApproveVo;
import com.cardpay.mgt.riskblack.service.RiskBlackCustomerApproveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
@RequestMapping("/api/riskBlackCustomerApprove")
public class RiskBlackCustomerApproveController extends BaseController<RiskBlackCustomerApprove> {

    @Autowired
    private RiskBlackCustomerApproveService riskBlackCustomerApproveService;

    @PostMapping("/pageList")
    public DataTablePage pageList() {
        Map<String, Object> map = new HashMap<>();
        map.put("orgId", ShiroKit.getOrgId());
        return dataTablePage("riskBlackCustomerApprovePageList", map);
    }


    /**
     * 申请转出风险名单或转入黑名单
     *
     * @param riskBlackCustomerApprove RiskBlackCustomerApprove
     * @param customerId               客户ID
     * @return 成功或失败
     */
    @PutMapping(value = "/approve", params = "customerId")
    public ResultTo approve(RiskBlackCustomerApprove riskBlackCustomerApprove,
                            @RequestParam("customerId") Integer customerId) {
        return riskBlackCustomerApproveService.approve(riskBlackCustomerApprove, customerId);
    }


    /**
     * 根据用户ID获取风险审批信息
     *
     * @param riskBlackApproveId 风险审批ID
     * @return 风险审批信息
     */
    @RequestMapping(value = "/{riskBlackApproveId}", method = RequestMethod.GET)
    public ResultTo customerApprove(@PathVariable("riskBlackApproveId") Integer riskBlackApproveId) {
        RiskBlackCustomerApproveVo riskBlackCustomerApproveVo = riskBlackCustomerApproveService
                .getCustomerApprove(riskBlackApproveId);
        return new ResultTo().setData(riskBlackCustomerApproveVo);
    }

    /**
     * 审批操作
     *
     * @param customerId 客户ID
     * @param flag       操作类型(0:拒绝1:同意)
     * @return 成功或失败
     */
    @RequestMapping(value = "/{customerId}", params = "flag", method = RequestMethod.PUT)
    public ResultTo approveResult(@PathVariable("customerId") Integer customerId, @RequestParam("flag") Integer flag) {
        return riskBlackCustomerApproveService.approveResult(customerId, flag);
    }
}
