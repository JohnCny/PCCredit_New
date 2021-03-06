package com.cardpay.mgt.customermanager.basic.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.customermanager.basic.model.TCustomerManager;
import com.cardpay.mgt.customermanager.basic.model.vo.TCustomerManagerBaseVo;
import com.cardpay.mgt.customermanager.basic.model.vo.TCustomerManagerEditVo;

import java.util.List;
import java.util.Map;

/**
 * 客户经理管理Service
 *
 * @author yanweichen
 */
public interface CustomerManagerService extends BaseService<TCustomerManager> {

    /**
     * 客户经理管理列表(此处是反射应用,没有显示调用)
     *
     * @param map 参数列表
     * @return 客户经理管理列表
     */
    List<TCustomerManagerEditVo> selectBaseVoList(Map<String, Object> map);

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

    /**
     * 组装编辑页面数据
     *
     * @return 编辑页面数据
     */
    TCustomerManagerEditVo assembleEditPageData(Integer userId);

    /**
     * 更新客户经理,插入权限用户等信息
     *
     * @param customerManager 客户经理信息
     * @return 是否成功
     */
    Integer updateCustomerManager(TCustomerManager customerManager);
}
