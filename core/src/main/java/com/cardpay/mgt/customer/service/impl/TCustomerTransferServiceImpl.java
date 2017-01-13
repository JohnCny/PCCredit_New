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

import static com.cardpay.basic.common.constant.CustomerStatusEnum.ORDINARY;

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
    public int accept(String customerIds, Integer flag, int userId) {
        HashMap<String, Object> transferMap = new HashMap();
        Map<String, Object> customerMap = new HashMap();
        Integer managerId = customerBasicService.getManagerId(userId);
        List<Integer> customerIdList = new ArrayList<>();
        String[] split = customerIds.split(",");
        for (String id : split) {
            int customerId = Integer.parseInt(id);
            customerIdList.add(customerId);
        }
        //客户经理接受此客户
        if (flag != null && flag == 1) {
            transferMap.put("transferStatus", ConstantEnum.TransferStatus.STATUS1.getVal());
            customerMap.put("managerId",managerId);
            //客户经理拒绝此客户
        } else {
            transferMap.put("transferStatus", ConstantEnum.TransferStatus.STATUS2.getVal());
        }
        transferMap.put("customerIds", customerIdList);
        int mark = tCustomerTransferDao.accept(transferMap);
        //接受/拒绝成功后回复客户状态
        if (mark != 0) {
            customerMap.put("status", ORDINARY.getValue());
            customerMap.put("customerIds", customerIdList);
            int status = tCustomerBasicService.updateStatus(customerMap);
            //消息推送
                String messageContent;
                    for (String id : split) {
                        int customerId = Integer.parseInt(id);
                        User user = userService.selectByPrimaryKey(userId);
                        TCustomerBasic tCustomerBasic = tCustomerBasicService.selectByPrimaryKey(customerId);
                        TCustomerTransfer transfer = new TCustomerTransfer();
                        transfer.setCustomerId(customerId);
                        List<TCustomerTransfer> customerTransferList = tCustomerTransferDao.select(transfer);
                        int acceptCustomerId = 0;
                        for (TCustomerTransfer tCustomerTransfer : customerTransferList) {
                            acceptCustomerId = tCustomerTransfer.getOriginCustomerManager();
                            continue;
                        }
                        if (flag != null && flag == 1) {
                            messageContent = "客户经理:" + user.getUserCname() + ",接受了你的客户:" + tCustomerBasic.getCname();
                        } else {
                            messageContent = "客户经理:" + user.getUserCname() + ",拒绝了你的客户:" + tCustomerBasic.getCname();
                        }
                        messageService.messagePush("客户移交结果", messageContent, acceptCustomerId
                                , 0, 0, 0);
                    }
            return status;
        }
        return 0;
    }

    @Override
    public List<TCustomerTransferVo> queryById(int customerId) {
        return tCustomerTransferDao.queryById(customerId);
    }
}
