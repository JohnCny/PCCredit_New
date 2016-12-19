package com.cardpay.controller.customer;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.customer.customerbasic.model.TCustomerBasic;
import com.cardpay.mgt.customer.customerbasic.service.CustomerBasicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 客户controller
 *
 * @author wangpeng
 */
@Api(value = "/customerBasic", description = "客户")
@RestController
@RequestMapping("/customerBasic")
public class CustomerBasicController extends BaseController<TCustomerBasic, Long> {
    @Autowired
    private CustomerBasicService customerBasicService;

    /**
     * 获取证件类型列表
     *
     * @return 证件类型列表
     */
    @GetMapping("/certList")
    @ApiOperation(value = "获取证件类型列表", notes = "证件类型列表", httpMethod = "GET")
    public ResultTo getCertList() {
        Map<String, Object> map = new HashMap<>();
        map.put("certList", customerBasicService.getCert());
        return new ResultTo().setData(map);
    }

    /**
     * 获取文化程度
     *
     * @return 文化程度列表
     */
    @GetMapping("/educationDegreeList")
    @ApiOperation(value = "获取文化程度", notes = "文化程度", httpMethod = "GET")
    public ResultTo getEducationDegreeList() {
        Map<String, Object> map = new HashMap<>();
        map.put("educationDegreeList", customerBasicService.getEducationDegree());
        return new ResultTo().setData(map);
    }

    /**
     * 获取婚姻状况
     *
     * @return 婚姻状况列表
     */
    @GetMapping("/marriageStatusList")
    @ApiOperation(value = "获取婚姻状况", notes = "婚姻状况", httpMethod = "GET")
    public ResultTo getMarriageStatusList() {
        Map<String, Object> map = new HashMap<>();
        map.put("marriageStatusList", customerBasicService.getMarriageStatus());
        return new ResultTo().setData(map);
    }

    /**
     * 获取客户状态
     *
     * @return 客户状态列表
     */
    @GetMapping("/customerStatusList")
    @ApiOperation(value = "客户状态列表", notes = "客户状态", httpMethod = "GET")
    public ResultTo getCustomerStatusList() {
        Map<String, Object> map = new HashMap<>();
        map.put("customerStatusList", customerBasicService.getCustomerStatus());
        return new ResultTo().setData(map);
    }

    /**
     * 获取潜在客户列表
     *
     * @return 潜在客户列表
     */
    @GetMapping("/prospectiveCustomers")
    @ApiOperation(value = "查询潜在客户列表", notes = "潜在客户列表", httpMethod = "GET")
    public ResultTo getProspectiveCustomers() {
        if (ShiroKit.getSubject().isAuthenticated()) {
            List<TCustomerBasic> customerBasics = customerBasicService.getProspectiveCustomers(ShiroKit.getUserId());
            return new ResultTo().setData(customerBasics);
        }
        return new ResultTo();
    }
}
