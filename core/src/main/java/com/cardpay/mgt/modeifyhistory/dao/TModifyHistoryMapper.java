package com.cardpay.mgt.modeifyhistory.dao;

import com.cardpay.basic.base.mapper.BasicMapper;
import com.cardpay.mgt.modeifyhistory.model.TModifyHistory;

import java.util.List;

public interface TModifyHistoryMapper extends BasicMapper<TModifyHistory> {

    /**
     * 批量插入
     *
     * @param list 数据列表
     * @return 插入条数
     */
    int batchInsert(List<TModifyHistory> list);
}