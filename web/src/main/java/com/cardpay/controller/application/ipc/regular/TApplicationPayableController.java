package com.cardpay.controller.application.ipc.regular;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.application.ipc.regular.model.TApplicationPayable;
import com.cardpay.mgt.application.ipc.regular.service.TApplicationPayableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 应付预收Controller
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/9 17:55
 */
@RestController
@RequestMapping("/api/applicationPayable")
public class TApplicationPayableController extends BaseController<TApplicationPayable> {
    @Autowired
    private TApplicationPayableService tApplicationPayableService;

    /**
     * 添加应付预收表信息更新总计
     *
     * @param applicationPayable    应付预收信息
     * @param fixedAssertTotalValue 应付预收合计
     * @return 数据变记录
     */
    @PostMapping
    public ResultTo insert(TApplicationPayable applicationPayable, BigDecimal fixedAssertTotalValue) {
        int flag = tApplicationPayableService.insertPayable(applicationPayable, fixedAssertTotalValue);
        return flag != 0 ? new ResultTo().setData(flag) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 更新应付预收表更新总计信息
     *
     * @param applicationPayable    应付预收信息
     * @param fixedAssertTotalValue 应付预收合计
     * @return 数据变记录
     */
    @PutMapping
    public ResultTo update(TApplicationPayable applicationPayable, BigDecimal fixedAssertTotalValue) {
        int flag = tApplicationPayableService.updatePayable(applicationPayable, fixedAssertTotalValue);
        return flag != 0 ? new ResultTo().setData(flag) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 删除应付预收更新总计
     *
     * @param fixedAssertTotalId    应付预收清单
     * @param fixedAssertTotalValue 应付预收合计
     * @return 数据变记录
     */
    @DeleteMapping
    public ResultTo delete(int fixedAssertTotalId, BigDecimal fixedAssertTotalValue) {
        int flag = tApplicationPayableService.deletePayable(fixedAssertTotalId, fixedAssertTotalValue);
        return flag != 0 ? new ResultTo().setData(flag) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 根据进件ID查询应付预收信息
     *
     * @param applicationId 进件ID
     * @return 分页信息
     */
    @RequestMapping("/pageList")
    public DataTablePage queryByApplicationId(int applicationId) {
        Map<String, Object> map = new HashMap();
        map.put("applicationId", applicationId);
        return dataTablePage("queryByApplicationId");
    }
}
