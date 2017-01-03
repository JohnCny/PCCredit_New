package com.cardpay.mgt.product.dao;

import com.cardpay.mgt.product.model.ProductInvestPictureDesc;
import com.cardpay.util.TestEnv;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by chenkai on 2016/12/9.
 */
public class ProductInvestPictureDescMapperTest extends TestEnv{
    @Autowired
    private ProductInvestPictureDescMapper tProductInvestPictureDescDao;

    @Test
    public void batchInsert() throws Exception {
        ProductInvestPictureDesc productInvestPictureDesc = new ProductInvestPictureDesc();
        productInvestPictureDesc.setId(100000);
        productInvestPictureDesc.setIsNeed(1);
        productInvestPictureDesc.setPritureDescription("1");
        productInvestPictureDesc.setProductId(1);
        ProductInvestPictureDesc productInvestPictureDesc2 = new ProductInvestPictureDesc();
        productInvestPictureDesc2.setId(200000);
        productInvestPictureDesc2.setIsNeed(2);
        productInvestPictureDesc2.setPritureDescription("2");
        productInvestPictureDesc2.setProductId(2);
        List<ProductInvestPictureDesc> list = new ArrayList<ProductInvestPictureDesc>(){
            {
                add(productInvestPictureDesc);
                add(productInvestPictureDesc2);
            }
        };
        int flag = tProductInvestPictureDescDao.batchInsertImg(list);
        assertEquals(flag, 2);
    }

}