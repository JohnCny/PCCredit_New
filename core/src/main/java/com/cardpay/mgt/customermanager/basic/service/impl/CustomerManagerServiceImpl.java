package com.cardpay.mgt.customermanager.basic.service.impl;

import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.mgt.customermanager.basic.dao.TCustomerManagerMapper;
import com.cardpay.mgt.customermanager.basic.model.TCustomerManager;
import com.cardpay.mgt.customermanager.basic.model.vo.TCustomerManagerListVo;
import com.cardpay.mgt.customermanager.basic.service.CustomerManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 客户经理管理实现类
 * @author yanweichen
 */
@Service
public class CustomerManagerServiceImpl extends BaseServiceImpl<TCustomerManager> implements CustomerManagerService {

    @Autowired
    private TCustomerManagerMapper customerManagerMapper;

    @Override
    public List<TCustomerManagerListVo> selectListVo(Map<String, Object> map) {
        return customerManagerMapper.selectListVo(map);
    }
}
