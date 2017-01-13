package com.cardpay.controller.customer;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.common.annotation.SystemControllerLog;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.customer.model.TCustomerIndustry;
import com.cardpay.mgt.customer.model.vo.TCustomerIndustryVo;
import com.cardpay.mgt.customer.service.TCustomerIndustryService;
import com.cardpay.mgt.industry.model.TIndustry;
import com.cardpay.mgt.industry.service.IndustryService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 客户行业相关
 *
 * @author chenkai
 */
@RestController
@RequestMapping("/api/customerIndustry")
public class CustomerIndustryController extends BaseController<TCustomerIndustry> {
    /**
     * 行业信息
     */
    @Autowired
    private IndustryService industryService;

    /**
     * 客户行业信息
     */
    @Autowired
    private TCustomerIndustryService tCustomerIndustryService;

    /**
     * 获取所有行业信息
     * @return 行业信息
     */
    @GetMapping
    public ResultTo get(){
        List<TIndustry> tIndustries = industryService.selectAll();
        return new ResultTo().setData(tIndustries);
    }

    /**
     * 查询客户所属行业信息
     *
     * @param customerId 客户id
     * @return 更新页面
     */
    @GetMapping("/industries")
    @SystemControllerLog("客户更新页面跳转")
    @ApiOperation(value = "查询客户所属行业信息", notes = "查询客户所属行业信息", httpMethod = "GET")
    public ResultTo returnUpdate(@ApiParam(value = "客户id", required = true) @RequestParam("customerId") int customerId) {
        List<TCustomerIndustryVo> tCustomerIndustryVos = tCustomerIndustryService.queryById(customerId);
        return new ResultTo().setData(tCustomerIndustryVos);
    }
}
