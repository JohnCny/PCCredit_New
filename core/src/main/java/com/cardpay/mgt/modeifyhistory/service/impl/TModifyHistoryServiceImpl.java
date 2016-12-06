package com.cardpay.mgt.modeifyhistory.service.impl;

import com.cardpay.basic.base.model.GenericEntity;
import com.cardpay.basic.base.service.BaseService;
import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.util.BeanFactoryUtil;
import com.cardpay.mgt.modeifyhistory.dao.TModifyHistoryMapper;
import com.cardpay.mgt.modeifyhistory.model.TModifyHistory;
import com.cardpay.mgt.modeifyhistory.service.TModifyHistoryService;
import com.cardpay.mgt.modeifyhistory.util.CompareBeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 修改实体类记录Service实现类
 *
 * Created by yanwe on 2016/12/1.
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
