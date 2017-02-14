package com.cardpay.controller.loan;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.core.shiro.enums.ShiroEnum;
import com.cardpay.mgt.loan.model.BadDebtCustomer;
import com.cardpay.mgt.loan.model.CustomerCollection;
import com.cardpay.mgt.loan.service.CustomerCollectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 不良客户controller
 *
 * @author rankai
 *         createTime 2017-01-2017/1/22 17:54
 */
@RestController
@RequestMapping("/api/BadDebtCustomer")
public class BadDebtCustomerController extends BaseController<BadDebtCustomer> {

    @Autowired
    private CustomerCollectionService customerCollectionService;

    /**
     * 不良客户分页列表
     *
     * @return 良客户分页列表
     */
    @PostMapping("/pageList")
    public DataTablePage pageList() {
        ShiroEnum roleType = ShiroKit.getRoleType();
        Map<String, Object> map = new HashMap<>();
        switch (roleType) {
            case ADMIN:
                break;
            case MANAGER:
                map.put("managerId", ShiroKit.getUserId());
                break;
            default:
                break;
        }
        map.put("orgId", ShiroKit.getOrgId());
        return dataTablePage("badDebtCustomerPageList", map);
    }

    /**
     * 增加不良催收
     *
     * @param customerCollection
     * @return 成功或者失败
     */
    @PostMapping
    public ResultTo addCustomerCollection(CustomerCollection customerCollection) {
        customerCollection.setCreateBy(ShiroKit.getUserId());
        customerCollection.setCreateTime(new Date());
        customerCollectionService.insertSelective(customerCollection);
        return new ResultTo();
    }

}
