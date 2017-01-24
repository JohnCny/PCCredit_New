package com.cardpay.controller.riskblack;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.riskblack.model.RiskBlackCustomerApprove;
import com.cardpay.mgt.riskblack.model.RiskCustomer;
import com.cardpay.mgt.riskblack.service.RiskCustomerService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 风险客户列表Cintroller
 *
 * @author rankai
 *         createTime 2017-01-2017/1/24 11:12
 */
@RestController
@RequestMapping("/riskCustomer")
public class RiskCustomerController extends BaseController<RiskCustomer> {

    @Autowired
    private RiskCustomerService riskCustomerService;

    /**
     * 获取风险客户或者黑名单操作审批表分页数据
     *
     * @return 风险客户或者黑名单操作审批表分页数据
     */
    @PostMapping("/pageList")
    public DataTablePage pageList() {
        Map<String, Object> map = new HashMap<>();
        map.put("orgId", ShiroKit.getOrgId());
        return dataTablePage("riskCustomerPageList", map);
    }

}
