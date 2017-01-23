package com.cardpay.mgt.loan.service;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.loan.model.PostLoanMonitor;
import com.cardpay.mgt.loan.model.vo.AddLoanVo;

import java.util.List;
import java.util.Map;

/**
 * 贷后监控服务层接口
 *
 * @author rankai
 *         createTime 2017-01-2017/1/22 14:50
 */
public interface PostLoanMonitorService extends BaseService<PostLoanMonitor> {

    /**
     * 贷后监控分页数据(反射调用)
     *
     * @param map 参数map
     * @return 分页数据
     */
    List<AddLoanVo> loanMonitorAddPageList(Map<String, Object> map);

    /**
     * 增加贷后监控
     *
     * @param applicationId 进件ID
     * @return 成功或失败
     */
    ResultTo addLoan(Integer applicationId);

    /**
     * 贷后监控分页数据(反射调用)
     *
     * @param map 参数map
     * @return 分页数据
     */
    List<AddLoanVo> loanMonitorPageList(Map<String, Object> map);
}
