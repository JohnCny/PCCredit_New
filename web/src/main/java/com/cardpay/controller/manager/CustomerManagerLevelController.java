package com.cardpay.controller.manager;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.manager.customermanagerlevel.model.TCustomerManagerLevel;
import com.cardpay.mgt.manager.customermanagerlevel.service.CustomerManagerLevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 客户经理级别controller
 *
 * @author wangpeng
 */
@Api(value = "/customerManagerLevel", description = "客户经理级别")
@RestController
@RequestMapping("/customerManagerLevel")
public class CustomerManagerLevelController extends BaseController<TCustomerManagerLevel, Integer> {
    @Autowired
    private CustomerManagerLevelService customerManagerLevelService;

    /**
     * 获取客户经理级别
     *
     * @return 客户经理级别列表
     */
    @GetMapping("/customerManagerLevelList")
    @ApiOperation(value = "获取客户经理级别", notes = "客户经理级别", httpMethod = "GET")
    public ResultTo getCustomerManagerLevel() {
        Map<String, Object> map = new HashMap<>();
        map.put("customerManagerLevelList", customerManagerLevelService.getCustomerManagerLevel());
        return new ResultTo().setData(map);
    }
}
