package com.cardpay.mgt.index.service;

import com.cardpay.mgt.index.model.IndexApplicationInfo;
import com.cardpay.mgt.index.model.IndexOrgApplicationInfo;

import java.math.BigDecimal;
import java.util.List;

/**
 * 首页Service
 *
 * @author yanwe
 *         createTime 2017-02-2017/2/8 10:26
 */
public interface IndexApplicationInfoService {

    /**
     * 查询该机构下所有进件状态数量
     *
     * @param topOrgId 顶级机构id
     * @return 该机构下所有进件状态数量
     */
    List<IndexOrgApplicationInfo> selectIndexOrgApplicationInfo(Integer topOrgId);

    /**
     * 查询该用户所有进件状态统计信息
     *
     * @param userId 用户id
     * @return 进件状态统计
     */
    List<IndexApplicationInfo> selectUserApplicationInfo(Integer userId);

    /**
     * 查询该用户当月的进件数量
     *
     * @param userId 用户id
     * @return 进件数量
     */
    Integer selectUserApplicationInfoMonth(Integer userId);

    /**
     * 查询该用户当月的进件数量
     *
     * @param userId 用户id
     * @return 进件数量
     */
    Integer selectUserApplicationInfoAllCount(Integer userId);

    /**
     * 查询该用户下所有进件审核额度总额
     *
     * @param userId 用户id
     * @return 进件数量
     */
    BigDecimal selectUserApplicationInfoApproveAmountSum(Integer userId);
}
