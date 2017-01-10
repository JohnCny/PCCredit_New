package com.cardpay.controller.application.regular;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.application.regular.model.TApplicationFixedAssert;
import com.cardpay.mgt.application.regular.service.TApplicationFixedAssertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * 固定资产Controller
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/9 15:39
 */
@RestController
@RequestMapping("/api/fixedAssert")
public class TApplicationFixedAssertController extends BaseController<TApplicationFixedAssert> {
    @Autowired
    private TApplicationFixedAssertService tApplicationFixedAssertService;

    /**
     * 添加固定资产表信息更新总计
     *
     * @param tApplicationFixedAssert    固定资产信息
     * @param fixedAssertTotalValue      总价值
     * @param fixedAssertDepreciateValue 折旧后价值
     * @return 数据变记录
     */
    @PostMapping
    public ResultTo insert(TApplicationFixedAssert tApplicationFixedAssert, BigDecimal fixedAssertTotalValue, BigDecimal fixedAssertDepreciateValue) {
        int flag = tApplicationFixedAssertService.insertFixedAssert(tApplicationFixedAssert, fixedAssertTotalValue, fixedAssertDepreciateValue);
        return flag != 0 ? new ResultTo().setData(false) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 更新固定资产表更新总计信息
     *
     * @param tApplicationFixedAssert    固定资产信息
     * @param fixedAssertTotalValue      总价值
     * @param fixedAssertDepreciateValue 折旧后价值
     * @return 数据变记录
     */
    @PutMapping
    public ResultTo update(TApplicationFixedAssert tApplicationFixedAssert, BigDecimal fixedAssertTotalValue, BigDecimal fixedAssertDepreciateValue) {
        int flag = tApplicationFixedAssertService.updateFixedAssert(tApplicationFixedAssert, fixedAssertTotalValue, fixedAssertDepreciateValue);
        return flag != 0 ? new ResultTo().setData(false) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 删除固定资产更新总计
     *
     * @param fixedAssertTotalId         固定资产清单
     * @param fixedAssertTotalValue      总价值
     * @param fixedAssertDepreciateValue 折旧后价值
     * @return 数据变记录
     */
    @DeleteMapping
    public ResultTo delete(int fixedAssertTotalId, BigDecimal fixedAssertTotalValue, BigDecimal fixedAssertDepreciateValue) {
        int flag = tApplicationFixedAssertService.deleteFixedAssert(fixedAssertTotalId, fixedAssertTotalValue, fixedAssertDepreciateValue);
        return flag != 0 ? new ResultTo().setData(false) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 根据进件ID查询固定资产信息
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
