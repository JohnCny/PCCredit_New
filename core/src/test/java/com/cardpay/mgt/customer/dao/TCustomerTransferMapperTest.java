package com.cardpay.mgt.customer.dao;

import com.cardpay.mgt.customer.model.vo.TCustomerVo;
import com.cardpay.util.TestEnv;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author chenkai 2016/12/20 16:35
 */
public class TCustomerTransferMapperTest extends TestEnv {
    @Autowired
    private TCustomerTransferMapper tCustomerTransferDao;

    @Test
    public void queryTransfer() throws Exception {
        /*List<TCustomerVo> tCustomerTransferVos = tCustomerTransferDao.queryTransfer(0, 1);
        assertTrue(tCustomerTransferVos.size() > 0);*/
    }

}