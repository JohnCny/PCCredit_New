package com.cardpay.mgt.customer.customermanagerlevel.service.impl;

import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.mgt.customer.customermanagerlevel.model.po.TCustomerManagerLevel;
import com.cardpay.mgt.customer.customermanagerlevel.service.CustomerManagerLevelService;
import com.cardpay.mgt.customer.customermanagerlevel.dao.TCustomerManagerLevelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 客户经理级别实现类
 * @author wangpeng
 */
@Service
public class CustomerManagerLevelServiceImpl extends BaseServiceImpl<TCustomerManagerLevel> implements CustomerManagerLevelService {

    @Autowired
    private TCustomerManagerLevelMapper customerManagerLevelMapper;

    @Override
    public Object getCustomerManagerLevel(){
        List<SelectModel> selects = new ArrayList<>();

        List<TCustomerManagerLevel> customerManagerLevels = customerManagerLevelMapper.selectAll();
        for (TCustomerManagerLevel value : customerManagerLevels){
            SelectModel selectModel=new SelectModel();
            selectModel.setId(value.getId());
            selectModel.setValue(value.getLevelName());
            selects.add(selectModel);
        }
        return selects;
    }
}
