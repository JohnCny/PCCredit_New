package com.cardpay.controller.customer;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.customer.model.TCustomerIndustry;
import com.cardpay.mgt.industry.model.TIndustry;
import com.cardpay.mgt.industry.service.IndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 客户行业相关
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/3 14:59
 */
@RestController
@RequestMapping("/customerIndustry")
public class CustomerIndustryController extends BaseController<TCustomerIndustry> {
    @Autowired //行业信息
    private IndustryService industryService;

    /**
     * 获取所有行业信息
     * @return 行业信息
     */
    @GetMapping
    public ResultTo get(){
        List<TIndustry> tIndustries = industryService.selectAll();
        return new ResultTo().setData(tIndustries);
    }
}
