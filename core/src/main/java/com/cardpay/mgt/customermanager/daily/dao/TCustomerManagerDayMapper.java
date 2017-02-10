package com.cardpay.mgt.customermanager.daily.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.customermanager.daily.model.TCustomerManagerDay;
import com.cardpay.mgt.customermanager.daily.model.TCustomerManagerDayAndUser;
import com.cardpay.mgt.customermanager.daily.model.vo.TCustomerManagerDayAndUserVo;

import java.util.List;
import java.util.Map;

public interface TCustomerManagerDayMapper extends BasicMapper<TCustomerManagerDay> {

    /**
     * 初始化所有客户经理日报
     */
    void initDaily();

    /**
     * 按条件查询日报
     *
     * @param map 查询条件
     * @return 日报列表
     */
    List<TCustomerManagerDayAndUser> selectDailyAndUser(Map<String,Object> map);
}