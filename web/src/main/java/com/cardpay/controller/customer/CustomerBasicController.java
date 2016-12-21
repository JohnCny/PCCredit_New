package com.cardpay.controller.customer;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.basic.common.interceptor.mapper.ReturnMapParam;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.customer.model.TCustomerBasic;
import com.cardpay.mgt.customer.service.TCustomerBasicService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import oracle.net.aso.i;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 客户controller
 *
 * @author chenkai
 */
@Api(value = "/customerBasic", description = "客户基本信息")
@Controller
@RequestMapping("/customerBasic")
public class CustomerBasicController extends BaseController<TCustomerBasic, Integer> {
    @Autowired
    private TCustomerBasicService customerBasicService;

    /**
     * 获取潜在客户列表
     *
     * @return 潜在客户列表
     */
    @ResponseBody
    @GetMapping("/prospectiveCustomers")
    @ApiOperation(value = "查询潜在客户列表", notes = "潜在客户列表", httpMethod = "GET")
    public ResultTo getProspectiveCustomers() {
        List<TCustomerBasic> customerBasics = customerBasicService.getProspectiveCustomers(ShiroKit.getUserId());
        return new ResultTo().setData(customerBasics);
    }

    /**
     * 验证证件号码是否已经存在
     *
     * @param identityCard 证件号码
     * @return true/false
     */
    @ResponseBody
    @GetMapping("/idCardExist")
    @ApiOperation(value = "证件号码验重", notes = "证件号码验重", httpMethod = "GET")
    public ResultTo validate(@ApiParam(value = "证件号码", required = true) int identityCard) {
        boolean idCardExist = customerBasicService.isIdCardExist(identityCard);
        return new ResultTo().setData(idCardExist);
    }

    /**
     * 更新客户基本信息
     *
     * @param tCustomerBasic 客户基本信息
     * @return 数据库变更数量
     */
    @ResponseBody
    @PutMapping("")
    @ApiOperation(value = "更新客户基本信息", notes = "更新客户基本信息", httpMethod = "PUT")
    public ResultTo update(@ApiParam(value = "客户基本信息", required = true) @ModelAttribute TCustomerBasic tCustomerBasic) {
        int count = updateAndCompareBean(tCustomerBasic, "customerBasic", "客户基本信息");
        return new ResultTo().setData(count);
    }

    /**
     * 查询客户经理所属客户
     *
     * @return 客户id:客户名称
     */
    @GetMapping("/customer")
    @ApiOperation(value = "查询客户经理所属客户", notes = "客户经理基本信息更新", httpMethod = "GET")
    public ModelAndView queryCustomer() {
        ModelAndView modelAndView = new ModelAndView();
        ReturnMapParam returnMapParam = new ReturnMapParam("id", "name");
        returnMapParam.put("managerId", ShiroKit.getUserId());
        Map<Integer, String> queryCustomer = customerBasicService.queryCustomer(returnMapParam);
        modelAndView.addObject("queryCustomer", queryCustomer);
        return modelAndView;
    }

    /**
     * 新建客戶经理
     *
     * @param tCustomerBasic 客户基本信息
     * @return 数据库变更记录
     */
    @ResponseBody
    @PostMapping("")
    @ApiOperation(value = "新建客戶", notes = "新建客戶经理", httpMethod = "POST")
    public ResultTo newCustomer(@ApiParam(value = "客户基本信息", required = true) @ModelAttribute TCustomerBasic tCustomerBasic) {
        Integer insert = customerBasicService.insertSelective(tCustomerBasic);
        return new ResultTo().setData(insert);
    }

    /**
     * 跳转新建客户经理页面
     * @return 客户经理新建页面
     */
    @GetMapping("/new")
    @ApiOperation(value = "跳转客户经理新建页面", notes = "客户经理新建页面", httpMethod = "GET")
    public ModelAndView returnNewCustomer(){
        ModelAndView modelAndView = new ModelAndView("/customer/new");
        Map<String,  List<SelectModel>> dropDownList = new HashMap<>();
        List<SelectModel> cert = customerBasicService.getCert();
        List<SelectModel> educationDegree = customerBasicService.getEducationDegree();
        List<SelectModel> marriageStatus = customerBasicService.getMarriageStatus();
        dropDownList.put("cert", cert);
        dropDownList.put("educationDegree", educationDegree);
        dropDownList.put("marriageStatus", marriageStatus);
        modelAndView.addObject("dropDownList", dropDownList);
        return modelAndView;
    }

    /**
     * 跳转查询客户页面
     * @return 客户列表
     */
    @GetMapping("/success")
    @ApiOperation(value = "跳转客户经理新建页面", notes = "客户经理新建页面", httpMethod = "GET")
    public ModelAndView returnCustomerList(){
        ModelAndView modelAndView = new ModelAndView("/customer/customer");
        List<TCustomerBasic> tCustomerBasicList = customerBasicService.queryCustomerList(ShiroKit.getUserId());
        modelAndView.addObject("tCustomerBasicList", tCustomerBasicList);
        return modelAndView;
    }
}
