package com.cardpay.controller.customer;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.customer.customertransfer.model.TCustomerTransfer;
import com.cardpay.mgt.customer.customertransfer.service.CustomerTransferService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
