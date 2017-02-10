package com.cardpay.mgt.riskblack.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.basic.util.datatable.DataTablePage;
import com.cardpay.mgt.riskblack.model.BlackCustomer;
import com.cardpay.mgt.riskblack.model.vo.BlackCustomerVo;

import java.util.List;
import java.util.Map;

/**
 * 黑名单客户列表
 *
 * @author rankai
 *         createTime 2017-01-2017/1/24 9:32
 */
public interface BlackCustomerService extends BaseService<BlackCustomer> {

    /**
     * 获取黑名单分页数据
     *
     * @param map 参数map
     * @return 黑名单分页数据
     */
    List<BlackCustomerVo> blackCustomerPageList(Map<String, Object> map);
}
