package com.cardpay.mgt.customer.service.impl;

import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.common.constant.ConstantEnum;
import com.cardpay.basic.common.interceptor.mapper.ReturnMapParam;
import com.cardpay.mgt.customer.dao.TCustomerBasicMapper;
import com.cardpay.mgt.customer.model.TCustomerBasic;
import com.cardpay.mgt.customer.service.TCustomerBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 客户基本信息服务实现类
 * @author chenkai
 */
@Service
public class TCustomerBasicServiceImpl extends BaseServiceImpl<TCustomerBasic> implements TCustomerBasicService {
    @Autowired
    private TCustomerBasicMapper customerBasicDao;

    @Override
    public Map<String, SelectModel> getDropDownList() {
        Map<String, SelectModel> map = new HashMap<>();
        for (ConstantEnum.CertificateType value : ConstantEnum.CertificateType.values()){
            SelectModel selectModel=new SelectModel();
            selectModel.setId(value.getVal());
            selectModel.setValue(value.getName());
            map.put("certificateType", selectModel);
        }
        for (ConstantEnum.EducationDegree value : ConstantEnum.EducationDegree.values()){
            SelectModel selectModel=new SelectModel();
            selectModel.setId(value.getVal());
            selectModel.setValue(value.getName());
            map.put("educationDegree", selectModel);
        }
        for (ConstantEnum.MarriageStatus value : ConstantEnum.MarriageStatus.values()){
            SelectModel selectModel=new SelectModel();
            selectModel.setId(value.getVal());
            selectModel.setValue(value.getName());
            map.put("marriageStatus", selectModel);
        }
        for (ConstantEnum.CustomerStatus value : ConstantEnum.CustomerStatus.values()){
            SelectModel selectModel=new SelectModel();
            selectModel.setId(value.getVal());
            selectModel.setValue(value.getName());
            map.put("customerStatus", selectModel);
        }
        return map;
    }

    @Override
    public List<TCustomerBasic> getProspectiveCustomers(Integer customerManagerId){
        return customerBasicDao.getProspectiveCustomers(customerManagerId);
    }

    @Override
    public boolean isIdCardExist(int idCard){
        return customerBasicDao.isIdCardExist(idCard) > 0 ? true : false;
    }

    @Override
    public Map<Integer, String> queryCustomer(ReturnMapParam mapParam) {
        return customerBasicDao.queryCustomer(mapParam);
    }

    @Override
    @Transactional
    public int updateStatus(Map map) {
        return customerBasicDao.updateStatus(map);
    }
}
