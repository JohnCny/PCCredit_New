package com.cardpay.mgt.customer.customermaintenance.service.impl;

import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.common.constant.ConstantEnum;
import com.cardpay.mgt.customer.customermaintenance.model.po.TCustomerMaintenance;
import com.cardpay.mgt.customer.customermaintenance.service.CustomerMaintenanceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 客户维护服务实现类
 * @author wangpeng
 */
@Service
public class CustomerMaintenanceServiceImpl extends BaseServiceImpl<TCustomerMaintenance> implements CustomerMaintenanceService {
    @Override
    public Object getMaintenanceType(){
        List<SelectModel> selects = new ArrayList<>();
        for (ConstantEnum.MaintenanceType value : ConstantEnum.MaintenanceType.values()){
            SelectModel selectModel=new SelectModel();
            selectModel.setId(value.getVal());
            selectModel.setValue(value.getName());
            selects.add(selectModel);
        }
        return selects;
    }

}
