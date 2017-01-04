package com.cardpay.mgt.customer.service.impl;

import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.common.constant.ConstantEnum;
import com.cardpay.core.shiro.common.ShiroKit;
import com.cardpay.mgt.customer.dao.TCustomerTransferMapper;
import com.cardpay.mgt.customer.model.TCustomerBasic;
import com.cardpay.mgt.customer.model.TCustomerTransfer;
import com.cardpay.mgt.customer.model.vo.TCustomerTransferVo;
import com.cardpay.mgt.customer.model.vo.TCustomerVo;
import com.cardpay.mgt.customer.service.TCustomerBasicService;
import com.cardpay.mgt.customer.service.TCustomerTransferService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 客户移交实现类
 *
 * @author yanweichen
 */
@Lazy
@Service
public class TCustomerTransferServiceImpl extends BaseServiceImpl<TCustomerTransfer> implements TCustomerTransferService {
    @Autowired
    private TCustomerTransferMapper tCustomerIndustryDao;

    @Autowired
    private TCustomerBasicService tCustomerBasicService;

    @Autowired
    private TCustomerTransferService tCustomerTransferService;

    @Override
    public List<SelectModel> getTransferStatus() {
        List<SelectModel> selects = new ArrayList<>();
        for (ConstantEnum.TransferStatus value : ConstantEnum.TransferStatus.values()) {
            SelectModel selectModel = new SelectModel();
            selectModel.setId(value.getVal());
            selectModel.setValue(value.getName());
            selects.add(selectModel);
        }
        return selects;
    }

    @Override
    public List<TCustomerVo> queryTransfer(Map<String, Object> map) {
        return tCustomerIndustryDao.queryTransfer(map);
    }

    @Override
    @Transactional
    public int accept(String customerIds, Integer flag) {
        TCustomerTransfer tCustomerTransfer = tCustomerTransferService.selectByPrimaryKey(customerIds);
        if (tCustomerTransfer.getTransferStatus() == 0) { //查询客户是否为待接受状态
            List<Integer> idList = new ArrayList<>();
            String[] split = customerIds.split(",");
            for (String id : split) {
                int customerId = Integer.parseInt(id);
                idList.add(customerId);
            }

            Map<String, Object> map = new HashMap();
            if (null != flag && flag == 1) { //接受
                map.put("transferStatus", ConstantEnum.TransferStatus.STATUS1.getVal());
                map.put("nowCustomerManager", ShiroKit.getUserId());
            } else {  //拒绝
                map.put("transferStatus", ConstantEnum.TransferStatus.STATUS2.getVal());
            }
            map.put("customerIds", idList);
            return tCustomerIndustryDao.accept(map);
        }
        return 0;
    }

    @Override
    public List<TCustomerTransferVo> queryById(int customerId) {
        return tCustomerIndustryDao.queryById(customerId);
    }
}
