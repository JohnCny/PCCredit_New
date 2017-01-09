package com.cardpay.controller.application;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.application.model.TApplication;
import com.cardpay.mgt.application.model.vo.TApplicationVo;
import com.cardpay.mgt.application.service.TApplicationService;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.cardpay.controller.application.enums.ApplicationStatus.*;

/**
 * ${DESCRIPTION}
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/5 15:38
 */

@RestController
@RequestMapping("/api/application")
public class ApplicationController extends BaseController<TApplication> {
    /**
     * 进件基本信息Service
     */
    @Autowired
    private TApplicationService tApplicationService;

    /**
     * 查询此产品是否可进行进件申请
     *
     * @param productId 产品Id
     * @return true/false
     */
    @GetMapping("/ifProduct")
    public ResultTo queryProductIfOk(int productId) {
        boolean flag = tApplicationService.queryProductIfOk(ShiroKit.getUserId(), productId);
        return new ResultTo().setData(flag);
    }

    /**
     * 查询此客户是否申请过此产品
     *
     * @param customerId 客户Id
     * @param productId  产品Id
     * @return true/false
     */
    @GetMapping("/ifCustomer")
    public ResultTo queryCustomerIfHaveProduct(int productId, int customerId) {
        boolean flag = tApplicationService.queryCustomerIfHaveProduct(customerId, productId);
        return new ResultTo().setData(flag);
    }

    /**
     * 新建进件
     *
     * @param productId  产品id
     * @param customerId 客户id
     * @return 进件Id
     */
    @PostMapping
    public ResultTo insertApplication(int productId, int customerId) {
        Integer managerId = ShiroKit.getUserId();
        TApplication tApplication = new TApplication();
        tApplication.setCreateTime(new Date());
        tApplication.setProductId(productId);
        tApplication.setCustomerId(customerId);
        tApplication.setCustomerManagerId(managerId);
        tApplication.setApplicationStatus(APP_UNFINISHED.getValue());
        Integer integer = tApplicationService.insertSelective(tApplication);
        return integer != 0 ? new ResultTo().setData(tApplication.getId()) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 查询客户经理下的所有进件
     *
     * @return 进件列表
     */
    @GetMapping
    public DataTablePage queryByManagerId() {
        Map<String, Object> map = new HashMap();
        map.put("managerId", ShiroKit.getUserId());
        return dataTablePage("queryByManagerId", map);
    }

    /**
     * 按进件id查询进件信息
     *
     * @param applicationId 进件id
     * @return 进件列表
     */
    @GetMapping("/{id}")
    public ResultTo queryByApplication(@PathVariable("id") int applicationId) {
        TApplicationVo tApplicationVo = tApplicationService.queryByApplication(applicationId);
        return new ResultTo().setData(tApplicationVo);
    }


}
