package com.cardpay.mgt.customer.service.impl;

import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.common.constant.ConstantEnum;
import com.cardpay.mgt.customer.dao.TCustomerMaintenanceMapper;
import com.cardpay.mgt.customer.model.TCustomerBasic;
import com.cardpay.mgt.customer.model.TCustomerMaintenance;
import com.cardpay.mgt.customer.model.vo.TCustomerMaintenanceVo;
import com.cardpay.mgt.customer.service.TCustomerMaintenanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 客户维护服务实现类
 * @author yanweichen
 */
@Lazy
@Service
public class TCustomerMaintenanceServiceImpl extends BaseServiceImpl<TCustomerMaintenance> implements TCustomerMaintenanceService {
    @Autowired
    private TCustomerMaintenanceMapper tCustomerMaintenanceDao;

    @Override
    public List<SelectModel> getMaintenanceType(){
        List<SelectModel> selects = new ArrayList<>();
        for (ConstantEnum.MaintenanceType value : ConstantEnum.MaintenanceType.values()){
            SelectModel selectModel=new SelectModel();
            selectModel.setId(value.getVal());
            selectModel.setValue(value.getName());
            selects.add(selectModel);
        }
        return selects;
    }

    @Override
    public List<TCustomerMaintenanceVo> queryCustomerByCondition(Map<String, Object> map) {
        return tCustomerMaintenanceDao.queryCustomerByCondition(map);
    }

}
