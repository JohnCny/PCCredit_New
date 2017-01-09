package com.cardpay.mgt.application.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.application.model.TApplication;
import com.cardpay.mgt.application.model.vo.TApplicationVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 进价基本信息Service
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/5 15:30
 */
public interface TApplicationService extends BaseService<TApplication> {

    /**
     * 查询此客户是否申请过此产品
     *
     * @param customerId 客户Id
     * @param productId  产品Id
     * @return true/false
     */
    boolean queryCustomerIfHaveProduct(int customerId, int productId);

    /**
     * 查询此产品是否可进行进件申请
     *
     * @return
     */
    boolean queryProductIfOk(int managerId, int productId);

    /**
     * 按客户经理Id查询进件信息
     *
     * @param map 客户经理Id
     * @return 进件Vo列表
     */
    List<TApplicationVo> queryByManagerId(Map<String, Object> map);

    /**
     * 按进件Id查询进件信息
     *
     * @param applicationId 进件id
     * @return 进件Vo类
     */
    TApplicationVo queryByApplication(int applicationId);
}
