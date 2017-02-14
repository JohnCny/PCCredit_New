package com.cardpay.mgt.application.basic.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.application.basic.model.TApplicationContract;
import com.cardpay.mgt.application.basic.model.vo.TApplicationContractVo;

import java.util.List;
import java.util.Map;

/**
 * 客户签约信息Service
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/11 10:01
 */
public interface TApplicationContractService extends BaseService<TApplicationContract>{

    /**
     * 查询客户签约信息 分页
     * @param map 客户名称
     * @return 签约信息
     */
    List<TApplicationContractVo> queryAll(Map<String, Object> map);
}
