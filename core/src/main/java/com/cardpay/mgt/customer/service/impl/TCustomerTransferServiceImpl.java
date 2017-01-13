package com.cardpay.mgt.customer.service.impl;

import com.cardpay.basic.base.model.SelectModel;
import com.cardpay.basic.base.service.impl.BaseServiceImpl;
import com.cardpay.basic.common.constant.ConstantEnum;
import com.cardpay.mgt.customer.dao.TCustomerTransferMapper;
import com.cardpay.mgt.customer.model.TCustomerBasic;
import com.cardpay.mgt.customer.model.TCustomerTransfer;
import com.cardpay.mgt.customer.model.vo.TCustomerTransferVo;
import com.cardpay.mgt.customer.model.vo.TCustomerVo;
import com.cardpay.mgt.customer.service.TCustomerBasicService;
import com.cardpay.mgt.customer.service.TCustomerTransferService;
import com.cardpay.mgt.customermanager.basic.model.vo.TCustomerManagerBaseVo;
import com.cardpay.mgt.customermanager.basic.service.CustomerManagerService;
import com.cardpay.mgt.message.service.MessageService;
import com.cardpay.mgt.user.model.User;
import com.cardpay.mgt.user.service.UserService;
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
    /**
     * 移交信息
     */
    @Autowired
    private TCustomerTransferMapper tCustomerTransferDao;
    /**
     * 客户信息
     */
    @Autowired
    private TCustomerBasicService tCustomerBasicService;
    /**
     * 用户信息
     */
    @Autowired
    private UserService userService;

    /**
     * 消息推送
     */
    @Autowired
    private MessageService messageService;

    /**
     * 客户信息
     */
    @Autowired
    private TCustomerBasicService customerBasicService;


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
        return tCustomerTransferDao.queryTransfer(map);
    }

    @Override
    @Transactional
    public synchronized int accept(String customerIds, Integer flag, int userId) {
        HashMap<String, Object> map = new HashMap();
        Map<String, Object> stringObjectMap = new HashMap();
        Integer managerId = customerBasicService.getManagerId(userId);
        List<Integer> customerIdList = new ArrayList<>();
        String[] split = customerIds.split(",");
        for (String id : split) {
            int customerId = Integer.parseInt(id);
            customerIdList.add(customerId);
        }
        //客户经理接受此客户
        if (flag != null && flag == 1) {
            map.put("transferStatus", ConstantEnum.TransferStatus.STATUS1.getVal());
            stringObjectMap.put("managerId",managerId);
            //客户经理拒绝此客户
        } else {
            map.put("transferStatus", ConstantEnum.TransferStatus.STATUS2.getVal());
        }
        map.put("customerIds", customerIdList);
        int mark = tCustomerTransferDao.accept(map);
        //接受/拒绝成功后回复客户状态
        if (mark != 0) {
            stringObjectMap.put("status", ConstantEnum.CustomerStatus.STATUS0.getVal());
            stringObjectMap.put("customerIds", customerIdList);
            int status = tCustomerBasicService.updateStatus(stringObjectMap);
            //消息推送
        /*
                String messageContent; //发送消息内容
                if (mark != 0) {
                    for (String id : split) {
                        int customerId = Integer.parseInt(id);
                        User user = userService.selectByPrimaryKey(userId);
                        TCustomerBasic tCustomerBasic = tCustomerBasicService.selectByPrimaryKey(customerId);
                        TCustomerTransfer tCustomerTransfer = tCustomerTransferDao.selectByPrimaryKey(customerId);
                        if (flag != null && flag == 1) {
                            messageContent = "客户经理:" + user.getUserCname() + ",接受了你的客户:" + tCustomerBasic.getCname();
                        } else {
                            messageContent = "客户经理:" + user.getUserCname() + ",拒绝了你的客户:" + tCustomerBasic.getCname();
                        }
                        messageService.sendMessage("客户移交结果", messageContent, tCustomerTransfer.getOriginCustomerManager()
                                , 0, 0);
                    }
            }*/
            return status;
        }
        return 0;
    }

    @Override
    public List<TCustomerTransferVo> queryById(int customerId) {
        return tCustomerTransferDao.queryById(customerId);
    }
}
