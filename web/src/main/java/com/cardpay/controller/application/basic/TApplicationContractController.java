package com.cardpay.controller.application.basic;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.application.basic.model.TApplicationContract;
import com.cardpay.mgt.application.basic.service.TApplicationContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 客户签约信息Controller
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/11 10:14
 */
@RestController
@RequestMapping("/api/applicationContract")
public class TApplicationContractController extends BaseController<TApplicationContract> {
    /**
     * 客户签约信息
     */
    @Autowired
    private TApplicationContractService tApplicationContractService;

    /**
     * 按条件查询客户签约列表
     *
     * @return 客户签约列表
     */
    @RequestMapping("/pageList")
    public DataTablePage pageList() {
        return dataTablePage();
    }

    /**
     * 添加客户签约信息
     * @param contract 签约信息
     * @return 数据库变记录
     */
    @PostMapping
    public ResultTo insert(TApplicationContract contract) {
        contract.setCreateTime(new Date());
        Integer mark = tApplicationContractService.insertSelective(contract);
        return mark != 0 ? new ResultTo().setData(mark) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }
}
