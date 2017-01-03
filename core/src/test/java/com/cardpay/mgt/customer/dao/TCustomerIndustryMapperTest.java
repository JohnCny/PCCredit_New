package com.cardpay.mgt.customer.dao;

import com.cardpay.mgt.customer.model.TCustomerIndustry;
import com.cardpay.util.TestEnv;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 行业客户测试类
 *
 * @author chenkai
 *         createTime 2017-01-2017/1/3 11:09
 */
public class TCustomerIndustryMapperTest extends TestEnv{
    @Autowired
    private TCustomerIndustryMapper tCustomerIndustryDao;

    @Test
    public void batchInsertFile() throws Exception {
        List<TCustomerIndustry> list = new ArrayList<>();
        String industry = "1,2,3,4,5";
        String[] split = industry.split(",");
        for (String id : split) {
            int industryId = Integer.parseInt(id);
            TCustomerIndustry tCustomerIndustry = new TCustomerIndustry();
            tCustomerIndustry.setCustomerId(1);
            tCustomerIndustry.setIndustryId(industryId);
            list.add(tCustomerIndustry);
        }
        int i = tCustomerIndustryDao.batchInsertFile(list);
        assertEquals(i, 5);
    }

}