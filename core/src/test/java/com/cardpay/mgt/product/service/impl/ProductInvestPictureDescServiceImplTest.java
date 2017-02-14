package com.cardpay.mgt.product.service.impl;

import com.cardpay.mgt.product.dao.ProductDescMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;

import static org.junit.Assert.assertEquals;

/**
 * 产品对应调查图片图片说明Services测试类
 * Created by chenkai on 2016/12/9.
 */
@RunWith(MockitoJUnitRunner.class)
@PrepareForTest({ProductDescServiceImpl.class})
public class ProductInvestPictureDescServiceImplTest {
    @Mock
    private ProductDescMapper tProductInvestPictureDescDao;

    @InjectMocks
    private ProductDescServiceImpl tProductInvestPictureDescService;

    @Test
    public void batchInsert() throws Exception {
     /*   List<ProductInvestPictureDesc> list = new ArrayList<ProductInvestPictureDesc>(){
            {
                add(new ProductInvestPictureDesc());
                add(new ProductInvestPictureDesc());
                add(new ProductInvestPictureDesc());
            }
        };
        when(tProductInvestPictureDescDao.batchInsertImg(list)).thenReturn(3);
        int flag = tProductInvestPictureDescService.batchInsertImg(list);
        assertEquals(3, flag);*/
    }

}