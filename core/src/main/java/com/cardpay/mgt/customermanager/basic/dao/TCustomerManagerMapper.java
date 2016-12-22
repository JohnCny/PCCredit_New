package com.cardpay.mgt.customermanager.basic.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.customermanager.basic.model.TCustomerManager;
import com.cardpay.mgt.customermanager.basic.model.vo.TCustomerManagerListVo;

import java.util.List;
import java.util.Map;

/**
 * 客户经理信息Mapper
 *
 * @author yanweichen
 */
public interface TCustomerManagerMapper extends BasicMapper<TCustomerManager> {

    /**
     * 客户经理管理列表
     *
     * @param map 参数列表
     * @return 客户经理管理列表
     */
    List<TCustomerManagerListVo> selectListVo(Map<String,Object> map);
}