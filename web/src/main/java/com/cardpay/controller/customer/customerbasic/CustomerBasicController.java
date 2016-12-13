package com.cardpay.controller.customer.customerbasic;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shrio.common.ShiroKit;
import com.cardpay.mgt.customer.customerbasic.model.po.TCustomerBasic;
import com.cardpay.mgt.customer.customerbasic.service.CustomerBasicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 客户controller
 * @author wangpeng
 */
@Api(value = "/customerbasic", description = "客户")
@RestController
@RequestMapping("/customerbasic")
public class CustomerBasicController extends BaseController<TCustomerBasic, Long> {
    @Autowired
    CustomerBasicService customerBasicService;

    /**
     * 获取证件类型列表
     * @return 证件类型列表
     */
    @ResponseBody
    @RequestMapping("/certList")
    public ResultTo getCertList(){
        Map<String,Object> map = new HashMap<String,Object>();
        ResultTo resultTo = new ResultTo();
        map.put("certList",customerBasicService.getCert());
        resultTo.setData(map);
        return resultTo;
    }

    /**
     * 获取文化程度
     * @return 文化程度列表
     */
    @ResponseBody
    @RequestMapping("/educationDegreeList")
    public ResultTo getEducationDegreeList(){
        Map<String,Object> map = new HashMap<String,Object>();
        ResultTo resultTo = new ResultTo();
        map.put("educationDegreeList",customerBasicService.getEducationDegree());
        resultTo.setData(map);
        return resultTo;
    }

    /**
     * 获取婚姻状况
     * @return 婚姻状况列表
     */
    @ResponseBody
    @RequestMapping("/marriageStatusList")
    public ResultTo getMarriageStatusList(){
        Map<String,Object> map = new HashMap<String,Object>();
        ResultTo resultTo = new ResultTo();
        map.put("marriageStatusList",customerBasicService.getMarriageStatus());
        resultTo.setData(map);
        return resultTo;
    }

    /**
     * 获取客户状态
     * @return 客户状态列表
     */
    @ResponseBody
    @RequestMapping("/customerStatusList")
    public ResultTo getCustomerStatusList(){
        Map<String,Object> map = new HashMap<String,Object>();
        ResultTo resultTo = new ResultTo();
        map.put("customerStatusList",customerBasicService.getCustomerStatus());
        resultTo.setData(map);
        return resultTo;
    }

    /**
     * 获取潜在客户列表
     * @return 潜在客户列表
     */
    @ResponseBody
    @RequestMapping("/prospectiveCustomers")
    @ApiOperation(value = "查询潜在客户列表", notes = "潜在客户列表",  httpMethod = "GET")
    public ResultTo getProspectiveCustomers(){
        if(ShiroKit.getSubject().isAuthenticated()) {
            int customerManagerId = ShiroKit.getUserId();
            ResultTo resultTo = new ResultTo();
            List<TCustomerBasic> customerBasics = customerBasicService.getProspectiveCustomers(customerManagerId);
            resultTo.setData(customerBasics);
            return resultTo;
        }
        return new ResultTo();
    }
}
