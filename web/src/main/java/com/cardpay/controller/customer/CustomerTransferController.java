package com.cardpay.controller.customer;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.basic.common.annotation.SystemControllerLog;
import com.cardpay.basic.common.constant.ConstantEnum;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.common.log.LogTemplate;
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
import org.springframework.web.servlet.ModelAndView;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

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
    @SystemControllerLog(description = "获取移交接收意见状态")
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
    @SystemControllerLog(description = "客户移交确定按钮")
    @PutMapping
    @ApiOperation(value = "客户移交", notes = "客户移交确定按钮", httpMethod = "PUT")
    public ResultTo changeCustomer(@ApiParam(value = "客户id(,分割)", required = true) @RequestParam String customerIds
            , @ApiParam(value = "状态(默认为正常)") @RequestParam(defaultValue = "0") int status
            , @ApiParam(value = "移交原因", required = true) @RequestParam String reason) {
        List<Integer> customerIdList = new ArrayList<>();
        //添加客户移交记录
        String[] split = customerIds.split(",");
        for (String id : split) {
            Integer customerId = Integer.parseInt(id);
            TCustomerBasic tCustomerBasic = customerBasicService.selectByPrimaryKey(customerId);
            TCustomerTransfer tCustomerTransfer = new TCustomerTransfer();
            tCustomerTransfer.setTransferTime(new Date());
            tCustomerTransfer.setId(customerId);
            tCustomerTransfer.setCustomerCname(tCustomerBasic.getCname());
            tCustomerTransfer.setCustomerCertificateNumber(tCustomerBasic.getCertificateNumber());
            tCustomerTransfer.setOriginCustomerManager(tCustomerBasic.getCustomerManagerId());
            tCustomerTransfer.setTransferReason(reason);
            tCustomerTransfer.setTransferStatus(ConstantEnum.TransferStatus.STATUS0.getVal());
            tCustomerTransfer.setTransferTime(new Date());
            customerTransferService.insertSelective(tCustomerTransfer);
            customerIdList.add(customerId);
        }
        Map<String, Object> map = new HashMap();
        map.put("status", status);
        map.put("customerIds", customerIdList);
        map.put("managerId", ShiroKit.getUserId()); //自己转移给自己
        int count = customerBasicService.updateStatus(map);
        logger.info("客户移交", "客户Id：" + customerIds + ",移交给了客户经理Id：" + ShiroKit.getUserId());
        return count != 0 ? new ResultTo().setData(count) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 查询客户接收列表
     *
     * @param status 状态(默认为待确认)
     * @return 客户接收列表
     */
    @ResponseBody
    @GetMapping("/queryTransfer")
    @SystemControllerLog(description = "查询客户接收列表")
    @ApiOperation(value = "客户接受", notes = "查询客户接收列表", httpMethod = "GET")
    public DataTablePage queryTransfer(@ApiParam("状态(默认为待确认)") @RequestParam(defaultValue = "0") int status) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", status);
        map.put("managerId", ShiroKit.getUserId());
        return dataTablePage("queryTransfer", map);
    }

    /**
     * 查询客户经理所属客户(客户移交)
     *
     * @return 客户id:客户名称
     */
    @GetMapping
    @SystemControllerLog(description = "查询客户经理所属客户(客户移交)")
    @ApiOperation(value = "客户移交页面跳转", notes = "客户移交页面跳转 参数名称:queryCustomer, 类型: Map", httpMethod = "GET")
    public ModelAndView queryCustomer() {
        ModelAndView modelAndView = new ModelAndView("customer/custransfer");
        List<TCustomerTransferVo> tCustomerVos = customerBasicService.queryCustomer(ShiroKit.getUserId());
        modelAndView.addObject("queryCustomer", tCustomerVos);
        return modelAndView;
    }

    /**
     * 客户接受/拒绝
     *
     * @param customerIds 客户id (,分割)
     * @return 数据库变记录
     */
    @PutMapping("/accept")
    @SystemControllerLog(description = "客户接受/拒绝")
    @ResponseBody
    @ApiOperation(value = "客户接收", notes = "客户接收/拒绝按钮", httpMethod = "PUT")
    public ResultTo customerReceive(@ApiParam("客户id(,分割)") @RequestParam String customerIds,
                                    @ApiParam("接收:1, 拒绝2") @RequestParam Integer flag) {
        int count = customerTransferService.accept(customerIds, flag);
        logger.info("客户接受/拒绝", "客户：" + customerIds + "接受/拒绝" + flag + ",给了客户经理：" + ShiroKit.getUserId());
        return count != 0 ? new ResultTo().setData(count) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 跳转客户接收页面
     *
     * @return 客户接收页面
     */
    @GetMapping("/accept")
    @ApiOperation(value = "跳转客户接收页面", notes = "客户接收页面", httpMethod = "GET")
    public ModelAndView returnAccept() {
        return new ModelAndView("/customer/accept");
    }

    /**
     * 查询单个客户移交记录
     *
     * @param customerId 客户Id
     * @return 单个客户移交记录
     */
    @GetMapping("/{id}")
    @ApiOperation(value = "查看客户移交记录", notes = "查看客户移交记录", httpMethod = "GET")
    public DataTablePage queryAccept(@ApiParam("客户id") @PathVariable("id") int customerId) {
        Example example = new Example(TCustomerTransfer.class);
        example.createCriteria().andEqualTo("id", customerId);
        return dataTablePage(example);
    }

}
