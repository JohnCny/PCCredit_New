package com.cardpay.mgt.modeifyhistory.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.mgt.modeifyhistory.dao.TModifyHistoryMapper;
import com.cardpay.mgt.modeifyhistory.model.TModifyHistory;
import com.cardpay.mgt.modeifyhistory.service.TModifyHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 修改实体类记录Service实现类
 *  @author yanwe
 */
@Service
public class TModifyHistoryServiceImpl extends BaseServiceImpl<TModifyHistory> implements TModifyHistoryService {

    @Autowired
    private TModifyHistoryMapper tModifyHistoryMapper;

    @Override
    public int batchInsert(List<TModifyHistory> list) {
        return tModifyHistoryMapper.batchInsert(list);
    }

}
