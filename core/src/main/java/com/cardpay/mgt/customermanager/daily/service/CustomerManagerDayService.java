package com.cardpay.mgt.customermanager.daily.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.customermanager.daily.model.TCustomerManagerDay;
import com.cardpay.mgt.customermanager.daily.model.TCustomerManagerDayAndUser;
import com.cardpay.mgt.customermanager.daily.model.vo.TCustomerManagerDayAndUserVo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 客户经理日报类
 * @author yanweichen
 */
public interface CustomerManagerDayService extends BaseService<TCustomerManagerDay> {

    /**
     * 初始化所有客户经理日报
     */
    void initDaily();

    /**
     * 按条件查询日报返回vo
     *
     * @param map 查询条件
     * @return 日报列表
     */
    List<TCustomerManagerDayAndUserVo> selectDailyAndUserVo(Map<String,Object> map);

    /**
     * 按条件查询日报返回
     *
     * @param map 查询条件
     * @return 日报列表
     */
    List<TCustomerManagerDayAndUser> selectDailyAndUser(Map<String,Object> map);

    /**
     * 导出excel
     *
     * @param request request
     * @param response response
     * @return excel
     */
    void expertExcel(HttpServletRequest request, HttpServletResponse response);
}
