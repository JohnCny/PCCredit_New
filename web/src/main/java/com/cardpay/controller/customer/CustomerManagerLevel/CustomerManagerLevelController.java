package com.cardpay.controller.customer.CustomerManagerLevel;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.customer.customermanagerlevel.model.po.TCustomerManagerLevel;
import com.cardpay.mgt.customer.customermanagerlevel.service.CustomerManagerLevelService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 客户经理级别controller
 * @author wangpeng
 */
@Api(value = "/customermanagerlevel", description = "客户经理级别")
@RestController
@RequestMapping("/customermanagerlevel")
public class CustomerManagerLevelController extends BaseController<TCustomerManagerLevel, Integer> {
    @Autowired
    private CustomerManagerLevelService customerManagerLevelService;

    /**
     * 获取客户经理级别
     * @return 客户经理级别列表
     */
    @RequestMapping("/customerManagerLevelList")
    public ResultTo getCustomerManagerLevel(){
        Map<String,Object> map = new HashMap<String,Object>();
        ResultTo resultTo = new ResultTo();
        map.put("customerManagerLevelList",customerManagerLevelService.getCustomerManagerLevel());
        resultTo.setData(map);
        return resultTo;
    }
}
