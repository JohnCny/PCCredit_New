package com.cardpay.mgt.index.service.impl;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.index.model.IndexApplicationInfo;
import com.cardpay.mgt.index.model.IndexOrgApplicationInfo;
import com.cardpay.mgt.index.service.IndexApplicationInfoService;
import com.cardpay.mgt.index.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * 首页Service实现类
 *
 * @author yanwe
 *         createTime 2017-02-2017/2/8 14:04
 */
@Service
public class IndexServiceImpl implements IndexService {

    @Autowired
    private IndexApplicationInfoService indexApplicationInfoService;

    @Override
    public ResultTo getIndexInfo() {
        switch (ShiroKit.getRoleType()){
            case ADMIN:
                return getAdminIndexInfo();
            case MANAGER:
                return getManagerIndexInfo();
            case SUPER:
                return getSuperIndexInfo();
            case EXPERT:
                return getExpertIndexInfo();
            case TEAM_CHARGE:
                return getTeamChargeIndexInfo();
        }
        return null;
    }

    private ResultTo getExpertIndexInfo() {
        return null;
    }

    private ResultTo getTeamChargeIndexInfo() {
        return null;
    }

    private ResultTo getSuperIndexInfo() {
        ResultTo resultTo = new ResultTo();
        List<IndexOrgApplicationInfo> indexOrgApplicationInfoList = indexApplicationInfoService.selectMoreOrgApplicationInfo();
        resultTo.setDataMap("indexOrgApplicationInfoList",indexOrgApplicationInfoList);
        return resultTo;
    }

    private ResultTo getManagerIndexInfo() {
        ResultTo resultTo = new ResultTo();
        Integer userId = ShiroKit.getUserId();
        //该客户经理所有进件统计数量信息
        List<IndexApplicationInfo> indexApplicationInfo =
                indexApplicationInfoService.selectUserApplicationInfo(userId);
        //该客户经理所有进件审核额度总额
        BigDecimal userApplicationInfoApproveAmountSum =
                indexApplicationInfoService.selectUserApplicationInfoApproveAmountSum(userId);
        //该客户经理当月的进件数量
        Integer userApplicationInfoMonth = indexApplicationInfoService.selectUserApplicationInfoMonth(userId);
        //该客户经理所有进件数量
        Integer userApplicationInfoAllCount = indexApplicationInfoService.selectUserApplicationInfoAllCount(userId);
        resultTo.setDataMap("indexApplicationInfo",indexApplicationInfo)
                .setDataMap("userApplicationInfoApproveAmountSum",userApplicationInfoApproveAmountSum)
                .setDataMap("userApplicationInfoMonth",userApplicationInfoMonth)
                .setDataMap("userApplicationInfoAllCount",userApplicationInfoAllCount);
        return resultTo;
    }

    private ResultTo getAdminIndexInfo() {
        ResultTo resultTo = new ResultTo();
        //查询该机构下所有机构的进件统计信息
        List<IndexOrgApplicationInfo> indexOrgApplicationInfoList =
                indexApplicationInfoService.selectIndexOrgApplicationInfo(ShiroKit.getTopOrgId());
        resultTo.setDataMap("indexOrgApplicationInfoList",indexOrgApplicationInfoList);
        return resultTo;
    }
}
