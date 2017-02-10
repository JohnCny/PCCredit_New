package com.cardpay.controller.customer;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.basic.common.annotation.SystemControllerLog;
import com.cardpay.basic.common.constant.ConstantEnum;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.customer.model.TCustomerBasic;
import com.cardpay.mgt.customer.model.TCustomerTransfer;
import com.cardpay.mgt.customer.model.vo.TCustomerTransferVo;
import com.cardpay.mgt.customer.service.TCustomerBasicService;
import com.cardpay.mgt.customer.service.TCustomerTransferService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

import static com.cardpay.basic.common.constant.CustomerStatusEnum.*;


/**
 * 客户移交controller
 *
 * @author chenkai
 */
@Api(value = "/api/customerTransfer", description = "客户移交")
@RestController
@RequestMapping("/api/customerTransfer")
public class CustomerTransferController extends BaseController<TCustomerTransfer> {
    /**
     * 客户移交
     */
    @Autowired
    private TCustomerTransferService customerTransferService;
    /**
     * 客户基本信息
     */
    @Autowired
    private TCustomerBasicService customerBasicService;

    /**
     * 获取移交接收意见状态
     *
     * @return 移交接收意见状态列表
     */
    @GetMapping("/transferStatusList")
    @SystemControllerLog("获取移交接收意见状态")
    @ApiOperation(value = "获取移交接收意见状态", notes = "移交接收意见状态", httpMethod = "GET")
    public ResultTo getTransferStatus() {
        List<SelectModel> transferStatus = customerTransferService.getTransferStatus();
        return new ResultTo().setData(transferStatus);
    }

    /**
     * 客户移交确定按钮
     *
     * @param customerIds 客户id(,分割)
     * @param reason      移交原因
     * @param managerId   客户经理id
     * @param customerType   客户类型
     * @return 数据库变记录
     */
    @PutMapping
    @SystemControllerLog("客户移交确定按钮")
    @ApiOperation(value = "客户移交", notes = "客户移交确定按钮", httpMethod = "PUT")
    public ResultTo changeCustomer(@ApiParam(value = "客户id(,分割)", required = true) @RequestParam String customerIds
            , @ApiParam(value = "移交原因", required = true) @RequestParam String reason,
                                   @RequestParam int managerId, @RequestParam int customerType) {
        List<Integer> customerIdList = new ArrayList<>();
        //添加客户移交记录
        String[] split = customerIds.split(",");
        for (String id : split) {
            Integer customerId = Integer.parseInt(id);
            TCustomerBasic tCustomerBasic = customerBasicService.selectByPrimaryKey(customerId);
            TCustomerTransfer tCustomerTransfer = new TCustomerTransfer();
            tCustomerTransfer.setTransferTime(new Date());
            tCustomerTransfer.setCustomerId(customerId);
            tCustomerTransfer.setOriginCustomerManager(tCustomerBasic.getCustomerManagerId());
            tCustomerTransfer.setTransferReason(reason);
            tCustomerTransfer.setCustomerType(customerType);
            Integer customerBasicServiceManagerId = customerBasicService.getManagerId(managerId);
            tCustomerTransfer.setNowCustomerManager(customerBasicServiceManagerId);
            tCustomerTransfer.setTransferStatus(ConstantEnum.TransferStatus.STATUS0.getVal());
            tCustomerTransfer.setTransferTime(new Date());
            customerTransferService.insert(tCustomerTransfer);
            customerIdList.add(customerId);
        }
        Map<String, Object> map = new HashMap();
        map.put("customerIds", customerIdList);
        map.put("status", TRANSFER.getValue());
        int count = customerBasicService.updateStatus(map);
        return count != 0 ? new ResultTo().setData(count) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 查询客户接收列表
     *
     * @param status 状态(默认为待确认)
     * @return 客户接收列表
     */
    @RequestMapping("/queryTransfer/{customerType}")
    @SystemControllerLog("查询客户接收列表")
    @ApiOperation(value = "客户接受", notes = "查询客户接收列表", httpMethod = "GET")
    public DataTablePage queryTransfer(@ApiParam("状态(默认为待确认)") @RequestParam(defaultValue = "0") int status
            , @PathVariable("customerType") int customerType) {
        Map<String, Object> map = new HashMap<>();
        Integer managerId = customerBasicService.getManagerId(ShiroKit.getUserId());
        map.put("status", status);
        map.put("managerId", managerId);
        map.put("customerType", customerType);
        return dataTablePage("queryTransfer", map);
    }

    /**
     * 查询客户经理所属客户(客户移交)
     * @param customerType 客户类型
     * @return 客户信息
     */
    @GetMapping("/list/{customerType}")
    @SystemControllerLog("查询客户经理所属客户(客户移交)")
    @ApiOperation(value = "客户移交页面跳转", notes = "客户移交页面跳转 ", httpMethod = "GET")
    public ResultTo queryCustomer(@PathVariable("customerType") int customerType) {
        Integer userId = ShiroKit.getUserId();
        Integer managerId = customerBasicService.getManagerId(userId);
        List<TCustomerTransferVo> tCustomerVos = customerBasicService.queryCustomer(managerId, customerType);
        return new ResultTo().setData(tCustomerVos);
    }

    /**
     * 客户接受/拒绝
     *
     * @param customerIds 客户id (,分割)
     * @return 数据库变记录
     */
    @PutMapping("/accept")
    @SystemControllerLog(description = "客户接受/拒绝")
    @ApiOperation(value = "客户接收", notes = "客户接收/拒绝按钮", httpMethod = "PUT")
    public ResultTo customerReceive(@ApiParam("客户id(,分割)") @RequestParam String customerIds,
                                    @ApiParam("接收:1, 拒绝2") @RequestParam Integer flag) {
        int count = customerTransferService.accept(customerIds, flag, ShiroKit.getUserId());
        return count != 0 ? new ResultTo().setData(count) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 按id查询客户移交记录(返回分页)
     *
     * @param customerId 客户Id
     * @return 单个客户移交记录
     */
    @RequestMapping("/transfer/{customerId}")
    @SystemControllerLog("按id查询客户移交记录(返回分页)")
    @ApiOperation(value = "查看客户移交记录", notes = "查看客户移交记录", httpMethod = "GET")
    public DataTablePage queryAccept(@ApiParam("客户id") @PathVariable("customerId") int customerId) {
        Example example = new Example(TCustomerTransfer.class);
        example.createCriteria().andEqualTo("id", customerId);
        return dataTablePage(example);
    }

    /**
     * 按id查询客户移交记录
     *
     * @param customerId 客户Id
     * @return 客户移交记录
     */
    @GetMapping("/{customerId}")
    @SystemControllerLog("按id查询移交记录")
    @ApiOperation(value = "按id查询移交记录", notes = "按id查询移交记录 ", httpMethod = "GET")
    public ResultTo queryById(@ApiParam(value = "客户id", required = true) @PathVariable("customerId") int customerId) {
        List<TCustomerTransferVo> tCustomerTransferVos = customerTransferService.queryById(customerId);
        return new ResultTo().setData(tCustomerTransferVos);
    }


}
