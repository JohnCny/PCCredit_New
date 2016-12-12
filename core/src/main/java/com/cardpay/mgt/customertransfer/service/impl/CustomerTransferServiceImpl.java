package com.cardpay.mgt.customertransfer.service.impl;

import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.common.constant.ConstantEnum;
import com.cardpay.mgt.customertransfer.model.po.TCustomerTransfer;
import com.cardpay.mgt.customertransfer.service.CustomerTransferService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 客户移交实现类
 * @author wangpeng
 */
@Service
public class CustomerTransferServiceImpl extends BaseServiceImpl<TCustomerTransfer> implements CustomerTransferService{
    @Override
    public Object getTransferStatus(){
        List<SelectModel> selects = new ArrayList<>();
        for (ConstantEnum.TransferStatus value : ConstantEnum.TransferStatus.values()){
            SelectModel selectModel=new SelectModel();
            selectModel.setId(value.getVal());
            selectModel.setValue(value.getName());
            selects.add(selectModel);
        }
        return selects;
    }
}
