package com.cardpay.controller.application.basic;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.enums.ResultEnum;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.application.basic.model.TApplicationContract;
import com.cardpay.mgt.application.basic.service.TApplicationContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        return dataTablePage("queryAll");
    }

    /**
     * 新增客户签约信息
     *
     * @param contract 签约信息
     * @return 数据库变记录
     */
    @PostMapping
    public ResultTo insert(@ModelAttribute TApplicationContract contract) {
        contract.setCreateTime(new Date());
        contract.setCreateBy(ShiroKit.getUserId());
        Integer mark = tApplicationContractService.insertSelective(contract);
        return mark != 0 ? new ResultTo().setData(mark) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 更新客户签约信息
     *
     * @param contract 签约信息
     * @return 数据库变记录
     */
    @PutMapping
    public ResultTo update(@ModelAttribute TApplicationContract contract) {
        Integer mark = tApplicationContractService.updateSelectiveByPrimaryKey(contract);
        return mark != 0 ? new ResultTo().setData(mark) : new ResultTo(ResultEnum.SERVICE_ERROR);
    }

    /**
     * 按进件id查询客户签约信息
     *
     * @param applicationId 进件id
     * @return 客户签约信息
     */
    @GetMapping("/{applicationId}")
    public ResultTo queryById(@PathVariable int applicationId) {
        TApplicationContract contract = new TApplicationContract();
        contract.setApplicationId(applicationId);
        TApplicationContract tApplicationContract = tApplicationContractService.selectOne(contract);
        return new ResultTo().setData(tApplicationContract);
    }
}
