package com.cardpay.controller.customertransfer;

import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.customertransfer.model.po.TCustomerTransfer;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 客户移交controller
 * @author wangpeng
 */
@Api(value = "/customertransfer", description = "客户移交")
@RestController
@RequestMapping("/customertransfer")
public class CustomerTransferController extends BaseController<TCustomerTransfer, Long> {
}
