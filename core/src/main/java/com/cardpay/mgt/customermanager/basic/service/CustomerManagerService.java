package com.cardpay.mgt.customermanager.basic.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.customermanager.basic.model.TCustomerManager;
import com.cardpay.mgt.customermanager.basic.model.vo.TCustomerManagerBaseVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 客户经理管理Service
 *
 * @author yanweichen
 */
public interface CustomerManagerService extends BaseService<TCustomerManager> {

    /**
     * 客户经理管理列表
     *
     * @param map 参数列表
     * @return 客户经理管理列表
     */
    List<TCustomerManagerBaseVo> selectBaseVoList(Map<String,Object> map);

    /**
     * 根据UserId查询客户经理
     *
     * @param userId 用户Id
     * @return 客户经理信息
     */
    TCustomerManager selectByUserId(Integer userId);

    /**
     * 查询客户经理BaseVo基础信息
     *
     * @param userId 用户Id
     * @return 客户经理BaseVo
     */
    TCustomerManagerBaseVo selectBaseVoByUserId(Integer userId);
}
