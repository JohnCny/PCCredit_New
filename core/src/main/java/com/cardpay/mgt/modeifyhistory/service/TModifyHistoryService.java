package com.cardpay.mgt.modeifyhistory.service;

import com.cardpay.basic.base.service.BaseService;
import com.cardpay.mgt.modeifyhistory.model.TModifyHistory;

import java.util.List;

/**
 * 修改实体类记录Service
 *
 * Created by yanwe on 2016/12/1.
 */
public interface TModifyHistoryService extends BaseService<TModifyHistory> {

    /**
     * 批量插入
     *
     * @param list 数据列表
     * @return 插入条数
     */
    int batchInsert(List<TModifyHistory> list);

}
