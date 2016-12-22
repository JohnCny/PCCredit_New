package com.cardpay.mgt.customer.service.impl;

import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.common.constant.ConstantEnum;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.customer.dao.TCustomerTransferMapper;
import com.cardpay.mgt.customer.model.TCustomerTransfer;
import com.cardpay.mgt.customer.model.vo.TCustomerVo;
import com.cardpay.mgt.customer.service.TCustomerTransferService;
import org.apache.commons.collections.map.HashedMap;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 客户移交实现类
 * @author yanweichen
 */
@Service
public class TCustomerTransferServiceImpl extends BaseServiceImpl<TCustomerTransfer> implements TCustomerTransferService {
    @Autowired
    private TCustomerTransferMapper tCustomerIndustryDao;


    @Override
    public List<SelectModel> getTransferStatus(){
        List<SelectModel> selects = new ArrayList<>();
        for (ConstantEnum.TransferStatus value : ConstantEnum.TransferStatus.values()){
            SelectModel selectModel=new SelectModel();
            selectModel.setId(value.getVal());
            selectModel.setValue(value.getName());
            selects.add(selectModel);
        }
        return selects;
    }

    @Override
    public List<TCustomerVo> queryTransfer(@Param("status") int status, @Param("managerId") int managerId) {
        return tCustomerIndustryDao.queryTransfer(status, managerId);
    }

    @Override
    public int accept(String customerIds, Integer flag) {
        List<Integer> idList = new ArrayList<>();
        String[] split = customerIds.split(",");
        for (String id : split) {
            int customerId = Integer.parseInt(id);
            idList.add(customerId);
        }
        Map<String, Object> map = new HashedMap();
        if (null != flag && flag==1){
            map.put("transferStatus", ConstantEnum.TransferStatus.STATUS1.getVal());
            map.put("nowCustomerManager", ShiroKit.getUserId());
        }else {
            map.put("transferStatus", ConstantEnum.TransferStatus.STATUS2.getVal());
        }
        map.put("customerIds", idList);
        return tCustomerIndustryDao.accept(map);
    }
}
