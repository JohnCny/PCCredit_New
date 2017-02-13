package com.cardpay.controller.customermanager;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.controller.base.BaseController;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.customermanager.daily.model.TCustomerManagerDay;
import com.cardpay.mgt.customermanager.daily.service.CustomerManagerDayService;
import com.cardpay.mgt.user.enums.UserStatus;
import io.swagger.annotations.Api;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 客户经理日报controller
 *
 * @author yanweichen
 */
@Api(value = "/api/customerManagerDay", description = "客户经理日报")
@RestController
@RequestMapping("/api/customerManagerDay")
public class CustomerManagerDayController extends BaseController<TCustomerManagerDay> {

    @Autowired
    private CustomerManagerDayService customerManagerDayService;

    /**
     * 按条件搜索日报
     *
     * @return 日报列表
     */
    @RequestMapping("/pageList")
    public DataTablePage pageList(){
        Map<String, Object> map = new HashMap();
        //查看当前机构下的客户经理
        map.put("organizationId", ShiroKit.getOrgId());
        map.put("status", UserStatus.NORMAL.getStatus());
        return dataTablePage("selectDailyAndUserVo",map);
    }

    /**
     * 获得客户经理日报
     *
     * @param customerManagerId id
     * @return 日报
     */
    @GetMapping()
    public ResultTo selectDailyByUserId(@RequestParam("customerManagerId") Integer customerManagerId){
        ResultTo resultTo = new ResultTo();
        TCustomerManagerDay customerManagerDay = customerManagerDayService.selectByPrimaryKey(customerManagerId);
        resultTo.setData(customerManagerDay);
        return resultTo;
    }
    /**
     * 导出客户经理日报
     *
     * @param request request
     * @param response response
     * @return 导出结果
     */
    @RequestMapping("/excel")
    public ResultTo expertExcel(HttpServletRequest request, HttpServletResponse response){
        ResultTo resultTo = new ResultTo();
        customerManagerDayService.expertExcel(request,response);
        return resultTo;
    }

}
