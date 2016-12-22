package com.cardpay.controller.customer;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.basic.common.log.LogTemplate;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.customer.model.TCustomerBasic;
import com.cardpay.mgt.customer.model.TCustomerTransfer;
import com.cardpay.mgt.customer.model.vo.TCustomerVo;
import com.cardpay.mgt.customer.model.vo.TCustomerTransferVo;
import com.cardpay.mgt.customer.service.TCustomerBasicService;
import com.cardpay.mgt.customer.service.TCustomerTransferService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 客户移交controller
 *
 * @author chenkai
 */
@Api(value = "/customerTransfer", description = "客户移交")
@RestController
@RequestMapping("/customerTransfer")
public class CustomerTransferController extends BaseController<TCustomerTransfer> {
    @Autowired
    private TCustomerTransferService customerTransferService;

    @Autowired //客户基本信息
    private TCustomerBasicService customerBasicService;

    @Autowired
    private static LogTemplate logger;

    /**
     * 获取移交接收意见状态
     *
     * @return 移交接收意见状态列表
     */
    @GetMapping("/transferStatusList")
    @ApiOperation(value = "获取移交接收意见状态", notes = "移交接收意见状态", httpMethod = "GET")
    public ResultTo getTransferStatus() {
        List<SelectModel> transferStatus = customerTransferService.getTransferStatus();
        return new ResultTo().setData(transferStatus);
    }

    /**
     * 客户移交确定按钮
     *
     * @param customerIds 客户id(,分割)
     * @param status      需要变更的状态
     * @param reason      移交原因
     * @return 数据库变记录
     */
    @ResponseBody
    @PutMapping("/customerTransfer")
    @ApiOperation(value = "客户移交", notes = "客户移交确定按钮", httpMethod = "PUT")
    public ResultTo changeCustomer(@ApiParam(value = "客户id(,分割)", required = true) String customerIds
            , @ApiParam(value = "状态(默认为正常)") @RequestParam(defaultValue = "0") int status
            , @ApiParam(value = "移交原因", required = true) String reason) {
        List<Integer> ids = new ArrayList<>();
        //添加客户移交记录
        String[] split = customerIds.split(",");
        for (String id : split) {
            int customerId = Integer.parseInt(id);
            TCustomerBasic tCustomerBasic = customerBasicService.selectByPrimaryKey(customerId);
            TCustomerTransfer tCustomerTransfer = new TCustomerTransfer();
            tCustomerTransfer.setTransferTime(new Date());
            tCustomerTransfer.setId(customerId);
            tCustomerTransfer.setCustomerCname(tCustomerBasic.getCname());
            tCustomerTransfer.setCustomerCertificateNumber(tCustomerBasic.getCertificateNumber());
            tCustomerTransfer.setOriginCustomerManager(tCustomerBasic.getCustomerManagerId());
            tCustomerTransfer.setTransferReason(reason);
            tCustomerTransfer.setTransferStatus(0);
            tCustomerTransfer.setTransferTime(new Date());
            customerTransferService.insert(tCustomerTransfer);
            ids.add(customerId);
        }
        Map<String, Object> map = new HashedMap();
        map.put("status", status);
        map.put("customerIds", ids);
        map.put("managerId", ShiroKit.getUserId()); //自己转移给自己
        int count = customerBasicService.updateStatus(map);
        logger.info("客户移交", "客户" + customerIds + "移交给了" + ShiroKit.getUserId());
        return new ResultTo().setData(count);
    }

    /**
     * 查询客户接收列表
     *
     * @param status 查询客户接收列表
     * @return 客户接收列表
     */
    @ResponseBody
    @GetMapping("/queryTransfer")
    @ApiOperation(value = "客户接受", notes = "查询客户接收列表", httpMethod = "GET")
    public ResultTo queryTransfer(@ApiParam("客户移交状态(默认为未接受)") @RequestParam(defaultValue = "0") int status) {
        List<TCustomerVo> tCustomerTransferVos = customerTransferService.queryTransfer(status, ShiroKit.getUserId());
        return new ResultTo().setData(tCustomerTransferVos);
    }

    /**
     * 查询客户经理所属客户(客户移交)
     *
     * @return 客户id:客户名称
     */
    @GetMapping("")
    @ApiOperation(value = "客户移交页面跳转", notes = "客户移交页面跳转 参数名称:queryCustomer, 类型: Map", httpMethod = "GET")
    public ModelAndView queryCustomer() {
        ModelAndView modelAndView = new ModelAndView("customer/custransfer");
        List<TCustomerTransferVo> tCustomerVos = customerBasicService.queryCustomer(ShiroKit.getUserId());
        modelAndView.addObject("queryCustomer", tCustomerVos);
        return modelAndView;
    }
}
