package com.cardpay.mgt.customermanager.basic.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.customermanager.basic.model.TCustomerManager;
import com.cardpay.mgt.customermanager.basic.model.vo.TCustomerManagerBaseVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 客户经理信息Mapper
 *
 * @author yanweichen
 */
public interface TCustomerManagerMapper extends BasicMapper<TCustomerManager> {

    /**
     * 根据条件查询客户经理BaseVo基础信息列表
     *
     * @param map 参数列表
     * @return 客户经理管理列表
     */
    List<TCustomerManagerBaseVo> selectBaseVoList(Map<String,Object> map);

    /**
     * 查询客户经理BaseVo基础信息
     *
     * @param userId 用户Id
     * @return 客户经理BaseVo
     */
    TCustomerManagerBaseVo selectBaseVoByUserId(@Param("userId") Integer userId);
}