package com.cardpay.mgt.customer.customerbasic.service.impl;

import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.common.constant.ConstantEnum;
import com.cardpay.mgt.customer.customerbasic.dao.TCustomerBasicMapper;
import com.cardpay.mgt.customer.customerbasic.model.po.TCustomerBasic;
import com.cardpay.mgt.customer.customerbasic.service.CustomerBasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 客户基本信息服务实现类
 * @author wangpeng
 */
@Service
public class CustomerBasicServiceImpl extends BaseServiceImpl<TCustomerBasic> implements CustomerBasicService {
    @Autowired
    private TCustomerBasicMapper customerBasicMapper;

    @Override
    public Object getCert() {
        List<SelectModel> selects = new ArrayList<>();
        for (ConstantEnum.CertificateType value : ConstantEnum.CertificateType.values()){
            SelectModel selectModel=new SelectModel();
            selectModel.setId(value.getVal());
            selectModel.setValue(value.getName());
            selects.add(selectModel);
        }
        return selects;
    }

    @Override
    public Object getEducationDegree(){
        List<SelectModel> selects = new ArrayList<>();
        for (ConstantEnum.EducationDegree value : ConstantEnum.EducationDegree.values()){
            SelectModel selectModel=new SelectModel();
            selectModel.setId(value.getVal());
            selectModel.setValue(value.getName());
            selects.add(selectModel);
        }
        return selects;
    }

    @Override
    public Object getMarriageStatus(){
        List<SelectModel> selects = new ArrayList<>();
        for (ConstantEnum.MarriageStatus value : ConstantEnum.MarriageStatus.values()){
            SelectModel selectModel=new SelectModel();
            selectModel.setId(value.getVal());
            selectModel.setValue(value.getName());
            selects.add(selectModel);
        }
        return selects;
    }

    @Override
    public Object getCustomerStatus(){
        List<SelectModel> selects = new ArrayList<>();
        for (ConstantEnum.CustomerStatus value : ConstantEnum.CustomerStatus.values()){
            SelectModel selectModel=new SelectModel();
            selectModel.setId(value.getVal());
            selectModel.setValue(value.getName());
            selects.add(selectModel);
        }
        return selects;
    }

    @Override
    public List<TCustomerBasic> getProspectiveCustomers(Integer customerManagerId){
        return customerBasicMapper.getProspectiveCustomers(customerManagerId);
    }

    @Override
    public boolean isIdCardExist(String idCard){
        return customerBasicMapper.isIdCardExist(idCard) > 0 ? true : false;
    }
}
