package com.cardpay.mgt.customer.service.impl;

import com.cardpay.basic.base.model.ResultTo;
import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.common.constant.ConstantEnum;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.customer.dao.TCustomerBasicMapper;
import com.cardpay.mgt.customer.model.TCustomerBasic;
import com.cardpay.mgt.customer.model.TCustomerMaintenance;
import com.cardpay.mgt.customer.model.vo.TCustomerTransferVo;
import com.cardpay.mgt.customer.model.vo.TCustomerVo;
import com.cardpay.mgt.customer.service.TCustomerBasicService;
import com.cardpay.mgt.manager.customermanager.model.TCustomerManager;
import com.cardpay.mgt.manager.customermanager.service.CustomerManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Autowired//客户经理Service
    private CustomerManagerService customerManagerService;

    @Override
    public List<SelectModel> getCert() {
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
    public List<SelectModel> getEducationDegree(){
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
    public List<SelectModel> getMarriageStatus(){
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
    public List<SelectModel> getCustomerStatus(){
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
        return customerBasicDao.getProspectiveCustomers(customerManagerId);
    }

    @Override
    public boolean isIdCardExist(int idCard){
        return customerBasicDao.isIdCardExist(idCard) > 0 ? true : false;
    }

    @Override
    public  List<TCustomerTransferVo> queryCustomer(int managerId) {
        return customerBasicDao.queryCustomer(managerId);
    }

    @Override
    @Transactional
    public int updateStatus(Map map) {
        return customerBasicDao.updateStatus(map);
    }

    @Override
    public List<TCustomerBasic> queryCustomerByCondition(TCustomerBasic tCustomerBasic) {
        return customerBasicDao.queryCustomerByCondition(tCustomerBasic);
    }
}
