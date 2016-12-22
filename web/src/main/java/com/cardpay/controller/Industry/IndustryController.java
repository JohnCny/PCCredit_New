package com.cardpay.controller.Industry;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.controller.base.BaseController;
import com.cardpay.mgt.industry.model.po.TIndustry;
import com.cardpay.mgt.industry.service.IndustryService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 行业信息controller
 * @author yanweichen
 */
@Api(value = "/industry", description = "行业信息")
@RestController
@RequestMapping("/industry")
public class IndustryController extends BaseController<TIndustry> {
    @Autowired
    private IndustryService industryService;

    /**
     * 获取行业信息
     * @return 行业信息列表
     */
    @RequestMapping("/industryList")
    public ResultTo getIndustryInfo(){
        Map<String,Object> map = new HashMap<String,Object>();
        ResultTo resultTo = new ResultTo();
        map.put("industryList",industryService.getIndustryInfo());
        resultTo.setData(map);
        return resultTo;
    }
}
