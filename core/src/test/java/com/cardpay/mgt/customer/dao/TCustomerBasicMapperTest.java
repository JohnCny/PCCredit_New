package com.cardpay.mgt.customer.dao;

import com.cardpay.mgt.customer.model.TCustomerBasic;
import com.cardpay.mgt.customer.model.vo.TCustomerTransferVo;
import com.cardpay.util.TestEnv;
import org.apache.commons.collections.map.HashedMap;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * 客户基本信息测试
 *
 * @author chenkai 2016/12/20 11:39
 */
public class TCustomerBasicMapperTest extends TestEnv {
    @Autowired
    private TCustomerBasicMapper tCustomerBasicMapper;

    @Test
    @Ignore
    //TODO :未确定需求
    public void getProspectiveCustomers() throws Exception {

    }

    @Test
    public void queryCustomer() throws Exception {
        List<TCustomerTransferVo> tCustomerTransferVos = tCustomerBasicMapper.queryCustomer(1);
        assertTrue(tCustomerTransferVos.size() > 0);
    }

    @Test
    public void isIdCardExist() throws Exception {
        Integer idCardExist = tCustomerBasicMapper.isIdCardExist(11);
        assertTrue(idCardExist > 0);
    }

    @Test
    public void updateStatus() throws Exception {
        Map<String, Object> map = new HashedMap();
        map.put("status", 1);
        List<Integer> list = new ArrayList<Integer>() {{
            add(1);
        }};
        map.put("customerIds", list);
        map.put("managerId", "1");
        int i = tCustomerBasicMapper.updateStatus(map);
        assertEquals(i, -1);
    }

    @Test
    public void queryCustomerByCondition() throws Exception {
        Map<String, Object> map = new HashedMap();
        map.put("customerManagerId", 4);
        List<TCustomerBasic> tCustomerBasics = tCustomerBasicMapper.queryCustomerByCondition(map);
        assertTrue(tCustomerBasics.size() > 0);
    }
}