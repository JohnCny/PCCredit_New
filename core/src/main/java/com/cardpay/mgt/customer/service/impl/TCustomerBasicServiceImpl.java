package com.cardpay.mgt.customer.service.impl;

import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.common.constant.ConstantEnum;
import com.cardpay.mgt.customer.dao.TCustomerBasicMapper;
import com.cardpay.mgt.customer.model.TCustomerBasic;
import com.cardpay.mgt.customer.model.TCustomerTransfer;
import com.cardpay.mgt.customer.model.vo.TCustomerTransferVo;
import com.cardpay.mgt.customer.service.TCustomerBasicService;
import com.cardpay.mgt.customer.service.TCustomerIndustryService;
import com.cardpay.mgt.customer.service.TCustomerMaintenanceService;
import com.cardpay.mgt.customermanager.basic.model.vo.TCustomerManagerBaseVo;
import com.cardpay.mgt.customermanager.basic.service.CustomerManagerService;
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
    /**
     * 客户行业信息
     */
    @Autowired
    private TCustomerIndustryService tCustomerIndustryService;

    /**
     * 客户维护服务
     */
    @Autowired
    private TCustomerMaintenanceService tCustomerMaintenanceService;

    /**
     * 客户移交
     */
    @Autowired
    private TCustomerTransferServiceImpl tCustomerTransferService;

    /**
     * 客户经理信息
     */
    @Autowired
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
    public boolean isIdCardExist(String idCard, Integer organizationId){
        return customerBasicDao.isIdCardExist(idCard, organizationId) > 0 ? true : false;
    }

    @Override
    public  List<TCustomerTransferVo> queryCustomer(int managerId, int customerType) {
        return customerBasicDao.queryCustomer(managerId, customerType);
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
    @Transactional
    public Integer deleteCustomer(int customerId) {
        Integer integer0 = customerBasicDao.deleteByPrimaryKey(customerId);
        Integer integer1 = tCustomerIndustryService.deleteByPrimaryKey(customerId);
        Integer integer2 = tCustomerMaintenanceService.deleteByPrimaryKey(customerId);
        TCustomerTransfer transfer = new TCustomerTransfer();
        transfer.setCustomerId(customerId);
        Integer integer3 = tCustomerTransferService.delete(transfer);
        return integer0+integer1+integer2+integer3;
    }

    @Override
    public Integer getManagerId(int userId) {
        TCustomerManagerBaseVo tCustomerManagerBaseVo = customerManagerService.selectBaseVoByUserId(userId);
        return tCustomerManagerBaseVo.getManagerId();
    }

}
