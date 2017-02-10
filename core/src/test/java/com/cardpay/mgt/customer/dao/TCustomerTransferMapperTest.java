package com.cardpay.mgt.customer.dao;

import com.cardpay.basic.common.constant.ConstantEnum;
import com.cardpay.mgt.customer.model.vo.TCustomerVo;
import com.cardpay.util.TestEnv;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author chenkai 2016/12/20 16:35
 */
public class TCustomerTransferMapperTest extends TestEnv {

    @Autowired
    private TCustomerTransferMapper tCustomerTransferDao;

    @Test
    public void accept() throws Exception {
        String customerIds = "1";
        List<Integer> customerIdList = new ArrayList<>();
        String[] split = customerIds.split(",");
        for (String id : split) {
            int customerId = Integer.parseInt(id);
            customerIdList.add(customerId);
        }
        Map<String, Object> map = new HashMap();
        map.put("transferStatus", ConstantEnum.TransferStatus.STATUS1.getVal());
        map.put("nowCustomerManager", 1);
        map.put("customerIds", customerIdList);
        int accept = tCustomerTransferDao.accept(map);
        assertEquals(accept,-1);
    }


    @Test
    public void queryTransfer() throws Exception {
        /*List<TCustomerVo> tCustomerTransferVos = tCustomerTransferDao.queryTransfer(0, 1);
        assertTrue(tCustomerTransferVos.size() > 0);*/
    }

}