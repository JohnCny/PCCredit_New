package com.cardpay.mgt.customer.dao;

import com.cardpay.mgt.customer.model.TCustomerBasic;
import com.cardpay.mgt.customer.model.vo.TCustomerMaintenanceVo;
import com.cardpay.util.TestEnv;
import org.apache.commons.collections.map.HashedMap;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author chenkai 2016/12/22 13:50
 */
public class TCustomerMaintenanceMapperTest extends TestEnv{

    @Autowired
    private TCustomerMaintenanceMapper tCustomerMaintenanceDao;

    @Test
    @Ignore
    //todo : 数据库数据不一致
    public void queryCustomerByCondition() throws Exception {
        Map<String, Object> map = new HashedMap();
        map.put("customerManagerId", 1);
        List<TCustomerMaintenanceVo> tCustomerMaintenanceVos = tCustomerMaintenanceDao.queryCustomerByCondition(map);
        assertTrue(tCustomerMaintenanceVos.size() > 0);
    }

}