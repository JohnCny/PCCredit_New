package com.cardpay.mgt.loan.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.mgt.loan.model.PostLoanMonitor;
import com.cardpay.mgt.loan.model.vo.AddLoanVo;

import java.util.List;
import java.util.Map;

public interface PostLoanMonitorMapper extends BasicMapper<PostLoanMonitor> {

    /**
     * 贷后监控分页数据(反射调用)
     *
     * @param map 参数map
     * @return 分页数据
     */
    List<AddLoanVo> loanMonitorAddPageList(Map<String, Object> map);

    /**
     * 贷后监控分页数据(反射调用)
     *
     * @param map 参数map
     * @return 分页数据
     */
    List<AddLoanVo> loanMonitorPageList(Map<String, Object> map);
}