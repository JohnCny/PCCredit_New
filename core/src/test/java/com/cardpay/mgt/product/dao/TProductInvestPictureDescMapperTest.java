package com.cardpay.mgt.product.dao;

import com.cardpay.mgt.product.model.TProductInvestPictureDesc;
import com.cardpay.util.TestEnv;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by chenkai on 2016/12/9.
 */
public class TProductInvestPictureDescMapperTest extends TestEnv{
    @Autowired
    private TProductInvestPictureDescMapper tProductInvestPictureDescDao;

    @Test
    public void batchInsert() throws Exception {
        TProductInvestPictureDesc tProductInvestPictureDesc = new TProductInvestPictureDesc();
        tProductInvestPictureDesc.setId(1);
        tProductInvestPictureDesc.setIsNeed(1);
        tProductInvestPictureDesc.setPritureDescription("1");
        tProductInvestPictureDesc.setProductId(1);
        TProductInvestPictureDesc tProductInvestPictureDesc2 = new TProductInvestPictureDesc();
        tProductInvestPictureDesc2.setId(2);
        tProductInvestPictureDesc2.setIsNeed(2);
        tProductInvestPictureDesc2.setPritureDescription("2");
        tProductInvestPictureDesc2.setProductId(2);
        List<TProductInvestPictureDesc> list = new ArrayList<TProductInvestPictureDesc>(){
            {
                add(tProductInvestPictureDesc);
                add(tProductInvestPictureDesc2);
            }
        };
        int flag = tProductInvestPictureDescDao.batchInsert(list);
        assertEquals(flag, 2);
    }

}