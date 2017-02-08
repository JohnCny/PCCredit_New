package com.cardpay.mgt.index.service.impl;

import com.cardpay.mgt.application.basic.dao.TApplicationMapper;
import com.cardpay.mgt.application.basic.model.TApplication;
import com.cardpay.mgt.application.enums.ApplicationStatus;
import com.cardpay.mgt.index.dao.IndexApplicationMapper;
import com.cardpay.mgt.index.model.IndexApplicationInfo;
import com.cardpay.mgt.index.model.IndexOrgApplicationInfo;
import com.cardpay.mgt.index.service.IndexApplicationInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * 首页ServiceImpl
 *
 * @author yanwe
 *         createTime 2017-02-2017/2/8 10:28
 */
@Service
public class IndexApplicationInfoServiceImpl implements IndexApplicationInfoService {

    @Autowired
    private IndexApplicationMapper indexApplicationMapper;

    @Autowired
    private TApplicationMapper applicationMapper;

    private static List<IndexApplicationInfo> zeroIndexApplicationInfoList;

    static {
        zeroIndexApplicationInfoList = new ArrayList<>();
        ApplicationStatus[] applicationStatuses = ApplicationStatus.values();
        for (ApplicationStatus applicationStatus : applicationStatuses) {
            IndexApplicationInfo indexApplicationInfo = new IndexApplicationInfo();
            indexApplicationInfo.setApplicationStatus(applicationStatus.getValue());
            indexApplicationInfo.setCount(0);
            zeroIndexApplicationInfoList.add(indexApplicationInfo);
        }
    }

    @Override
    public List<IndexOrgApplicationInfo> selectIndexOrgApplicationInfo(Integer topOrgId) {
        List<IndexOrgApplicationInfo> indexOrgApplicationInfoList = indexApplicationMapper.selectOrgApplicationInfo(topOrgId);
        for (IndexOrgApplicationInfo indexOrgApplicationInfo : indexOrgApplicationInfoList) {
            emptyHandle(indexOrgApplicationInfo.getIndexApplicationInfoList());
        }
        return indexOrgApplicationInfoList;
    }

    @Override
    public List<IndexApplicationInfo> selectUserApplicationInfo(Integer userId) {
        List<IndexApplicationInfo> indexApplicationInfoList = indexApplicationMapper.selectUserApplicationInfo(userId);
        emptyHandle(indexApplicationInfoList);
        return indexApplicationInfoList;
    }

    @Override
    public Integer selectUserApplicationInfoMonth(Integer userId) {
        return indexApplicationMapper.selectUserApplicationInfoMonth(userId);
    }

    @Override
    public Integer selectUserApplicationInfoAllCount(Integer userId) {
        Example example = new Example(TApplication.class);
        example.createCriteria().andEqualTo("customerManagerId",userId);
        return applicationMapper.selectCountByExample(example);
    }

    @Override
    public BigDecimal selectUserApplicationInfoApproveAmountSum(Integer userId) {
        return indexApplicationMapper.selectUserApplicationInfoApproveAmountSum(userId);
    }

    /**
     * 处理进件不存在状态的统计信息
     *
     * @param indexApplicationInfoList 进件统计信息
     * @return 处理后的统计信息
     */

    private void emptyHandle(List<IndexApplicationInfo> indexApplicationInfoList) {
        if(indexApplicationInfoList.isEmpty()){
            indexApplicationInfoList.addAll(zeroIndexApplicationInfoList);
            return;
        }
        ApplicationStatus[] applicationStatuses = ApplicationStatus.values();
        if(indexApplicationInfoList.size() != applicationStatuses.length){
            for (ApplicationStatus applicationStatus : applicationStatuses) {
                boolean flag = true;
                for (IndexApplicationInfo indexApplicationInfo : indexApplicationInfoList) {
                    //存在此状态跳出
                    if (applicationStatus.getValue() == indexApplicationInfo.getApplicationStatus()){
                        flag = false;
                        break;
                    }
                }
                //不存在此状态记录
                if(flag){
                    IndexApplicationInfo indexApplicationInfo = new IndexApplicationInfo();
                    indexApplicationInfo.setApplicationStatus(applicationStatus.getValue());
                    indexApplicationInfo.setCount(0);
                    indexApplicationInfoList.add(indexApplicationInfo);
                }
            }
        }
    }

}
