package com.cardpay.mgt.customer.dao;

import com.cardpay.mgt.customer.model.TCustomerBasic;
import com.cardpay.mgt.customer.model.vo.TCustomerMaintenanceVo;
import com.cardpay.util.TestEnv;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author chenkai 2016/12/22 13:50
 */
public class TCustomerMaintenanceMapperTest extends TestEnv{
    @Autowired
    private TCustomerMaintenanceMapper tCustomerMaintenanceDao;

    @Test
    @Ignore
    public void queryCustomerByCondition() throws Exception {
        TCustomerBasic tCustomerBasic = new TCustomerBasic();
        tCustomerBasic.setCustomerManagerId(141);
        tCustomerBasic.setCname("1asd");
        tCustomerBasic.setCertificateNumber("11");
        List<TCustomerMaintenanceVo> tCustomerMaintenanceVos = tCustomerMaintenanceDao.queryCustomerByCondition(tCustomerBasic);
        assertTrue(tCustomerMaintenanceVos.size() > 0);
    }

}