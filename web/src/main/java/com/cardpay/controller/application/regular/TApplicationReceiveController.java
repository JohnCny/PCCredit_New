package com.cardpay.controller.application.regular;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.application.regular.model.TApplicationReceive;
import com.cardpay.mgt.application.regular.service.TApplicationReceiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 应收预付Controller
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/9 18:01
 */
@RestController
@RequestMapping("/api/applicationReceive")
public class TApplicationReceiveController extends BaseController<TApplicationReceive> {
    @Autowired
    private TApplicationReceiveService tApplicationReceiveService;

    /**
     * 添加应收预付表信息更新总计
     *
     * @param applicationPayable    应收预付信息
     * @param fixedAssertTotalValue 应收预付合计
     * @return 数据变记录
     */
    @PostMapping
    public ResultTo insert(TApplicationReceive applicationPayable, BigDecimal fixedAssertTotalValue) {
        int flag = tApplicationReceiveService.insertReceive(applicationPayable, fixedAssertTotalValue);
        return flag != 0 ? new ResultTo().setData(false) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 更新应收预付表更新总计信息
     *
     * @param applicationPayable    应收预付信息
     * @param fixedAssertTotalValue 应收预付合计
     * @return 数据变记录
     */
    @PutMapping
    public ResultTo update(TApplicationReceive applicationPayable, BigDecimal fixedAssertTotalValue) {
        int flag = tApplicationReceiveService.updateReceive(applicationPayable, fixedAssertTotalValue);
        return flag != 0 ? new ResultTo().setData(false) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 删除应收预付更新总计
     *
     * @param receiveId             应收预付清单
     * @param fixedAssertTotalValue 应收预付合计
     * @return 数据变记录
     */
    @DeleteMapping
    public ResultTo delete(int receiveId, BigDecimal fixedAssertTotalValue) {
        int flag = tApplicationReceiveService.deleteReceive(receiveId, fixedAssertTotalValue);
        return flag != 0 ? new ResultTo().setData(false) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 根据进件ID查询应收预付信息
     *
     * @param applicationId 进件ID
     * @return 分页信息
     */
    @RequestMapping
    public DataTablePage queryByApplicationId(int applicationId) {
        Map<String, Object> map = new HashMap();
        map.put("applicationId", applicationId);
        return dataTablePage("queryByApplicationId");
    }
}
