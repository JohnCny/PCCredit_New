package com.cardpay.controller.riskblack;

import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.riskblack.model.BlackCustomer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 风险名单操作controller
 *
 * @author rankai
 *         createTime 2017-01-2017/1/24 9:41
 */
@RestController
@RequestMapping("/api/blackCustomer")
public class BlackCustomerController extends BaseController<BlackCustomer> {

    /**
     * 获取黑名单
     *
     * @return 黑名单分页列表
     */
    @PostMapping("/pageList")
    public DataTablePage pageList() {
        Map<String, Object> map = new HashMap();
        map.put("orgId", ShiroKit.getOrgId());
        return dataTablePage("blackCustomerPageList", map);
    }

}
