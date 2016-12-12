package com.cardpay.mgt.customermanagerlevel.service.impl;

import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.common.constant.ConstantEnum;
import com.cardpay.mgt.customermanagerlevel.dao.TCustomerManagerLevelMapper;
import com.cardpay.mgt.customermanagerlevel.model.po.TCustomerManagerLevel;
import com.cardpay.mgt.customermanagerlevel.service.CustomerManagerLevelService;
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
