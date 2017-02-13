package com.cardpay.mgt.application.basic.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.application.basic.model.TApplication;
import com.cardpay.mgt.application.basic.model.vo.TApplicationVo;

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
    Map<String, Object> queryProductIfOk(int managerId, int productId);

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

    /**
     * 按机构id查询进件信息
     * @param map 机构id
     * @return 进件信息
     */
    List<TApplicationVo> queryAppByOrgId(Map<String, Object> map);

    /**
     * 按团队Id查询进件信息
     * @param map 团队id
     * @return 进件信息
     */
    List<TApplicationVo> queryAppByTeamId(Map<String, Object> map);

    /**
     * 此用是否属于此团队的负责人
     * @param teamId 团队id
     * @param userId 用户id
     * @return true/false
     */
    boolean userIfTeamBoss(int teamId, int userId);

    /**
     * 此用是否属于此机构的负责人
     * @param orgId 机构id
     * @param userId 用户id
     * @return true/false
     */
    boolean userIfOrgBoss(int orgId, int userId);

    /**
     * 删除进件
     * @param applicationId 进件ID
     * @return true/false
     */
    boolean deleteApplication(int applicationId);

    /**
     * 新建进件
     * @param productId 产品id
     * @param customerId 客户id
     * @param userId 用户id
     * @return true/flase
     */
    int insertApplication(int productId, int customerId, int userId);
}
