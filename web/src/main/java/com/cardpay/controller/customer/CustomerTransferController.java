package com.cardpay.controller.customer;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.customer.customertransfer.model.po.TCustomerTransfer;
import com.cardpay.mgt.customer.customertransfer.service.CustomerTransferService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 客户移交controller
 *
 * @author wangpeng
 */
@Api(value = "/customerTransfer", description = "客户移交")
@RestController
@RequestMapping("/customerTransfer")
public class CustomerTransferController extends BaseController<TCustomerTransfer, Long> {

    @Autowired
    private CustomerTransferService customerTransferService;

    /**
     * 获取移交接收意见状态
     *
     * @return 移交接收意见状态列表
     */
    @RequestMapping("/transferStatusList")
    public ResultTo getTransferStatus() {
        Map<String, Object> map = new HashMap<>();
        map.put("transferStatusList", customerTransferService.getTransferStatus());
        return new ResultTo().setData(map);
    }
}
