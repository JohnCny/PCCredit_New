package com.cardpay.controller.customer;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.customer.model.TCustomerBasic;
import com.cardpay.mgt.customer.model.TCustomerTransfer;
import com.cardpay.mgt.customer.service.CustomerBasicService;
import com.cardpay.mgt.customer.service.CustomerTransferService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 客户移交controller
 *
 * @author wangpeng
 */
@Api(value = "/customerTransfer", description = "客户移交")
@RestController
@RequestMapping("/customerTransfer")
public class CustomerTransferController extends BaseController<TCustomerTransfer, Integer> {
    @Autowired
    private CustomerTransferService customerTransferService;

    @Autowired //客户基本信息
    private CustomerBasicService customerBasicService;

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
     * 更新客户状态
     *
     * @param customerIds 客户id(,分割)
     * @param status      需要变更的状态
     * @param reason      移交原因
     * @param viewName    试图名称
     * @return 数据库变记录
     */
    @PutMapping("/customerStatus")
    @ApiOperation(value = "客户移交", notes = "客户移交确定按钮", httpMethod = "PUT")
    public ModelAndView changeCustomer(@ApiParam(value = "客户id(,分割)", required = true) String customerIds
            , @ApiParam(value = "状态", required = true) int status
            , @ApiParam(value = "移交原因", required = true) String reason
            , @ApiParam(value = "跳转试图地址", required = true) String viewName) {
        ModelAndView modelAndView = new ModelAndView();
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
        }

        Map<String, Object> map = new HashedMap();
        map.put("status", status);
        map.put("customerIds", customerIds);
        int count = customerBasicService.updateStatus(map);
        modelAndView.addObject(count);
        modelAndView.setViewName(viewName);
        return modelAndView;
    }
}
