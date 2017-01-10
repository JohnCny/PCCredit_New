package com.cardpay.mgt.customer.service.impl;

import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.common.constant.ConstantEnum;
import com.cardpay.mgt.customer.dao.TCustomerBasicMapper;
import com.cardpay.mgt.customer.model.TCustomerBasic;
import com.cardpay.mgt.customer.model.vo.TCustomerIndustryVo;
import com.cardpay.mgt.customer.model.vo.TCustomerTransferVo;
import com.cardpay.mgt.customer.service.TCustomerBasicService;
import com.cardpay.mgt.customer.service.TCustomerIndustryService;
import com.cardpay.mgt.customer.service.TCustomerMaintenanceService;
import com.cardpay.mgt.customermanager.basic.service.CustomerManagerService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 客户基本信息服务实现类
 * @author chenkai
 */
@Lazy
@Service
public class TCustomerBasicServiceImpl extends BaseServiceImpl<TCustomerBasic> implements TCustomerBasicService {
    @Autowired
    private TCustomerBasicMapper customerBasicDao;

    @Autowired //客户行业信息
    private TCustomerIndustryService tCustomerIndustryService;

    @Autowired //客户维护服务
    private TCustomerMaintenanceService tCustomerMaintenanceService;

    @Autowired //客户移交
    private TCustomerTransferServiceImpl tCustomerTransferService;

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
    public boolean isIdCardExist(long idCard){
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
    public List<TCustomerBasic> queryCustomerByCondition(Map<String, Object> map) {
        return customerBasicDao.queryCustomerByCondition(map);
    }

    @Override
    public List<TCustomerBasic> selectDelete(Map<String, Object> map) {
        return customerBasicDao.selectDelete(map);
    }

    @Override
    public Integer deleteCustomer(int customerId) {
        Integer integer0 = customerBasicDao.deleteByPrimaryKey(customerId);
        Integer integer1 = tCustomerIndustryService.deleteByPrimaryKey(customerId);
        Integer integer2 = tCustomerMaintenanceService.deleteByPrimaryKey(customerId);
        Integer integer3 = tCustomerTransferService.deleteByPrimaryKey(customerId);
        return integer0+integer1+integer2+integer3;
    }

}
